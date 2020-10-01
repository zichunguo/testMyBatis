package com.guo.dao;

import com.guo.pojo.User;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guo
 * @date 2020/9/26
 */
//@Log4j
public class UserMapperTest {

	private static final Logger log = Logger.getLogger(UserMapperTest.class);

	@Test
	public void getUserList() {
		// 获取 SqlSession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 第一种方式：获取 Mapper（推荐）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行 mapper 中的方法回去数据，即调用接口
		List<User> userList = userMapper.getUserList();
		// 第二种方式：获取获取查询
//		List<User> userList = sqlSession.selectList("com.guo.dao.UserMapper.getUserList");

		for (User user : userList) {
			System.out.println(user);
			log.info("user:" + user);
		}
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void getUserByID() {
		// 获取 SqlSession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 第一种方式：获取 Mapper（推荐）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行 mapper 中的方法回去数据，即调用接口
		User user = userMapper.getUserById(1);
		System.out.println(user);
		log.info("user:" + user);

		// 一级缓存，SQLSession 级别，当前 sqlSession 有效
		User user2 = userMapper.getUserById(1);
		System.out.println(user2);
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void getUserLike() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.getUserLike("张");
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}


	@Test
	public void addUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int num = userMapper.addUser(new User(7, "王八", 1000));
		if (num > 0) {
			System.out.println("插入成功！num = " + num);
		}

		// 增删改要提交事务，否则不会提交到数据库
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void addUserByMap() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 7);
		map.put("userName", "哈哈");
		map.put("userAge", 28);
		int num = userMapper.addUserByMap(map);
		if (num > 0) {
			System.out.println("插入成功！num = " + num);
		}

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int num = userMapper.updateUser(new User(7, "哈哈", 100));
		if (num > 0) {
			System.out.println("修改数据成功！num = " + num);
		}

		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void deleteUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int num = userMapper.deleteUser(7);
		if (num > 0) {
			System.out.println("删除数据成功！num = " + num);
		}

		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void getUserByLimit() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("pageNo", 0);
		map.put("pageSize", 3);
		List<User> userList = userMapper.getUserByLimit(map);
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void getUserByRowBounds() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 分页对象 RowBounds
		RowBounds rowBounds = new RowBounds(0, 3);

		List<User> userList = sqlSession.selectList("com.guo.dao.UserMapper.getUserByRowBounds", null, rowBounds);
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void batchInsertUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = new ArrayList<>();
		list.add(new User(7, "王八", 1000));
		list.add(new User(8, "乌龟", 2000));
		int i = userMapper.batchInsertUser(list);
		if (i > 0) {
			System.out.println("插入成功：" + i);
		}
		sqlSession.close();
	}

	@Test
	public void batchDeleteUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer[] ids = {7, 8};
		int i = userMapper.batchDeleteUser(ids);
		if (i > 0) {
			System.out.println("删除成功：" + i);
		}
		sqlSession.close();
	}

	@Test
	public void testLog4j() {
		log.debug("log4j: debug 级别");
		log.info("log4j: info 级别");
		log.error("log4j: error 级别");
	}

}

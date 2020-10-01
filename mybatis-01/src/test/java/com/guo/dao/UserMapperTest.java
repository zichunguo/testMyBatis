package com.guo.dao;

import com.guo.pojo.User;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guo
 * @date 2020/9/26
 */
public class UserMapperTest {

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
		}
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
	public void getUserByID() {
		// 获取 SqlSession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 第一种方式：获取 Mapper（推荐）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 执行 mapper 中的方法回去数据，即调用接口
		User user = userMapper.getUserById(1);
		System.out.println(user);
		// 关闭资源
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
}

package com.guo.dao;

import com.guo.pojo.User;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author guo
 * @date 2020/10/1
 */
public class UserAnnotationMapperTest {

	@Test
	public void getUserList() {
		// 获取 SqlSession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 第一种方式：获取 Mapper（推荐）
		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		// 执行 mapper 中的方法回去数据，即调用接口
		List<User> userList = mapper.getUserList();
		// 第二种方式：获取获取查询
//		List<User> userList = sqlSession.selectList("com.guo.dao.UserMapper.getUserList");

		for (User user : userList) {
			System.out.println(user);
		}
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void getUserByID() {
		// 获取 SqlSession
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// 第一种方式：获取 Mapper（推荐）
		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		// 执行 mapper 中的方法回去数据，即调用接口
		User user = mapper.getUserById(1);
		System.out.println(user);
		// 关闭资源
		sqlSession.close();
	}

	@Test
	public void addUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		int num = mapper.addUser(new User(8, "王八", 1000));
		if (num > 0) {
			System.out.println("插入成功！num = " + num);
		}

		// 增删改要提交事务，否则不会提交到数据库
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		int num = mapper.updateUser(new User(7, "呜呜", 100));
		if (num > 0) {
			System.out.println("修改数据成功！num = " + num);
		}

		// 提交事务
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void updateUser2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		int num = mapper.updateUser2(7, "哈哈", 100);
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

		UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);
		int num = mapper.deleteUser(7);
		if (num > 0) {
			System.out.println("删除数据成功！num = " + num);
		}

		// 提交事务
//		sqlSession.commit();
		sqlSession.close();
	}
}

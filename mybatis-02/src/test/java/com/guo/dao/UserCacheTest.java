package com.guo.dao;

import com.guo.pojo.User;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author guo
 * @date 2020/9/29
 */
public class UserCacheTest {

	/**
	 * 测试一级缓存
	 */
	@Test
	public void getUserByID() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);
		System.out.println(user);
		System.out.println("********************************");
		// 增、删、改 会导致缓存失效
//		int num = userMapper.updateUser(new User(7, "哈哈", 100));
		// 手动清理缓存
//		sqlSession.clearCache();
		// 同一个会话 SqlSession 查询数据会存到本地缓存
		User user2 = userMapper.getUserById(2);
		System.out.println(user2);
		sqlSession.close();
	}

	/**
	 * 测试二级缓存
	 */
	@Test
	public void getUserByID2() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);
		System.out.println(user);
		sqlSession.close();// 当 sqlSession 关闭后才会将本地缓存写人二级缓存

		System.out.println("********************************");
		// 增、删、改 会导致缓存失效
//		int num = userMapper.updateUser(new User(7, "哈哈", 100));
		// 手动清理缓存
//		sqlSession.clearCache();

		SqlSession sqlSession2 = MybatisUtil.getSqlSession();
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 同一个会话 SqlSession 查询数据会存到本地缓存
		User user2 = userMapper2.getUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}

}

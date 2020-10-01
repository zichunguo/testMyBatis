package com.guo.dao;

import com.guo.pojo.Blog;
import com.guo.util.IDUtil;
import com.guo.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author guo
 * @date 2020/9/27
 */
public class BlogMapperTest {

	@Test
	public void queryBlogForeach() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		map.put("ids", ids);
		List<Blog> blogList = blogMapper.queryBlogForeach(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogForeachByMap() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		map.put("ids", ids);
		List<Blog> blogList = blogMapper.queryBlogForeachByMap(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogForeachByList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("title", "Java入门到放弃");
		map.put("author", "Java劝退师");
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<Blog> blogList = blogMapper.queryBlogForeachByList(ids);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void updateBlogSet() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("title", "标题");
		map.put("author", "张三");
		map.put("id", "1");
		int i = blogMapper.updateBlogSet(map);
		if (i > 0) {
			System.out.println("更新成功");
		}
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void queryBlogChoose() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("title", "Java入门到放弃");
		map.put("author", "Java劝退师");
		List<Blog> blogList = blogMapper.queryBlogChoose(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogSQL() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("author", "Java劝退师");
		map.put("title", "Java入门到放弃");
		List<Blog> blogList = blogMapper.queryBlogSQL(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogWhere() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("author", "Java劝退师");
		map.put("title", "Java入门到放弃");
		List<Blog> blogList = blogMapper.queryBlogWhere(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void queryBlogIf() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("author", "Java劝退师");
		map.put("title", "Java入门到放弃");
		List<Blog> blogList = blogMapper.queryBlogIf(map);
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void listBlog() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.listBlog();
		for (Blog blog : blogList) {
			System.out.println(blog);
		}
		sqlSession.close();
	}

	@Test
	public void addBlog() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
		Blog blog1 = new Blog(IDUtil.getUUID(), "Java入门到放弃", "Java劝退师", new Date(), 666);
		blogMapper.addBlog(blog1);
		Blog blog2 = new Blog(IDUtil.getUUID(), "Spring深入之路", "Java劝退师", new Date(), 888);
		blogMapper.addBlog(blog2);
		Blog blog3 = new Blog(IDUtil.getUUID(), "前端划水之精神", "前端劝退师", new Date(), 9999);
		blogMapper.addBlog(blog3);
		sqlSession.commit();
		sqlSession.close();
	}
}

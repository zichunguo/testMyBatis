package com.guo.dao;

import com.guo.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 测试动态 SQL
 */
public interface BlogMapper {

	/**
	 * 测试动态 SQL - foreach - in 查询
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogForeach(Map<String, Object> map);

	/**
	 * 测试动态 SQL - foreach - 使用 map 做参数
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogForeachByMap(Map<String, Object> map);

	/**
	 * 测试动态 SQL - foreach - 使用 list 做参数
	 * @param ids
	 * @return
	 */
	List<Blog> queryBlogForeachByList(@Param("ids") List<Integer> ids);

	/**
	 * 测试动态 SQL - set
	 * @param map
	 * @return
	 */
	int updateBlogSet(Map<String, Object> map);

	/**
	 * 测试动态 SQL - choose
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogChoose(Map<String, Object> map);

	/**
	 * 测试动态 SQL - sql 片段
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogSQL(Map<String, Object> map);

	/**
	 * 测试动态 SQL - where
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogWhere(Map<String, Object> map);

	/**
	 * 测试动态 SQL - if
	 * @param map
	 * @return
	 */
	List<Blog> queryBlogIf(Map<String, Object> map);

	/**
	 * 查询所有
	 * @return
	 */
	List<Blog> listBlog();

	/**
	 * 添加
	 * @param blog
	 * @return
	 */
	int addBlog(Blog blog);
}

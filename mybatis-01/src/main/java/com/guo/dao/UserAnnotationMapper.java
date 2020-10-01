package com.guo.dao;

import com.guo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用注解的形式
 */
public interface UserAnnotationMapper {

	/**
	 * 查询全部用户
	 * @return
	 */
	@Select("select * from user")
	List<User> getUserList();

	/**
	 * 根据 ID 查询用户
	 * @param id
	 * @return
	 */
	@Select("select * from user where id = #{id}")
	User getUserById(@Param("id") int id);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Insert("insert into user(id, name, age) values(#{id}, #{name}, #{age})")
	int addUser(User user);

	/**
	 * 更新用户
	 * @param user
	 */
	@Update("update user set name = #{name},age = #{age} where id=#{id}")
	int updateUser(User user);

	/**
	 * 根据参数更新数据
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	@Update("update user set name = #{name},age = #{age} where id=#{id}")
	int updateUser2(@Param("id") int id, @Param("name") String name, @Param("age") int age);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@Delete("delete from user where id = #{id}")
	int deleteUser(@Param("id") int id);
}

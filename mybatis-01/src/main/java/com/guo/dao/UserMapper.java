package com.guo.dao;

import com.guo.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 使用 xml 配置文件的形式
 */
public interface UserMapper {
	/**
	 * 查询全部用户
	 * @return
	 */
	List<User> getUserList();

	/**
	 * 根据 ID 查询用户
	 * @param id
	 * @return
	 */
	User getUserById(int id);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 更新用户
	 * @param user
	 */
	int updateUser(User user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteUser(int id);

	/**
	 * 添加用户 通过map参数
	 * @param map
	 * @return
	 */
	int addUserByMap(Map<String, Object> map);

	/**
	 * 根据名字模糊查询
	 * @param name
	 * @return
	 */
	List<User> getUserLike(String name);
}

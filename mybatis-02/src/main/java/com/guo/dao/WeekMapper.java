package com.guo.dao;

import com.guo.pojo.Week;

import java.util.List;

public interface WeekMapper {

	/**
	 * 测试枚举类型的映射器 - 使用整形值存储
	 * enum 默认的映射器为 EnumTypeHandler
	 * 如果坚持使用整形值代码存储枚举类型，需要设置枚举映射器 EnumOrdinalTypeHandler，在 mybatis-config.xml 配置
	 * @return
	 */
	List<Week> listWeek();

	/**
	 * 测试枚举类型的映射器 - 某些情况下使用枚举名字（String）存储
	 * 在 ResultMap 中的 Result 标签上配置：typeHandler="org.apache.ibatis.type.EnumTypeHandler"
	 * @return
	 */
	List<Week> listWeek2();
}

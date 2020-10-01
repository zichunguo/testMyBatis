package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试枚举类型的映射
 * enum 默认的映射器为 EnumTypeHandler
 * 如果坚持使用整形值代码存储枚举类型，需要设置枚举映射器 EnumOrdinalTypeHandler，在 mybatis-config.xml 配置
 *
 * 如果某些情况下使用枚举名字（String）存储
 * 在 ResultMap 中的 Result 标签上配置：typeHandler="org.apache.ibatis.type.EnumTypeHandler"
 * @author guo
 * @date 2020/10/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Week {
	int id;
	WeekDay weekDay;
}

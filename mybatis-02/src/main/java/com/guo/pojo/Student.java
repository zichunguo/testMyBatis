package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guo
 * @date 2020/9/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int id;
	private String name;
	private int tid;// 测试 Teacher 一对多 Student 时开启
//	private Teacher teacher;// 测试 Student 多对一 Teacher 时开启
}

package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guo
 * @date 2020/9/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
	private int id;
	private String name;

	private List<Student> studentList;
}

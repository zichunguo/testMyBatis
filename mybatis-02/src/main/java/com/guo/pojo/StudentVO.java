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
public class StudentVO {
	private int id;
	private String name;
	private int tid;
	private String teacherName;
}

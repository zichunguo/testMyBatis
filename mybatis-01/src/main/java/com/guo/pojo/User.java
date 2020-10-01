package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guo
 * @date 2020/9/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String name;
	private int age;
}

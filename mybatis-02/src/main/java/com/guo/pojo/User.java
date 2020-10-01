package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author guo
 * @date 2020/9/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Alias("user")
public class User implements Serializable {
	private int id;
	private String name;
	private int age;
}

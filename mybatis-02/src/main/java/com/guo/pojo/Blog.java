package com.guo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author guo
 * @date 2020/9/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
	private String id;
	private String title;
	private String author;
	private Date createTime;
	private int views;
}

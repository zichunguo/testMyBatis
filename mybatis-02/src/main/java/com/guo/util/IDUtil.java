package com.guo.util;

import java.util.UUID;

/**
 * @author guo
 * @date 2020/9/28
 */
public class IDUtil {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}

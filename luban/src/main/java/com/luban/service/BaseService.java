package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: xingbinjie
 * @Desc:  即使父类没有注解 spring也会递归找到父类的注解 加以注入
 * @Version: 0.0.1
 * @Date: 2020/11/24
 */
public class BaseService {
	@Autowired
	public OrderService orderService;
}

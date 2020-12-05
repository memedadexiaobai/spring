package com.luban.service;

import com.luban.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: xingbinjie
 * @Desc:
 * @Value("#{userService}")
 *        public UserService userService;  可以直接注入bean
 *
 *        $ 代表占位符 使用Environment中的内容填充
 *        # 代表spring表达式 回去寻找bean
 * @Version: 0.0.1
 * @Date: 2020/11/23
 */
@Component
public class OrderService {
	@Value("#{userService}")
	public UserService userService;


}

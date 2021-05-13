package com.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 完全注解开发配置类
 */
@Configuration  // 声明为配置类
@ComponentScan(basePackages = {"com.aspectj"})  // 替代开启注解扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)  // 替代生成代理对象
public class ConfigAspectJ {
}

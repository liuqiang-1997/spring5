package comment.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"comment.demo"})
/**
 *   开启组件扫描-->
 *     @ComponentScan(basePackages = {"comment.demo"})
 *
 *    相当于
 *
 *     <context:component-scan base-package="comment.demo"></context:component-scan>
 */
public class SpringConfig {

}

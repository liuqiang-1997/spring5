package comment.demo;

/**
 *  IOC容器-基于注解方式操作bean管理
 *
 *  1，Spring针对Bean管理中创建对象提供注解（都可用于创建bean实例对象）
 *       （1）@Component：普通组件，都可用它创建对象
 *       （2）@Service：使用在业务逻辑层上（service层）
 *       （3）@Controller：使用在web层
 *       （4）@Repository：使用在Dao持久层
 *
 * 2，基于注解方式实现创建对象
 *        （1）引入依赖jar包：spring-aop-5.2.6.RELEASE.jar
 *        （2）开启组件扫描（告诉spring在那些类下存在注解）（bean10.xml)
 *        （3）创建类，在类上面添加创建对象注解
 *             在注解中的value属性值可以不写，默认为类名称，首字母小写
 *             （@Component(value = "userServices") ）
 *
 * 3，开启组件扫描的细节配置
 *
 * 4，基于注解方式实现属性注入  (示例comment.demo.service.UserServices.java)
 *        （1）AutoWired：根据属性类型进行自动装配
 *
 *        （2）Qualifier：根据属性名称进行注入
 *
 *        （3）Resource：可以根据类型注入，也可根据属性名称注入
 *
 *        （4）Value：注入普通类型属性
 *
 * 5，完全注解开发
 *     （1）创建配置类，替代xml的配置文件
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class DemoInfo2 {
}

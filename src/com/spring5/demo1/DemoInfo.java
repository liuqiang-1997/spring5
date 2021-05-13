package com.spring5.demo1;

/** IOC容器-Bean管理操作
 *        基于xml方式创建对象注入属性
 * DI：依赖注入，就是注入属性(先创建对象后注入属性)
 * 1，第一种注入方式：使用set方法进行注入（示例Book类）
 *        （1）创建类 -> 定义属性和对应的set方法
 *        （2）在Spring配置文件配置对象创建，配置属性注入
 *
 * 2，第二种注入方式：使用有参构造器进行注入（示例Orders类）
 *        （1）创建类 -> 定义属性和创建对应的有参构造器
 *        （2）在Spring配置文件中进行配置
 *
 * 3，了解方式：p名称空间注入
 *        （1）在配置文件中添加属性 xmlns:p="http://www.springframework.org/schema/p"
 *        （2）在bean标签中使用 p:属性名="" 方式进行属性注入
 *
 * 4， xml注入其他类型属性 （示例Book类）
 *     1。字面量：属性的固定值
 *         （1）null值
 *                  对应的属性值使用 <null/> 标签替代
 *         （2）属性值包含特殊符号
 *                <![CDATA[带有特殊符号的内容 ]]> ; 使用转义字符
 *
 * 5，注入属性 （分三种）
 *    5.1 外部bean  （示例service与dao）
 *         （0）要求：创建两个类：service类与dao类，在service中调用dao里的方法
 *         （1）在service中声明dao类型的属性以及对应的set方法
 *         （2）Spring配置文件中进行配置 bean2.xml
 *    5.2 内部bean  （示例bean包下的Dept类与Emp类）
 *         （1）在实体类之间表示一对多关系
 *         （2）Spring配置文件中进行配置 bean3.xml
 *    5.3 级联赋值 （示例bean包下的Dept类与Emp类）
 *         （第一种）Spring配置文件中进行配置 bean4.xml
 *         （第二种）需要在有对象属性的类中设置其对应的get方法 （示例Emp类）
 *
 * 6，xml注入集合属性 （示例collectiontype包下Stu类与Course类,配置文件bean5.xml）
 *    6.1 注入数组类型属性
 *
 *    6.2 注入List集合类型属性
 *
 *    6.3 注入Map集合类型属性
 *
 *    步骤：1，创建类，定义数组，list，map，set类型的属性，并生成对应的set方法
 *         2，Spring配置文件中进行配置(配置文件bean5.xml)
 *
 * 7，提取集合注入部分 （示例collectiontype包下books类，bean55.xml)
 *    （1）在Spring配置文件中引入名称空间 util
 *    （2）使用util标签完成list集合注入提取
 *
 * 8，工厂bean(FactoryBean)
 *   Spring有两种类型bean：普通 bean和工厂 bean
 *       普通bean：配置文件中定义bean类型就是返回类型 （任意示例bean）
 *       工厂bean：配置文件中定义bean类型可以和返回类型不同（示例factorybean包下MyBean，bean6.xml）
 *               （1）创建类，让这个类作为工厂bean，实现接口FactoryBean
 *               （2）实现接口里的方法，在实现的方法里定义返回的bean类型
 *
 * 9，bean作用域（示例collectiontype包下books类，bean55.xml)
 *     （1） 在Spring中可以设置创建bean实例是单实例还是多实例 （单实例对象地址值相同）
 *     （2） 在Spring中，默认情况下创建的bean实例为单实例
 *     （3） 在Spring配置文件中的bean标签中有属性（scope）用于设置单实例还是多实例
 *                scope属性值：
 *                        1，singleton 表示单实例对象（默认值）加载Spring配置文件时就会创建单实例对象
 *                        2，prototype 表示多实例对象 调用getBean方法时候创建多实例对象
 *
 * 10，bean生命周期（示例com.spring5.bean.Orders与MyBeanPost,bean7.xml）
 *       （1）通过构造器创建bean实例 (无参数构造）
 *       （2）为bean的属性设置值和对其他bean的引用 (调用set方法)
 *       （3）调用bean的初始化方法（需要进行配置初始化方法）
 *       （4）使用bean（获取bean实例对象）
 *       （5）当容器关闭的时候，调用bean的销毁方法（需要进行配置销毁方法）
 *     10.1 bean的后置处理器：（有后置处理器之后，bean的生命周期有七步）MyBeanPost
 *        （1）通过构造器创建bean实例 (无参数构造）
 *        （2）为bean的属性设置值和对其他bean的引用 (调用set方法)
 *        （   将bean实例传递给bean后置处理器的方法 postProcessBeforeInitialization
 *        （3）调用bean的初始化方法（需要进行配置初始化方法）
 *        （   将bean实例传递给bean后置处理器的方法 postProcessAfterInitialization
 *        （4）使用bean（获取bean实例对象）
 *        （5）当容器关闭的时候，调用bean的销毁方法（需要进行配置销毁方法）
 *       注： 创建后置处理器后，会为配置文件中的每一个bean实例都配置后置处理器
 *
 * 11，基于xml的bean管理自动装配（示例autowire包,bean8.xml）
 *    （根据指定装配规则(属性名或属性类型)，Spring自动将匹配的属性值进行注入）
 *    11.1 自动装配过程
 *         bean标签中的属性autowire属性，可用来完成自动装配
 *             autowire属性值：
 *                    byName：根据属性名称注入，但注入值bean的id需要和类属性名一致
 *                    byType：根据属性类型注入，但不能声明多个同类型注入值bean
 *
 * 12，引入外部属性文件 (示例bean9.xml)
 *
 *
 * ################################################
 *
 *
 *
 *
 */
public class DemoInfo {

}

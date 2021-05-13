package com.spring5.bean;

/**
 * bean生命周期演示
 *       （1）通过构造器创建bean实例 (无参数构造）
 *       （2）为bean的属性设置值和对其他bean的引用 (调用set方法)
 *       （3）调用bean的初始化方法（需要进行配置初始化方法）
 *       （4）使用bean（获取bean实例对象）
 *       （5）当容器关闭的时候，调用bean的销毁方法（需要进行配置销毁方法）
 */
public class Orders {
    private String oname;

    public Orders() {
        System.out.println("第一步：执行无参构造器创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步：调用set方法设置属性值");
    }

    // 创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步：执行初始化方法");
    }

    // 创建执行的销毁方法
    public void destroyMethod(){
        System.out.println("第五步：执行销毁方法");
    }
}

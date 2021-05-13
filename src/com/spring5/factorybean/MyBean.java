package com.spring5.factorybean;

import com.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;
// 设置Mybean返回的类型为Course
public class MyBean implements FactoryBean<Course> {
    @Override
    /**
     * 返回bean实例；自定义返回bean
     */
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    /**
     * 返回bean类型
     */
    public Class<?> getObjectType() {
        return Course.class;
    }

    @Override
    /**
     * 判断是否为单例
     */
    public boolean isSingleton() {
        return false;
    }
}

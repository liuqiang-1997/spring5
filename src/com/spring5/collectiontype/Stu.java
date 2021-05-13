package com.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    // 数组类型属性
    private String[] course;

    // List集合类型属性
    private List<String> list;

    // 对象List集合类型属性
    private List<Course> courseList;


    // Map集合类型属性
    private Map<String,String> maps;

    //Set集合类型属性
    private Set<String> sets;

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test(){
        System.out.println("数组类型属性-->"+Arrays.toString(course));
        System.out.println("List集合类型属性-->"+list);
        System.out.println("Map集合类型属性-->"+maps);
        System.out.println("Set集合类型属性-->"+sets);
        System.out.println("对象List集合类型属性-->"+courseList);
    }
}

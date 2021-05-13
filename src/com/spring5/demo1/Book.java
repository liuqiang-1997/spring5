package com.spring5.demo1;

/**
 * 演示使用set方法进行注入属性(依赖注入)
 */

public class Book {
    // 1 创建属性
    private String bname;
    private String bauthor;
    private String address;

    // 2 创建属性对应的set方法

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo(){
        System.out.println("bname:"+bname+"\nbauthor:"+bauthor+"\naddress:"+address);
    }
}

package com.spring5.bean;

/**
 * 员工类
 */
public class Emp {
    private String ename;
    private String gender;
    private Dept dept;  // 员工所属部门，使用对象形式表示

    public Dept getDept() {  // 第二种级联赋值方法
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void showInfo(){
        System.out.println("ename:"+ename+"\ngender:"+gender+"\ndept:"+dept);
    }

}

package com.spring5.demo1;

/**
 * 使用有参数构造器进行注入
 */
public class Orders {
    // 属性
    private String oname;
    private String address;
    //
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void testDemo(){
        System.out.println("oname:"+oname+"\naddress:"+address);
    }
}

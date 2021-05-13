package com.spring5.collectiontype;

import java.util.List;

public class Books {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void testbooks() {
        System.out.println( "books{" +
                "list=" + list +
                '}');
    }
}

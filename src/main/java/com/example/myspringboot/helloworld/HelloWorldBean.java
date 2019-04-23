package com.example.myspringboot.helloworld;

import lombok.Data;

@Data
public class HelloWorldBean {

    private String name;

    public HelloWorldBean(String name) {
        super();
        this.name = name;
        // TODO Auto-generated constructor stub
    }
}

package com.example.myspringboot.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
@JsonFilter("MyBeanFilter")    //MyBean에 가지고 있는 값을 임의로 조정하여 client에게 공개여부 조정 가능
public class MyBean {

    //Bean 에 3가지 정보

    private String name;
    private String age;
    private String address;


    public MyBean(String name, String age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

}

package com.example.myspringboot.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    // 1개의 데이터
    // name, age 제어
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveMyBean(){
        MyBean myBean = new MyBean("LUUU","33","Seoul");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","age");

        FilterProvider filters = new SimpleFilterProvider().addFilter("MyBeanFilter", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(myBean);
        mappingJacksonValue.setFilters(filters);


        return  mappingJacksonValue;
    }

    // 여러개 데이터
    // age, address 제어
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfMyBean(){
        List<MyBean> list = Arrays.asList(
                new MyBean("하하","11","서울"),
                new MyBean("그그","22","수원"),
                new MyBean("사사사","33","용인")
        );

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","age");

        FilterProvider filters = new SimpleFilterProvider().addFilter("MyBeanFilter", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filters);


        return  mappingJacksonValue;
    }

}

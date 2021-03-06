package com.example.myspringboot.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {

    private Integer id;

    @Size(min=2, message="2글자 이상으로 입력해주세요")
    @ApiModelProperty(notes = "Name should have at least 2 characters")


    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date should be in the past")
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s]", id, name);
    }

}

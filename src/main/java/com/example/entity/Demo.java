package com.example.entity;

import com.example.InterfaceOne;
import com.example.InterfaceTwo;
import lombok.Synchronized;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Demo {
    @NotNull(message = "email不能为空",groups = InterfaceOne.class)
    @Size(min = 5,max = 15)
    private String email;

    @NotNull
    @Size(min = 8,message = "密码最少8位数",groups = {InterfaceOne.class, InterfaceTwo.class})
    private String passWord;

    @NotNull(message = "电话不能为空",groups = InterfaceTwo.class)
    private String phone;
}

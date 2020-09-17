package com.example.zhujie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {


    @Conditional(Windows.class)
    @Bean("张三")
    public Person getPerson1(){
        return new Person("张三","123");
    }

    @Bean("李四")
    @Conditional(Linux.class)
    public Person getPerson2(){
        return new Person("李四","456");
    }
}

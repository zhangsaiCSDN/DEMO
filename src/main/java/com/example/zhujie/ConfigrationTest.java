package com.example.zhujie;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ConfigrationTest {

    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);

    @Test
    public void test1(){
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}

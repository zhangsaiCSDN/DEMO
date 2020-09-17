package com.example.zhujie;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Linux implements Condition {
    @Override
    public boolean matches(ConditionContext var1, AnnotatedTypeMetadata var2) {
        //方法返回true，则注入该注解修饰的@Bean
        return false;
    }
}

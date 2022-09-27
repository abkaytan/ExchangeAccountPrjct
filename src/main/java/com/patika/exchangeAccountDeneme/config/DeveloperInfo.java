package com.patika.exchangeAccountDeneme.config;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface DeveloperInfo {

    public enum Level{
        JUNIOR, MID, SENIOR, LEAD
    }

    Level level() default Level.JUNIOR;
    String url() default "";
    String createdBy() default "";
    String email() default "";

}

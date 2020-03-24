package com.shaylee.common.datasource.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Title: Mapper
 * Project: shaylee-common
 *
 * @author Adrian
 * @date 2020-03-23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisMapper {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any
     */
    String value() default "";

}

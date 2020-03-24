package com.shaylee.common.datasource.config;

import com.shaylee.common.datasource.annotation.MybatisMapper;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Mybatis配置
 * Project: shaylee-archetype
 *
 * @author Adrian
 * @date 2020-03-09
 */
@Configuration
@MapperScan(value = "com.shaylee.**.dao", annotationClass = MybatisMapper.class)
public class MyBatisConfig {

}

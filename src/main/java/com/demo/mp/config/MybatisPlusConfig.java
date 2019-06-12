package com.demo.mp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.demo.mp.mapper")
public class MybatisPlusConfig {


}

package com.study.example.leetcodestudy.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.study.example.leetcodestudy.aspect")
public class ConfigAOP {


}

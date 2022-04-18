package com.study.example.leetcodestudy.aspectTest;

import com.study.example.leetcodestudy.aspect.ConfigAOP;
import com.study.example.leetcodestudy.aspect.IPowerService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {

    @Test
    public void testAspect(){

        // 初始化注解式IOC容器
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext(ConfigAOP.class);
        // 从容器中获取PowerService实例
        IPowerService powerService =  (IPowerService)ctx.getBean(IPowerService.class);
        // 调用PowerService的login方法
        boolean bool =  powerService.login("yangchao", "123");
        // 关闭IOC容器
        ctx.close();
    }
}

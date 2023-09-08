package com.study.example.leetcodestudy.test.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

public class AwarePostProcessor implements BeanPostProcessor {

    private ConfigurableApplicationContext applicationContext;

    public AwarePostProcessor(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof Aware){
                if (bean instanceof TimeAware) {
                    ((TimeAware) bean).setStringTime(new Date());
                }
            }
            return bean;
    }
}

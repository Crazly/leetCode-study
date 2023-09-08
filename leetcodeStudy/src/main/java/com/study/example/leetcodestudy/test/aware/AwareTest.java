package com.study.example.leetcodestudy.test.aware;

import com.study.example.leetcodestudy.util.DateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
@Import(AwarePostProcessor.class)
public class AwareTest implements TimeAware{

    Date date;
    @Override
    public void setStringTime(Date date) {
        this.date=date;
    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AwareTest.class);
        AwareTest bean = context.getBean(AwareTest.class);
        System.out.println(bean.date);

    }

    private static long getDuration(Date date1, Date date2) {
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date2.toInstant(), ZoneId.systemDefault());
        Duration between1 = Duration.between(localDateTime1, localDateTime2);
        return between1.toHours();
    }


}

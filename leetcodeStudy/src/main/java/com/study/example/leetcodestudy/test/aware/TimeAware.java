package com.study.example.leetcodestudy.test.aware;

import org.springframework.beans.factory.Aware;

import java.util.Date;

public interface TimeAware extends Aware {
    public void setStringTime(Date date);
}

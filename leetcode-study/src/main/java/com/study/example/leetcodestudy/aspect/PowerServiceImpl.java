package com.study.example.leetcodestudy.aspect;

import org.springframework.stereotype.Service;

@Service
public class PowerServiceImpl implements IPowerService{
    @Override
    public boolean login(String userName, String password) {
        boolean bool = false;
        System.out.println("to execute PowerServiceImpl.login() method...");
        bool = userName != null && userName.startsWith("yang");
        return bool;
    }
}

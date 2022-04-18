package com.study.example.leetcodestudy.test;

public class SingleStudy {

    private volatile static SingleStudy singleStudy;

    public SingleStudy() {
    }

    public SingleStudy getSingleStudyTest(){

        if (null==singleStudy) {
            synchronized (SingleStudy.class){
                if (null==singleStudy) {
                    singleStudy = new SingleStudy();
                }
            }
        }
        return singleStudy;
    }

}

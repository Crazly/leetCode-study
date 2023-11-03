package com.study.example.leetcodestudy.test.study01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EatableTest {
    public static void main(String[] args) {
        List<Eatable> eatables = new ArrayList<>();
        Eatable c = new Chinese();
        Eatable a = new American();
        Eatable i = new Indian();
        @SuppressWarnings("unused") Eatable e = new Indian();
        eatables.add(c);
        eatables.add(a);
        eatables.add(i);
        for (Eatable eatable : eatables) {
            eatable.eat();
        }

        Eatable.sub();

    }
}

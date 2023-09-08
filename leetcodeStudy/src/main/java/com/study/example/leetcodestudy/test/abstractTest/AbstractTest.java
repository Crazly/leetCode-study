package com.study.example.leetcodestudy.test.abstractTest;

public class AbstractTest {

    public static void main(String[] args) {

        Person student = new Student("", 10);
        student.talk();
        student.eat();
    }


    static abstract class Person{

        String name;
        Integer age;

        public Person() {
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public abstract void eat();

        public void talk(){
            System.out.println("people talk");
        }


    }

   public static class Student extends Person{

       public Student(String name, Integer age) {
           super(name, age);
       }

       @Override
       public void eat() {
           System.out.println("student eat");
       }
   }

}

package com.dysjsjy.hot100Java;

public class test {
    public static void main(String[] args) {
        Dog.sayHello();
    }
}


// Java静态方法也是可以继承的
class Animal {
    public void shout() {
        System.out.println("动物叫");
    }

    public static void sayHello() {
        System.out.println("hello");
    }
}

class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪汪");
    }
}
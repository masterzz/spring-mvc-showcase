package org.springframework.jvm;

public class Demo1 {
    public int math() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.math();
    }
}

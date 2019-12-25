package org.springframework.log;

public class Father {
    private String a;
    private String b;
    public  String d ;

    Father() {
        d = "222";
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}

class Son extends  Father{
    public static void main(String[] args) {
        System.out.println(new Father().d);
    }
}

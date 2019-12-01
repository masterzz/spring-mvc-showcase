package org.springframework.concurency;

public class TestCalling {
    public static void main(String[] args) {
        CallingNumber callingNumber1 = new CallingNumber();
        CallingNumber callingNumber2 = new CallingNumber();
        CallingNumber callingNumber3 = new CallingNumber();
        CallingNumber callingNumber4 = new CallingNumber();

        new Thread(callingNumber1).start();
        new Thread(callingNumber2).start();
        new Thread(callingNumber3).start();
        new Thread(callingNumber4).start();
    }
}

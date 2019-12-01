package org.springframework.concurency;

public class CallingNumber implements Runnable {
    private static int i = 1;

    @Override
    public void run() {
        call();
    }

    private void call() {
        while (true)
            synchronized (this) {
                System.out.println(Thread.currentThread() + ":" +i++);
            }
    }
}

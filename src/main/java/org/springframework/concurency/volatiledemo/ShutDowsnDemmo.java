package org.springframework.concurency.volatiledemo;

public class ShutDowsnDemmo extends Thread{
    private volatile boolean started=false;

    @Override
    public void run() {
        while(started){

        }
    }
    public void shutdown(){
        started=false;
    }
}

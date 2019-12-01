package org.springframework.concurency.synchro.homework;

public class App {
    public static void main(String[] args) {
        AirLineService airLineService = new AirLineService();
        for(int i =1; i <= 5000; i ++){
            airLineService.getTicket(i);
        }

    }
}

package org.springframework.concurency.synchro.homework;

import java.util.List;

public class AirLine extends Thread {
    String airName;

    private List<User> userList;

    AirLine() {
    }

    AirLine(String airName ,List<User> users) {
        this.airName = airName;
        this.userList = users;
    }

    @Override
    public void run() {
        while (true) {
            if(userList.size() >0 ) {
                User first = userList.remove(0);
                synchronized (first) {
                    System.out.println(this.airName + "给第" + first.getId() + "位用户提供机票");
                }
            }

        }
    }
}

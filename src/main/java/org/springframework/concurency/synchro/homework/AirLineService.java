package org.springframework.concurency.synchro.homework;

import java.util.ArrayList;
import java.util.List;

public class AirLineService {
    private List<AirLine> airLines;
    private List<User> users;

    public AirLineService() {
        users = new ArrayList<>();
        airLines = new ArrayList<AirLine>();
        airLines.add(new AirLine("东方航空",users));
        airLines.add(new AirLine("南方航空",users));
        airLines.add(new AirLine("海南航空",users));

        for(AirLine airLine : airLines)
            airLine.start();
    }

    public void getTicket(int i) {
        User user = new User();
        user.setId(i);
        this.users.add(user);
    }
}

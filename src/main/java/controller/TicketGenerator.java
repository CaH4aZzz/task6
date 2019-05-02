package controller;

import java.util.ArrayList;
import java.util.List;

public class TicketGenerator {

    public List<String> generateTicketsList(int ticketCount, int digitCount) {
        List<String> ticketList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            ticketList.add(getRandomTicket(digitCount));
        }
        return ticketList;
    }

    private String getRandomTicket(int digitCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digitCount; i++) {
            sb.append(getRandomNumberInRange(0, 9));
        }
        return sb.toString();
    }

    private int getRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}

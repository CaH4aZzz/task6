package controller;

import java.util.List;

public abstract class TicketCounter {

    int getHappyTicketsCount(List<String> ticketList){
        int happyCounter = 0;
        for (String ticket : ticketList) {
            if (isHappyTicket(ticket)) {
                happyCounter++;
            }
        }
        return happyCounter;
    }

    protected abstract boolean isHappyTicket(String ticket);


}

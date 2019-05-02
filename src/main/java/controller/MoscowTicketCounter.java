package controller;

import java.util.List;

public class MoscowTicketCounter implements TicketCounter {

    public int getHappyTicketsCount(List<String> ticketList) {
        int happyCounter = 0;
        for (String ticket : ticketList) {
            if (isHappyTicket(ticket)) {
                happyCounter++;
            }
        }
        return happyCounter;
    }

    private boolean isHappyTicket(String ticket) {
        int firstHalf = Integer.parseInt(ticket.substring(0, ticket.length() / 2));
        int secondHalf = Integer.parseInt(ticket.substring(ticket.length() / 2, ticket.length()));

        return getHalfSum(firstHalf) == getHalfSum(secondHalf);
    }

    private int getHalfSum(int halfNumber) {
        int sum = 0;
        while (halfNumber > 0) {
            sum += halfNumber % 10;
            halfNumber = halfNumber / 10;
        }

        return sum;
    }
}

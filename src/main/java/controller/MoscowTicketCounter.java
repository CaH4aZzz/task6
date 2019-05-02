package controller;

import java.util.List;

public class MoscowTicketCounter extends TicketCounter {


    protected boolean isHappyTicket(String ticket) {
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

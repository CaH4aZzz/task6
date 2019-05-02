package controller;

import java.util.List;

public class PiterTicketCounter extends TicketCounter {
    private final static boolean EVEN = true;
    private final static boolean ODD = false;


    protected boolean isHappyTicket(String ticket) {
        int even = getEvenOrOdd(ticket, EVEN);
        int odd = getEvenOrOdd(ticket, ODD);
        return getSumOfEvenOrOdd(even) == getSumOfEvenOrOdd(odd);
    }

    private int getEvenOrOdd(String ticket, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        char[] ticketArray = ticket.toCharArray();
            for (int i = 0; i < ticketArray.length; i++) {
                if (i % 2 == 0 == isEven) {
                    sb.append(ticketArray[i]);
                }
            }
        return Integer.parseInt(sb.toString());
    }


    private int getSumOfEvenOrOdd(int halfNumber) {
        int sum = 0;
        while (halfNumber > 0) {
            sum += halfNumber % 10;
            halfNumber = halfNumber / 10;
        }
        return sum;
    }
}

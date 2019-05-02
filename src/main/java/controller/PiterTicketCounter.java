package controller;

import java.util.List;

public class PiterTicketCounter implements TicketCounter {
    private final static boolean isEven = true;
    private final static boolean isOdd = false;

    @Override
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
        int even = getEvenOrOdd(ticket, isEven);
        int odd = getEvenOrOdd(ticket, isOdd);
        System.out.println(even);
        System.out.println(odd);
        return getSumOfEvenOrOdd(even) == getSumOfEvenOrOdd(odd);
    }

    private int getEvenOrOdd(String ticket, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        char[] ticketArray = ticket.toCharArray();
        if (isEven) {
            for (int i = 0; i < ticketArray.length; i++) {
                if (i % 2 == 0) {
                    sb.append(ticketArray[i]);
                }
            }
        } else {
            for (int i = 0; i < ticketArray.length; i++) {
                if (i % 2 != 0) {
                    sb.append(ticketArray[i]);
                }
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

package controller;

import exception.NoAlgorithmException;
import view.ConsoleWorker;

import java.io.IOException;
import java.util.List;

public class TicketsDispatcher {
    private final static String MOSCOW = "Moscow";
    private final static String PITER = "Piter";

    private FileWorker fileWorker;
    private ConsoleWorker consoleWorker;
    private TicketGenerator ticketGenerator;

    public TicketsDispatcher(FileWorker fileWorker, ConsoleWorker consoleWorker, TicketGenerator ticketGenerator) {
        this.fileWorker = fileWorker;
        this.consoleWorker = consoleWorker;
        this.ticketGenerator = ticketGenerator;
    }

    public void start() throws IOException, NoAlgorithmException {
        createFileWithTickets();
        List<String> ticketList = getTicketList();
        TicketCounter ticketCounter = getTicketCounter();
        showTicketCount(ticketCounter.getHappyTicketsCount(ticketList));
    }

    private List<String> getTicketList() {
        consoleWorker.printMessage("Please enter path to the file with tickets in format <fileName.txt>");
        List<String> ticketList = null;
        try {
            ticketList = fileWorker.getFileContentAsList(consoleWorker.getUserInput());
        } catch (IOException e) {
            consoleWorker.printException(e);
            System.exit(0);
        }
        return ticketList;
    }

    private TicketCounter getTicketCounter() {

        consoleWorker.printMessage("Where to find algorithm?");
        String filePath;
        String algorithm;
        TicketCounter ticketCounter = null;
        try {
            filePath = consoleWorker.getUserInput();
            algorithm = fileWorker.getAlgorithm(fileWorker.getFileContentAsList(filePath), MOSCOW, PITER);
            if (algorithm.equals(MOSCOW)) {
                ticketCounter = new MoscowTicketCounter();
            } else if (algorithm.equals(PITER)) {
                ticketCounter = new PiterTicketCounter();
            }
        } catch (NoAlgorithmException | IOException e) {
            consoleWorker.printException(e);
            System.exit(0);
        }

        return ticketCounter;
    }

    private void createFileWithTickets() {
        List<String> list = ticketGenerator.generateTicketsList(1000, 6);
        try {
            fileWorker.writeTicketsToFile("tickets.txt", list);
        } catch (IOException e) {
            consoleWorker.printException(e);
            System.exit(0);
        }
    }

    private void showTicketCount(int ticketCount) {
        consoleWorker.printMessage("[ " + ticketCount + " ] HappyTicket(s) had been found");
    }
}

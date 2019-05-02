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

    public void start() {
        createAndWriteTicketsToFile();
        try {
            List<String> ticketList = fileWorker.getFileContentAsList("tickets.txt");
            consoleWorker.printMessage("Where to find algorithm?");
            String filePath = consoleWorker.getUserInput();
            TicketCounter ticketCounter = chooseAlgorithm(filePath);
            consoleWorker.printMessage("[ " + ticketCounter.getHappyTicketsCount(ticketList) + " ] HappyTicket(s) had been found");
        } catch (NoAlgorithmException | IOException e) {
            consoleWorker.printException(e);
        }
    }

    private TicketCounter chooseAlgorithm(String filePath) throws NoAlgorithmException, IOException {
        return fileWorker.getAlgorithm(fileWorker.getFileContentAsList(filePath), MOSCOW, PITER);
    }

    private void createAndWriteTicketsToFile() {
        List<String> list = ticketGenerator.generateTicketsList(1000, 6);
        try {
            fileWorker.writeTicketsToFile("tickets.txt", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
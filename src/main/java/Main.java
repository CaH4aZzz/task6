import controller.FileWorker;
import controller.TicketGenerator;
import controller.TicketsDispatcher;
import exception.NoAlgorithmException;
import view.ConsoleWorker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, NoAlgorithmException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TicketsDispatcher dispatcher = new TicketsDispatcher(new FileWorker(), new ConsoleWorker(reader), new TicketGenerator());
        dispatcher.start();
    }
}

package view;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleWorker {
    private BufferedReader reader;

    public ConsoleWorker(BufferedReader reader) {
        this.reader = reader;
    }

    public void printMessage(Object message) {
        System.out.println(message);
    }

    public void printInstruction(String instruction) {
        System.out.println(instruction);
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public String getUserInput() throws IOException {
        return reader.readLine();
    }
}

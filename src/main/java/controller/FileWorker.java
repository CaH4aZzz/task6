package controller;

import exception.NoAlgorithmException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWorker {

    public List<String> getFileContentAsList(String fileName) throws IOException {
        Stream<String> stream = Files.lines(Paths.get(fileName));
        return stream.collect(Collectors.toList());
    }

    public void writeTicketsToFile(String fileName, List<String> ticketList) throws IOException {
        Files.write(new File(fileName).toPath(), ticketList);
    }

    public TicketCounter getAlgorithm(List<String> stringList, String moskowAlg, String piterAlg) throws NoAlgorithmException {
        for (String line : stringList) {
            if (line.contains(moskowAlg)) {
                return new MoscowTicketCounter();
            } else if (line.contains(piterAlg)) {
                return new PiterTicketCounter();
            }
        }
        throw new NoAlgorithmException(moskowAlg + " and " + piterAlg + " were not found in file");
    }
}

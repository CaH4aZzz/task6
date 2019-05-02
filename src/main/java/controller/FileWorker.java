package controller;

import exception.NoAlgorithmException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWorker {

    public List<String> getFileContentAsList(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public void writeTicketsToFile(String fileName, List<String> ticketList) throws IOException {
        Files.write(new File(fileName).toPath(), ticketList);
    }

    public String getAlgorithm(List<String> stringList, String moskowAlg, String piterAlg) throws NoAlgorithmException {
        String algorithm = null;
        for (String line : stringList) {
            if (line.contains(moskowAlg)) {
                algorithm = moskowAlg;
            } else if (line.contains(piterAlg)) {
                algorithm = piterAlg;
            }
        }
        if (algorithm == null)
            throw new NoAlgorithmException("Algorithm was not found");
        return algorithm;
    }
}

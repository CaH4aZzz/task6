package view;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by avokado on 02.05.2019.
 */
public class ConsoleWorkerTest {
    @Test
    public void getUserInput() throws Exception {
        System.out.println("sdfsdf");
        String expected = "test";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String actual = reader.readLine();
        assertEquals(expected, actual);
    }
}
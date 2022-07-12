package com.testTask;

import java.io.PrintWriter;

public class ConsoleLogger extends Logger {

    private final PrintWriter pw = new PrintWriter(System.out, true);

    public ConsoleLogger(String level) {
        super(level);
    }

    public void writing(String message) {
        pw.println(message);
    }
}

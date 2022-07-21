package com.Nekhoroshev.Logger;

import lombok.Getter;
import lombok.Setter;

import java.io.PrintWriter;

@Getter
@Setter
public class ConsoleLogger extends Logger {

    private final PrintWriter pw = new PrintWriter(System.out, true);

    public ConsoleLogger(Level level) {
        super(level);
    }

    public void write(String message) {
        pw.println(message);
    }
}

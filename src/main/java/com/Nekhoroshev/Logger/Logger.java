package com.Nekhoroshev.Logger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Logger implements ILogger {

    private Level level;

    @Override
    public void error(String message, Error error) {
        write(message + " Error type: " + error.toString() + " Error message: " + error.getMessage());
    }

    @Override
    public void info(String message) {
        if (level == Level.INFO || level == Level.DEBUG) {
            write(message);
        }
    }

    @Override
    public void debug(String message) {
        if (level == Level.DEBUG) {
            write(message);
        }
    }

    abstract void write(String message);
}

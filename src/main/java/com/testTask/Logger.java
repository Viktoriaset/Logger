package com.testTask;

public abstract class Logger implements ILogger {

    enum Level {ERROR, INFO, DEBUG}

    private Level level;

    Logger(String level) {
        if (level == "ERROR") {
            this.level = Level.ERROR;
        } else if (level == "INFO") {
            this.level = Level.INFO;
        } else if (level == "DEBUG") {
            this.level = Level.DEBUG;
        } else {
            throw new IllegalArgumentException(level + " is not a level logger");
        }
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public void error(String message) {
        writing(message);
    }

    @Override
    public void info(String message) {
        if (level == Level.INFO || level == Level.DEBUG) {
            writing(message);
        }
    }

    @Override
    public void debug(String message) {
        if (level == Level.DEBUG) {
            writing(message);
        }
    }

    abstract void writing(String message);
}

package com.testTask;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger extends Logger {

    private String fileName;

    public FileLogger(String level, String fileName) {
        super(level);
        this.fileName = fileName;
    }

    @Override
    void writing(String message) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(message + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

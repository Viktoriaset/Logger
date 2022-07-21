package com.Nekhoroshev.Logger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.FileWriter;
import java.io.IOException;

@Getter
@Setter
public class FileLogger extends Logger {

    private String fileName;

    public FileLogger(Level level, String fileName) {
        super(level);
        this.fileName = fileName;
    }

    @Override
    void write(String message) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(message + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

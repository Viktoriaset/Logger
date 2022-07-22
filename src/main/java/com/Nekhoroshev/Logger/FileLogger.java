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
        StringBuilder sb = new StringBuilder();
        sb.append(message).append(System.lineSeparator());

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

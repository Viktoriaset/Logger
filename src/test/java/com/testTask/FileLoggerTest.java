package com.testTask;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {

    private final String fileName = "Logs";

    @BeforeEach
    public void createFile() {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testCreateLoggerWithNotExitLevel(){

        assertThrows(IllegalArgumentException.class, ()-> new FileLogger("Something",fileName));
    }

    @Test
    public void testErrorForLoggerError(){
        ILogger log = new FileLogger("ERROR", fileName);
        log.error("Error message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("Error message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerError(){
        ILogger log = new FileLogger("ERROR", fileName);
        log.info("Info message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(null, str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDebugForLoggerError(){
        ILogger log = new FileLogger("ERROR", fileName);
        log.debug("debug message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(null, str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testErrorForLoggerInfo(){
        ILogger log = new FileLogger("INFO", fileName);
        log.error("Error message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("Error message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerInfo(){
        ILogger log = new FileLogger("INFO", fileName);
        log.info("Info message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("Info message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDebugForLoggerInfo() {
        ILogger log = new FileLogger("INFO", fileName);
        log.debug("debug message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(null, str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testErrorForLoggerDebug(){
        ILogger log = new FileLogger("DEBUG", fileName);
        log.error("Error message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("Error message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerDebug(){
        ILogger log = new FileLogger("DEBUG", fileName);
        log.info("Info message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("Info message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDebugForLoggerDebug() {
        ILogger log = new FileLogger("DEBUG", fileName);
        log.debug("debug message");

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals("debug message", str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @AfterEach
    public void deletedFile(){
        File file = new File(fileName);
        file.delete();
    }

}
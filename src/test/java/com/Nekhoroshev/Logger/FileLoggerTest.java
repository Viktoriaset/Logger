package com.Nekhoroshev.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerTest {

    private final String fileName = "build/Logs";

    private final String errorMassage = "Error message";
    private final String infoMassage = "Info message";
    private final String debugMassage = "Debug message";

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
    public void testErrorForLoggerError(){
        ILogger log = new FileLogger(Level.ERROR, fileName);
        log.error(errorMassage, new Error());

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertTrue( str.contains(errorMassage));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerError(){
        ILogger log = new FileLogger(Level.ERROR, fileName);
        log.info(infoMassage);

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
        ILogger log = new FileLogger(Level.ERROR, fileName);
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
        ILogger log = new FileLogger(Level.INFO, fileName);
        log.error(errorMassage, new Error());

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertTrue( str.contains(errorMassage));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerInfo(){
        ILogger log = new FileLogger(Level.INFO, fileName);
        log.info(infoMassage);

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(infoMassage, str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDebugForLoggerInfo() {
        ILogger log = new FileLogger(Level.INFO, fileName);
        log.debug(debugMassage);

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
        ILogger log = new FileLogger(Level.DEBUG, fileName);
        log.error(errorMassage, new Error());

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertTrue( str.contains(errorMassage));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInfoForLoggerDebug(){
        ILogger log = new FileLogger(Level.DEBUG, fileName);
        log.info(infoMassage);

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(infoMassage, str);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDebugForLoggerDebug() {
        ILogger log = new FileLogger(Level.DEBUG, fileName);
        log.debug(debugMassage);

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = bufferedReader.readLine();
            assertEquals(debugMassage, str);

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
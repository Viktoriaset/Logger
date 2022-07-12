package com.testTask;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleLoggerTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateLoggerWithNotExitLevel(){
        assertThrows(IllegalArgumentException.class, ()-> new ConsoleLogger("Something"));
    }

    @Test
    public void testErrorForLoggerError(){
        ILogger log = new ConsoleLogger("ERROR");
        log.error("Error message");

        assertEquals("Error message\r\n", outputStream.toString());
    }

    @Test
    public void testInfoForLoggerError(){
        ILogger log = new ConsoleLogger("ERROR");
        log.info("INFO message");

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testDebugForLoggerError(){
        ILogger log = new ConsoleLogger("ERROR");
        log.debug("Debug message");

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testErrorForLoggerInfo(){
        ILogger log1 = new ConsoleLogger("INFO");
        log1.error("Error message");

        assertEquals("Error message\r\n", outputStream.toString());
    }

    @Test
    public void testInfoForLoggerInfo(){
        ILogger log1 = new ConsoleLogger("INFO");
        log1.info("INFO message");

        assertEquals("INFO message\r\n", outputStream.toString());
    }

    @Test
    public void testDebugForLoggerInfo() {
        ILogger log = new ConsoleLogger("INFO");
        log.debug("INFO message");

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testErrorForLoggerDebug(){
        ILogger log = new ConsoleLogger("DEBUG");
        log.error("Error message");

        assertEquals("Error message\r\n", outputStream.toString());
    }

    @Test
    public void testInfoForLoggerDebug(){
        ILogger log = new ConsoleLogger("DEBUG");
        log.info("Info message");

        assertEquals("Info message\r\n", outputStream.toString());
    }

    @Test
    public void testDebugForLoggerDebug(){
        ILogger log = new ConsoleLogger("DEBUG");
        log.debug("debug message");

        assertEquals("debug message\r\n", outputStream.toString());
    }

    @AfterEach
    public void cleanUpStream(){
        System.setOut(null);
    }
}
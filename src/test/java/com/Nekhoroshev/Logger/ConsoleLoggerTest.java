package com.Nekhoroshev.Logger;


import com.sun.javafx.PlatformUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.management.PlatformManagedObject;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleLoggerTest {
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static String stringEnd;
    public final static char lf = '\n';
    public final static char cr = '\r';
    public final static String crlf = "" + cr + lf;

    private final String errorMassage = "Error message";
    private final String infoMassage = "Info message";
    private final String debugMassage = "Debug message";

    @BeforeAll
    public static void setStringEnd(){
        if (PlatformUtil.isWindows()){
            stringEnd = crlf;
        } else if (PlatformUtil.isMac()){
            stringEnd = "" + cr;
        } else {
            stringEnd = "" + lf;
        }
    }

    @BeforeEach
    public void setUpStream(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testErrorForLoggerError(){
        ILogger log = new ConsoleLogger(Level.ERROR);
        log.error(errorMassage, new Error());

        assertTrue( outputStream.toString().contains(errorMassage));
    }

    @Test
    public void testInfoForLoggerError(){
        ILogger log = new ConsoleLogger(Level.ERROR);
        log.info(infoMassage);

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testDebugForLoggerError(){
        ILogger log = new ConsoleLogger(Level.ERROR);
        log.debug(infoMassage);

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testErrorForLoggerInfo(){
        ILogger log1 = new ConsoleLogger(Level.INFO);
        log1.error(errorMassage, new Error());

        assertTrue( outputStream.toString().contains(errorMassage));
    }

    @Test
    public void testInfoForLoggerInfo(){
        ILogger log1 = new ConsoleLogger(Level.INFO);
        log1.info(infoMassage);

        assertEquals(infoMassage + stringEnd, outputStream.toString());
    }

    @Test
    public void testDebugForLoggerInfo() {
        ILogger log = new ConsoleLogger(Level.INFO);
        log.debug(debugMassage);

        assertEquals("", outputStream.toString());
    }

    @Test
    public void testErrorForLoggerDebug(){
        ILogger log = new ConsoleLogger(Level.DEBUG);
        log.error(errorMassage, new Error());

        assertTrue( outputStream.toString().contains(errorMassage));
    }

    @Test
    public void testInfoForLoggerDebug(){
        ILogger log = new ConsoleLogger(Level.DEBUG);
        log.info(infoMassage);

        assertEquals(infoMassage + stringEnd, outputStream.toString());
    }

    @Test
    public void testDebugForLoggerDebug(){
        ILogger log = new ConsoleLogger(Level.DEBUG);
        log.debug(debugMassage);

        assertEquals(debugMassage + stringEnd, outputStream.toString());
    }

    @AfterEach
    public void cleanUpStream(){
        System.setOut(null);
    }
}
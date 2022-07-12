package com.testTask;

/*Написать логгер. Класс, который умеет логировать сообщения в консоль или в файл с различными уровнями INFO, DEBUG, ERROR

Logger - интерфейс
ConcoleLogger - имплементация, которая пишет в консоль
FileLogger - имплементация, которая пишет в файл

Logger logger1 = new ConcoleLogger(INFO)
Logger logger2 = new FileLogger(DEBUG, "filename") - может иметь дополнительные аргументы

Каждая имплементация должна иметь текущий уровень логирования
ERROR>INFO>DEBUG - enum
если указан уровень логгирования ERROR пишем только ERROR
если указан уровень логгирования INFO пишем INFO and ERROR
если указан уровень логгирования DEBUG пишем DBUG and INFO and ERROR

Пример использования:
logger1.info("message1") - логирует "message1" в консоль
logger1.debug("message2") - "message2" не логируется, потому что INFO < DEBUG
logger2.debug("message3") - логируется сообщение "message3"в файл
logger2.error("message4", exception) - логируется сообщение "message4" и exception в файл*/

public interface ILogger {

    void info(String message);

    void debug(String message);

    void error(String message);


}

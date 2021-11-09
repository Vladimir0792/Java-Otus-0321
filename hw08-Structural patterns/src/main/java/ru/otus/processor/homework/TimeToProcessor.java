package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.time.*;



public class TimeToProcessor implements Processor {

    private final LocalDateTime time = LocalDateTime.now();



    public TimeToProcessor() {

    }

    @Override
    public Message process(Message message) {

        if (time.getSecond() % 2 == 0) {

            throw new NullPointerException("Процесс идет в четную секунду");
        }

        return message;
    }
    interface Instant{
        int getSecond();
    }

}

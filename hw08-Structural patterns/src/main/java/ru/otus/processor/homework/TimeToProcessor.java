package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.Optional;

public class TimeToProcessor implements Processor {

    private Instant instant;

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    @Override
    public Message process(Message message) {

        if (Optional.ofNullable(instant).orElse(Clock.systemUTC().instant()).getEpochSecond() % 2 == 0) {
            throw new DateTimeException("Процесс идет в четную секунду");
        }

        return message;
    }

}

package ru.otus.processor.homework;

import org.junit.jupiter.api.Test;
import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.io.IOException;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class TimeToProcessorTest {

    @Test
    void processEven() {
        var evenSecond = 0L;
        var message = getMessage();
        var processor = getProcessor(evenSecond);

        Throwable thrown = assertThrows(DateTimeException.class, () -> {
            processor.process(message);
        });

        assertNotNull(thrown.getMessage());
    }

    @Test
    void processNotEven() throws IOException {

        var notAccident = 1L;
        var message = getMessage();
        var processor = getProcessor(notAccident);

        assertNotNull(processor.process(message));
    }

    private Processor getProcessor(Long second) {

        var processor = new TimeToProcessor();
        var instant = Instant.ofEpochSecond(second);
        TimeToProcessor.Instant instant1 = () -> 0;

        return processor;
    }

    private Message getMessage() {

        var id = 1L;
        var message = new Message.Builder(id).build();
        return message;
    }
}



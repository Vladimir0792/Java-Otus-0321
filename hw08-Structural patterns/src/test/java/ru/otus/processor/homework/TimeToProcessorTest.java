package ru.otus.processor.homework;

import org.junit.jupiter.api.Test;
import ru.otus.model.Message;

import java.io.InterruptedIOException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TimeToProcessorTest {

        private final Message message = new Message.Builder(1L).build();

        @Test
        void shouldThrow() throws InterruptedIOException {
            var timeM = 1L;
            var processor = new TimeToProcessor();
            Runnable code = () -> processor.process(message);

            assertThatThrownBy(code::run).isInstanceOf(IllegalStateException.class);
        }

        @Test
        void shouldNotThrow() throws InterruptedIOException {
            var timeM = 2L;
            var processor = new TimeToProcessor();
            Runnable code = () -> processor.process(message);

            assertThatNoException().isThrownBy(code::run);
        }
    }


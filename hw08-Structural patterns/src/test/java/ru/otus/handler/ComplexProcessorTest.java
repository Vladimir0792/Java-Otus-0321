package ru.otus.handler;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.listener.Listener;
import ru.otus.model.Message;
import ru.otus.processor.Processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComplexProcessorTest {

    @Test
    @DisplayName("Тестируем вызовы процессоров")
    void handleProcessorsTest() throws IOException {
        //given
        var message = new Message.Builder(1L).field7("field7").build();

        var processor1 = Mockito.mock(Processor.class);
        Mockito.when(processor1.process(message)).thenReturn(message);

        var processor2 = Mockito.mock(Processor.class);
        Mockito.when(processor2.process(message)).thenReturn(message);

        var processors = List.of(processor1, processor2);

        var complexProcessor = new ComplexProcessor(processors, (ex) -> {
        });

        //when
        var result = complexProcessor.handle(message);

        //then
        Mockito.verify(processor1).process(message);
        Mockito.verify(processor2).process(message);
        assertThat(result).isEqualTo(message);
    }

    @Test
    @DisplayName("Тестируем обработку исключения")
    void handleExceptionTest() throws IOException {
        //given
        var message = new Message.Builder(1L).field3("field3").field8("field8").build();

        var processor1 = Mockito.mock(Processor.class);
        Mockito.when(processor1.process(message)).thenThrow(new RuntimeException("Test Exception"));

        var processor2 = Mockito.mock(Processor.class);
        Mockito.when(processor2.process(message)).thenReturn(message);

        var processors = List.of(processor1, processor2);

        var complexProcessor = new ComplexProcessor(processors, (ex) -> {
            throw new TestException(ex.getMessage());
        });

        //when
        Assertions.assertThatExceptionOfType(TestException.class).isThrownBy(() -> complexProcessor.handle(message));

        //then
        Mockito.verify(processor1, Mockito.times(1)).process(message);
        Mockito.verify(processor2, Mockito.never()).process(message);
    }

    @Test
    @DisplayName("Тестируем уведомления")
    void notifyTest() {
        //given
        var message = new Message.Builder(1L).field4("field4").field9("field9").build();

        var listener = Mockito.mock(Listener.class);

        var complexProcessor = new ComplexProcessor(new ArrayList<>(), (ex) -> {
        });

        complexProcessor.addListener(listener);

        //when
        complexProcessor.handle(message);
        complexProcessor.removeListener(listener);
        complexProcessor.handle(message);

        //then
        Mockito.verify(listener, Mockito.times(1)).onUpdated(message);
    }

    private static class TestException extends RuntimeException {
        public TestException(String message) {
            super(message);
        }
    }

    }

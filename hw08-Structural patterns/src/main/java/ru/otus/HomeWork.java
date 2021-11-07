package ru.otus;

import ru.otus.handler.ComplexProcessor;
import ru.otus.listener.ListenerPrinterConsole;
import ru.otus.listener.homework.HistoryListener;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;
import ru.otus.processor.LoggerProcessor;
import ru.otus.processor.Processor;
import ru.otus.processor.ProcessorConcatFields;
import ru.otus.processor.ProcessorUpperField10;
import ru.otus.processor.homework.ProcessorField11and12;
import ru.otus.processor.homework.TimeToProcessor;

import java.util.List;


public class HomeWork {

    public static void main(String[] args) {
        List<Processor> processors = List.of(new TimeToProcessor(), new LoggerProcessor(new ProcessorConcatFields()), new LoggerProcessor(new ProcessorUpperField10()),
                new LoggerProcessor(new ProcessorField11and12()), new TimeToProcessor());

        ComplexProcessor complexProcessor = new ComplexProcessor(processors, e -> System.err.println(e));

        ListenerPrinterConsole listenerPrinter = new ListenerPrinterConsole();
        HistoryListener historyListener = new HistoryListener();
        complexProcessor.addListener(listenerPrinter);
        complexProcessor.addListener(historyListener);

        List<String> strings = List.of("SOUR", "PICK", "RAVEN", "TRAVEL","OCTOPUS");
        ObjectForMessage objectForMessage = new ObjectForMessage();
        objectForMessage.setData(strings);
        var message = new Message.Builder(1L)
                .field1("SPARK")
                .field2("leak")
                .field3("PEN")
                .field4("moon")
                .field5("KNOT")
                .field6("spirit")
                .field7("ARMADA")
                .field8("cube")
                .field9("SCRIBERE")
                .field10("planet")
                .field11("STAND")
                .field12("imago")
                .field13(objectForMessage)
                .build();


        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
        complexProcessor.removeListener(historyListener);
    }
}


    /*
     Реализовать to do:
       1. Добавить поля field11 - field13 (для field13 используйте класс ObjectForMessage)
       2. Сделать процессор, который поменяет местами значения field11 и field12
       3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
            Секунда должна определяьться во время выполнения.
       4. Сделать Listener для ведения истории: старое сообщение - новое (подумайте, как сделать, чтобы сообщения не портились)
     */
        /*
           по аналогии с Demo.class
           из элеменов "to do" создать new ComplexProcessor и обработать сообщение
         */


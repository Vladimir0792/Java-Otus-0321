package homework.src.main.java.ru.otus.ru.otus;

import homework.src.main.java.ru.otus.ru.otus.handler.ComplexProcessor;
import homework.src.main.java.ru.otus.ru.otus.listener.Listener;
import homework.src.main.java.ru.otus.ru.otus.listener.ListenerPrinterConsole;
import homework.src.main.java.ru.otus.ru.otus.model.Message;
import homework.src.main.java.ru.otus.ru.otus.processor.LoggerProcessor;
import homework.src.main.java.ru.otus.ru.otus.processor.ProcessorConcatFields;
import homework.src.main.java.ru.otus.ru.otus.processor.ProcessorUpperField10;


import java.util.List;

public class Demo  {
    public static void main(String[] args) {
        var processors = List.of(new ProcessorConcatFields(),
                new LoggerProcessor(new ProcessorUpperField10()));

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
        Listener listenerPrinter = (Listener) new ListenerPrinterConsole();
        complexProcessor.addListener( listenerPrinter);

        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field6("field6")
                .field10("field10")
                .build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);
    }
}

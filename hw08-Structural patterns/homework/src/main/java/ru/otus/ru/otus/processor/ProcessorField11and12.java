package homework.src.main.java.ru.otus.ru.otus.processor;

import homework.src.main.java.ru.otus.ru.otus.model.Message;


public class ProcessorField11and12 implements Processor {

    @Override
    public Message process(Message message) {
        var field11 = message.getField11();
        var field12 = message.getField12();
        return message.toBuilder().field12(field11).field11(field12).build();
    }
}

package homework.src.main.java.ru.otus.ru.otus.processor;

import homework.src.main.java.ru.otus.ru.otus.model.Message;

public class ProcessorUpperField10 implements Processor {

    @Override
    public Message process(Message message) {
        return message.toBuilder().field4(message.getField10().toUpperCase()).build();
    }
}

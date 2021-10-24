package ru.otus.processor;

import ru.otus.model.Message;




public class TimeToProcessor implements Processor {
    private final Time time;

    public TimeToProcessor(Time instance){
        time = instance;
    }

    @Override
    public Message process(Message message) {
        if (time.getSeconds() % 2 == 0) {
            throw new IllegalCallerException("Процесс идет в четную секунду");
        }
        return message;
    }
        interface Time {
            int getSeconds();
        }


}

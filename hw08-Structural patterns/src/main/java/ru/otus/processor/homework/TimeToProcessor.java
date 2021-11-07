package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;


public class TimeToProcessor implements Processor {
    private Time time;



    public TimeToProcessor() {
        this.time = new Time() {
            @Override
            public int getSeconds() {
                return 0;
            }
        };
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

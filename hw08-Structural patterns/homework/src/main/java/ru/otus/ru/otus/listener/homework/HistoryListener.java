package homework.src.main.java.ru.otus.ru.otus.listener.homework;

import homework.src.main.java.ru.otus.ru.otus.model.Message;
import homework.src.main.java.ru.otus.ru.otus.listener.Listener;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private final Map<Long,Message> history = new HashMap<>();


    @Override
    public void onUpdated(Message msg) {
        try{
            history.put(msg.getId(),msg.clone());
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

    }
        //throw new UnsupportedOperationException();

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.of(history.get(id));

        //throw new UnsupportedOperationException();
    }
}

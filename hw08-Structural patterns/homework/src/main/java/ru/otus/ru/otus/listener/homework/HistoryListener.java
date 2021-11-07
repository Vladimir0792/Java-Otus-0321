package ru.otus.listener.homework;

import ru.otus.listener.Listener;
import ru.otus.model.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader, Cloneable {

    private final Map<Long, Message> history = new HashMap<>();
    private Message copy;


    @Override
    public void onUpdated(Message msg) {
            history.put(msg.getId(), copy);
    }
        //throw new UnsupportedOperationException();

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.of(history.get(id));

        //throw new UnsupportedOperationException();
    }
}

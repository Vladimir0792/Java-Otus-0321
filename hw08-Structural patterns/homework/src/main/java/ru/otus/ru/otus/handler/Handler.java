package homework.src.main.java.ru.otus.ru.otus.handler;

import homework.src.main.java.ru.otus.ru.otus.listener.Listener;
import homework.src.main.java.ru.otus.ru.otus.model.Message;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}

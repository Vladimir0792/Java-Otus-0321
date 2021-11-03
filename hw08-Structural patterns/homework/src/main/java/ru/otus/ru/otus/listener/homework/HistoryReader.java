package homework.src.main.java.ru.otus.ru.otus.listener.homework;

import homework.src.main.java.ru.otus.ru.otus.model.Message;

import java.util.Optional;

public interface HistoryReader {

    Optional<Message> findMessageById(long id);
}

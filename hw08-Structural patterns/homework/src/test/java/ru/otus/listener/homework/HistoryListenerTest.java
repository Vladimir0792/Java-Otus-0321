package homework.src.test.java.ru.otus.listener.homework;


import org.junit.jupiter.api.Test;
import homework.src.main.java.ru.otus.ru.otus.listener.homework.HistoryListener;
import homework.src.main.java.ru.otus.ru.otus.model.Message;
import homework.src.main.java.ru.otus.ru.otus.model.ObjectForMessage;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class HistoryListenerTest {


    @Test
    void listenerTest() {
        //given
        var historyListener = new HistoryListener();

        var id = 100L;
        var data = "33";
        var field13 = new ObjectForMessage();
        var field13Data = new ArrayList<String>();
        field13Data.add(data);
        field13.setData(field13Data);

        var message = new Message.Builder(id)
                .field10("field10")
                .field13(field13)
                .build();

        //when
        historyListener.onUpdated(message);
        message.getField13().setData(new ArrayList<>());
        field13Data.clear();

        //then
        var messageFromHistory = historyListener.findMessageById(id);
        assertThat(messageFromHistory).isPresent();
        assertThat(messageFromHistory.get().getField13().getData()).containsExactly(data);

    }
}

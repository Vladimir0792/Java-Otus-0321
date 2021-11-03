package homework.src.main.java.ru.otus.ru.otus.listener;

import homework.src.main.java.ru.otus.ru.otus.model.Message;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("oldMsg:%s", msg);
        System.out.println(logString);
    }
}

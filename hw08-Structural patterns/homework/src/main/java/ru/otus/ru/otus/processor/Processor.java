package homework.src.main.java.ru.otus.ru.otus.processor;

import homework.src.main.java.ru.otus.ru.otus.model.Message;


import java.io.IOException;

public interface Processor {

    Message process(Message message) throws IOException;




    //todo: 2. Сделать процессор, который поменяет местами значения field11 и field12

    //todo: 3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
    //         Секунда должна определяьться во время выполнения.
    //         Тест - важная часть задания
}

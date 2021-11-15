package ru.netology.graphics;

import ru.netology.graphics.image.ColorSchema;
import ru.netology.graphics.image.Converter;
import ru.netology.graphics.image.TextGraphicsConverter;
import ru.netology.graphics.server.GServer;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new Converter();// Создайте тут объект вашего класса конвертера
        converter.setTextColorSchema(new ColorSchema());
        GServer server = new GServer(converter); // Создаём объект сервера
        server.start();

        //Или то же, но с сохранением в файл:
        //String url = "https://i.ibb.co/6DYM05G/edu0.jpg";
        //String imgTxt = converter.convert(url);
        //System.out.println(imgTxt);


    }
}

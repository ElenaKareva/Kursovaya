package ru.netology.graphics.image;

public class ColorSchema implements TextColorSchema {

    @Override
    public char convert(int color) {
        char c;
        if (color <= 32) {
            c = '#';
        } else if (color > 32 && color <= 64) {
            c = '$';
        } else if (color > 64 && color <= 96) {
            c = '@';
        } else if (color > 96 && color <= 128) {
            c = '%';
        } else if (color > 128 && color <= 160) {
            c = '*';
        } else if (color > 160 && color <= 192) {
            c = '+';
        } else if (color > 192 && color <= 224) {
            c = '-';
        } else {
            c = '\'';
        }
        return c;
    }

        /* вариант 2:
    private final char[] chars = new char[]{'#', '$', '@', '%', '*', '+', '-', '\''};
    @Override
    public char convert(int color) {
        return chars[color / 32];
    }
         */
}
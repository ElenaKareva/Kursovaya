package ru.netology.graphics.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;


public class Converter implements TextGraphicsConverter {

    private TextColorSchema schema;
    private double maxRatio;
    private int maxWidth;
    private int maxHeight;

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {
        BufferedImage img = ImageIO.read(new URL(url));
        int width = img.getWidth();
        int height = img.getHeight();
        double ratio = (double) width / height;

        if (ratio > maxRatio && maxRatio > 0) {
            throw new BadImageSizeException(ratio, maxRatio);
        }

        //maxWidth= 50; maxHeight = 100;

        int newWidth = width <= maxWidth ? width : width * maxHeight / height;
        int newHeight = height <= maxHeight ? height : height * maxWidth / width;


        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);

        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < newHeight; h++) {
            for (int w = 0; w < newWidth; w++) {
                WritableRaster bwRaster = bwImg.getRaster();
                int color = bwRaster.getPixel(w, h, new int[3])[0];
                char c = schema.convert(color);
                sb.append(c);
                sb.append(c);
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    @Override
    public void setMaxWidth(int width) {
        maxWidth = width;
    }

    @Override
    public void setMaxHeight(int height) {
        maxHeight = height;

    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}









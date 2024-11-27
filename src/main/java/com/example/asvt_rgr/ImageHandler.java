package com.example.asvt_rgr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public static BufferedImage load(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("Файл не найден: " + filePath);
            }
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void save(BufferedImage image, String filePath) {
        try {
            File outputFile = new File(filePath);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
            ImageIO.write(image, "jpg", outputFile);
            System.out.println("Изображение сохранено: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

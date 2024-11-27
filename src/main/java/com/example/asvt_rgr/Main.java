package com.example.asvt_rgr;

import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputImageFile = new File("src/images/image.jpg");

        if (!inputImageFile.exists()) {
            System.out.println("Файл изображения не найден: " + inputImageFile.getAbsolutePath());
            return;
        }

        System.out.println("Выбранный файл: " + inputImageFile.getAbsolutePath());
        BufferedImage originalImage = ImageHandler.load(inputImageFile.getAbsolutePath());

        // Добавляем импульсный шум с уровнем 30%
        BufferedImage noisedImage = NoiseGenerator.addImpulseNoise(originalImage, 0.3);

        // Сохраняем зашумленное изображение
        String noisedFilePath = "src/images/noised.jpg";
        ImageHandler.save(noisedImage, noisedFilePath);

        // Применяем вертикальный линейный медианный фильтр 5x1
        BufferedImage filteredImage = MedianFilter.applyVerticalMedianFilter(noisedImage, 5, 1);

        // Сохраняем результат
        String outputFilePath = "src/images/filtered.jpg";
        ImageHandler.save(filteredImage, outputFilePath);
    }
}

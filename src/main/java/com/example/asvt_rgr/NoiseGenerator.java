package com.example.asvt_rgr;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NoiseGenerator {
    public static BufferedImage addImpulseNoise(BufferedImage image, double noiseRatio) {
        int width = image.getWidth();
        int height = image.getHeight();
        Random random = ThreadLocalRandom.current();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Добавляем шум с заданной вероятностью
                if (random.nextDouble() < noiseRatio) {
                    int grayValue = random.nextBoolean() ? 0 : 255; // Черный или белый
                    int noisyPixel = (grayValue << 16) | (grayValue << 8) | grayValue;
                    image.setRGB(x, y, noisyPixel);
                }
            }
        }

        return image;
    }
}

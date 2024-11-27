package com.example.asvt_rgr;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class MedianFilter {
    public static BufferedImage applyVerticalMedianFilter(BufferedImage image, int filterHeight, int filterWidth) {
        int width = image.getWidth();
        int height = image.getHeight();
        int halfFilterWidth = filterWidth / 2;
        int halfFilterHeight = filterHeight / 2;

        BufferedImage filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        for (int y = halfFilterHeight; y < height - halfFilterHeight; y++) {
            for (int x = halfFilterWidth; x < width - halfFilterWidth; x++) {
                int medianColor = calculateMedian(image, x, y, filterHeight,filterWidth);
                filteredImage.setRGB(x, y, medianColor);
            }
        }

        return filteredImage;
    }

    private static int calculateMedian(BufferedImage image, int x, int y, int filterHeight, int filterWidth) {
        int[] values = new int[filterHeight * filterWidth];
        int id = 0;
        int halfFilterHeight = filterHeight / 2;
        int halfFilterWidth = filterWidth / 2;

        // Собираем значения серого в вертикальной области фильтра
        for (int dy = -halfFilterHeight; dy <= halfFilterHeight; dy++) {
            for(int dx = -halfFilterWidth; dx <= halfFilterWidth; dx++) {
                values[id++] = image.getRGB(x + dx, y + dy);
            }
        }

        // Сортируем и берем медиану
        Arrays.sort(values);
        return values[values.length / 2];
    }
}

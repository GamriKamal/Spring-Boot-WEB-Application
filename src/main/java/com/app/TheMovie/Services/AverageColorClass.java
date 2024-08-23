package com.app.TheMovie.Services;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

@Service
public class AverageColorClass {
    public Color calculateAverageColorFromURL(String url) throws IOException {
        BufferedImage image = ImageIO.read(new URL(url));
        int width = image.getWidth();
        int height = image.getHeight();
        int totalPixels = width * height;
        int[] sumRGB = {0, 0, 0};

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                sumRGB[0] += red;
                sumRGB[1] += green;
                sumRGB[2] += blue;
            }
        }

        int avgRed = sumRGB[0] / totalPixels;
        int avgGreen = sumRGB[1] / totalPixels;
        int avgBlue = sumRGB[2] / totalPixels;

        int enhancedAvgRed = avgRed;
        int enhancedAvgGreen = avgGreen;
        int enhancedAvgBlue = avgBlue;

        return new Color(enhancedAvgRed, enhancedAvgGreen, enhancedAvgBlue);
    }

}

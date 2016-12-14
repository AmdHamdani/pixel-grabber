package com.azure.application;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pixel {

	public static Color[][] getPixelsRGB(File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		Color[][] pixel = new Color[image.getWidth()][image.getHeight()];

		for (int x = 0; x < image.getWidth(); x++)
			for (int y = 0; y < image.getHeight(); y++)
				pixel[x][y] = new Color(image.getRGB(x, y));

		return pixel;
	}

	public static int[][] getPixelBW(File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		int width = image.getWidth();
		int height = image.getHeight();
		int[][] pixels = new int[height][width];

		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[y][x] = (int)(image.getRGB(x, y) == 0xFFFFFFFF ? 0 : 1);
			}
		}

		return pixels;
	}

	public static void main(String[] args) throws IOException {

		/**
		 * change the image.png to image file name
		 * */
		int[][] data = getPixelBW(new File("res/image.png"));

		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data[0].length; y++) {
				System.out.print(data[x][y] + ",");
			}
			/**
			 * remove this output and the coma
			 * to see the pict in 0 and 1 */
			//System.out.println();
		}

		/**
		 * insert
		 * 0 = non pornografi
		 * 1 = pornografi
		 * to add the attribute class and remove the comment
		 * System.out.println(0); */
	}
}

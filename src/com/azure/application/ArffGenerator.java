package com.azure.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArffGenerator {

//	public static String generate(String title, int width, int height) {
//		String out = "";
//
//		out += "@relation " + title + "\n";
//
//		for (int y = 0; y < height; y++) {
//			for (int x = 0; x < width; x++) {
//				out += "@attribute pixel:x=" + y + ":y=" + x + " numeric" + "\n";
//			}
//		}
//
//		return out;
//	}

	public static void main(String[] args) throws IOException {
		String out = "";

		out += "@relation " + "image_dataset" + "\n\n";

		for (int x = 0; x < 160; x++) {
			for (int y = 0; y < 128; y++) {
				out += "@attribute pixel:x=" + x + ":y=" + y + " numeric\n";
			}
		}

		/**
		 * 0 = non pornografi
		 * 1 = pornografi*/
		out += "@attribute class {0,1}";

		out += "\n\n@data";

		Files.write(Paths.get("res/dataset.arff"), out.getBytes());
	}
}

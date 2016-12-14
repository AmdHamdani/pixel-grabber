package com.azure.application;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.javafx.scene.control.skin.FXVK.Type;

public class ConvertToPixel {
	
	private BufferedImage image;
	
	private int width;
	private int height;
	private String alpha;
	private String rgb;
	private String type;
	
	public ConvertToPixel(String dir, String type) throws IOException {
		this.type = type;
		
		File input = new File(dir);
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		alpha = "";
		rgb = "";
		
//		for(int i = 0; i < height; i++) {
//			for(int j = 0; j < width; j++) {
//				Color c = new Color(image.getRGB(j, i));
//				int color;
//				if(type.equals("Alpha")){
//					color = (c.getBlue()) > 128 ? 0 : 1;
//					alpha += color + ",";	
//				} else
//					rgb += "Red : " + c.getRed() + " Green : " + c.getGreen() + " Blue : " + c.getBlue() + "\n";
//			}
//		}
	}
	
	private void convertPixel(int i, int j){
		Color c = new Color(image.getRGB(j, i));
		
		int color;
		
		if(type.equals("Alpha")){
			color = (c.getBlue()) > 128 ? 0 : 1;
			alpha += color + ",";	
		} else
			rgb += "Red : " + c.getRed() + " Green : " + c.getGreen() + " Blue : " + c.getBlue() + "\n";
		
		System.out.println(alpha);
		
		if(i < height && j < width)
			convertPixel(i++, j++);
	}
	
	public String getPixelValue() {
		
		convertPixel(0, 0);
		
		if(type.equals("Alpha")){
			return alpha;
		}else{
			return rgb;
	}}
}

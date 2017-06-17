package com.yoxnet.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageTool {

	public static int getImageWidth(File file) {
		BufferedImage sourceImg = null;
		try {
			sourceImg = ImageIO.read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sourceImg != null) {
			return sourceImg.getWidth();
		} else {
			return 0;
		}
	}
	
	public static int getImageHeight(File file) {
		
		BufferedImage sourceImg = null;
		try {
			sourceImg = ImageIO.read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sourceImg != null) {
			return sourceImg.getHeight();
		}else {
			return 0;
		}
	}
	
}
package com.biometria.main;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class BaseDeDadosBiometrico {
    
        public static String nome;
        public static int nivel;
    public static String sobrenome;

	public static boolean TesteBiometria(String digital) throws IOException {
                File fileImg = new File(digital);
                BufferedImage img1 = ImageIO.read(BaseDeDadosBiometrico.class.getResource("biometria/Digital-Lucas.jpg"));
                BufferedImage img2 = ImageIO.read(BaseDeDadosBiometrico.class.getResource("biometria/Digital-Dyane.jpeg"));
                BufferedImage img3 = ImageIO.read(BaseDeDadosBiometrico.class.getResource("biometria/Digital-Pedro.jpg"));
                BufferedImage digitalScanner = ImageIO.read(fileImg);
		
		int[] pixels1 = getPixels(img1);
                int[] pixels2 = getPixels(img2);
                int[] pixels3 = getPixels(img3);
		int[] pixelsDigital = getPixels(digitalScanner);
		
		if (Arrays.equals(pixels1, pixelsDigital) || Arrays.equals(pixels2, pixelsDigital) || Arrays.equals(pixels3, pixelsDigital)) {
                    if(Arrays.equals(pixels1, pixelsDigital)){
                        nome = "Lucas";
                        sobrenome = "Bortolo";
                        nivel = 2;
                    }
                    if(Arrays.equals(pixels2, pixelsDigital)){
                        nome = "Dyane";
                        sobrenome = "Andrade";
                        nivel = 3;
                    }
                    if(Arrays.equals(pixels3, pixelsDigital)){
                        nome = "Pedro";
                        sobrenome = "Henrique";
                        nivel = 1;
                    }
		    return true;

		}else {
                    return false;
		}
	}
	
	private static final Component OBSERVER = new Component() {

		/**
		 * @return 
		 * 
		 */
		private static final long serialVersionUID = 1L;};


	private static int[] getPixels(BufferedImage image) {
		final int width = image.getWidth(OBSERVER);
		final int height = image.getHeight(OBSERVER);
		int size = width * height;
		PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, width, height, new int[size], 0, width);
		pixelGrabber.startGrabbing();
		return (int[]) pixelGrabber.getPixels();

	}

}

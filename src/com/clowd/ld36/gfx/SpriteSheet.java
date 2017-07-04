package com.clowd.ld36.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	private int[] pixels;
	private int width;
	
	
	public static SpriteSheet tileSheet = new SpriteSheet("/sheets/sheet.png");
	public static SpriteSheet spriteSheet = new SpriteSheet("/sheets/sprites.png");
	public static SpriteSheet font = new SpriteSheet("/sheets/font.png");
	public static SpriteSheet font2 = new SpriteSheet("/sheets/font2.png");
	public static SpriteSheet gui = new SpriteSheet("/sheets/gui.png");
	
	public SpriteSheet(String path){
		this.path = path;
		loadSheet();
	}

	public void loadSheet(){
		BufferedImage image = null;
		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(image == null) return;
		
		int w = image.getWidth();
		int h = image.getHeight();
		pixels = image.getRGB(0, 0, w, h, null, 0, w);
		
		width = w;
	}
	
	public int[] getPixels(){
		return pixels;
	}
	public int getWidth(){
		return width;
	}
	
}

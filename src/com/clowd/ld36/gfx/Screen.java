package com.clowd.ld36.gfx;

import java.awt.Graphics;
import java.awt.Image;

import com.clowd.ld36.level.tile.Tile;

public class Screen {

	private static int width, height;
	private int[] pixels;
	private Graphics g;
	private int xOffset, yOffset;
	
	private int brightness = 0;
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	public void graphics(Graphics g){
		this.g = g;
	}
	
	//Render Methods
	public void renderSprite(int xp, int yp, Sprite sprite){
		for(int y = 0; y < sprite.getHeight(); y++){
			int yy = yp + y;
			for(int x = 0; x < sprite.getWidth(); x++){
				int xx = xp + x;
				if(xx < -sprite.getWidth() || xx >= width || yy < 0 || yy >= height) break;
				if(xx < 0) xx = 0;
				int col = sprite.getPixels()[x + y * sprite.getWidth()];
				if(col != 0xffff00ff && col != 0xffd100d1){
					pixels[xx + yy * width] = col;
				}
			}
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite){
		xp += xOffset;
		yp += yOffset;
		renderPlayer(xp, yp, sprite);
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite){
		for(int y = 0; y < sprite.getHeight(); y++){
			int yy = yp + y;
			for(int x = 0; x < sprite.getWidth(); x++){
				int xx = xp + x;
				if(xx < -sprite.getWidth() || xx >= width || yy < 0 || yy >= height) break;
				if(xx < 0) xx = 0;
				int col = sprite.getPixels()[x + y * sprite.getWidth()];
				if(col != 0xffff00ff && col != 0xffd100d1){
					col = Light.changeBrightness(col, brightness);
					pixels[xx + yy * width] = col;
				}
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile){
		xp += xOffset;
		yp += yOffset;
		for(int y = 0; y < tile.getSprite().getHeight(); y++){
			int yy = yp + y;
			for(int x = 0; x < tile.getSprite().getWidth(); x++){
				int xx = xp + x;
				if(xx >= width || xx < -tile.getSprite().getWidth() || yy >= height || yy < -tile.getSprite().getHeight() ) break;
				if(xx < 0) xx = 0;
				if(yy < 0) yy = 0;
				int col = tile.getSprite().getPixels()[x + y * tile.getSprite().getWidth()];
				if(col != 0xffff00ff && col != 0xffd100d1){
					col = Light.changeBrightness(col, brightness);
					pixels[xx + yy * width] = col;
				}
			}
		}
	}
	
	public void renderRect(int xp, int yp, int w, int h, int color){
		for(int y = 0; y < h; y++){
			int yy = yp + y;
			for(int x = 0; x < w; x++){
				int xx = xp + x;
				pixels[xx+yy*width] = color;
			}
		}
	}
	
	public void renderText(int xp, int yp, int character, int color, int scale){
		int offset = ((character % 28) << 3) + ((character / 28) << 3) * SpriteSheet.font.getWidth();

		for(int y = 0; y < 8; y++){
			int yy = yp + y;
			for(int x = 0; x < 8; x++){
				int xx = xp + x;
				
				if(xx >= width || xx < -8 || yy >= height || yy < -8) break;
				if (yy < 0)yy = 0;
				if (xx < 0)xx = 0;
				
				int col = SpriteSheet.font.getPixels()[x + y * SpriteSheet.font.getWidth() + offset];
				if(col == 0xffffffff) col = color;
				if(col != 0xffff00ff && col != 0xffd100d1) pixels[xx + yy * width] = col;
			}
		}
	}
	
	public void renderText2(int xp, int yp, int character, int color, int scale){
		int offset = ((character % 28) << 4) + ((character / 28) << 4) * SpriteSheet.font2.getWidth();

		for(int y = 0; y < 16; y++){
			int yy = yp + y;
			for(int x = 0; x < 16; x++){
				int xx = xp + x;
				
				if(xx >= width || xx < -16 || yy >= height || yy < -16) break;
				if (yy < 0)yy = 0;
				if (xx < 0)xx = 0;
				
				int col = SpriteSheet.font2.getPixels()[x + y * SpriteSheet.font2.getWidth() + offset];
				if(col == 0xffffffff) col = color;
				if(col != 0xffff00ff && col != 0xffd100d1) pixels[xx + yy * width] = col;
			}
		}
	}
	
	//Getters and Setters
	public static int getWidth(){
		return width;
	}
	public static int getHeight(){
		return height;
	}
	public int[] getPixels(){
		return pixels;
	}
	public int getXOffset(){
		return xOffset;
	}
	public int getYOffset(){
		return yOffset;
	}
	public void setOffset(int x, int y){
		xOffset = x;
		yOffset = y;
	}
	
	public void setLight(int b){
		brightness = b;
	}
	

}

package com.clowd.ld36.gfx;

public class Sprite {

	private int x, y;
	private int width, height;
	private SpriteSheet sheet;
	private int[] pixels;
	
	public static Sprite[] player = {new Sprite(SpriteSheet.spriteSheet, 0, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 0, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 0, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 16, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 16, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 16, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 32, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 32, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 32, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 48, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 48, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 48, 64, 16, 32)};
	
	public static Sprite[] wolf = {new Sprite(SpriteSheet.spriteSheet, 64, 0, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 64, 16, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 64, 32, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 0, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 16, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 32, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 0, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 16, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 32, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 0, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 16, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 32, 16, 16)};
	
	public static Sprite[] whitewolf = {new Sprite(SpriteSheet.spriteSheet, 64, 48, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 64, 64, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 64, 80, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 48, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 64, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 72, 80, 8, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 48, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 64, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 80, 80, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 48, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 64, 16, 16),
									new Sprite(SpriteSheet.spriteSheet, 96, 80, 16, 16)};
	
	public static Sprite[] evilman = {new Sprite(SpriteSheet.spriteSheet, 112, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 112, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 112, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 128, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 128, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 128, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 144, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 144, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 144, 64, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 160, 0, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 160, 32, 16, 32),
									new Sprite(SpriteSheet.spriteSheet, 160, 64, 16, 32)};
	
	public static Sprite darkmonster = new Sprite(SpriteSheet.spriteSheet, 176, 0, 32, 32);
	
	public static Sprite[] squirel = {new Sprite(SpriteSheet.spriteSheet, 208, 0, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 208, 16, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 208, 32, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 214, 0, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 214, 16, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 214, 32, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 220, 0, 16, 10),
									new Sprite(SpriteSheet.spriteSheet, 220, 16, 16, 10),
									new Sprite(SpriteSheet.spriteSheet, 220, 32, 16, 10),
									new Sprite(SpriteSheet.spriteSheet, 236, 0, 16, 10),
									new Sprite(SpriteSheet.spriteSheet, 236, 16, 16, 10),
									new Sprite(SpriteSheet.spriteSheet, 236, 32, 16, 10),};
	
	public static Sprite rocksH = new Sprite(SpriteSheet.spriteSheet, 0, 144, 16, 16);
	public static Sprite arrowH = new Sprite(SpriteSheet.spriteSheet, 16, 144, 16, 16);
	public static Sprite spearH = new Sprite(SpriteSheet.spriteSheet, 32, 144, 16, 16);
	public static Sprite healthH = new Sprite(SpriteSheet.spriteSheet, 48, 144, 16, 16);
	public static Sprite scoreH = new Sprite(SpriteSheet.spriteSheet, 64, 144, 16, 16);
	public static Sprite supH = new Sprite(SpriteSheet.spriteSheet, 80, 144, 16, 16);
	
	public static Sprite[] spear = {new Sprite(SpriteSheet.spriteSheet, 0, 112, 2, 32),
									new Sprite(SpriteSheet.spriteSheet, 4, 112, 2, 32),
									new Sprite(SpriteSheet.spriteSheet, 8, 112, 32, 2),
									new Sprite(SpriteSheet.spriteSheet, 8, 116, 32, 2)};
	public static Sprite throwrock = new Sprite(SpriteSheet.spriteSheet, 32, 96, 8, 8);
	public static Sprite[] arrow = {new Sprite(SpriteSheet.spriteSheet, 0, 96, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 8, 96, 6, 16),
									new Sprite(SpriteSheet.spriteSheet, 16, 96, 16, 6),
									new Sprite(SpriteSheet.spriteSheet, 16, 104, 16, 6)};
	
	public static Sprite grass = new Sprite(SpriteSheet.tileSheet, 0, 0, 32, 32);
	public static Sprite grassflower = new Sprite(SpriteSheet.tileSheet, 32, 0, 32, 32);
	public static Sprite grassrock = new Sprite(SpriteSheet.tileSheet, 64, 0, 32, 32);
	public static Sprite grasschest = new Sprite(SpriteSheet.tileSheet, 96, 0, 32, 32);
	public static Sprite[] grassdirt = {new Sprite(SpriteSheet.tileSheet, 224, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 192, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 224, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 256, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 256, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 256, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 224, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 192, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 192, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 288, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 320, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 320, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 288, 32, 32, 32)};
	public static Sprite[] grassfire = {new Sprite(SpriteSheet.tileSheet, 11*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 12*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 12*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 11*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 13*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 14*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 14*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 13*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 15*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 16*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 16*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 15*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 17*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 18*32, 0, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 18*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 17*32, 32, 32, 32)};
	public static Sprite[] grasstree = {new Sprite(SpriteSheet.tileSheet, 4*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 5*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 5*32, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 4*32, 64, 32, 32)};
	public static Sprite[] grasstrees = {new Sprite(SpriteSheet.tileSheet, 0*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 1*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 2*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 3*32, 32, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 0*32, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 1*32, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 2*32, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 3*32, 64, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 0*32, 96, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 1*32, 96, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 2*32, 96, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 3*32, 96, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 0*32, 128, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 1*32, 128, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 2*32, 128, 32, 32),
										new Sprite(SpriteSheet.tileSheet, 3*32, 128, 32, 32)};
	public static Sprite[] cave = {new Sprite(SpriteSheet.tileSheet, 9*32, 2*32, 32, 32),
									new Sprite(SpriteSheet.tileSheet, 10*32, 2*32, 32, 32),
									new Sprite(SpriteSheet.tileSheet, 11*32, 2*32, 32, 32),
									new Sprite(SpriteSheet.tileSheet, 12*32, 2*32, 32, 32),
									new Sprite(SpriteSheet.tileSheet, 12*32, 3*32, 32, 32),
									new Sprite(SpriteSheet.tileSheet, 12*32, 4*32, 32, 32)};
	public static Sprite fog = new Sprite(SpriteSheet.tileSheet, 128, 0, 32, 32);
	public static Sprite voidtile = new Sprite(32, 32, 0x005599);
	
	public static Sprite title = new Sprite(SpriteSheet.gui, 0, 260, 335, 112);
	
	public static Sprite hud = new Sprite(SpriteSheet.gui, 0, 0, 10, 35);
	public static Sprite slot = new Sprite(SpriteSheet.gui, 560, 0, 30, 30);
	public static Sprite alertbox = new Sprite(SpriteSheet.gui, 20, 0, 450, 250);
	public static Sprite bgtrees = new Sprite(SpriteSheet.gui, 480, 0, 64, 64);
	
	public Sprite(SpriteSheet sheet, int x, int y, int w, int h){
		width = w;
		height = h;
		pixels = new int[width*height];
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		create(width, height);
	}
	
	public Sprite(int w, int h, int col){
		width = w;
		height = h;
		pixels = new int[w*h];
		create(w, h, col);
	}
	
	public void create(int w, int h){
		for(int y = 0; y < h; y++){
			for(int x = 0; x < w; x++){
				pixels[x+y*w] = sheet.getPixels()[(x + this.x) + (y + this.y) * sheet.getWidth()];
			}
		}
	}
	
	public void create(int w, int h, int col){
		for(int y = 0; y < h; y++){
			for(int x=0; x < w; x++){
				pixels[x+y*w]=col;
			}
		}
	}
	
	public int[] getPixels(){
		return pixels;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}

package com.clowd.ld36.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.entity.mob.Player;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.tile.Tile;

public class Level {

	protected String path;
	protected int width, height;
	protected int[] tiles;
	
	protected int levelX, levelY;
	protected int playerX, playerY;
	protected int playerXA, playerYA;
	protected int spawnX, spawnY;
	protected boolean scroll = false;
	
	protected int score;
	protected int timeScore;
	protected int killScore;
	protected int itemScore;
	protected int healthScore = 0;
	
	protected int playerH;
	protected int playerW;
	protected double supplies;
	protected double time;
	protected double ttime;
	
	protected boolean start = true;
	protected boolean load = false;
	protected boolean win = false;
	protected boolean gameover = false;
	
	protected int flash = 0;
	
	protected List<Entity> entities = new ArrayList<Entity>();	
	protected List<Entity> addentities = new ArrayList<Entity>();
	protected List<Entity> removeentities = new ArrayList<Entity>();
	
	protected StateManager manager;
	
	public Level(String path, StateManager manager){
		this.path = path;
		this.manager = manager;
		
		loadLevel();
	}
	
	public void loadLevel(){
		try{
			BufferedImage image = ImageIO.read(Level.class.getResourceAsStream(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width*height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}catch (IOException e){
			e.printStackTrace();
		}
		generateLevel();
	}
	
	public void generateLevel(){
		
	}
	
	public void addEntity(Entity e){
		addentities.add(e);
	}
	
	public void removeEntity(Entity e){
		removeentities.add(e);
	}
	
	public void updateEntities(Input input){
		for(Entity e : entities){
			e.update(input);
		}
		for(Entity e : addentities){
			entities.add(e);
		}
		addentities.clear();
		for(Entity e : removeentities){
			entities.remove(e);
		}
		removeentities.clear();
		
		Tile.grassfire[0].update();
		Tile.grassfire[1].update();
		Tile.grassfire[2].update();
		Tile.grassfire[3].update();
	}
	
	public void update(Input input){
		flash++;
		if(flash >= 50){
			flash = 0;
		}
		
		if(supplies <= 0) gameover = true;
		
		update2(input);
	}
	
	public void update2(Input input){
		
	}
	
	public void render(Screen screen){
		levelX = -playerX + screen.getWidth()/2 - 8;
		levelY = -playerY + screen.getHeight()/2 - 16;
		
		screen.setOffset(levelX, levelY);
		
		int x0 = -levelX >> 5;
		int x1 = (-levelX + screen.getWidth() + 32) >> 5;
		int y0 = -levelY >> 5;
		int y1 = (-levelY + screen.getHeight() + 32) >> 5;
		//Tiles
		for(int y = y0; y < y1; y++){
			for(int x = x0; x < x1; x++){
				if(x+y*width < 0 || x+y*width > width*height){
					Tile.voidtile.render(x, y, screen);
					continue;
				}
				getTile(x, y).render(x, y, screen);
			}
		}
		//Entities
		for(Entity e : entities){
			e.render(screen);
		}

		
		//GUI
		for(int i = 0; i < 550/10; i++){
			screen.renderSprite(0 + 10*i, screen.getHeight()-35, Sprite.hud);
		}
		screen.renderRect(0, screen.getHeight()-35, (int)(screen.getWidth()*(time/ttime)), 5, 0x0000cc);
		
		screen.renderRect(5, screen.getHeight()-25, 250, 20, 0x999999);
		screen.renderRect(5, screen.getHeight()-25, (int)(((double)playerH/100)*250), 20, 0xcc0000);
		Font.render(screen, "HEALTH", 15, screen.getHeight()-20, 0xffffff);
		screen.renderRect(screen.getWidth()-255, screen.getHeight()-25, 250, 20, 0x999999);
		screen.renderRect(screen.getWidth()-255, screen.getHeight()-25, (int)(((double)supplies/100)*250), 20, 0x00cc00);
		Font.render(screen, "SUPPLIES", screen.getWidth()-80, screen.getHeight()-20, 0xffffff);

		screen.renderRect(screen.getWidth()/2 - 12, screen.getHeight()-27, 24, 24, 0x000000);
		if(playerW == 0){
			screen.renderSprite(screen.getWidth()/2 - 8, screen.getHeight()-23, Sprite.rocksH);
		}else if(playerW == 1){
			screen.renderSprite(screen.getWidth()/2 - 8, screen.getHeight()-23, Sprite.arrowH);
		}else if(playerW == 2){
			screen.renderSprite(screen.getWidth()/2 - 8, screen.getHeight()-23, Sprite.spearH);
		}
		
		//Render2
		render2(screen);
	}
	
	public void render2(Screen screen){
		
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || x >= width || y < 0 || y >= height) return Tile.voidtile;
		if(tiles[x+y*width] == 0xff00ff00) return Tile.grasstile;
		if(tiles[x+y*width] == 0xffffff00) return Tile.flowertile;
		if(tiles[x+y*width] == 0xffff0000) return Tile.rocktile;
		if(tiles[x+y*width] == 0xffbb0000) return Tile.chesttile;
		
		if(tiles[x+y*width] == 0xffa00000) return Tile.grassfire[0];
		if(tiles[x+y*width] == 0xffa10000) return Tile.grassfire[1];
		if(tiles[x+y*width] == 0xffa20000) return Tile.grassfire[2];
		if(tiles[x+y*width] == 0xffa30000) return Tile.grassfire[3];
		
		if(tiles[x+y*width] == 0xff009000) return Tile.grasstrees[0];
		if(tiles[x+y*width] == 0xff009100) return Tile.grasstrees[1];
		if(tiles[x+y*width] == 0xff009200) return Tile.grasstrees[2];
		if(tiles[x+y*width] == 0xff009300) return Tile.grasstrees[3];
		if(tiles[x+y*width] == 0xff009400) return Tile.grasstrees[4];
		if(tiles[x+y*width] == 0xff009500) return Tile.grasstrees[5];
		if(tiles[x+y*width] == 0xff009600) return Tile.grasstrees[6];
		if(tiles[x+y*width] == 0xff009700) return Tile.grasstrees[7];
		if(tiles[x+y*width] == 0xff009800) return Tile.grasstrees[8];
		if(tiles[x+y*width] == 0xff009900) return Tile.grasstrees[9];
		if(tiles[x+y*width] == 0xff009a00) return Tile.grasstrees[10];
		if(tiles[x+y*width] == 0xff009b00) return Tile.grasstrees[11];
		if(tiles[x+y*width] == 0xff009c00) return Tile.grasstrees[12];
		if(tiles[x+y*width] == 0xff009d00) return Tile.grasstrees[13];
		if(tiles[x+y*width] == 0xff009e00) return Tile.grasstrees[14];
		if(tiles[x+y*width] == 0xff009f00) return Tile.grasstrees[15];
		
		if(tiles[x+y*width] == 0xff111111) return Tile.cavetile[0];
		if(tiles[x+y*width] == 0xff222222) return Tile.cavetile[1];
		if(tiles[x+y*width] == 0xff333333) return Tile.cavetile[2];
		if(tiles[x+y*width] == 0xff444444) return Tile.cavetile[3];
		if(tiles[x+y*width] == 0xff555555) return Tile.cavetile[4];
		if(tiles[x+y*width] == 0xff666666) return Tile.cavetile[5];
		
		return Tile.voidtile;
	}
	
	public int getLevelX(){
		return levelX;
	}
	public int getLevelY(){
		return levelY;
	}
	public void setPlayerX(double x){
		playerX = (int)x;
	}
	public void setPlayerY(double y){
		playerY = (int)y;
	}
	public double getPlayerXA(){
		return playerXA;
	}
	public double getPlayerYA(){
		return playerYA;
	}
	public void setPlayerXA(double xa){
		playerXA = (int)xa;
	}
	public void setPlayerYA(double ya){
		playerYA = (int)ya;
	}
	public int getPlayerH(){
		return playerH;
	}
	public void setPlayerH(int h){
		playerH = h;
	}
	public int getPlayerW(){
		return playerW;
	}
	public void setPlayerW(int w){
		playerW = w;
	}
	public void addKScore(int s){
		killScore += s;
	}
	public void addIScore(int s){
		itemScore += s;
	}
	public int[] getScores(){
		int[] s = {timeScore, killScore, itemScore, healthScore};
		return s;
	}
	public boolean getBusy(){
		if(!start){
			return false;
		}
		return true;
	}
	public void addSupplies(double a){
		supplies += a;
		if(supplies > 100) supplies = 100;
	}
	public void hitSupplies(double a){
		supplies -=a;
	}
	public boolean gameOver(){
		return gameover;
	}
	public void setGameOver(boolean g){
		gameover = g;
	}
	public boolean getWin(){
		return win;
	}
	public Player getPlayer(){
		for(Entity e : entities){
			if(e instanceof Player){
				return (Player) e;
			}
		}
		return null;
	}
	
	public List<Entity> getEntities(){
		return entities;
	}
	
}

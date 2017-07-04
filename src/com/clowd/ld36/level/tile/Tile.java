package com.clowd.ld36.level.tile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;

public class Tile {
	
	public static Tile grasstile = new GroundTile(Sprite.grass);
	public static Tile flowertile = new GroundTile(Sprite.grassflower);
	public static Tile rocktile = new WallTile(Sprite.grassrock);
	public static Tile chesttile = new GroundTile(Sprite.grasschest);
	public static Tile fogtile = new WallTile(Sprite.fog);
	
	public static Tile[] grassdirt = {new MudTile(Sprite.grassdirt[0]),
									new MudTile(Sprite.grassdirt[1]),
									new MudTile(Sprite.grassdirt[2]),
									new MudTile(Sprite.grassdirt[3]),
									new MudTile(Sprite.grassdirt[4]),
									new MudTile(Sprite.grassdirt[5]),
									new MudTile(Sprite.grassdirt[6]),
									new MudTile(Sprite.grassdirt[7]),
									new MudTile(Sprite.grassdirt[8]),
									new MudTile(Sprite.grassdirt[9]),
									new MudTile(Sprite.grassdirt[10]),
									new MudTile(Sprite.grassdirt[11]),
									new MudTile(Sprite.grassdirt[12])};
	
	private static Sprite[] grassfire0 = {Sprite.grassfire[0], Sprite.grassfire[4], Sprite.grassfire[8], Sprite.grassfire[12]};
	private static Sprite[] grassfire1 = {Sprite.grassfire[1], Sprite.grassfire[5], Sprite.grassfire[9], Sprite.grassfire[13]};
	private static Sprite[] grassfire2 = {Sprite.grassfire[2], Sprite.grassfire[6], Sprite.grassfire[10], Sprite.grassfire[14]};
	private static Sprite[] grassfire3 = {Sprite.grassfire[3], Sprite.grassfire[7], Sprite.grassfire[11], Sprite.grassfire[15]};
	
	public static Tile[] grassfire = {new FireTile(grassfire0),
									new FireTile(grassfire1),
									new FireTile(grassfire2),
									new FireTile(grassfire3)};
	
	public static Tile[] grasstrees = {new WallTile(Sprite.grasstrees[0]),
									new WallTile(Sprite.grasstrees[1]),
									new WallTile(Sprite.grasstrees[2]),
									new WallTile(Sprite.grasstrees[3]),
									new WallTile(Sprite.grasstrees[4]),
									new WallTile(Sprite.grasstrees[5]),
									new WallTile(Sprite.grasstrees[6]),
									new WallTile(Sprite.grasstrees[7]),
									new WallTile(Sprite.grasstrees[8]),
									new WallTile(Sprite.grasstrees[9]),
									new WallTile(Sprite.grasstrees[10]),
									new WallTile(Sprite.grasstrees[11]),
									new WallTile(Sprite.grasstrees[12]),
									new WallTile(Sprite.grasstrees[13]),
									new WallTile(Sprite.grasstrees[14]),
									new WallTile(Sprite.grasstrees[15])};
	
	public static Tile[] grasstree = {new WallTile(Sprite.grasstree[0]),
			     					new WallTile(Sprite.grasstree[1]),
			     					new WallTile(Sprite.grasstree[2]),
			     					new WallTile(Sprite.grasstree[3])};
	
	public static Tile[] cavetile = {new WallTile(Sprite.cave[0]),
									new WallTile(Sprite.cave[1]),
									new WallTile(Sprite.cave[2]),
									new WallTile(Sprite.cave[3]),
									new WallTile(Sprite.cave[4]),
									new WallTile(Sprite.cave[5])};
	
	public static Tile voidtile = new WallTile(Sprite.voidtile);
	
	protected Sprite sprite;
	protected Sprite[] spritea;
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public Tile(Sprite[] spritea){
		this.spritea = spritea;
		sprite = spritea[0];
	}
	
	public void update(){
		
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean mud(){
		return false;
	}
	
	public boolean anim(){
		return false;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
}

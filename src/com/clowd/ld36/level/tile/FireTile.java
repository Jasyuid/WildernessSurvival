package com.clowd.ld36.level.tile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;

public class FireTile extends Tile{
	
	int timer = 0;
	
	public FireTile(Sprite[] spritea){
		super(spritea);
	}

	public void update(){
		timer++;
		if(timer > 80){
			sprite = spritea[3];
			timer = 0;
		}else if(timer > 60){
			sprite = spritea[2];
		}else if(timer > 40){
			sprite = spritea[1];
		}else if(timer > 20){
			sprite = spritea[0];
		}
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}
	
	public boolean anim(){
		return true;
	}
	
	public boolean solid(){
		return true;
	}
}

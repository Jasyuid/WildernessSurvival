package com.clowd.ld36.level.tile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;

public class FogTile extends Tile{

	public FogTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid(){
		return true;
	}
}

package com.clowd.ld36.level.tile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;

public class GroundTile extends Tile{

	public GroundTile(Sprite sprite){
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 5, y << 5, this);
	}
	
}

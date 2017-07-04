package com.clowd.ld36.entity.item;

import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Item extends Entity{
	
	int type;
	int killTimer = 1500;
	
	public Item(Level level, double x, double y){
		super(level, x, y);
		int sel = r.nextInt(10);
		if(sel == 0){
			sprite = Sprite.rocksH;
			type = 0;
		}else if(sel == 1){
			sprite = Sprite.arrowH;
			type = 1;
		}else if(sel == 2){
			sprite = Sprite.spearH;
			type = 2;
		}else if(sel == 3 || sel == 4){
			sprite = Sprite.healthH;
			type = 3;
		}else if(sel == 5 || sel == 6){
			sprite = Sprite.supH;
			type = 4;
		}else{
			sprite = Sprite.scoreH;
			type = 5;
		}
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		killTimer--;
		if(killTimer <= 0){
			level.removeEntity(this);
		}
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
	public int getType(){
		return type;
	}
}

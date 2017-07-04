package com.clowd.ld36.entity.projectile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Arrow extends Projectile{

	double xa, ya;
	int damage;
	
	public Arrow(Level level, double x, double y, int dir, int team){
		super(level, x, y);
		this.dir = dir;
		spritea = Sprite.arrow;
		speed = 4;
		this.team = team;
		damage = 5;
		range = 200;
		
		if(dir == 0){
			xa = -speed;
			sprite = spritea[3];
		}else if(dir == 1){
			ya = -speed;
			sprite = spritea[1];
		}else if(dir == 2){
			xa = speed;
			sprite = spritea[2];
		}else if(dir == 3){
			ya = speed;
			sprite = spritea[0];
		}
		
		distance += speed;
		
		if(distance > range){
			level.removeEntity(this);
		}
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		move(xa, ya);
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
	public int getDamage(){
		return damage;
	}
}

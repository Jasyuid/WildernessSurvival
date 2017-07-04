package com.clowd.ld36.entity.projectile;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class ThrowRock extends Projectile{

	double xa, ya;
	int damage;
	
	public ThrowRock(Level level, double x, double y, int dir, int team){
		super(level, x, y);
		this.dir = dir;
		this.team = team;
		sprite = Sprite.throwrock;
		speed = 3;
		range = 50;
		damage = 10;
		
		if(dir == 0){
			xa = -speed;
		}else if(dir == 1){
			ya = -speed;
		}else if(dir == 2){
			xa = speed;
		}else if(dir == 3){
			ya = speed;
		}
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		move(xa, ya);
		distance += speed;
		
		if(distance > range){
			level.removeEntity(this);
		}
		
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

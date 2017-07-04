package com.clowd.ld36.entity.weapon;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Spear extends Weapon{

	double xa, ya;
	int damage;
	
	public Spear(Level level, double x, double y, int dir, int team){
		super(level, x, y);
		this.dir = dir;
		spritea = Sprite.spear;
		speed = 1;
		range = 16;
		damage = 20;
		
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
		
		width = sprite.getWidth() + 2;
		height = sprite.getHeight() + 2;
	}
	
	public void update(Input input){
		if(dir == 0){
			xa = -speed;
			ya = 0;
			sprite = spritea[3];
		}else if(dir == 1){
			ya = -speed;
			xa = 0;
			sprite = spritea[1];
		}else if(dir == 2){
			xa = speed;
			ya = 0;
			sprite = spritea[2];
		}else if(dir == 3){
			ya = speed;
			xa = 0;
			sprite = spritea[0];
		}
		
		xa += level.getPlayerXA();
		ya += level.getPlayerYA();
		
		move(xa, ya);
		
		distance += speed;
		if(ret && distance <= 0){
			level.removeEntity(this);
		}
		
		if(distance >= range){
			/*xa = -xa;
			ya = -ya;
			speed = -speed;
			ret = true;*/
			level.removeEntity(this);
		}
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
	public int getDamage(){
		return damage;
	}
	
}

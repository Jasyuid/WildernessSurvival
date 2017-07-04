package com.clowd.ld36.entity.mob;

import java.util.Random;

import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Mob extends Entity{
	
	protected int dir = 0;
	protected boolean moving;
	protected Sprite[] spritea;
	protected int walkdelay = 0, walkframe = 0;
	
	protected int health;
	
	protected double speed;
	
	public Mob(Level level, double x, double y){
		super(level, x, y);
	}
	
	public Mob(Level level){
		super(level);
	}
	
	public void move(double xa, double ya){
		if(xa != 0 && ya != 0){
			move(xa*0.71, 0);
			move(0, ya*0.71);
			return;
		}
		
		if(xa > 0) dir = 2;
		if(xa < 0) dir = 0;
		if(ya < 0) dir = 1;
		if(ya > 0) dir = 3;
		
		while(xa != 0){
			if(Math.abs(xa) > 1){
				if(!tileCollision(abs(xa), ya)){
					this.x += abs(xa);
				}
				xa -= abs(xa);
			}else{
				if(!tileCollision(abs(xa), ya)){
					this.x += xa;
				}
				xa = 0;
			}
			
		}
		
		while(ya != 0){
			if(Math.abs(ya) > 1){
				if(!tileCollision(xa, abs(ya))){
					this.y += abs(ya);
				}
				ya -= abs(ya);
			}else{
				if(!tileCollision(xa, abs(ya))){
					this.y += ya;
				}
				ya = 0;
			}
			
		}
	}
	
	public void moveMob(double xa, double ya){
		
	}
	
	public double abs(double val){
		if(val > 0) return 1;
		return -1;
	}
	
	public boolean tileCollision(double xa, double ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			double xt = ((x + xa) + c % 2 * 16) / 32;
			double yt = ((y + ya) + c / 2 * 16 + 13) / 32;
			if(level.getTile((int)xt, (int)yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void walkAnimation(Sprite[] spritea){
		if(moving) {
			walkdelay++;
		}else{
			walkdelay = 0;
		}

		
		if(walkdelay >= 15){
			walkdelay = 0;
			walkframe++;
		}
		
		if(dir == 0){
			if(moving){
				if(walkframe % 2 == 1){
					sprite = spritea[10];
				}else{
					sprite = spritea[11];
				}
			}else{
				sprite = spritea[9];
			}
		}else if(dir == 1){
			if(moving){
				if(walkframe % 2 == 1){
					sprite = spritea[4];
				}else{
					sprite = spritea[5];
				}
			}else{
				sprite = spritea[3];
			}
		}else if(dir == 2){
			if(moving){
				if(walkframe % 2 == 1){
					sprite = spritea[7];
				}else{
					sprite = spritea[8];
				}
			}else{
				sprite = spritea[6];
			}
		}else if(dir == 3){
			if(moving){
				if(walkframe % 2 == 1){
					sprite = spritea[1];
				}else{
					sprite = spritea[2];
				}
			}else{
				sprite = spritea[0];
			}
		}
	}
	
	public void update(Input input){
		
	}
	
	public void render(Screen screen){
		
	}
}

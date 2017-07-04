package com.clowd.ld36.entity.projectile;

import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Projectile extends Entity{
	
	protected int dir = 0;
	protected Sprite sprite;
	protected Sprite[] spritea;
	
	protected double speed;
	protected double distance = 0;
	protected double range;
	
	public Projectile (Level level, double x, double y){
		super(level, x, y);
	}
	
	public void move(double xa, double ya){
		while(xa != 0){
			if(Math.abs(xa) > 1){
				if(!tileCollision(abs(xa), ya)){
					this.x += abs(xa);
				}else{
					level.removeEntity(this);
				}
				xa -= abs(xa);
			}else{
				if(!tileCollision(abs(xa), ya)){
					this.x += xa;
				}else{
					level.removeEntity(this);
				}
				xa = 0;
			}
			
		}
		
		while(ya != 0){
			if(Math.abs(ya) > 1){
				if(!tileCollision(xa, abs(ya))){
					this.y += abs(ya);
				}else{
					level.removeEntity(this);
				}
				ya -= abs(ya);
			}else{
				if(!tileCollision(xa, abs(ya))){
					this.y += ya;
				}else{
					level.removeEntity(this);
				}
				ya = 0;
			}
			
		}
	}
	
	public double abs(double val){
		if(val > 0) return 1;
		return -1;
	}
	
	public boolean tileCollision(double xa, double ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			double xt = ((x + xa) + c % 2 * 8) / 32;
			double yt = ((y + ya) + c / 2 * 8 + 13) / 32;
			if(level.getTile((int)xt, (int)yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void update(Input input){
		
	}
	
	public void render(Screen screen){
		
	}
	
}

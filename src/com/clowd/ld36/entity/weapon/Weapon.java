package com.clowd.ld36.entity.weapon;

import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Weapon extends Entity{
	
	protected int dir;
	protected Sprite sprite;
	protected Sprite[] spritea;
	
	protected double speed;
	protected int range;
	protected double distance;
	protected boolean ret = false;
	
	public Weapon(Level level, double x, double y){
		super(level, x, y);
	}
	
	public void move(double xa, double ya){
		x += xa;
		y += ya;
	}
	
	public void update(Input input){
		
	}
	
	public void render(Screen screen){
		
	}
}

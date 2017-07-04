package com.clowd.ld36.entity;

import java.util.Random;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;

public class Entity {

	protected Level level;
	protected double x, y;
	protected int width, height;
	protected Sprite sprite;
	protected int state;
	protected int team;
	
	protected Random r = new Random();
	
	public Entity(Level level, double x, double y){
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	public Entity(Level level){
		this.level = level;
	}
	
	public void update(Input input){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public int getTeam(){
		return team;
	}
}

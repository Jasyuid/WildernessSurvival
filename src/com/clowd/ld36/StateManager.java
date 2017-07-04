package com.clowd.ld36;

import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;
import com.clowd.ld36.level.Level_One;
import com.clowd.ld36.level.Level_Three;
import com.clowd.ld36.level.Level_Two;
import com.clowd.ld36.level.tile.Tile;
import com.clowd.ld36.menu.GameOverMenu;
import com.clowd.ld36.menu.MainMenu;
import com.clowd.ld36.menu.Menu;
import com.clowd.ld36.menu.WinMenu;
import com.clowd.ld36.sound.Sound;

public class StateManager {
	//States
	private int state;
	
	private boolean pause;
	private boolean hit;
	
	private double bgx;
	
	private int flashtimer;
	
	private Game game;
	private IntroScreen intro;
	private Menu menu;
	private Level level;
	
	public StateManager(Game game){
		state = 0;
		pause = false;
		this.game = game;
		
		intro = new IntroScreen(this);
		menu = new MainMenu(this);
		level = new Level_One("/levels/level1.png", this);
	}
	
	public void quit(){
		game.stop();
	}
	
	public void update(Input input){
		if(!input.enter && !input.esc && !input.up && !input.down && !input.left && !input.right) hit = false;
		
		flashtimer++;
		if(flashtimer >= 100){
			flashtimer = 0;
		}
		
		if(state == 0){
			intro.update(input);
		}else if(state == 1){
			bgx-=0.4;
			if(bgx <= -64){
				bgx = 0;
			}
			menu.update(input);
		}else if(state == 2){
			if(!input.getFocus()) pause = true;
			if(pause){
				if(input.esc && !hit){
					pause = false;
					hit = true;
				}
			}else{
				level.update(input);
				if(!level.getBusy() &&input.esc && !hit){
					pause = true;
					hit = true;
				}
				if(level.gameOver()){
					menu = new GameOverMenu(this, level.getScores());
					Sound.stopAll();
					state = 1;
				}
				if(level.getWin()){
					menu = new WinMenu(this, level.getScores());
					Sound.stopAll();
					state = 1;
				}
			}
		}
	}
	
	public void render(Screen screen){
		if(state == 0){
			intro.render(screen);
		}else if(state == 1){
			for(int y = 0; y < 6; y++){
				for(int x = 0; x < 10; x++){
					screen.renderSprite((int)bgx + 64*x, 64*y, Sprite.bgtrees);
				}
			}
			
			menu.render(screen);
		}else if(state == 2){
			level.render(screen);
			
			if(pause){
				screen.setLight(-80);
				Font.render2(screen, "PAUSED", screen.getWidth()/2 - 48, 100, 0xaaaaff);
			}
		}
	}
	
	//Getters and Setters
	public int getState(){
		return state;
	}
	public void setState(int s){
		state = s;
	}
	public void setMenu(Menu m){
		menu = m;
	}
	public void setLevel(Level l){
		level = l;
	}
	public boolean getHit(){
		return hit;
	}
	public void setHit(boolean h){
		hit = h;
	}
	public int getFlash(){
		return flashtimer;
	}
}

package com.clowd.ld36;

import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.tile.Tile;
import com.clowd.ld36.sound.Sound;

public class IntroScreen {
	
	private StateManager manager;
	
	int timer;
	
	public IntroScreen(StateManager manager){
		this.manager = manager;
	}
	
	public void update(Input input){
		if(input.enter){
			manager.setHit(true);
			manager.setState(1);
			Sound.menumusic.play(true);
		}
		
		timer++;
		if(timer > 50){
			timer = 0;
		}
	}
	
	public void render(Screen screen){
		if(timer < 25)
			Font.render2(screen, "PRESS ENTER TO CONTINUE!", 83, 120, 0x00ff00);
		else
			Font.render2(screen, "PRESS ENTER TO CONTINUE!", 83, 120, 0xffffff);
	}
	
}

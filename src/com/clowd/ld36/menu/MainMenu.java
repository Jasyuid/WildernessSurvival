package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.sound.Sound;

public class MainMenu extends Menu{
	
	public MainMenu(StateManager manager){
		super(manager);
		selected = 0;
	}
	
	public void update(Input input){
		if(input.enter && !manager.getHit()){
			if(selected == 0){
				Sound.enter.play(false);
				manager.setMenu(new PlayMenu(manager));
			}else if(selected == 1){
				Sound.enter.play(false);
				manager.setMenu(new AboutMenu(manager));
			}else if(selected == 2){
				Sound.enter.play(false);
				manager.setMenu(new HelpMenu(manager));
			}
			manager.setHit(true);
		}
		
		if(input.down && !manager.getHit()){
			if(selected < 2){
				Sound.select.play(false);
				selected++;
				manager.setHit(true);
			}
		}else if(input.up && !manager.getHit()){
			if(selected > 0){
				Sound.select.play(false);
				selected--;
				manager.setHit(true);
			}
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(10, 10, Sprite.title);
		if(selected == 0){
			Font.render2(screen, "PLAY", 20, 160, 0x00ff00);
			Font.render2(screen, "ABOUT", 20, 190, 0xffffff);
			Font.render2(screen, "HELP", 20, 220, 0xffffff);
		}else if(selected == 1){
			Font.render2(screen, "PLAY", 20, 160, 0xffffff);
			Font.render2(screen, "ABOUT", 20, 190, 0x00ff00);
			Font.render2(screen, "HELP", 20, 220, 0xffffff);
		}else if(selected == 2){
			Font.render2(screen, "PLAY", 20, 160, 0xffffff);
			Font.render2(screen, "ABOUT", 20, 190, 0xffffff);
			Font.render2(screen, "HELP", 20, 220, 0x00ff00);
		}
		
		Font.render(screen, "Made by Justin Symmank", 5, 335, 0xffffff);
	}
	
}

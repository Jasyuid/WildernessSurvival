package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.sound.Sound;

public class AboutMenu extends Menu{

	public AboutMenu(StateManager manager){
		super(manager);
		selected = 0;
	}
	
	public void update(Input input){
		if(input.enter && !manager.getHit()){
			Sound.enter.play(false);
			manager.setMenu(new MainMenu(manager));
			manager.setHit(true);
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(50, 25, Sprite.alertbox);
		
		Font.render2(screen, "About", screen.getWidth()/2-40, 80, 0xffffff);
		
		Font.render(screen, "Wilderness Survival was a game made for", 70, 120, 0xffffff);
		Font.render(screen, "Ludum Dare 36, a Game Programing Event where you", 70, 130, 0xffffff);
		Font.render(screen, "have 48 hours to create a game from scratch based", 70, 140, 0xffffff);
		Font.render(screen, "on a theme voted on by the community. The theme for", 70, 150, 0xffffff);
		Font.render(screen, "this year's event was \"Ancient Weapon\".", 70, 160, 0xffffff);
				
		Font.render(screen, "DATE COMPLETED: August 28th, 2016", 70, 200, 0xaaaaff);
		
		Font.render2(screen, "MENU", screen.getWidth()/2-32, 300, 0x00ff00);
	}
	
}

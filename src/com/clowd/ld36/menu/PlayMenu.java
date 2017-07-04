package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level_One;
import com.clowd.ld36.level.Level_Three;
import com.clowd.ld36.level.Level_Two;
import com.clowd.ld36.sound.Sound;

public class PlayMenu extends Menu{
	
	public PlayMenu(StateManager manager){
		super(manager);
		selected = 0;
	}
	
	public void update(Input input){
		if(input.enter && !manager.getHit()){
			if(selected == 0){
				Sound.enter.play(false);
				Sound.menumusic.stop();
				manager.setLevel(new Level_One("/levels/level1.png", manager));
				Sound.music.play(true);
				manager.setState(2);
			}else if(selected == 1){
				Sound.enter.play(false);
				Sound.menumusic.stop();
				manager.setLevel(new Level_Two("/levels/level2.png", manager));
				Sound.music.play(true);
				manager.setState(2);
			}else if(selected == 2){
				Sound.enter.play(false);
				Sound.menumusic.stop();
				manager.setLevel(new Level_Three("/levels/level3.png", manager));
				Sound.music.play(true);
				manager.setState(2);
			}else if(selected == 3){
				Sound.enter.play(false);
				manager.setMenu(new MainMenu(manager));
			}
			manager.setHit(true);
		}
		
		if(input.down && !manager.getHit()){
			if(selected < 3){
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
		screen.renderSprite(50, 25, Sprite.alertbox);
		
		if(selected == 0){
			Font.render2(screen, "EASY", 243, 100, 0x00ff00);
			Font.render2(screen, "MEDIUM", 227, 130, 0xffffff);
			Font.render2(screen, "HARD", 243, 160, 0xffffff);
			Font.render2(screen, "MENU", 243, 190, 0xffffff);
		}else if(selected == 1){
			Font.render2(screen, "EASY", 243, 100, 0xffffff);
			Font.render2(screen, "MEDIUM", 227, 130, 0x00ff00);
			Font.render2(screen, "HARD", 243, 160, 0xffffff);
			Font.render2(screen, "MENU", 243, 190, 0xffffff);
		}else if(selected == 2){
			Font.render2(screen, "EASY", 243, 100, 0xffffff);
			Font.render2(screen, "MEDIUM", 227, 130, 0xffffff);
			Font.render2(screen, "HARD", 243, 160, 0x00ff00);
			Font.render2(screen, "MENU", 243, 190, 0xffffff);
		}
		else if(selected == 3){
			Font.render2(screen, "EASY", 243, 100, 0xffffff);
			Font.render2(screen, "MEDIUM", 227, 130, 0xffffff);
			Font.render2(screen, "HARD", 243, 160, 0xffffff);
			Font.render2(screen, "MENU", 243, 190, 0x00ff00);
		}
	}
}

package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.sound.Sound;

public class GameOverMenu extends Menu{

	int[] scores;
	
	public GameOverMenu(StateManager manager, int[] scores){
		super(manager);
		this.scores = scores;
	}
	
	public void update(Input input){
		if(input.enter && !manager.getHit()){
			Sound.enter.play(false);
			Sound.menumusic.play(true);
			manager.setMenu(new MainMenu(manager));
			manager.setHit(true);
		}
	}
	
	public void render(Screen screen){
		screen.renderSprite(50, 25, Sprite.alertbox);
		Font.render2(screen, "GAME OVER", screen.getWidth()/2-72, 40, 0xff0000);
		
		Font.render2(screen, "Time - " + scores[0], 100, 110, 0xffffff);
		Font.render2(screen, "Kill - " + scores[1], 100, 130, 0xffffff);
		Font.render2(screen, "Item - " + scores[2], 100, 150, 0xffffff);
		
		screen.renderRect(90, 170, 370, 5, 0xffffff);
		int totScore = scores[0] + scores[1] + scores[2];
		Font.render2(screen, "Score - " + totScore, 100, 180, 0x6666ff);
		
		Font.render2(screen, "MENU", screen.getWidth()/2-32, 300, 0x00ff00);
	}
	
}

package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.sound.Sound;

public class WinMenu extends Menu{

	int[] scores;
	
	public WinMenu(StateManager manager, int[] scores){
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
		Font.render2(screen, "YOU WIN!", screen.getWidth()/2-64, 40, 0x00ff00);
		
		Font.render2(screen, "Time - " + scores[0], 100, 100, 0xffffff);
		Font.render2(screen, "Kill - " + scores[1], 100, 120, 0xffffff);
		Font.render2(screen, "Item - " + scores[2], 100, 140, 0xffffff);
		Font.render2(screen, "Health+Supplies - " + scores[3], 100, 160, 0xffffff);
		
		screen.renderRect(90, 180, 370, 5, 0xffffff);
		int totScore = scores[0] + scores[1] + scores[2] + scores[3];
		Font.render2(screen, "Score - " + totScore, 100, 190, 0x6666ff);
		
		Font.render2(screen, "MENU", screen.getWidth()/2-32, 300, 0x00ff00);
	}
	
}

package com.clowd.ld36.menu;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.sound.Sound;

public class HelpMenu extends Menu{

	int page;
	
	public HelpMenu(StateManager manager){
		super(manager);
		selected = 0;
		page = 0;
	}
	
	public void update(Input input){
		if(page == 0){
			if(selected == 1) selected = 2;
			if(input.right && !manager.getHit()){
				if(selected < 2){
					Sound.select.play(false);
					selected=2;
					manager.setHit(true);
				}
			}else if(input.left && !manager.getHit()){
				if(selected > 0){
					Sound.select.play(false);
					selected=0;
					manager.setHit(true);
				}
			}
		}else if(page == 1 || page == 2){			
			if(input.right && !manager.getHit()){
				if(selected < 2){
					Sound.select.play(false);
					selected++;
					manager.setHit(true);
				}
			}else if(input.left && !manager.getHit()){
				if(selected > 0){
					Sound.select.play(false);
					selected--;
					manager.setHit(true);
				}
			}
		}else if(page == 3){
			if(selected == 2) selected = 1;
			if(input.right && !manager.getHit()){
				if(selected < 2){
					Sound.select.play(false);
					selected=1;
					manager.setHit(true);
				}
			}else if(input.left && !manager.getHit()){
				if(selected > 0){
					Sound.select.play(false);
					selected=0;
					manager.setHit(true);
				}
			}
		}
		
		if(input.enter && !manager.getHit()){
			if(selected == 0){
				Sound.enter.play(false);
				manager.setMenu(new MainMenu(manager));
			}else if(selected == 1){
				Sound.enter.play(false);
				if(page>0) page--;
			}else if(selected == 2){
				Sound.enter.play(false);
				if(page<3) page++;
			}
			manager.setHit(true);
		}
		
	}
	
	public void render(Screen screen){
		screen.renderSprite(50, 25, Sprite.alertbox);
		
		if(page == 0){
			Font.render2(screen, "HELP", screen.getWidth()/2-32, 60, 0xffffff);

			Font.render(screen, "In Wilderness Survival you are a caveman defending", 70, 90, 0xffffff);
			Font.render(screen, "his camp from all of the wild creatures and other", 70, 100, 0xffffff);
			Font.render(screen, "people. Along with staying alive yourself, you also", 70, 110, 0xffffff);
			Font.render(screen, "need to make sure all of your supplies are not stolen", 70, 120, 0xffffff);
			Font.render(screen, "in the process. To complete this task you will use", 70, 130, 0xffffff);
			Font.render(screen, "various ancient weapons. You start out with throwing", 70, 140, 0xffffff);
			Font.render(screen, "rocks, but you can pick up a spear or bow and arrow", 70, 150, 0xffffff);
			Font.render(screen, "from an enemy.", 70, 160, 0xffffff);
			
			Font.render(screen, "Movement = Arrow Keys/WASD", 90, 180, 0xaaaaff);
			Font.render(screen, "Use Weapon = Space", 90, 195, 0xaaaaff);
			Font.render(screen, "Pause = Escape", 90, 210, 0xaaaaff);
			
		}else if(page == 1){
			screen.renderSprite(70, 40, Sprite.rocksH);
			screen.renderSprite(70, 80, Sprite.arrowH);
			screen.renderSprite(70, 120, Sprite.spearH);
			screen.renderSprite(70, 160, Sprite.healthH);
			screen.renderSprite(70, 200, Sprite.supH);
			screen.renderSprite(70, 240, Sprite.scoreH);
			
			Font.render(screen, "Throwing Rocks - (Speed:3, Range:50, Power:10)", 90, 45, 0xffffff);
			Font.render(screen, "\"The default weapon. Very Balanced.\"", 90, 60, 0xaaaaff);
			
			Font.render(screen, "Bow and Arrow - (Speed:4, Range:200, Power:5)", 90, 85, 0xffffff);
			Font.render(screen, "\"A fast weapon with long range but low power.\"", 90, 100, 0xaaaaff);
			
			Font.render(screen, "Spear - (Speed:1, Range:32, Power:20)", 90, 125, 0xffffff);
			Font.render(screen, "\"A close range weapon thats very powerful.\"", 90, 140, 0xaaaaff);
			
			Font.render(screen, "Health Pack - (Refill 25 Health)", 90, 165, 0xffffff);
			Font.render(screen, "\"Use to extend your life slightly.\"", 90, 180, 0xaaaaff);
			
			Font.render(screen, "Supply Chest - (Refill 25 Supplies)", 90, 205, 0xffffff);
			Font.render(screen, "\"Get back some supplies those pesky squirels took!\"", 90, 220, 0xaaaaff);
			
			Font.render(screen, "Point Star - (1000 Points)", 90, 245, 0xffffff);
			Font.render(screen, "\"FREE POINTS!\"", 90, 260, 0xaaaaff);
			
		}else if(page == 2){
			screen.renderSprite(70, 40, Sprite.squirel[9]);
			screen.renderSprite(70, 120, Sprite.wolf[9]);
			screen.renderSprite(70, 200, Sprite.whitewolf[9]);
			
			Font.render(screen, "Squirel - Only hurts you if you run into it. The", 100, 45, 0xffffff);
			Font.render(screen, "problem is its love for your supplies. Keep an", 110, 55, 0xffffff);
			Font.render(screen, "eye out for them, or they will become a big", 110, 65, 0xffffff);
			Font.render(screen, "problem.", 110, 75, 0xffffff);
			
			Font.render(screen, "Wolf - A ferocious animal whose only goal is your", 100, 125, 0xffffff);
			Font.render(screen, "demise. They love to charge directly at you so", 110, 135, 0xffffff);
			Font.render(screen, "stay on your toes at all time to avoid being", 110, 145, 0xffffff);
			Font.render(screen, "torn to shreads by them.", 110, 155, 0xffffff);
			
			Font.render(screen, "White Wolf - An even stronger wolf. Compared to a", 100, 205, 0xffffff);
			Font.render(screen, "normal wolf, these guys are even faster. They", 110, 215, 0xffffff);
			Font.render(screen, "are extremley hard to hurt before taking a", 110, 225, 0xffffff);
			Font.render(screen, "hit yourself.", 110, 235, 0xffffff);
			
		}else if(page == 3){
			screen.renderSprite(78, 40, Sprite.evilman[0]);
			screen.renderSprite(70, 160, Sprite.darkmonster);
			
			Font.render(screen, "Evil Man - Even though he looks like you,", 110, 45, 0xffffff);
			Font.render(screen, "he is no friend. They rush toward your", 120, 55, 0xffffff);
			Font.render(screen, "supplies while firing arrows all over the", 120, 65, 0xffffff);
			Font.render(screen, "place. Good luck!", 120, 75, 0xffffff);
			
			Font.render(screen, "Dark Monster - A mysterious dark shadow", 110, 165, 0xffffff);
			Font.render(screen, "that rarely appears. It moves very slowly", 120, 175, 0xffffff);
			Font.render(screen, "but do not be tricked. It has tons of HP", 120, 185, 0xffffff);
			Font.render(screen, "and if it reaches you supplies, they will", 120, 195, 0xffffff);
			Font.render(screen, "be gone before you know what happened.", 120, 205, 0xffffff);
		}
		
		
		if(selected == 0){
			Font.render2(screen, "MENU", screen.getWidth()/4-32, 300, 0x00ff00);
			if(page != 0)Font.render2(screen, "BACK", screen.getWidth()/2-32, 300, 0xffffff);
			if(page != 3)Font.render2(screen, "NEXT", 3*screen.getWidth()/4-32, 300, 0xffffff);
		}else if(selected == 1){
			Font.render2(screen, "MENU", screen.getWidth()/4-32, 300, 0xffffff);
			if(page != 0)Font.render2(screen, "BACK", screen.getWidth()/2-32, 300, 0x00ff00);
			if(page != 3)Font.render2(screen, "NEXT", 3*screen.getWidth()/4-32, 300, 0xffffff);
		}else if(selected == 2){
			Font.render2(screen, "MENU", screen.getWidth()/4-32, 300, 0xffffff);
			if(page != 0)Font.render2(screen, "BACK", screen.getWidth()/2-32, 300, 0xffffff);
			if(page != 3)Font.render2(screen, "NEXT", 3*screen.getWidth()/4-32, 300, 0x00ff00);
		}
	}
	
}

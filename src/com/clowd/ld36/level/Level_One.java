package com.clowd.ld36.level;

import java.util.Random;

import com.clowd.ld36.StateManager;
import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.entity.item.Item;
import com.clowd.ld36.entity.mob.DarkMonster;
import com.clowd.ld36.entity.mob.EvilMan;
import com.clowd.ld36.entity.mob.Player;
import com.clowd.ld36.entity.mob.Squirel;
import com.clowd.ld36.entity.mob.WhiteWolf;
import com.clowd.ld36.entity.mob.Wolf;
import com.clowd.ld36.entity.projectile.Arrow;
import com.clowd.ld36.gfx.Font;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;

public class Level_One extends Level{
	
	protected boolean eSpawn = false;
	protected int eSpawnT = 0;
	protected int eSpawnDelay, eSpawnTRange;
	
	protected Random r = new Random();
	
	public Level_One(String path, StateManager manager){
		super(path, manager);
	}
	
	public void generateLevel(){
		spawnX = 14;
		spawnY = 20;
		supplies = 100;
		ttime = 100;
		time = ttime;
		addEntity(new Player(this, spawnX*32, spawnY*32));
		
		eSpawnDelay = 60;
		eSpawnTRange = 200;
	}
	
	public void update2(Input input){
		if(start){
			if(!load){
				for(int i = 0; i < 5; i++){
					updateEntities(input);
					getPlayer().setPlayerX(spawnX*32);
					getPlayer().setPlayerY(spawnY*32);
				}
				load = true;
			}
			
			if(input.enter && !manager.getHit()){
				start = false;
				manager.setHit(true);
			};
			return;
		}
		updateEntities(input);
		
		
		if(eSpawn){
			int section = r.nextInt(2);
			if(section == 0){
				int chance = r.nextInt(100);
				if(chance < 50){
					addEntity(new Squirel(this, r.nextInt(14*32 - 12*32) + 12*32, 7*32, 0));
				}else if(chance < 100){
					addEntity(new Wolf(this, r.nextInt(14*32 - 12*32) + 12*32, 7*32));
				}
			}else if(section == 1){
				int chance = r.nextInt(100);
				if(chance < 50){
					addEntity(new Squirel(this, r.nextInt(19*32 - 17*32) + 17*32, 7*32, 0));
				}else if(chance < 100){
					addEntity(new Wolf(this, r.nextInt(19*32 - 17*32) + 17*32, 7*32));
				}
			}
			
			eSpawn = false;
		}else{
			eSpawnT++;
			if(eSpawnT >= eSpawnDelay){
				eSpawn = true;
				eSpawnT = 0;
				eSpawnDelay = 100 + r.nextInt(eSpawnTRange);
			}
		}
		
		
		time -= 0.01;
		if(flash % 10 == 0){
			timeScore++;
		}
		if(time <= 0){
			time = 0;
			healthScore = (int)(getPlayerH() + supplies)*10;
			win = true;
		}
	}
	
	public void render2(Screen screen){
		if(start){
			screen.setLight(-80);
			
			screen.renderSprite(50, 25, Sprite.alertbox);
			Font.render2(screen, "Welcome!", 211, 40, 0xaaaaff);
			screen.renderRect(90, 65, 370, 5, 0xffffff);
			Font.render2(screen, "Here's some quick info:", 91, 90, 0xaaaaff);
			
			screen.renderSprite(70, 120, Sprite.rocksH);
			screen.renderSprite(70, 140, Sprite.arrowH);
			screen.renderSprite(70, 160, Sprite.spearH);
			screen.renderSprite(70, 180, Sprite.healthH);
			screen.renderSprite(70, 200, Sprite.supH);
			screen.renderSprite(70, 220, Sprite.scoreH);
			
			Font.render(screen, "Throwing Rocks - (Speed:3, Range:50, Power:10)", 90, 125, 0xffffff);
			Font.render(screen, "Bow and Arrow - (Speed:4, Range:200, Power:5)", 90, 145, 0xffffff);
			Font.render(screen, "Spear - (Speed:1, Range:32, Power:20)", 90, 165, 0xffffff);
			Font.render(screen, "Health Pack - (Refill 25 Health)", 90, 185, 0xffffff);
			Font.render(screen, "Supply Chest - (Refill 25 Supplies)", 90, 205, 0xffffff);
			Font.render(screen, "Point Star - (1000 Points)", 90, 225, 0xffffff);
			
			
			if(flash < 25)
				Font.render2(screen, "PRESS ENTER TO CONTINUE!", 83, 250, 0x00ff00);
			else
				Font.render2(screen, "PRESS ENTER TO CONTINUE!", 83, 250, 0xffffff);
			
		}else{
			screen.setLight(0);
		}
	}
	
}

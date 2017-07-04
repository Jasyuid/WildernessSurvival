package com.clowd.ld36.entity.mob;

import com.clowd.ld36.entity.Entity;
import com.clowd.ld36.entity.item.Item;
import com.clowd.ld36.entity.projectile.Arrow;
import com.clowd.ld36.entity.projectile.ThrowRock;
import com.clowd.ld36.entity.weapon.Spear;
import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;
import com.clowd.ld36.level.Level;
import com.clowd.ld36.level.Level_Three;
import com.clowd.ld36.level.Level_Two;
import com.clowd.ld36.sound.Sound;

public class DarkMonster extends Mob{

	double xa, ya;
	int spawner;
	
	public DarkMonster(Level level, double x, double y, int spawner){
		super(level, x, y);
		sprite = Sprite.darkmonster;
		team = 1;
		this.spawner = spawner;
		health = 100;
		speed = 0.2;
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		xa = 0; ya = 0;
		
		if(level instanceof Level_Three){
			if(spawner == 0){
				xa += speed;
				if(x >= 33.5 * 32){
					if(y > 25.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 21.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.5);
						xa = 0;
						ya = 0;
					}
				}
			}else if(spawner == 1){
				xa = -speed;
				if(x <= 37.5 * 32){
					if(y > 25.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 21.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.5);
						xa = 0;
						ya = 0;
					}
				}
			}else if(spawner == 2){
				ya = speed;
				if(y >= 21.5 * 32){
					if(x > 37.5*32){
						xa = -speed;
						ya = 0;
					}else if(x < 33.5*32){
						xa = speed;
						ya = 0;
					}else{
						level.hitSupplies(0.5);
						xa = 0;
						ya = 0;
					}
				}
			}
		}
		
		move(xa, ya);
		moving = true;
		
		width = sprite.getWidth();
		height = sprite.getHeight();
		
		for(Entity e : level.getEntities()){
			if((e.getX() < x + width && e.getX() + e.getWidth() > x) && (e.getY() < y + height && e.getY() + e.getHeight() > y)){
				if(e instanceof ThrowRock){
					if(e.getTeam() != team){
						Sound.hurt.play(false);
						level.removeEntity(e);
						health-=((ThrowRock) e).getDamage();
					}
				}else if(e instanceof Arrow){
					if(e.getTeam() != team){
						Sound.hurt.play(false);
						level.removeEntity(e);
						health-=((Arrow) e).getDamage();
					}
				}else if(e instanceof Spear){
					if(e.getTeam() != team){
						Sound.hurt.play(false);
						level.removeEntity(e);
						health-=((Spear) e).getDamage();
					}
				}
			}
		}
		
		if(health <= 0){
			level.addEntity(new Item(level, x, y));
			
			level.addKScore(500);
			level.removeEntity(this);
		}
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
}

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
import com.clowd.ld36.sound.Sound;

public class WhiteWolf extends Mob{

	double xa, ya;
	
	public WhiteWolf(Level level, double x, double y){
		super(level, x, y);
		spritea = Sprite.whitewolf;
		sprite = spritea[0];
		dir = 3;
		team = 1;
		health = 30;
		speed = 1.2;
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		xa = 0; ya = 0;
		if(level.getPlayer().getX()+4 - x < -2){
			xa = -speed;
		}else if(level.getPlayer().getX()+4 - x > 2){
			xa = speed;
		}
		if(level.getPlayer().getY()+8 - y < -2){
			ya = -speed;
		}else if(level.getPlayer().getY()+8 - y > 2){
			ya = speed;
		}
		
		move(xa, ya);
		moving = true;
		
		walkAnimation(spritea);
		
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
			if(r.nextInt(2) == 0){
				level.addEntity(new Item(level, x, y));
			}
			level.addKScore(300);
			level.removeEntity(this);
		}
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
}

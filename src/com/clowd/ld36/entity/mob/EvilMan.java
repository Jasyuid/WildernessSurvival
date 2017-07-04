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

public class EvilMan extends Mob{

	double xa, ya;
	int shottimer;
	int spawner;
	int arrowdir;
	
	public EvilMan(Level level, double x, double y, int spawner){
		super(level, x, y);
		spritea = Sprite.evilman;
		sprite = spritea[0];
		dir = 3;
		team = 1;
		health = 40;
		speed = 1;
		shottimer = 0;
		this.spawner = spawner;
		
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		xa = 0; ya = 0;
		
		if(level instanceof Level_Two){
			if(spawner == 0){
				xa += speed;
				arrowdir = 2;
				if(x >= 33.5 * 32){
					if(r.nextInt(2) == 0){
						arrowdir = 1;
					}else{
						arrowdir = 3;
					}
					if(y > 13.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 9.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.05);
						xa = 0;
						ya = 0;
					}
				}
			}else if(spawner == 1){
				xa = -speed;
				arrowdir = 0;
				if(x <= 37.5 * 32){
					if(r.nextInt(2) == 0){
						arrowdir = 1;
					}else{
						arrowdir = 3;
					}
					if(y > 13.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 9.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.05);
						xa = 0;
						ya = 0;
					}
				}
			}
		}else if(level instanceof Level_Three){
			if(spawner == 0){
				xa += speed;
				arrowdir = 2;
				if(x >= 33.5 * 32){
					if(r.nextInt(2) == 0){
						arrowdir = 1;
					}else{
						arrowdir = 3;
					}
					if(y > 25.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 21.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.03);
						xa = 0;
						ya = 0;
					}
				}
			}else if(spawner == 1){
				xa = -speed;
				arrowdir = 0;
				if(x <= 37.5 * 32){
					if(r.nextInt(2) == 0){
						arrowdir = 1;
					}else{
						arrowdir = 3;
					}
					if(y > 25.5*32){
						ya = -speed;
						xa = 0;
					}else if(y < 21.5*32){
						ya = speed;
						xa = 0;
					}else{
						level.hitSupplies(0.03);
						xa = 0;
						ya = 0;
					}
				}
			}else if(spawner == 2){
				ya = speed;
				arrowdir = 3;
				if(y >= 20.5 * 32){
					if(r.nextInt(2) == 0){
						arrowdir = 0;
					}else{
						arrowdir = 2;
					}
					if(x > 37.5*32){
						xa = -speed;
						ya = 0;
					}else if(x < 33.5*32){
						xa = speed;
						ya = 0;
					}else{
						level.hitSupplies(0.03);
						xa = 0;
						ya = 0;
					}
				}
			}
		}
		
		move(xa, ya);
		moving = true;
		
		walkAnimation(spritea);
		
		width = sprite.getWidth();
		height = sprite.getHeight();
		
		if(shottimer <= 0){
			shottimer = 120;
			level.addEntity(new Arrow(level, x + width/4, y + height/4, arrowdir, team));
		}else{
			shottimer--;
		}
		
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

			level.addKScore(400);
			level.removeEntity(this);
		}
	}
	
	public void render(Screen screen){
		screen.renderMob((int)x, (int)y, sprite);
	}
	
}

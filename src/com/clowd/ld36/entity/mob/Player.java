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

public class Player extends Mob{
	
	private double xa, ya;
	
	private int health;
	
	private int shotDelay;
	private int shotClock = 0;
	
	private int damageFlash = 0;
	private int damageClock = 200;
	
	private int weapon = 0;
	
	public Player(Level level, double x, double y){
		super(level, x, y);
		speed = 1.5;
		spritea = Sprite.player;
		sprite = spritea[0];
		dir = 3;
		team = 0;
		health = 100;
		width = sprite.getWidth();
		height = sprite.getHeight();
	}
	
	public void update(Input input){
		xa = 0; ya = 0;
		
		if(input.up) ya-=speed;
		if(input.down) ya+=speed;
		if(input.left) xa-=speed;
		if(input.right) xa+=speed;
		
		if(xa != 0 || ya != 0){
			move(xa, ya);
			moving = true;
		}else{
			moving = false;
		}
		
		walkAnimation(spritea);
		
		if(weapon == 0){
			shotDelay = 30;
			if(input.space){
				if(shotClock == 0){
					level.addEntity(new ThrowRock(level, x + width/4, y + height/4, dir, team));
					shotClock = shotDelay;
				}else{
					shotClock--;
				}
			}else{
				shotClock = 0;
			}
		}else if(weapon == 1){
			shotDelay = 20;
			if(input.space){
				if(shotClock == 0){
					level.addEntity(new Arrow(level, x + width/4, y + height/4, dir, team));
					shotClock = shotDelay;
				}else{
					shotClock--;
				}
			}else{
				shotClock = 0;
			}
		}else if(weapon == 2){
			shotDelay = 20;
			if(input.space){
				if(shotClock == 0){
					if(dir == 0){
						level.addEntity(new Spear(level, x - 16, y + height/2, dir, team));
					}else if(dir == 1){
						level.addEntity(new Spear(level, x + width/2-2, y - 16, dir, team));
					}else if(dir == 2){
						level.addEntity(new Spear(level, x + width - 16, y + height/2, dir, team));
					}else if(dir == 3){
						level.addEntity(new Spear(level, x + width/2-2, y + height - 16, dir, team));
					}
					
					shotClock = shotDelay;
				}else{
					shotClock--;
				}
			}
		}
		
		

		for(Entity e : level.getEntities()){
			if((e.getX() < x + width && e.getX() + e.getWidth() > x) && (e.getY() < y + height && e.getY() + e.getHeight() > y)){
				if(e instanceof Item){
					Sound.heal.play(false);
					if(((Item) e).getType() == 0){
						weapon = 0;
						level.addIScore(100);
					}else if(((Item) e).getType() == 1){
						weapon = 1;
						level.addIScore(100);
					}else if(((Item) e).getType() == 2){
						weapon = 2;
						level.addIScore(100);
					}else if(((Item) e).getType() == 3){
						health+=25;
						if(health > 100) health = 100;
						level.addIScore(100);
					}else if(((Item) e).getType() == 4){
						level.addSupplies(25);
						level.addIScore(100);
					}else if(((Item) e).getType() == 5){
						level.addIScore(1000);
					}
					level.removeEntity(e);
				}else if(e instanceof Squirel){
					if(damageFlash == 0){
						Sound.hit.play(false);
						health -= 5;
						damageFlash = damageClock;
					}
				}else if(e instanceof Wolf){
					if(damageFlash == 0){
						Sound.hit.play(false);
						health -= 10;
						damageFlash = damageClock;
					}
				}else if(e instanceof WhiteWolf){
					if(damageFlash == 0){
						Sound.hit.play(false);
						health -= 10;
						damageFlash = damageClock;
					}
				}else if(e instanceof EvilMan){
					if(damageFlash == 0){
						Sound.hit.play(false);
						health -= 5;
						damageFlash = damageClock;
					}
				}else if(e instanceof Arrow){
					if(e.getTeam() != team){
						Sound.hit.play(false);
						level.removeEntity(e);
						health -= 5;
						damageFlash = damageClock;
					}
				}else if(e instanceof DarkMonster){
					if(damageFlash == 0){
						Sound.hit.play(false);
						health -= 20;
						damageFlash = damageClock;
					}
				}
			}
		}
		
		if(damageFlash > 0){
			damageFlash--;
		}
		
		if(health <= 0){
			level.removeEntity(this);
			level.setGameOver(true);
		}
		
		level.setPlayerX(x);
		level.setPlayerY(y);
		level.setPlayerXA(xa);
		level.setPlayerYA(ya);
		level.setPlayerH(health);
		level.setPlayerW(weapon);
	}
	
	public void render(Screen screen){
		if(damageFlash % 2 != 1){
			screen.renderPlayer(screen.getWidth() / 2 - width/2, screen.getHeight() / 2 - height/2, sprite);
		}
	}
	
	public double getPlayerX(){
		return x;
	}
	public double getPlayerY(){
		return y;
	}
	public double getPlayerXA(){
		return xa;
	}
	public double getPlayerYA(){
		return ya;
	}
	public void setPlayerX(double x){
		this.x = x;
	}
	public void setPlayerY(double y){
		this.y = y;
	}
	
}

package com.clowd.ld36.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	
	public static final Sound music = new Sound("/sound/music.wav");
	public static final Sound menumusic = new Sound("/sound/menumusic.wav");
	public static final Sound select = new Sound("/sound/select.wav");
	public static final Sound enter = new Sound("/sound/enter.wav");
	public static final Sound hit = new Sound("/sound/hit.wav");
	public static final Sound hurt = new Sound("/sound/hurt.wav");
	public static final Sound heal = new Sound("/sound/heal.wav");
	
	
	private AudioClip sound;
	
	private Sound(String name) {
		sound = Applet.newAudioClip(Sound.class.getResource(name));
	}
	
	public void play(boolean loop){
		if(loop)
			sound.loop();
		else
			sound.play();
	}
	
	public void stop(){
		sound.stop();
	}
	
	public static void stopAll(){
		music.stop();
		menumusic.stop();
		select.stop();
		enter.stop();
		hit.stop();
		hurt.stop();
		heal.stop();
	}
	
}

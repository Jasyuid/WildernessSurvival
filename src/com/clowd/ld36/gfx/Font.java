package com.clowd.ld36.gfx;

public class Font {
	
	public static String chars = "" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ  " + "abcdefghijklmnopqrstuvwxyz  " + ".,!?\"'/\\<>0123456789+-=*:;()";
	
	public static void render(Screen screen, String msg, int x, int y, int color){
		for(int i = 0; i < msg.length(); i++){
			int charIndex = chars.indexOf(msg.charAt(i));
			if(charIndex >= 0) screen.renderText(x + (8*i), y, charIndex, color, 1);
		}
	}
	
	public static void render2(Screen screen, String msg, int x, int y, int color){
		for(int i = 0; i < msg.length(); i++){
			int charIndex = chars.indexOf(msg.charAt(i));
			if(charIndex >= 0) screen.renderText2(x + (16*i), y, charIndex, color, 1);
		}
	}
	
}

package com.clowd.ld36.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener, FocusListener {
	
	private boolean[] keys = new boolean[65536];
	public boolean up, down, left, right, enter, space, esc;
	private boolean focus = false;
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_ENTER];
		space = keys[KeyEvent.VK_SPACE];
		esc = keys[KeyEvent.VK_ESCAPE];
	}
	
	//FocusListener
	public void focusGained(FocusEvent e) {
		focus = true;
	}
	public void focusLost(FocusEvent e) {
		focus = false;
	}
	
	//KeyListener
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	public void keyTyped(KeyEvent e) {
		
	
	}
	
	//Getters and Setters
	public boolean getFocus(){
		return focus;
	}
}

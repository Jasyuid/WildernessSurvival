package com.clowd.ld36;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.clowd.ld36.gfx.Screen;
import com.clowd.ld36.gfx.Sprite;
import com.clowd.ld36.input.Input;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	//JFrame
	private JFrame frame = new JFrame();
	private final int WIDTH = 550;
	private final int HEIGHT = 350;
	private final int SCALE = 2;
	private final String TITLE = "Wilderness Survival";
	//Thread
	private Thread thread;
	private boolean running = false;
	//BufferedImage
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	//Outside Classes
	private Screen screen;
	private Input input;
	private StateManager manager;
	
	public Game() {
		Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		
		screen = new Screen(WIDTH, HEIGHT);
		
		input = new Input();
		addKeyListener(input);
		addFocusListener(input);
		
		manager = new StateManager(this);
	}
	
	public void start(){
		if(!running){
			thread = new Thread(this, "Game Thread");
			thread.start();
			running = true;
		}
	}
	
	public void stop(){
		if(running){
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		double ns = 1000000000.0 / 100.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			while(System.currentTimeMillis() - lastTimer > 1000){
				lastTimer += 1000;
				System.out.println("UPS: " + updates + ", FPS: " + frames);
				frames = 0;
				updates = 0;
				
			}
			
		}
	}
	
	public void update(){
		input.update();

		manager.update(input);
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g= bs.getDrawGraphics();
		screen.graphics(g);
		screen.clear();
		//Render Screen Stuff Here
		
		manager.render(screen);
		
		for(int i = 0; i < WIDTH*HEIGHT; i++){
			pixels[i] = screen.getPixels()[i];
		}
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		//Render NonScreen Items
		
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		
		game.frame.setResizable(false);
		game.frame.setTitle(game.TITLE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);
		
		URL url = Game.class.getResource("/icon.png");
		ImageIcon imgicon = new ImageIcon(url);
		game.frame.setIconImage(imgicon.getImage());
		
		game.start();
	}
	
}

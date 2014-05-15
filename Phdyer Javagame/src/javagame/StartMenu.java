package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState {
	
	public Image title;
	public Image startButton;
	public Image optionsButton;
	public Image quitButton;
	public Image menuChest;
	public Image grassGround;
	public MenuOptions menu;
	float titleX = 15;
	float titleY = 10;
	float startX = 242;
	float startY = 100;
	float optX = 242;
	float optY = 200;
	float quitX = 242;
	float quitY = 300;
	
	 public StartMenu(int state) {
		 
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		title = new Image("res/menu_title.png");
		startButton = new Image("res/start_button.png"); //changed
		optionsButton = new Image("res/options_button.png");
		quitButton = new Image("res/quit_button.png");
		menuChest = new Image("res/menu_chest.png");
		grassGround = new Image("res/Grass Block.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		for(int i = -80; i <= 400; i += 80) {
			for(int k = 0; k <= 8; k ++) {
				g.drawImage(grassGround, (k*100), i);
			}
		}
		
		g.drawImage(title, titleX, titleY);
		g.drawString("Created by: Presley Dyer", 480, 465);
		g.drawString("             Version 1.5", 480, 480);
		g.drawImage(startButton, startX, startY);
		g.drawImage(optionsButton, optX, optY);
		g.drawImage(quitButton, quitX, quitY);
		g.drawImage(menuChest, 0, 150);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		//click start button
		if((mouseX > 242 && mouseX < 458) && (mouseY > 343 && mouseY < 396) && Mouse.isButtonDown(0)) {
				sbg.enterState(4);
			
		}
		//click options button
		if((mouseX > 242 && mouseX < 458) && (mouseY > 243 && mouseY < 296)) {
			if(input.isMousePressed(0)) {
				sbg.enterState(1);
			}
		}
		//click quit button
		if((mouseX > 242 && mouseX < 458) && (mouseY > 143 && mouseY < 196)) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
	}
	
	public int getID() {
		
		return 0;
		
	}
	
}

package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState {
	
	//297 50
	public Image startButton;
	public Image optionsButton;
	public Image quitButton;
	float startX = 202;
	float startY = 100;
	float optX = 202;
	float optY = 200;
	float quitX = 202;
	float quitY = 300;
	
	 public StartMenu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		startButton = new Image("res/start_button.png");
		optionsButton = new Image("res/options_button.png");
		quitButton = new Image("res/quit_button.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("WELCOME TO ADVENTURES IN JAVA!", 215, 25);
		Image woodGround = new Image("res/Wood Block.png");
		//101 171
		
		for(int i = 0; i <= 320; i += 80) {
			for(int k = 0; k <= 7; k ++) {
				g.drawImage(woodGround, (k*100), i);
			}
		}
		g.drawString("Created by: Presley Dyer", 480, 465);
		g.drawImage(startButton, startX, startY);
		g.drawImage(optionsButton, optX, optY);
		g.drawImage(quitButton, quitX, quitY);
		
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_W)) {
			startY -= .5;
		}
		if(input.isKeyDown(Input.KEY_S)) {
			startY += .5;
		}
		if(input.isKeyDown(Input.KEY_A)) {
			startX -= .5;
		}
		if(input.isKeyDown(Input.KEY_D)) {
			startX += .5;
		}
	}
	
	public int getID() {
		return 0;
	}
}

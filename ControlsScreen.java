package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ControlsScreen extends BasicGameState {
	
	public Image grassGround;
	public Image controls;
	public Image controlsTitle;
	public Image backButton;
	float controlsX = 225;
	float controlsY = 75;
	float titleX = 175;
	float titleY = 10;
	float backX = 5;
	float backY = 100;
	
	public ControlsScreen(int state) {
		
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		grassGround = new Image("res/Grass Block.png");
		controls = new Image("res/controls.png");
		controlsTitle = new Image("res/controls_title.png");
		backButton = new Image("res/back_button.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		for(int i = -80; i <= 400; i += 80) {
			for(int k = 0; k <= 8; k ++) {
				g.drawImage(grassGround, (k*100), i);
			}
		}
		g.drawImage(controls, controlsX, controlsY);
		g.drawImage(controlsTitle, titleX, titleY);
		g.drawImage(backButton, backX, backY);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		if((mouseX > 5 && mouseX < 221) && (mouseY > 346 && mouseY < 400) && MouseAction.isButtonDown(0)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(0);
			}
		}
		
	}
	
	public int getID() {
		
		return 3;
		
	}
}

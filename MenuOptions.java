package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuOptions extends BasicGameState {
	
	public Image grassGround;
	public Image title;
	public Image backButton;
	public Image controlsButton;
	public Image optionsChest;
	float titleX = 220;
	float titleY = 10;
	float backX = 459;
	float backY = 100;
	float controlsX = 459;
	float controlsY = 200;
	
	public MenuOptions(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		title = new Image("res/options_title.png");
		backButton = new Image("res/back_button.png");
		optionsChest = new Image("res/options_chest.png");
		grassGround = new Image("res/Grass Block.png");
		controlsButton = new Image("res/control_button.png");
		
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
		g.drawImage(backButton, backX, backY);
		g.drawImage(controlsButton, controlsX, controlsY);
		g.drawImage(optionsChest, 0, 150);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		//click back button
		if((mouseX > 459 && mouseX < 675) && (mouseY > 343 && mouseY < 396) && Mouse.isButtonDown(0)) {
			if(Mouse.getEventButtonState()) {
				sbg.enterState(0);
			}
		}
		//controls button
		if((mouseX > 459 && mouseX < 675) && (mouseY > 243 && mouseY < 296) && Mouse.isButtonDown(0)) {
			if(Mouse.getEventButtonState()) {
				sbg.enterState(3);
			}
		}
		
	}
	
	public int getID() {
		
		return 1;
		
	}
	
}

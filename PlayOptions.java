package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class PlayOptions extends BasicGameState {
	
	public Image title;
	public Image resumeButton;
	public Image optionsChest;
	float titleX = 220;
	float titleY = 10;
	float resumeX = 459;
	float resumeY = 100;
	float soundOnX = 459;
	float soundOnY = 200;
	float soundOffX = 459;
	float soundOffY = 300;
	float saveX = 459;
	float saveY = 400;
	
	public PlayOptions(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		title = new Image("res/options_title.png");
		resumeButton = new Image("res/resume_button.png");
		optionsChest = new Image("res/options_chest.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		Image grassGround = new Image("res/Grass Block.png");
		for(int i = -80; i <= 400; i += 80) {
			for(int k = 0; k <= 8; k ++) {
				g.drawImage(grassGround, (k*100), i);
			}
		}
		g.drawImage(title, titleX, titleY);
		g.drawString("Created by: Presley Dyer", 480, 465);
		g.drawString("             Version 1.0", 480, 480); //update version with releases
		g.drawImage(resumeButton, resumeX, resumeY);
		g.drawImage(optionsChest, 67, 150);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		//click resume button
		if((mouseX > 459 && mouseX < 675) && (mouseY > 343 && mouseY < 396)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(4);
			}
		}
		
	}
	
	public int getID() {
		
		return 2;
		
	}
}

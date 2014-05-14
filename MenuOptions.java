package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuOptions extends BasicGameState {
	
	public Image grassGround;
	public Image title;
	public Image backButton;
	public Image soundButtonOn;
	public Image soundButtonOff;
	public Image optionsChest;
	float titleX = 220;
	float titleY = 10;
	float backX = 459;
	float backY = 100;
	float soundOnX = 459;
	float soundOnY = 200;
	float soundOffX = 459;
	float soundOffY = 300;
	boolean sound;
	
	public MenuOptions(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		title = new Image("res/options_title.png");
		soundButtonOn = new Image("res/sound_on.png");
		soundButtonOff = new Image("res/sound_off.png");
		backButton = new Image("res/back_button.png");
		optionsChest = new Image("res/options_chest.png");
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
		g.drawString("             Version 1.0", 480, 480); //update version with releases
		g.drawImage(backButton, backX, backY);
		g.drawImage(soundButtonOn, soundOnX, soundOnY);
		g.drawImage(soundButtonOff, soundOffX, soundOffY);
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
		//click sound button
		if((mouseX > 459 && mouseX < 675) && (mouseY > 243 && mouseY < 296)) {
			if(Mouse.isButtonDown(0)) {
				sound = true;
				System.out.println(sound);
			}
		}
		if((mouseX > 459 && mouseX < 675) && (mouseY > 143 && mouseY < 196)) {
			if(Mouse.isButtonDown(0)) {
				sound = false;
				System.out.println(sound);
			}
		}
		
		/* movement for player
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
		*/
		
	}
	
	public int getID() {
		
		return 1;
		
	}
	
}

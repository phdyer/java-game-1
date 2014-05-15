package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ControlsScreen extends BasicGameState {
	
	public Image grassGround;
	public Image controlsScreen;
	float controlsX = 0;
	float controlsY = 0;
	
	public ControlsScreen(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		grassGround = new Image("res/Grass Block.png");
		controlsScreen = new Image("res/controls_screen2.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		for(int i = -80; i <= 400; i += 80) {
			for(int k = 0; k <= 8; k ++) {
				g.drawImage(grassGround, (k*100), i);
			}
		}
		g.drawImage(controlsScreen, controlsX, controlsY);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		
		if((mouseX > 5 && mouseX < 221) && (mouseY > 346 && mouseY < 400) && Mouse.isButtonDown(0)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(0);
			}
		}
		
	}
	
	public int getID() {
		
		return 3;
		
	}
}

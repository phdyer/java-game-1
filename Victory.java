package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Victory extends BasicGameState {
	
	public Image banner;
	public Level level;
	float scrollX = 800;
	float scrollY = 100;
	
	public Victory(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		banner = new Image("res/victory_banner.png");
		level = new Level();
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		level.victory.draw(0, 0);
		banner.draw(scrollX, scrollY);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		scrollX -= delta * .2f;
		if(scrollX < -850) {
			sbg.enterState(0);
		}
		
	}
	
	public int getID() {
		
		return 5;
		
	}
}

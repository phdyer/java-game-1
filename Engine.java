package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Engine extends StateBasedGame {
	
	public static final String gameTitle = "Adventures in Java";
	public static final int menu0 = 0;
	public static final int play = 1;
	
	public Engine(String gameTitle) {
		super(gameTitle);
		this.addState(new StartMenu(menu0));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu0).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu0);
	}

	public static void main(String[] args) {
		AppGameContainer window;
		
		try {
			window = new AppGameContainer(new Engine(gameTitle));
			window.setDisplayMode(700, 500, false);
			window.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

}

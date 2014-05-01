package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Engine extends StateBasedGame {
	
	public static final String gameTitle = "Adventures in Java";
	public static final int menu = 0;
	public static final int menuOptions = 1;
	public static final int playOptions = 2;
	public static final int controlsScreen = 3;
	public static final int play = 4;
	
	public Engine(String gameTitle) {
		super(gameTitle);
		this.addState(new StartMenu(menu));
		this.addState(new MenuOptions(menuOptions));
		this.addState(new PlayOptions(playOptions));
		this.addState(new ControlsScreen(controlsScreen));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(menuOptions).init(gc, this);
		this.getState(playOptions).init(gc, this);
		this.getState(controlsScreen).init(gc,  this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}

	public static void main(String[] args) {
		AppGameContainer window;
		
		try {
			window = new AppGameContainer(new Engine(gameTitle));
			window.setDisplayMode(700, 500, false);
			window.setShowFPS(false);
			window.start();
		}
		catch(SlickException e) {
			e.printStackTrace();
		}
	}

}

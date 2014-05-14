package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	public Image level1Key;
	public Image level1;
	public Image level2;
	public Image level3Locked;
	public Image level3Jewel;
	public Image level3;
	public Image pauseMenu;
	public Player player;
	float pauseX = 227;
	float pauseY = 127;
	float levelX = 0;
	float levelY = 0;
	float levelBoundaryX;
	float levelBoundaryY;
	float playerX = 275;
	float playerY = 175;
	boolean exit1, exit2a, exit2b, exit2c, exit2d;
	boolean onLevel1 = true, onLevel2, onLevel3, onLevel4, onLevel5, onLevel6, onLevel7;
	boolean key1Found, key2Found;
	boolean jewel1Found, jewel2Found, jewel3Found;
	boolean switch1;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 
		player = new Player();
		level1Key = new Image("res/level1_key.png");
		level1 = new Image("res/level1.png");
		level2 = new Image("res/level2.png");
		level3Locked = new Image("res/level3_locked.png");
		level3Jewel = new Image("res/level3_jewel.png");
		level3 = new Image("res/level3.png");
		
		pauseMenu = new Image("res/pause_menu.png");
		levelBoundaryX = level1.getWidth() * (-1) + 375;
		levelBoundaryY = level1.getHeight() * (-1) + 340;
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		
		
		if(onLevel1 && !key1Found) {
			level1Key.draw(levelX, levelY);
		}
		if(onLevel1 && key1Found) {
			level1.draw(levelX,levelY);
			
		}
		if(onLevel2) {
			level2.draw(levelX, levelY);
		}
		if(onLevel3 && !key1Found) {
			level3Locked.draw(levelX, levelY);
			if(levelY < -750) {
				levelY += .7f;
			}
		}
		if(onLevel3 && key1Found) {
			if(!jewel1Found) {
				level3Jewel.draw(levelX, levelY);
			} 
			if(jewel1Found) {
				level3.draw(levelX, levelY);
			}
		}
		
		player.player.draw(playerX, playerY);
		
		if(levelX == 0 && onLevel1) {
			player.welcomeSpeech.draw(playerX+100, playerY - 150);
		}
		
		
		g.drawString("level X: "+levelX+"\nlevel Y: "+levelY, 400, 20);
		if(gc.isPaused()) {
			pauseMenu.draw(pauseX, pauseY);
		}
		
		g.drawString(player.numberOfJewels() + " ", 585, 10);
		player.gem.draw(600, -7);
		player.key.draw(650, 0);
		g.drawString(player.numberOfKeys() + " ", 640, 10);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		pause(gc, sbg);
		move(gc, sbg, delta);
		levelExit(gc, sbg, delta);
		item(gc, sbg, delta);
		
		
		
	}
	
	public void pause(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE) && !gc.isPaused()) {
		    gc.setPaused(!gc.isPaused());
		}
		if(gc.getInput().isKeyPressed(Input.KEY_R) && gc.isPaused()) {
			gc.setPaused(!gc.isPaused());
		}
		if(gc.getInput().isKeyPressed(Input.KEY_O) && gc.isPaused()) {
			sbg.enterState(2);
		}
		if(gc.getInput().isKeyPressed(Input.KEY_Q) && gc.isPaused()) {
			sbg.enterState(0);
		}
		
	}
	
	public void move(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_W)) {
			player.walkingUp();
			levelY += delta * .2f;
			if(levelY > 200) {
				levelY -= delta * .2f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_S)) {
			player.walkingDown();
			levelY -= delta * .2f;
			if(levelY < levelBoundaryY) {
				levelY += delta * .2f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_A)) {
			player.walkingLeft();
			levelX += delta * .2f;
			if(levelX > 300) {
				levelX -= delta * .2f;
			}
		}
		
		if(input.isKeyDown(Input.KEY_D)) {
			player.walkingRight();
			levelX -= delta * .2f;
			if(levelX < levelBoundaryX) {
				levelX += delta * .2f;
			}
		}
		
	}
	
	public void levelExit(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if(levelX < -1885 && onLevel1) {
			if(levelY < -200 && levelY > -380) {
				onLevel1 = false;
				onLevel2 = true;
				levelX = 25;
				levelY = -545;
			}
		}
		
		if(levelX > 250 && onLevel2) {
			if(levelY < -475 && levelY > -620) {
				onLevel2 = false;
				onLevel1 = true;
				levelX = -1850;
				levelY = -312;
			}
		}
		
		if(levelX < -720 && levelX > -1030 && onLevel2) {
			if(levelY < -1350) {
				onLevel2 = false;
				onLevel3 = true;
				levelX = -885;
				levelY = 80;
			}
		}
		
		if(levelX < -720 && levelX > -1030 && onLevel3) {
			if(levelY > 150) {
				onLevel3 = false;
				onLevel2 = true;
				levelX = -885;
				levelY = -1300;
			}
		}
		
	}
	
	public void item(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if(onLevel1 && !key1Found && (levelX < -1800) && (levelY > 40)) {
			key1Found = true;
			player.addKey();
		}
		
		if(onLevel3 && !jewel1Found && (levelX < -720 && levelX > -1030) && (levelY < -1125)) {
			jewel1Found = true;
			player.addJewel();
		}
		
	}
	
	public int getID() {
		
		return 4;
		
	}
}
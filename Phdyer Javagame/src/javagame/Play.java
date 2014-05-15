package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	public Music music;
	public Image pauseMenu;
	public Player player;
	public Level level;
	float pauseX = 227;
	float pauseY = 127;
	float levelX = 0;
	float levelY = 0;
	float levelBoundaryX;
	float levelBoundaryY;
	float playerX = 275;
	float playerY = 175;
	boolean onLevel1 = true, onLevel2, onLevel3, onLevel4, onLevel5, onLevel6, onLevel7, onLevel8;
	boolean key1Found, key2Found;
	boolean jewel1Found, jewel2Found, jewel3Found, jewel4Found;
	boolean switch1, switch2, switch3, switchComboJewel, switchComboKey;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		 
		player = new Player();
		level = new Level();
		pauseMenu = new Image("res/pause_menu.png");
		levelBoundaryX = level.level1.getWidth() * (-1) + 375;
		levelBoundaryY = level.level1.getHeight() * (-1) + 340;
		music = new Music("res/8bit_music_play.ogg");
		music.loop();
		music.setVolume(.3f);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if(onLevel1) {
			if(!key1Found) {
				level.level1Key.draw(levelX, levelY);
			}
			if(key1Found) {
				level.level1.draw(levelX, levelY);
			}
		}
		if(onLevel2) {
			if(!switchComboKey) {
				level.level2.draw(levelX, levelY);
			}
			if(switchComboKey && key2Found) {
				level.level2.draw(levelX, levelY);
			}
			if(switchComboKey && !key2Found) {
				level.level2Key.draw(levelX, levelY);
			}
		}
		if(onLevel3) {
			if(!key1Found) {
				level.level3Locked.draw(levelX, levelY);
				if(levelY < -750) {
					levelY += .7f;
				}
			}
			if(key1Found) {
				if(!jewel1Found) {
					level.level3Jewel.draw(levelX, levelY);
				}
				if(jewel1Found) {
					level.level3.draw(levelX, levelY);
				}
			}
		}
		if(onLevel4) {
			if(!switchComboJewel) {
				level.level4Locked.draw(levelX, levelY);
			}
			if(switchComboJewel) {
				if(!jewel2Found) {
					level.level4Jewel.draw(levelX, levelY);
				}
				if(jewel2Found) {
					level.level4.draw(levelX, levelY);
				}
			}
		}
		if(onLevel5) {
			level.level5.draw(levelX, levelY);
		}
		if(onLevel6) {
			if(!jewel3Found) {
				level.level6Jewel.draw(levelX, levelY);
			}
			if(jewel3Found) {
				level.level6.draw(levelX, levelY);
			}
		}
		if(onLevel7) {
			if(!key2Found) {
				level.level7Locked.draw(levelX, levelY);
			}
			if(key2Found) {
				if(!jewel4Found) {
					level.level7Jewel.draw(levelX, levelY);
				}
				if(jewel4Found) {
					level.level7.draw(levelX, levelY);
				}
			}
		}
		if(onLevel8) {
			if(levelY > -390) {
				levelY -= .7f;
			}
			if(!switch1 && switch2 && switch3) {
				switchComboJewel = true;
			}
			if(switch1 && !switch2 && !switch3) {
				switchComboKey = true;
			}
			if(!switch1 && !switch2 && !switch3) {
				level.level8.draw(levelX, levelY);
			}
			if(switch1 && !switch2 && !switch3) {
				level.level8SwitchLeft.draw(levelX, levelY);
			}
			if(!switch1 && switch2 && !switch3) {
				level.level8SwitchMiddle.draw(levelX, levelY);
			}
			if(!switch1 && !switch2 && switch3) {
				level.level8SwitchRight.draw(levelX, levelY);
			}
			if(switch1 && switch2 && !switch3) {
				level.level8SwitchLeftMiddle.draw(levelX, levelY);
			}
			if(!switch1 && switch2 && switch3) {
				level.level8SwitchMiddleRight.draw(levelX, levelY);
			}
			if(switch1 && !switch2 && switch3) {
				level.level8SwitchLeftRight.draw(levelX, levelY);
			}
			if(switch1 && switch2 && switch3) {
				level.level8SwitchAll.draw(levelX, levelY);
			}
		}
		
		player.player.draw(playerX, playerY);
		
		if(levelX == 0 && onLevel1) {
			player.welcomeSpeech.draw(playerX+100, playerY - 150);
		}
		
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
		if(player.numberOfJewels() == 4) {
			sbg.enterState(5);
		}
		
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
		
		if(onLevel1) {
			if(levelX < -1885 && levelY < -200 && levelY > -380) {
				onLevel1 = false;
				onLevel2 = true;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 2 from Area 1");
				levelX = 25;
				levelY = -545;
			}
		}
		if(onLevel2) {
			if(levelX > 250 && levelY < -475 && levelY > -620) {
				onLevel1 = true;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 1 from Area 2");
				levelX = -1850;
				levelY = -312;
			}
			else if(levelX < -720 && levelX > -1030 && levelY < -1350) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = true;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 3 from Area 2");
				levelX = -885;
				levelY = 80;
			}
			else if(levelX < -720 && levelX > -1030 && levelY > 150) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = true;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 4 from Area 2");
				levelX = -885;
				levelY = -1300;
			}
			else if(levelX < -1885 && levelY < -475 && levelY > -620) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = true;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 5 from Area 2");
				levelX = 25;
				levelY = -545;
			}
		}
		if(onLevel3) {
			if(levelX < -720 && levelX > -1030 && levelY > 150) {
				onLevel1 = false;
				onLevel2 = true;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 2 from Area 3");
				levelX = -885;
				levelY = -1300;
			}
		}
		if(onLevel4) {
			if(levelX < -720 && levelX > -1030 && levelY < -1350) {
				onLevel1 = false;
				onLevel2 = true;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 2 from Area 4");
				levelX = -885;
				levelY = 80;
			}
		}
		if(onLevel5) {
			if(levelX > 250 && levelY < -475 && levelY > -620) {
				onLevel1 = false;
				onLevel2 = true;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 2 from Area 5");
				levelX = -1850;
				levelY = -545;
			}
			else if(levelX < -720 && levelX > -1385 && levelY < -1350) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = true;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 6 from Area 5");
				levelX = -885;
				levelY = 80;
			}
			else if(levelX < -1650 && levelY < -475 && levelY > -620) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = true;
				onLevel8 = false;
				System.out.println("Entering Area 7 from Area 5");
				levelX = 25;
				levelY = -545;
			}
			else if(levelX < -720 && levelX > -1385 && levelY > 150) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = false;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = true;
				System.out.println("Entering Area 8 from Area 5");
				levelX = -885;
				levelY = -1300;
			}
		}
		if(onLevel6) {
			if(levelX < -720 && levelX > -1385 && levelY > 150) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = true;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 5 from Area 6");
				levelX = -885;
				levelY = -1300;
			}
		}
		if(onLevel7) {
			if(levelX > 250 && levelY < -475 && levelY > -620) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = true;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 5 from Area 7");
				levelX = -1500;
				levelY = -545;
			}
		}
		if(onLevel8) {
			if(levelX < -720 && levelX > -1385 && levelY < -1350) {
				onLevel1 = false;
				onLevel2 = false;
				onLevel3 = false;
				onLevel4 = false;
				onLevel5 = true;
				onLevel6 = false;
				onLevel7 = false;
				onLevel8 = false;
				System.out.println("Entering Area 5 from Area 8");
				switch1 = false;
				switch2 = false;
				switch3 = false;
				levelX = -885;
				levelY = 80;
			}
		}
		
	}
	
	public void item(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Input input = gc.getInput();
		
		if(onLevel1) {
			if(!key1Found) {
				if(levelX < -1800 && levelY > 40) {
					key1Found = true;
					player.addKey();
				}
			}
		}
		if(onLevel2) {
			if(switchComboKey && !key2Found) {
				if(levelX < -780 && levelX > -960 && levelY < -430 && levelY > -615) {
					key2Found = true;
					player.addKey();
				}
			}
		}
		if(onLevel3) {
			if(!jewel1Found) {
				if(levelX < -720 && levelX > -1030 && levelY < -1125) {
					jewel1Found = true;
					player.addJewel();
				}
			}
		}
		if(onLevel4) {
			if(switchComboJewel && !jewel2Found) {
				if(levelX < -1730 && levelX > -1880 && levelY < -130 && levelY > -330) {
					jewel2Found = true;
					player.addJewel();
				}
			}
		}
		if(onLevel6) {
			if(!jewel3Found) {
				if(levelX < -100 && levelX > -250 && levelY < -1175) {
					jewel3Found = true;
					player.addJewel();
				}
			}
		}
		if(onLevel7) {
			if(key2Found && !jewel4Found) {
				if(levelX < -1380 && levelY < -430 && levelY > -1850) {
					jewel4Found = true;
					player.addJewel();
				}
			}
		}
		if(onLevel8) {
			if(levelY > -450) {
				if(levelX < -60 && levelX > -340) {
					if(input.isKeyPressed(Input.KEY_SPACE)) {
						switch1 = true;
					}
				}
				if(levelX < -720 && levelX > -1030) {
					if(input.isKeyPressed(Input.KEY_SPACE)) {
						switch2 = true;
					}
				}
				if(levelX < -1420 && levelX > -1740) {
					if(input.isKeyPressed(Input.KEY_SPACE)) {
						switch3 = true;
					}
				}
			}
		}
		
	}
	
	public int getID() {
		
		return 4;
		
	}
}
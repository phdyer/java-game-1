package javagame;

import org.newdawn.slick.*;

public class Level {
	
	public Image level1;
	public Image level1Key;
	public Image level2;
	public Image level2Key;
	public Image level3;
	public Image level3Jewel;
	public Image level3Locked;
	public Image level4;
	public Image level4Jewel;
	public Image level4Locked;
	public Image level5;
	public Image level6;
	public Image level6Jewel;
	public Image level7;
	public Image level7Jewel;
	public Image level7Locked;
	public Image level8;
	public Image level8SwitchLeft;
	public Image level8SwitchMiddle;
	public Image level8SwitchRight;
	public Image level8SwitchLeftMiddle;
	public Image level8SwitchMiddleRight;
	public Image level8SwitchLeftRight;
	public Image level8SwitchAll;
	public Image victory;
	
	public Level() throws SlickException {
		
		level1 = new Image("res/level1.png");
		level1Key = new Image("res/level1_key.png");
		level2 = new Image("res/level2.png");
		level2Key = new Image("res/level2_key.png");
		level3 = new Image("res/level3.png");
		level3Jewel = new Image("res/level3_jewel.png");
		level3Locked = new Image("res/level3_locked.png");
		level4 = new Image("res/level4.png");
		level4Jewel = new Image("res/level4_jewel.png");
		level4Locked = new Image("res/level4_locked.png");
		level5 = new Image("res/level5.png");
		level6 = new Image("res/level6.png");
		level6Jewel = new Image("res/level6_jewel.png");
		level7 = new Image("res/level7.png");
		level7Jewel = new Image("res/level7_jewel.png");
		level7Locked = new Image("res/level7_locked.png");
		level8 = new Image("res/level8.png");
		level8SwitchLeft = new Image("res/level8_switch_left.png");
		level8SwitchMiddle = new Image("res/level8_switch_middle.png");
		level8SwitchRight = new Image("res/level8_switch_middle.png");
		level8SwitchLeftMiddle = new Image("res/level8_switch_left_middle.png");
		level8SwitchMiddleRight = new Image("res/level8_switch_middle_right.png");
		level8SwitchLeftRight = new Image("res/level8_switch_left_right.png");
		level8SwitchAll = new Image("res/level8_switch_all.png");
		victory = new Image("res/victory.png");
		
	}
	
}

package javagame;

import org.newdawn.slick.*;

public class Player {
	
	Animation player, movingUp, movingDown, movingLeft, movingRight;
	public Image playerFront;
	public Image playerBack;
	public Image playerLeft;
	public Image playerRight;
	public Image key;
	public Image gem;
	public Image firstLockSpeech;
	public Image secondLockSpeech;
	public Image welcomeSpeech;
	public Image keySpeech;
	public Image jewelSpeech;
	public Image finalJewelSpeech;
	int[] duration = {200, 200};
	int keys = 0;
	int jewels = 0;
	
	
	public Player() throws SlickException {
		Image[] walkingDown = { new Image("res/player_front.png"), new Image("res/player_front.png") };
		Image[] walkingUp = { new Image("res/player_back.png"), new Image("res/player_back.png") };
		Image[] walkingLeft = { new Image("res/player_left.png"), new Image("res/player_left.png") };
		Image[] walkingRight = { new Image("res/player_right.png"), new Image("res/player_right.png") };
		
		key = new Image("res/key.png");
		gem = new Image("res/blue_gem.png");
		welcomeSpeech = new Image("res/welcome_speech.png");
		firstLockSpeech = new Image("res/first_lock_speech.png");
		secondLockSpeech = new Image("res/second_lock_speech.png");
		keySpeech = new Image("res/key_speech.png");
		jewelSpeech = new Image("res/first_jewel_speech.png");
		finalJewelSpeech = new Image("res/all_jewel_speech.png");
		
		
		movingUp = new Animation(walkingUp, duration, false);
		movingDown = new Animation(walkingDown, duration, false);
		movingLeft = new Animation(walkingLeft, duration, false);
		movingRight = new Animation(walkingRight, duration, false);
		player = movingDown;
	}
	
	public void walkingUp() {
		player = movingUp;
	}
	
	public void walkingDown() {
		player = movingDown;
	}
	
	public void walkingLeft() {
		player = movingLeft;
	}
	
	public void walkingRight() {
		player = movingRight;
	}
	
	public int numberOfKeys() {
		
		int howMany = keys;
		return howMany;
		
	}
	
	public void addKey() {
		
		keys ++;
		
	}
	
	public int numberOfJewels() {
		
		int howMany = jewels;
		return howMany;
		
	}
	
	public void addJewel() {
		
		jewels ++;
		
	}
}

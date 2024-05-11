package data;

import lejos.hardware.Sound;

public class Robot {
	private static int id;
	private static int speed;
	private static int turn;
	private static int run=1;
	private static int music;
	
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Robot.id = id;
	}
	public static void setId(String id) {
		try {
			Robot.id = Integer.parseInt(id);
		}
		catch(Exception e) {
			//id remains unchanged
		}
	}
	 public static void playLondonBridgeMusic() {
		  int[] notes = { 392, 392, 440, 392, 349, 330, 294 };
		  int[] durations = { 200, 200, 400, 200, 200, 400, 400 };
		  // Play the song
		  for (int i = 0; i < notes.length; i++) {
		      Sound.playTone(notes[i], durations[i]);
		      try {
		          Thread.sleep(durations[i] + 50); // Add a small delay between notes
		      } catch (InterruptedException e) {
		          e.printStackTrace();
		      }
		  }
		}
	public static int getSpeed() {
		return speed;
	}
	public static int turnRight() {//Slower Right Motor
		if (turn<0) {
			return speed+turn;
		}
		else {
			return speed;
		}
		
	}
	public static int turnLeft() {//Slower Left motor
		if (turn>0) {
			return speed-turn;
		}
		else {
			return speed;
		}
	}
	public static void setSpeed(int speed) {
		Robot.speed = speed;
	}
	public static void setSpeed(String speed) {
		try {
			Robot.speed = Integer.parseInt(speed);
		}
		catch(Exception e) {
			//speed remains unchanged
		}
	}
	public static int getTurn() {
		return turn;
	}
	public static void setTurn(int turn) {
		Robot.turn = turn;
	}
	public static void setTurn(String turn) {
		try {
			Robot.turn = Integer.parseInt(turn);
		}
		catch(Exception e) {
			///turn remains unchanged
		}
	}
	public static int getRun() {
		return run;
	}
	public static void setRun(int run) {
		Robot.run = run;
	}
	public static void setRun(String run) {
		try {
			Robot.run = Integer.parseInt(run);
		}
		catch(Exception e) {
			///run remains unchanged
		}
	}
}

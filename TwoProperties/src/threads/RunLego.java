package threads;

import data.Robot;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.Sound;

public class RunLego implements Runnable{
    UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
    UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (Robot.getRun()==1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			motorA.setPower(Robot.turnRight());
			motorB.setPower(Robot.turnLeft());
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
}

package app;

import threads.*;

public class LegoApp {

	public static void main(String[] args) {
		RunLego runLego=new RunLego();
		ReadData readData=new ReadData();

		System.out.println("Run in Threads");

		Thread runLegoThread=new Thread(runLego);
		Thread readDataThread=new Thread(readData);
		runLegoThread.start(); //Threads start
		readDataThread.start(); //Virtual computer starts thread
	}
}

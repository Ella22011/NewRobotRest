package app;

import threads.*;

public class LegoApp {

	public static void main(String[] args) {
		RunLego runLego=new RunLego();
		ReadData readData=new ReadData();

		System.out.println("Run in Threads");

		Thread runLegoThread=new Thread(runLego);
		Thread readDataThread=new Thread(readData);
		runLegoThread.start(); //Säikeen käynnistys
		readDataThread.start(); //Virtuaalikone aloittaa säikeen kun ehtii
	}
}

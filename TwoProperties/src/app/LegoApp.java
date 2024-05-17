package app;

import threads.RunLego;
import threads.ReadData;

/**
 * Main class to start the Lego robot application.
 */
public class LegoApp {
    public static void main(String[] args) {
        RunLego runLego = new RunLego();
        ReadData readData = new ReadData();

        System.out.println("Running in Threads");

        Thread runLegoThread = new Thread(runLego);
        Thread readDataThread = new Thread(readData);
        runLegoThread.start(); // Start the thread to control the robot
        readDataThread.start(); // Start the thread to read data from the web service
    }
}

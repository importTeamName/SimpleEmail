//package com.importteamname.simpleemail;

import java.awt.EventQueue;

/**
 * Program to run SimpleEmail system
 * Creates the RemoteSite to manage the data
 * Starts the EmailGUI to interface with the system
 * @author ImportTeamName
 * TODO: JUnit Tests
 */
public class SimpleEmail {
	
	private static RemoteSite  masterSite = new RemoteSite();
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new EmailGUI(masterSite);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
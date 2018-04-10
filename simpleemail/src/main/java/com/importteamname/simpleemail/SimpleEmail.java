package com.importteamname.simpleemail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.util.ArrayList;

public class SimpleEmail {
	
	private JFrame frame;
	private static RemoteSite  masterSite = new RemoteSite();
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailGUI window2 = new EmailGUI(masterSite);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

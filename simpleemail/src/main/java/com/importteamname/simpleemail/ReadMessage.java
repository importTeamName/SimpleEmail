//package com.importteamname.simpleemail;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.UIManager;

public class ReadMessage {

	private JFrame 		frame;
	private Message		message;

    /**
     * Create the application.
     */
    public ReadMessage(Message m) {
		message = m;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 479);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 38, 600, 118);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblFrom = new JLabel("From:");
        lblFrom.setBounds(39, 11, 61, 16);
        panel.add(lblFrom);
        
        JLabel lblTo = new JLabel("To:");
        lblTo.setBounds(55, 49, 30, 16);
        panel.add(lblTo);
        
        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setBounds(24, 87, 61, 16);
        panel.add(lblSubject);
        
        JLabel lblSenderAddress = new JLabel("sender address here");
        lblSenderAddress.setBounds(89, 11, 481, 16);
        panel.add(lblSenderAddress);
        
        JLabel lblFromAddress = new JLabel("recipitant address here");
        lblFromAddress.setBounds(89, 49, 481, 16);
        panel.add(lblFromAddress);
        
        JLabel lblSubjectText = new JLabel("subject here");
        lblSubjectText.setBounds(89, 87, 481, 16);
        panel.add(lblSubjectText);
        
        JTextPane textPane = new JTextPane();
        textPane.setBounds(0, 158, 600, 280);
        frame.getContentPane().add(textPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(UIManager.getColor("Button.background"));
        panel_1.setBounds(0, 0, 600, 39);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(450, 6, 117, 29);
        panel_1.add(btnDelete);
        
        JLabel lblDateTime = new JLabel(message.getDate().toString());
        lblDateTime.setBounds(10, 13, 231, 14);
        panel_1.add(lblDateTime);
    }
}
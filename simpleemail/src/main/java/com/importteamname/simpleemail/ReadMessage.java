//package com.importteamname.simpleemail;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.UIManager;
/**
 * Class for creating a read message dialog
 * @author Alex, Daniel Weber, Clay Turner
 *
 */
public class ReadMessage {

	private JFrame 		frame;
	private Message		message;

    /**
     * Create the application.
     * @param m Message to display
     */
    public ReadMessage(Message m) {
		message = m;
        initialize();
        frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Read Message");
        frame.setBounds(100, 100, 600, 479);
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
        
        // Fill in all fields with info
        JLabel lblSenderAddress = new JLabel(message.getSender().getAccountname());
        lblSenderAddress.setBounds(89, 11, 481, 16);
        panel.add(lblSenderAddress);
        
        JLabel lblFromAddress = new JLabel(message.getReceiversString());
        lblFromAddress.setBounds(89, 49, 481, 16);
        panel.add(lblFromAddress);
        
        JLabel lblSubjectText = new JLabel(message.getSubject());
        lblSubjectText.setBounds(89, 87, 481, 16);
        panel.add(lblSubjectText);
        
        JTextPane textPane = new JTextPane();
        textPane.setText(message.getText());
        textPane.setBounds(0, 158, 600, 280);
        frame.getContentPane().add(textPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(UIManager.getColor("Button.background"));
        panel_1.setBounds(0, 0, 600, 39);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        LocalDateTime time = message.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d YYYY hh:MM:SS a");
        String timestr = time.format(formatter);
        JLabel lblDateTime = new JLabel(timestr);
        lblDateTime.setBounds(10, 13, 231, 14);
        panel_1.add(lblDateTime);
    }
}
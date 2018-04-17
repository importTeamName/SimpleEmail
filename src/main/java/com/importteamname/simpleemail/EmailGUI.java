/**
 * Class for the main GUI for the SimpleEmail system
 * Created using the WindowBuilder extension
 * @author Alex Porter, Clay Turner
 */

package com.importteamname.simpleemail;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import java.util.ArrayList;

public class EmailGUI {

	private JFrame			frame;
	private JTextField		UserText;
	private JTextField  	PasswordText;
	private JLabel 			lblwelcome;
	private JLabel 			lblActiveAccount;
	private JPopupMenu 		accountMenu;
	private JButton 		btnInbox;
	private JButton 		btnSent;
	private JButton 		btnTrash;
	private Border			defaultBorder;
	private JList<String> 	list;
	private JScrollPane		scrollList;
	private boolean			noEmails;
	
	private RemoteSite		CopyOfMasterSite;
	private User			CurrentUser;
	private Account			CurrentAccount;
    private MailBox			CurrentMailBox;
    
	/**
	 * Create the application.
	 * @param remSite Copy of remote site to access data from 
	 */
	public EmailGUI(RemoteSite remSite) {
		CopyOfMasterSite = remSite;
		initialize();
		frame.setVisible(true);
		frame.setResizable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Simple Email by ImportTeamName");
		frame.setBounds(100, 100, 700, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		/* 
		 * ---Stuff on the Login Screen--- 
		 */
		JPanel LoginScreen = new JPanel();
		frame.getContentPane().add(LoginScreen, "name_443823858163679");
		LoginScreen.setLayout(null);
		
		//User name
		UserText = new JTextField();
		UserText.setBounds(293, 102, 86, 20);
		LoginScreen.add(UserText);
		UserText.setColumns(10);
		
		//Password
		PasswordText = new JTextField();
		PasswordText.setBounds(293, 133, 86, 20);
		LoginScreen.add(PasswordText);
		PasswordText.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(130, 105, 153, 14);
		LoginScreen.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpassword.setBounds(141, 136, 142, 14);
		LoginScreen.add(lblpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//check for valid login
				if(CopyOfMasterSite.userExists(UserText.getText())) {
					if(CopyOfMasterSite.validatePassword(UserText.getText(), PasswordText.getText()))
					{
						//Login to the user
						CurrentUser = CopyOfMasterSite.getUser(UserText.getText());
						StartMailbox();
					}
					else {
						JOptionPane.showMessageDialog(frame,"Incorrect Username or Password");
					}
				}
				else {
					JOptionPane.showMessageDialog(frame,"User does not exist");
				}
				
			}
		});
		btnLogin.setBounds(290, 164, 89, 23);
		LoginScreen.add(btnLogin);
		defaultBorder = btnLogin.getBorder();
		
		JLabel lblEnterInfo = new JLabel("Enter Login Information");
		lblEnterInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterInfo.setBounds(221, 80, 158, 14);
		LoginScreen.add(lblEnterInfo);
		
		JButton btnadduser = new JButton("Add User");
		btnadduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(1);
			}
		});
		btnadduser.setBounds(10, 11, 89, 23);
		LoginScreen.add(btnadduser);
		
		JButton btndeleteuser = new JButton("Delete User");
		btndeleteuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(2);
			}
		});
		btndeleteuser.setBounds(109, 11, 101, 23);
		LoginScreen.add(btndeleteuser);
		
		/* 
		 * ---Stuff on the MailBox Screen--- 
		 */
		JPanel MailboxScreen = new JPanel();
		frame.getContentPane().add(MailboxScreen, "name_443823897215886");
		MailboxScreen.setLayout(null);
		
		JButton btnaddaccount = new JButton("Add Account");
		btnaddaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(3);
			}
		});
		btnaddaccount.setBounds(20, 20, 107, 23);
		MailboxScreen.add(btnaddaccount);
		
		JButton btndeleteaccount = new JButton("Delete Account");
		btndeleteaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(4);
			}
		});
		btndeleteaccount.setBounds(160, 20, 120, 23);
		MailboxScreen.add(btndeleteaccount);
		
		JButton btnlogout = new JButton("Log Out");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOut();
			}
		});
		btnlogout.setBounds(591, 10, 89, 23);
		MailboxScreen.add(btnlogout);
		
		lblwelcome = new JLabel();
		lblwelcome.setBounds(5, 2, 178, 14);
		MailboxScreen.add(lblwelcome);
		
		btnInbox = new JButton("Inbox");
		btnInbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Check that there is an account selected
				if(CurrentUser.getAccounts().isEmpty()) {
					JOptionPane.showMessageDialog(frame,"Must have an account to view emails");
				}
				else if(CurrentAccount == null) {
					JOptionPane.showMessageDialog(frame,"Must have an account selected to view emails");
				}
				else {
					SetEmailView(1);
				}
			}
		});
		btnInbox.setBounds(31, 121, 89, 23);
		MailboxScreen.add(btnInbox);
		
		btnSent = new JButton("Sent");
		btnSent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Check that there is an account selected
				if(CurrentUser.getAccounts().isEmpty()) {
					JOptionPane.showMessageDialog(frame,"Must have an account to view emails");
				}
				else if(CurrentAccount == null) {
					JOptionPane.showMessageDialog(frame,"Must have an account selected to view emails");
				}
				else {
					SetEmailView(2);
				}
			}
		});
		btnSent.setBounds(31, 155, 89, 23);
		MailboxScreen.add(btnSent);
		
		btnTrash = new JButton("Trash");
		btnTrash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Check that there is an account selected
				if(CurrentUser.getAccounts().isEmpty()) {
					JOptionPane.showMessageDialog(frame,"Must have an account to view emails");
				}
				else if(CurrentAccount == null) {
					JOptionPane.showMessageDialog(frame,"Must have an account selected to view emails");
				}
				else {
					SetEmailView(3);
				}
			}
		});
		btnTrash.setBounds(31, 189, 89, 23);
		MailboxScreen.add(btnTrash);
		
		lblActiveAccount = new JLabel("...");
		lblActiveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveAccount.setBounds(10, 96, 140, 14);
		MailboxScreen.add(lblActiveAccount);
		
		JButton btnCompose = new JButton("Compose");
		btnCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Check that there is an account selected
				if(CurrentUser.getAccounts().isEmpty()) {
					JOptionPane.showMessageDialog(frame,"Must have an account to send emails");
				}
				else if(CurrentAccount == null) {
					JOptionPane.showMessageDialog(frame,"Must have an account selected to send emails");
				}
				else {
					// Create a new compose message dialog
					new ComposeMessage(CurrentAccount, CopyOfMasterSite);
				}
			}
		});
		
		btnCompose.setBounds(160, 46, 120, 23);
		MailboxScreen.add(btnCompose);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] index = list.getSelectedIndices();
				if (!noEmails && index.length > 0) {
					DeleteMessages(index);
				}
			}
		});
		btnDelete.setBounds(425, 46, 89, 23);
		MailboxScreen.add(btnDelete);
		
		JButton btnReply = new JButton("Reply");
		btnReply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Can't reply to things in the Trash mailbox
				int[] index = list.getSelectedIndices();
				if (!noEmails && !CurrentMailBox.getName().equals("Trash") && index.length > 0) {
					ReplyMessages(index);
				}
			}
			
		});
		
		btnReply.setBounds(305, 46, 89, 23);
		MailboxScreen.add(btnReply);
				
		accountMenu = new JPopupMenu();
		final JButton btnChooseAccount = new JButton("Select Acc");
		btnChooseAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accountMenu.show(btnChooseAccount, btnChooseAccount.getX(), btnChooseAccount.getY()-btnChooseAccount.getHeight());
			}
		});
		
		btnChooseAccount.setBounds(20, 46, 107, 23);
		MailboxScreen.add(btnChooseAccount);
		
		JLabel lblCurrentAccount = new JLabel("Current Account:");
		lblCurrentAccount.setBounds(20, 81, 107, 14);
		MailboxScreen.add(lblCurrentAccount);
		
		list = new JList<>();
		scrollList = new JScrollPane(list);
		String[] listarr = {"..."};
		noEmails = true;
		list.setListData(listarr);
		list.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {
				// Read messages when enter key is pressed
				if(e.getKeyChar() == '\n' || e.getKeyChar() == 'r') {
					int[] index = list.getSelectedIndices();
					if (!noEmails && index.length > 0) {
						ArrayList<Message> messages = CurrentMailBox.getMessages();
						for(int i = 0; i < index.length; i++) {
							new ReadMessage(messages.get(i));
						}
					}
				}
			}
			
		});
		list.setBounds(160, 80, 472, 251);
		scrollList.setBounds(160,80,472,251);
		MailboxScreen.add(scrollList);
		
		//JLabel lblOpenInstruc = new JLabel("<html>To open an email, select with mouse and press enter</html>");
		//lblOpenInstruc.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblOpenInstruc = new JLabel("To open an email, select with mouse and press enter");
		lblOpenInstruc.setBounds(160, 330, 350, 20);
		MailboxScreen.add(lblOpenInstruc);
	}
	
	/**
	 * Sets up the Mailbox view Layout when a user logs in
	 */
	public void StartMailbox() {
		//Populate the mailbox with things
		CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		cl.next(frame.getContentPane());
		UserText.setText("");
		PasswordText.setText("");
		lblwelcome.setText("Welcome, " + CurrentUser.getUserName());
		
		//populate accounts menu
		for (Account a : CurrentUser.getAccounts()) {
			final JMenuItem item = new JMenuItem(a.getAccountname());
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblActiveAccount.setText(item.getText());
					CurrentAccount = CurrentUser.getAccount(item.getText());
					String[] listarr = {"..."};
					list.setListData(listarr);
					btnInbox.setBorder(defaultBorder);
					btnSent.setBorder(defaultBorder);
					btnTrash.setBorder(defaultBorder);
				}
			});
			accountMenu.add(item);
		}
	}
	
	/**
	 * Logs out of a user and resets Mailbox view Layout
	 */
	public void LogOut() {
		//Populate the mailbox with things
		CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		cl.next(frame.getContentPane());
		//Unset current account and user
		CurrentUser = null;
		CurrentAccount = null;
		//Reset email view and acount label to nothing
		String[] listarr = {"..."};
		list.setListData(listarr);
		lblActiveAccount.setText("...");
		//remove everything from accounts menu
		accountMenu.removeAll();
		btnInbox.setBorder(defaultBorder);
		btnSent.setBorder(defaultBorder);
		btnTrash.setBorder(defaultBorder);
	}

	/**
	 * Deletes the selected messages
	 */
	public void DeleteMessages(int[] emails) {
		ArrayList<Message> messages = CurrentMailBox.getMessages();
		for(int i = emails.length-1; i >= 0; i--) {
			// Move deleted email to trash if not in trash mailbox
			if (!CurrentMailBox.getName().equals("Trash")) {
				CurrentAccount.getTrash().addMessageToMailBox(messages.get(emails[i]));
			}
			messages.remove(emails[i]);
		}
		// Refresh current mailbox
		if (CurrentMailBox.getName().equals("Inbox")) { SetEmailView(1); }
		else if (CurrentMailBox.getName().equals("Sent")) { SetEmailView(2); }
		else if (CurrentMailBox.getName().equals("Trash")) { SetEmailView(3); }
	}
	
	/**
	 * Replies to the selected messages
	 */
	public void ReplyMessages(int[] emails) {
		ArrayList<Message> messages = CurrentMailBox.getMessages();
		ComposeMessage m;
		for(int i = 0; i < emails.length; i++) {
			m = new ComposeMessage(CurrentAccount, CopyOfMasterSite);
			m.ReplyMessage(messages.get(emails[i]).getReceiversString());
		}
	}
	
	/**
	 * Sets the List view to the correct mailbox when selected
	 * @param choice : 1 for Inbox, 2 for sent, 3 for trash
	 */
	public void SetEmailView(final int choice) {
		btnInbox.setBorder(defaultBorder);
		btnSent.setBorder(defaultBorder);
		btnTrash.setBorder(defaultBorder);
		// Set border to show selected mailbox
		if (choice == 1) {
			CurrentMailBox = CurrentAccount.getInbox();
			btnInbox.setBorder(BorderFactory.createLoweredBevelBorder());
		}
		else if (choice == 2) {
			CurrentMailBox = CurrentAccount.getSent();
			btnSent.setBorder(BorderFactory.createLoweredBevelBorder());
		}
		else if (choice == 3) {
			CurrentMailBox = CurrentAccount.getTrash();
			btnTrash.setBorder(BorderFactory.createLoweredBevelBorder());
		}
		else {
			CurrentMailBox = null;
		}
		// Populate email list view
		ArrayList<Message> messages = CurrentMailBox.getMessages();
		String[] listarr;
		if (messages.size() == 0) {
			listarr = new String[1]; 
			listarr[0] = "No Emails";
			noEmails = true;
		}
		else {
			listarr = new String[messages.size()];
			for (int i = 0; i < messages.size(); i++) {
				if(choice == 2)//sent
				{
					listarr[i] = "To: " + messages.get(i).getSender().getAccountname() + "     |     Subject: " + messages.get(i).getSubject();
				}
				else if(choice == 3)// Recv
				{
					listarr[i] = "From: " + messages.get(i).getSender().getAccountname() + "     |     Subject: " + messages.get(i).getSubject();
				}
				else
				{
					listarr[i] = "From: "+ messages.get(i).getSender().getAccountname() + "     |     Subject: " + messages.get(i).getSubject();
				}
			}
			noEmails = false;
		}
		list.setListData(listarr);
	}
	
	/**
	 * Creates a Dialog for creating/deleteing accounts and users
	 * @param choice : 1 for add user, 2 for delete user, 3 for add account, 4 for delete account 
	 */
	public void ManageDialog(final int choice) {
		final JFrame dialog = new JFrame();
		dialog.getContentPane().setLayout(new GridLayout(4,2));
		
		final JTextField name = new JTextField();
		final JTextField login1 = new JTextField();
		final JTextField login2 = new JTextField();
		final CheckboxGroup site = new CheckboxGroup();
		String btnText;
		
		//Set the go button text to Create or delete
		if (choice == 1 || choice == 3) {btnText = "Create";}
		else {btnText = "Delete";}
		JButton gobutton = new JButton(btnText);
		gobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(dialog,"Must enter a username");
				}
				else if ((choice == 1 || choice == 2) && login1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(dialog,"Must enter a password");
				}
				
				// Choice 1 = add user
				else if (choice == 1) {
					if ( login1.getText().equals(login2.getText())) {
						//Call to add another user
						if(CopyOfMasterSite.userExists(name.getText()))
						{
							//User already exists
							JOptionPane.showMessageDialog(dialog,"User already exists");
						}
						else
						{
							CopyOfMasterSite.createUser(name.getText(), login1.getText());
						}
						dialog.dispose();
					}
					else {JOptionPane.showMessageDialog(dialog,"Passwords must match");}
				}
				
				// Choice 2 = delete user
				else if (choice == 2) {
					if(CopyOfMasterSite.userExists(name.getText()))
					{
						if(CopyOfMasterSite.validatePassword(name.getText(), login1.getText()))
						{
							int result = JOptionPane.showConfirmDialog(dialog, "Are you sure you wish to delete this account?", "Confirm Choice", 2);
							if (result == JOptionPane.YES_OPTION) {
								//Call to delete user
								CopyOfMasterSite.removeUser(name.getText());
								dialog.dispose();
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(dialog,"User does not exist");
					}
					
				}
				
				// Choice 3 = add account
				else if (choice == 3) {
					//Call to create account on the user that is associated with the open window
					String sitestr = "@uah.edu";
					if (site.getSelectedCheckbox().getLabel().equals("Local Site")) {
						sitestr = "@uah.edu";
					}
					else {
						sitestr = "@gmail.com";
					}
					
					if (CopyOfMasterSite.UniqueCheck(name.getText() + sitestr)) {
						CopyOfMasterSite.getUser(CurrentUser.getUserName()).addAccount(name.getText(), sitestr);
						
						//add new account to accounts menu
						final JMenuItem item = new JMenuItem(name.getText()+ sitestr);
						item.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lblActiveAccount.setText(item.getText());
								CurrentAccount = CurrentUser.getAccount(item.getText());
							}
						});
						accountMenu.add(item);
						dialog.dispose();
					}
					else {
						JOptionPane.showMessageDialog(dialog,"Account name is not unique");
					}
				}
				
				// Choice 4 = delete account
				else if (choice == 4) {
					int result = JOptionPane.showConfirmDialog(dialog, "Are you sure you wish to delete this account?", "Confirm Choice", 2);
					if (result == JOptionPane.YES_OPTION) {
						//Call to delete account
						CopyOfMasterSite.getUser(CurrentUser.getUserName()).removeAccount(name.getText());
						//remove from accounts menu
						for (int i = 0 ; i <  accountMenu.getComponentCount(); i++) {
						      JMenuItem item = (JMenuItem)accountMenu.getComponent(i);
						      if (item.getText().equals(name.getText())) {
						          accountMenu.remove(i);
						      }
						}
						//if deleted account is CurrentAccount, set Current Account to null and change list view
						if (CurrentAccount.getAccountname().equals(name.getText())) {
							CurrentAccount = null;
							lblActiveAccount.setText("...");
							String[] listarr = {"..."};
							list.setListData(listarr);
							btnInbox.setBorder(defaultBorder);
							btnSent.setBorder(defaultBorder);
							btnTrash.setBorder(defaultBorder);
						}
						
						dialog.dispose();
					}
				}
			}
		});
		
		// Add correct components to the dialog
		dialog.getContentPane().add(new JLabel("Username: "));
		dialog.getContentPane().add(name);
		if (choice == 1 || choice == 2) {
			dialog.getContentPane().add(new JLabel("Password: "));
			dialog.getContentPane().add(login1);
		}
		if (choice == 1) {
			dialog.getContentPane().add(new JLabel("Repeat Password: "));
			dialog.getContentPane().add(login2);
		}
		if (choice == 3) {
			 dialog.add(new Checkbox("Local Site", site, true));
			 dialog.add(new Checkbox("Remote Site", site, false));
		}
		dialog.getContentPane().add(gobutton);
		
		dialog.pack();
		dialog.setVisible(true);	
	}
}
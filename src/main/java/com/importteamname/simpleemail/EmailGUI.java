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
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;



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
        //initialize();
        initLoginScreen();
        initMailboxScreen();
		frame.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initLoginScreen() {

        frame = new JFrame();
		frame.setTitle("Simple Email by ImportTeamName");
		frame.setBounds(100, 100, 700, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));


        /* 
		 * ---Stuff on the Login Screen--- 
		 */        
        JPanel LoginScreen = new javax.swing.JPanel();
        final JTextField UserText = new javax.swing.JTextField();
        JLabel lblUsername = new javax.swing.JLabel();
        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JLabel lblpassword = new javax.swing.JLabel();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        JButton btnadduser = new javax.swing.JButton();
        JButton btndeleteuser = new javax.swing.JButton();
        JButton btnLogin = new javax.swing.JButton();
        final JPasswordField PasswordText = new javax.swing.JPasswordField();

        LoginScreen.setBackground(new java.awt.Color(50, 56, 72));

        UserText.setBackground(new java.awt.Color(50, 56, 72));
        UserText.setForeground(new java.awt.Color(255, 255, 255));
        //UserText.setText("UserText");
        UserText.setBorder(null);

        lblUsername.setForeground(new java.awt.Color(236, 125, 244));
        lblUsername.setText("Account");

        lblpassword.setForeground(new java.awt.Color(236, 125, 244));
        lblpassword.setText("Password");

        btnadduser.setBackground(new java.awt.Color(226,123,242));
        btnadduser.setForeground(new java.awt.Color(226, 123, 242));
        btnadduser.setText("Add User");
        btnadduser.setActionCommand("Add User  ");
        btnadduser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 125, 244)));
        btnadduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(1);
			}
		});

        btndeleteuser.setBackground(new java.awt.Color(50, 56, 72));
        btndeleteuser.setForeground(new java.awt.Color(226, 123, 242));
        btndeleteuser.setText("Delete User");
        btndeleteuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));
        btndeleteuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(2);
			}
		});

        btnLogin.setBackground(Color.decode("#E27BF2"));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setContentAreaFilled(true);
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
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

        PasswordText.setBackground(new java.awt.Color(50, 56, 72));
        PasswordText.setForeground(new java.awt.Color(255, 255, 255));
        //PasswordText.setText("PasswordText");
        PasswordText.setBorder(null);

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnadduser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndeleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginScreenLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(lblpassword)
                            .addComponent(jSeparator1)
                            .addComponent(lblUsername)
                            .addComponent(UserText)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PasswordText, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadduser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        frame.getContentPane().add(LoginScreen);

        /* 
		 * ---Stuff on the MailBox Screen--- 
		 */


    }

    private void initMailboxScreen() {

        JSeparator jSeparator3 = new javax.swing.JSeparator();
        JPanel MailboxScreen = new javax.swing.JPanel();
        JButton btnadduser = new javax.swing.JButton();
        JButton btndeleteuser = new javax.swing.JButton();
        JButton btnlogout = new javax.swing.JButton();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JButton btnInbox = new javax.swing.JButton();
        JButton btnSent = new javax.swing.JButton();
        JButton btnTrash = new javax.swing.JButton();
        JLabel jLabel3 = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JList jList1 = new javax.swing.JList<>();
        JButton btnChooseAccount = new javax.swing.JButton();
        JButton btnReply = new javax.swing.JButton();
        JButton btnDelete = new javax.swing.JButton();
        JButton btnCompose = new javax.swing.JButton();
        JLabel jLabel4 = new javax.swing.JLabel();

        MailboxScreen.setBackground(new java.awt.Color(50, 56, 72));

        btnadduser.setBackground(new java.awt.Color(50, 56, 72));
        btnadduser.setForeground(new java.awt.Color(255, 255, 255));
        btnadduser.setText("Add Account");
        btnadduser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));

        btndeleteuser.setBackground(new java.awt.Color(50, 56, 72));
        btndeleteuser.setForeground(new java.awt.Color(255, 255, 255));
        btndeleteuser.setText("Delete User");
        btndeleteuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));

        btnlogout.setBackground(new java.awt.Color(50, 56, 72));
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setText("Logout");
        btnlogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOut();
			}
		});

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(244, 127, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome, User");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Current Account:");

        btnInbox.setBackground(new java.awt.Color(160, 112, 246));
        btnInbox.setForeground(new java.awt.Color(255, 255, 255));
        btnInbox.setText("Inbox");
        btnInbox.setActionCommand("");
        btnInbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnInbox.setBorderPainted(false);
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

        btnSent.setBackground(new java.awt.Color(98, 117, 246));
        btnSent.setForeground(new java.awt.Color(255, 255, 255));
        btnSent.setText("Sent");
        btnSent.setActionCommand("");
        btnSent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnSent.setBorderPainted(false);
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

        btnTrash.setBackground(new java.awt.Color(107, 194, 250));
        btnTrash.setForeground(new java.awt.Color(255, 255, 255));
        btnTrash.setText("Trash");
        btnTrash.setActionCommand("");
        btnTrash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnTrash.setBorderPainted(false);
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

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html>To open an email, select with mouse and press enter</html>");

        jList1.setBackground(new java.awt.Color(50, 56, 72));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 127, 245)));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        btnChooseAccount.setBackground(new java.awt.Color(50, 56, 72));
        btnChooseAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseAccount.setText("Accounts Menu");
        btnChooseAccount.setActionCommand("");
        btnChooseAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));

        btnReply.setBackground(new java.awt.Color(50, 56, 72));
        btnReply.setForeground(new java.awt.Color(255, 255, 255));
        btnReply.setText("Reply");
        btnReply.setActionCommand("");
        btnReply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));
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

        btnDelete.setBackground(new java.awt.Color(50, 56, 72));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setActionCommand("");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));
        btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] index = list.getSelectedIndices();
				if (!noEmails && index.length > 0) {
					DeleteMessages(index);
				}
			}
			
		});

        btnCompose.setBackground(new java.awt.Color(50, 56, 72));
        btnCompose.setForeground(new java.awt.Color(255, 255, 255));
        btnCompose.setText("Compose");
        btnCompose.setActionCommand("");
        btnCompose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 123, 242)));
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
        

        jLabel4.setBackground(new java.awt.Color(35, 35, 35));
        jLabel4.setForeground(new java.awt.Color(244, 127, 245));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout MailboxScreenLayout = new javax.swing.GroupLayout(MailboxScreen);
        MailboxScreen.setLayout(MailboxScreenLayout);
        MailboxScreenLayout.setHorizontalGroup(
            MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MailboxScreenLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(btnTrash, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(btnSent, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(btnInbox, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(btnChooseAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MailboxScreenLayout.createSequentialGroup()
                        .addComponent(btnadduser, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndeleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(MailboxScreenLayout.createSequentialGroup()
                            .addComponent(btnCompose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        MailboxScreenLayout.setVerticalGroup(
            MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MailboxScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadduser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeleteuser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChooseAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReply, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MailboxScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MailboxScreenLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(btnInbox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnSent, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnTrash, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        frame.getContentPane().add(MailboxScreen, "name_443823897215886");

    }// </editor-fold>


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
		btnlogout.setBounds(305, 20, 89, 23);
		MailboxScreen.add(btnlogout);
		
		lblwelcome = new JLabel();
		lblwelcome.setBounds(454, 24, 178, 14);
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
		
		JButton btnCompose = new JButton("Compose New Email");
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
		btnCompose.setBounds(160, 46, 188, 23);
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
		btnDelete.setBounds(454, 46, 89, 23);
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
		btnReply.setBounds(355, 46, 89, 23);
		MailboxScreen.add(btnReply);
				
		accountMenu = new JPopupMenu();
		final JButton btnChooseAccount = new JButton("Accounts Menu");
		btnChooseAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				accountMenu.show(btnChooseAccount, btnChooseAccount.getX(), btnChooseAccount.getY()-btnChooseAccount.getHeight());
			}
		});
		btnChooseAccount.setBounds(10, 46, 140, 23);
		MailboxScreen.add(btnChooseAccount);
		
		JLabel lblCurrentAccount = new JLabel("Current Account:");
		lblCurrentAccount.setBounds(20, 81, 107, 14);
		MailboxScreen.add(lblCurrentAccount);
		
		list = new JList<>();
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
		MailboxScreen.add(list);
		
		JLabel lblOpenInstruc = new JLabel("<html>To open an email, select with mouse and press enter</html>");
		lblOpenInstruc.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenInstruc.setBounds(31, 223, 89, 108);
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
				listarr[i] = messages.get(i).getSender().getAccountname() + ": " + messages.get(i).getSubject();
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
		final CheckboxGroup site = new CheckboxGroup();;
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
					String sitestr;
					if (site.getSelectedCheckbox().getLabel().equals("Local Site")) {
						sitestr = "@local";
					}
					else {
						sitestr = "@remote";
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
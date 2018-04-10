/**
 * Class for the main GUI for the SimpleEmail system
 * Created using the WindowBuilder extension
 * @author Alex Porter
 */

//Things specifically imported by us
//---

//Things imported by WindowBuilder
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.ActionEvent;

import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.util.Vector;

public class EmailGUI {

	private JFrame		frame;
	private JTextField	LoginText;
	private JTextField	UserText;
	private RemoteSite	CopyOfMasterSite;
	private User		CurrentUser;
	/**
	 * Create the application.
	 */
	public EmailGUI(RemoteSite remSite) {
		System.out.println("Creating an EmailGUI");
		CopyOfMasterSite = remSite;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 638, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel LoginScreen = new JPanel();
		frame.getContentPane().add(LoginScreen, "name_443823858163679");
		LoginScreen.setLayout(null);
		
		//Username
		LoginText = new JTextField();
		LoginText.setBounds(293, 102, 86, 20);
		LoginScreen.add(LoginText);
		LoginText.setColumns(10);
		
		//password
		UserText = new JTextField();
		UserText.setBounds(293, 133, 86, 20);
		LoginScreen.add(UserText);
		UserText.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(221, 105, 62, 14);
		LoginScreen.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(221, 136, 62, 14);
		LoginScreen.add(lblpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//check for valid login
				if(CopyOfMasterSite.userExists(LoginText.getText()))
				{
					if(CopyOfMasterSite.validatePassword(LoginText.getText(), UserText.getText()))
					{
						CurrentUser = CopyOfMasterSite.getUser(LoginText.getText());
						StartMailbox(e);
					}
				}
				else
				{
					JFrame dialog = new JFrame();
					JOptionPane.showMessageDialog(dialog,"User does not exist");
					dialog.getContentPane().setLayout(new GridLayout(4,2));
				}
				
			}
		});
		btnLogin.setBounds(290, 164, 89, 23);
		LoginScreen.add(btnLogin);
		
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
		
		JPanel MailboxScreen = new JPanel();
		frame.getContentPane().add(MailboxScreen, "name_443823897215886");
		
		JButton btnaddaccount = new JButton("Add Account");
		btnaddaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(3);
			}
		});
		btnaddaccount.setBounds(10, 20, 107, 23);
		
		JButton btndeleteaccount = new JButton("Delete Account");
		btndeleteaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(4);
			}
		});
		btndeleteaccount.setBounds(122, 20, 120, 23);
		
		JLabel lblwelcome = new JLabel("Welcome, User");
		lblwelcome.setBounds(434, 24, 178, 14);
		MailboxScreen.setLayout(null);
		MailboxScreen.add(btnaddaccount);
		MailboxScreen.add(btndeleteaccount);
		MailboxScreen.add(lblwelcome);
		
		JMenu mnActiveAccount = new JMenu("Active Account");
		mnActiveAccount.setBounds(10, 66, 107, 22);
		MailboxScreen.add(mnActiveAccount);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnActiveAccount.add(mntmNewMenuItem);
		
		JButton btnInbox = new JButton("Inbox");
		btnInbox.setBounds(31, 121, 89, 23);
		MailboxScreen.add(btnInbox);
		
		JButton btnSent = new JButton("Sent");
		btnSent.setBounds(31, 155, 89, 23);
		MailboxScreen.add(btnSent);
		
		JButton btnTrash = new JButton("Trash");
		btnTrash.setBounds(31, 189, 89, 23);
		MailboxScreen.add(btnTrash);
		
		JLabel lblActiveAccount = new JLabel("...");
		lblActiveAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblActiveAccount.setBounds(31, 96, 86, 14);
		MailboxScreen.add(lblActiveAccount);
		
		Vector<JLabel> emails = new Vector<JLabel>();
		
		JButton btnCompose = new JButton("Compose New Email");
		btnCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComposeMessage newMessage = new ComposeMessage();
			}
		});
		btnCompose.setBounds(138, 46, 127, 23);
		MailboxScreen.add(btnCompose);
		DefaultListModel<String> model = new DefaultListModel<String>();
		//Sample Elements to show idea
		model.addElement("This is a list");
		model.addElement("of Strings that will");
		model.addElement("be a list of emails");
		
		JList<String> list = new JList<>();
		list.setBounds(140, 80, 400, 200);
		MailboxScreen.add(list);
		list.setModel(model);
		
	}
	
	public void StartMailbox(MouseEvent e) {
		//Populate the mailbox with things
		CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		cl.next(frame.getContentPane());
	}
	
	/*
	 * @param choice : 1 for add user, 2 for delete user, 3 for add account, 4 for delete account 
	 */
	void ManageDialog(int choice) {
		JFrame dialog = new JFrame();
		dialog.getContentPane().setLayout(new GridLayout(4,2));
		
		JTextField name = new JTextField();
		JTextField login1 = new JTextField();
		JTextField login2 = new JTextField();
		String btnText;
		if (choice == 1 || choice == 3) {btnText = "Create";}
		else {btnText = "Delete";}
		JButton gobutton = new JButton(btnText);
		gobutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(dialog,"Must enter a username");
				}
				else if ((choice == 1 | choice == 2) & login1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(dialog,"Must enter a password");
				}
				
				// Choice 1 = add user
				else if (choice == 1) {
					if ( login1.getText().equals(login2.getText())) {
						//Call to add another user
						if(CopyOfMasterSite.userExists(name.getText()))
						{
							//Username already exists
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
						JFrame dialog = new JFrame();
						JOptionPane.showMessageDialog(dialog,"User does not exist");
						dialog.getContentPane().setLayout(new GridLayout(4,2));
					}
					
				}
				// Choice 3 = add account
				else if (choice == 3) {
					//Call to create account on the user that is associated
					// with the open window
					CopyOfMasterSite.getUser(CurrentUser.getUserName()).addAccount(name.getText(), "uah.edu", login1.getText());
					dialog.dispose();
				}

				// Choice 4 = delete account
				else if (choice == 4) {
					int result = JOptionPane.showConfirmDialog(dialog, "Are you sure you wish to delete this account?", "Confirm Choice", 2);
					if (result == JOptionPane.YES_OPTION) {
						//Call to delete account
						CopyOfMasterSite.getUser(CurrentUser.getUserName()).removeAccount(name.getText());
						dialog.dispose();
					}
				}
			}
		});
		
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
		dialog.getContentPane().add(gobutton);
		
		dialog.pack();
		dialog.setVisible(true);	
	}
	
}

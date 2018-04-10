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
import javax.swing.JPopupMenu;
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

	private JFrame frame;
	private JTextField LoginText;
	private JTextField UserText;

	/**
	 * Create the application.
	 */
	public EmailGUI() {
		System.out.println("Creating an EmailGUI");
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
		
		LoginText = new JTextField();
		LoginText.setBounds(293, 102, 86, 20);
		LoginScreen.add(LoginText);
		LoginText.setColumns(10);
		
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
				StartMailbox(e);
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
		btnaddaccount.setBounds(21, 20, 107, 23);
		
		JButton btndeleteaccount = new JButton("Delete Account");
		btndeleteaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageDialog(4);
			}
		});
		btndeleteaccount.setBounds(138, 20, 120, 23);
		
		JLabel lblwelcome = new JLabel("Welcome, User"); //access current user
		lblwelcome.setBounds(434, 24, 178, 14);
		MailboxScreen.setLayout(null);
		MailboxScreen.add(btnaddaccount);
		MailboxScreen.add(btndeleteaccount);
		MailboxScreen.add(lblwelcome);
		
		JMenu mnActiveAccount = new JMenu("Active Account");
		/*mnActiveAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.)
			}
		});*/
		mnActiveAccount.setBounds(31, 46, 126, 16);
		MailboxScreen.add(mnActiveAccount);
		
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
		btnCompose.setBounds(138, 46, 188, 23);
		MailboxScreen.add(btnCompose);
		DefaultListModel<String> model = new DefaultListModel<String>();
		//Sample Elements to show idea
		model.addElement("This is a list");
		model.addElement("of Strings that will");
		model.addElement("be a list of emails");
		
		JList<String> list = new JList<>();
		list.setBounds(140, 80, 472, 251);
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
				else if ((choice == 1 || choice == 2) && login1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(dialog,"Must enter a password");
				}
				else if (choice == 1) {
					if ( login1.getText().equals(login2.getText())) {
						//Call to add another user
						dialog.dispose();
					}
					else {JOptionPane.showMessageDialog(dialog,"Passwords must match");}
				}
				else if (choice == 2) {
					int result = JOptionPane.showConfirmDialog(dialog, "Are you sure you wish to delete this account?", "Confirm Choice", 2);
					if (result == JOptionPane.YES_OPTION) {
						//Call to delete user
						dialog.dispose();
					}
					//Call to create account
					dialog.dispose();
				}
				else if (choice == 3) {
					//Call to create account
					dialog.dispose();
				}
				else if (choice == 4) {
					int result = JOptionPane.showConfirmDialog(dialog, "Are you sure you wish to delete this account?", "Confirm Choice", 2);
					if (result == JOptionPane.YES_OPTION) {
						//Call to delete account
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

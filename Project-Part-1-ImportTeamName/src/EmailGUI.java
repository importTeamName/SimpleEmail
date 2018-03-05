import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.Choice;
import javax.swing.AbstractListModel;
import java.awt.List;
import javax.swing.JScrollBar;

public class EmailGUI {

	private JFrame frame;
	private JTextField LoginText;
	private JTextField UserText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailGUI window = new EmailGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmailGUI() {
		initialize();
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
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(221, 136, 62, 14);
		LoginScreen.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//check for valid login???
				StartMailbox(e);
			}
		});
		btnLogin.setBounds(290, 164, 89, 23);
		LoginScreen.add(btnLogin);
		
		JLabel lblEnterLoginInformation = new JLabel("Enter Login Information");
		lblEnterLoginInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterLoginInformation.setBounds(221, 80, 158, 14);
		LoginScreen.add(lblEnterLoginInformation);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 11, 89, 23);
		LoginScreen.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete User");
		btnNewButton_1.setBounds(109, 11, 89, 23);
		LoginScreen.add(btnNewButton_1);
		
		JPanel MailboxScreen = new JPanel();
		frame.getContentPane().add(MailboxScreen, "name_443823897215886");
		
		JButton btnNewButton_2 = new JButton("Add Account");
		btnNewButton_2.setBounds(10, 20, 93, 23);
		
		JButton btnNewButton_3 = new JButton("Delete Account");
		btnNewButton_3.setBounds(109, 20, 105, 23);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome, User");
		lblNewLabel_1.setBounds(434, 24, 178, 14);
		MailboxScreen.setLayout(null);
		MailboxScreen.add(btnNewButton_2);
		MailboxScreen.add(btnNewButton_3);
		MailboxScreen.add(lblNewLabel_1);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(135, 96, 452, 235);
		MailboxScreen.add(panel);
		
		Vector<JLabel> emails = new Vector<JLabel>();
		JLabel mail1 = new JLabel("Email 1");
		JLabel mail2 = new JLabel("Email 2");
		mail1.setHorizontalAlignment(SwingConstants.LEFT);
		emails.add(mail1);
		panel.add(mail1);
		emails.add(mail2);
		panel.add(mail2);
		
		JButton btnComposeNewEmail = new JButton("Compose New Email");
		btnComposeNewEmail.setBounds(138, 46, 127, 23);
		MailboxScreen.add(btnComposeNewEmail);
		
	}
	
	public void StartMailbox(MouseEvent e) {
		CardLayout cl = (CardLayout)(frame.getContentPane().getLayout());
		cl.next(frame.getContentPane());
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

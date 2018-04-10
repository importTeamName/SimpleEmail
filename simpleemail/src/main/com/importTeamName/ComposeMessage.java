import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.UIManager;

public class ComposeMessage {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComposeMessage window = new ComposeMessage();
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
    public ComposeMessage() {
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
        
        textField = new JTextField();
        textField.setBounds(89, 6, 484, 26);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(89, 44, 484, 26);
        panel.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(89, 82, 484, 26);
        panel.add(textField_2);
        
        JTextPane textPane = new JTextPane();
        textPane.setBounds(0, 158, 600, 280);
        frame.getContentPane().add(textPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(UIManager.getColor("Button.background"));
        panel_1.setBounds(0, 0, 600, 39);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnReply = new JButton("Send");
        btnReply.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnReply.setBounds(6, 6, 117, 29);
        panel_1.add(btnReply);
        
        Panel panel_2 = new Panel();
        panel_2.setBackground(UIManager.getColor("Button.background"));
        panel_2.setBounds(0, 438, 600, 19);
        frame.getContentPane().add(panel_2);
    }
    
}

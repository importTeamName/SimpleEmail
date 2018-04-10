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

public class ReadMessage {

	private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReadMessage window = new ReadMessage();
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
    public ReadMessage() {
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
        
        JLabel lblSenderAddressHere = new JLabel("sender address here");
        lblSenderAddressHere.setBounds(89, 11, 481, 16);
        panel.add(lblSenderAddressHere);
        
        JLabel lblNewLabel = new JLabel("recipitant address here");
        lblNewLabel.setBounds(89, 49, 481, 16);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("subject here");
        lblNewLabel_1.setBounds(89, 87, 481, 16);
        panel.add(lblNewLabel_1);
        
        JTextPane textPane = new JTextPane();
        textPane.setBounds(0, 158, 600, 280);
        frame.getContentPane().add(textPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(UIManager.getColor("Button.background"));
        panel_1.setBounds(0, 0, 600, 39);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnSend = new JButton("Forward");
        btnSend.setBounds(135, 6, 117, 29);
        panel_1.add(btnSend);
        
        JButton btnReply = new JButton("Reply");
        btnReply.setBounds(6, 6, 117, 29);
        panel_1.add(btnReply);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(477, 6, 117, 29);
        panel_1.add(btnDelete);
        
        Panel panel_2 = new Panel();
        panel_2.setBackground(UIManager.getColor("Button.background"));
        panel_2.setBounds(0, 438, 600, 19);
        frame.getContentPane().add(panel_2);
    }
}

/**
 * Program that simulates an email system
 * @author ImportTeamName
 * 
 */
import java.awt.EventQueue;
/*
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
*/
import java.util.ArrayList;

public class SimpleEmail {
	
	//private JFrame frame;
	
	public static void main(String[] args) {
		
		System.out.print("Running SimpleEmail\n");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailGUI window = new EmailGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Don't need this now that EmailGUI is running the GUI creation
	/*
	public SimpleEmail()
	{
		initialize();
	}
	
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("hellooooooooooooooooooooo");
		
		ArrayList<JLabel> myJLabels = new ArrayList<JLabel>();
		myJLabels.add(lblNewLabel);
		
		frame.getContentPane().add(myJLabels.get(0), BorderLayout.EAST);
	}*/

}

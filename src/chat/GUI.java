package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextField textField;
	JTextArea textArea;
	
	
	public GUI() { 
        super("Super tchat");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(TextPrep(), BorderLayout.SOUTH);
        
        
        textArea = new JTextArea("Push me !");
        textArea.setEditable(false);
        contentPane.add(textArea, BorderLayout.CENTER);
    }
	
	private JPanel TextPrep() {
		JPanel textPrep = new JPanel (new BorderLayout());
		
		textField = new JTextField();
		textPrep.add(textField, BorderLayout.CENTER);
		
		JButton btnPushMe = new JButton("Push me !");
		btnPushMe.setPreferredSize(new Dimension(100,50));
		textPrep.add(btnPushMe, BorderLayout.EAST);
		
		btnPushMe.addActionListener((event) -> this.send());
		return textPrep;
		
	}
	
	private void send() {
		String text = String.format("%s\n", textField.getText());
		textArea.append(text);
	}
    
    public static void main(String[] args) throws Exception{
    	
    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
    	
    	GUI window = new GUI();
    	window.setVisible(true);
    }

    
}
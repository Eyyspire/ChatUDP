package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUI() { 
        super("Super tchat");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JButton btnPushMe = new JButton("Push me !");
        btnPushMe.setPreferredSize(new Dimension(200,100));
        contentPane.add(btnPushMe, BorderLayout.EAST);
        
        
        JTextField text = new JTextField("Push me !");
        text.setPreferredSize(new Dimension(100,100));
        contentPane.add(text, BorderLayout.SOUTH);
        
        
        JTextArea textArea = new JTextArea("Push me !");
        textArea.setEditable(false);
        contentPane.add(textArea, BorderLayout.CENTER);
        
        
    }
    
    public static void main(String[] args) throws Exception{
    	
    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
    	
    	GUI window = new GUI();
    	window.setVisible(true);
    }

    
}
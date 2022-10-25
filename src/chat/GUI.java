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
	
	ProtocolUDP protocolUDP;
	
	public GUI(ProtocolUDP protocolUDP) { 
        super("Super tchat");
        
        this.protocolUDP = protocolUDP;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        contentPane.add(TextPrep(), BorderLayout.SOUTH);
        
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        contentPane.add(textArea, BorderLayout.CENTER);
    }
	
	private JPanel TextPrep() {
		JPanel textPrep = new JPanel (new BorderLayout());
		
		textField = new JTextField();
		textPrep.add(textField, BorderLayout.CENTER);
		
		JButton btnPushMe = new JButton("Send");
		btnPushMe.setPreferredSize(new Dimension(100,50));
		textPrep.add(btnPushMe, BorderLayout.EAST);
		
		btnPushMe.addActionListener((event) -> this.send());
		return textPrep;
		
	}
	
private void send() {
		String text;
		if(!(text = textField.getText()).equals("")) {
			textField.setText("");
			protocolUDP.send(text);
		}
		
	}

	public JTextArea getTextArea() {
		return this.textArea;
	}
	
	public JTextField getTextField() {
		return this.textField;
	}

    
}
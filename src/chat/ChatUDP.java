package chat;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ChatUDP{
    public static void main(String args[]) throws UnsupportedLookAndFeelException{
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        ProtocolUDP protocol = new ProtocolUDP(address, port){
            public void run(){
                try{
                    this.joinGroup(address);
                    System.out.println("fuhifuz");
                } catch(IOException e){
                    System.out.println(e.getMessage());
                }
                while(true){
                    this.read();
                }
            }
        };
        
        GUI window = new GUI(protocol);
        protocol.setGui(window);
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
    	window.setVisible(true);
    	
    	protocol.start();
    }
}
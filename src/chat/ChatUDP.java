package chat;

import java.io.*;

public class ChatUDP{
    public static void main(String args[]){
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        ProtocolUDP sender = new ProtocolUDP(address, port){
            public void run(){
                try{
                    this.joinGroup(address);
                } catch(IOException e){
                    e.getMessage();
                }
                while(true){
                    this.read();
                }
            }
        };
        ProtocolUDP receiver = new ProtocolUDP(address, port){
            public void run(){
                while(true){
                    this.send();
                }
            }
        };
        sender.start();
        receiver.start();
    }
}
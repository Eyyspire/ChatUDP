package chat;

import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class ProtocolUDP extends Thread{

    private MulticastSocket socket;
    private DatagramPacket packet;
    private String address;
    private Scanner scanner;
    
    private GUI gui;

    /**
     * Creates an instance of ProtocolUDP
     * @param address the address to bind to the socket
     * @param port The port to bind to the socket
     */
    public ProtocolUDP(String address, int port){
        try{
            this.socket = new MulticastSocket(port);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        this.packet = new DatagramPacket(new byte[512], 512);
        this.scanner = new Scanner(System.in);
        this.address = address;
    }

    /**
     * Sends a message
     */
    public void send(String message){
        try{
            InetAddress group = getGroup(address);
            byte[] buffer = message.getBytes();
            DatagramPacket p = new DatagramPacket(buffer, buffer.length, group, socket.getLocalPort());
            try{
                socket.send(p);
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
        } catch(UnknownHostException e){
            System.out.println("Error");
        }
        
    }

    /**
     * Joins a multicast group
     * @param address the adress to join
     * @throws IOException
     * @throws UnknownHostException
     */
    @SuppressWarnings("deprecation")
	public void joinGroup(String address) throws IOException, UnknownHostException{
        socket.joinGroup(getGroup(address));
    }

    /**
     * Leaves a multicast group
     * @param address the adress to leave
     * @throws IOException
     * @throws SocketException
     */
    public void leaveGroup(String address)throws IOException, SocketException{
        socket.leaveGroup(getGroup(address));
    }

    /**
     * Gets the multicast group of the given adress
     * @param address the given address
     * @throws UnknownHostException
     */
    private InetAddress getGroup(String address) throws UnknownHostException{
        return InetAddress.getByName(address);
    }

    /**
     * Waits for a message, and reads it
     */
    public void read(){
        try{
            this.socket.receive(this.packet);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        this.getMessage();
        this.packet = new DatagramPacket(new byte[512], 512);
    }

    /**
     * Displays the message received
     */
    public void getMessage(){
    	gui.getTextArea().append(String.format("%s : %s\n",this.packet.getAddress(), new String(this.packet.getData())));
        System.out.printf("%s : %s\n",this.packet.getAddress(), new String(this.packet.getData()));
    }

    /**
     * Closes the socket
     */
    public void close(){
        this.socket.close();
    }
    
    public void setGui(GUI gui) {
    	this.gui = gui;
    }
}
package unicast;

import java.net.*;
import java.io.*;
import java.lang.*;

public class ProtocolUDP {

    private DatagramSocket socket;
    private DatagramPacket packet;

    /**
     * Creates an instance of ProtocolUDP
     * @param port The port to bind to the socket
     */
    public ProtocolUDP(int port){
        try{
            this.socket = new DatagramSocket(port);
        } catch(SocketException e){
            System.out.println(e.getMessage());
        }
        this.packet = new DatagramPacket(new byte[512], 512);
    }

    public ProtocolUDP(){
        try{
            this.socket = new DatagramSocket();
        } catch(SocketException e){
            System.out.println(e.getMessage());
        }

    } 

    /**
     * Sends a message
     * @param message the message to send
     * @param address the address on which the message is sent
     */
    public void send(String message, String address, int port){

        try{
            byte[] buffer = message.getBytes();
            InetAddress dst = InetAddress.getByName(address);
            DatagramPacket p = new DatagramPacket(buffer, buffer.length, dst, port);
            socket.send(p);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
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
        this.packetDetails();
        this.getMessage();
    }

    /**
     * Details the received packet
     */
    public void packetDetails(){
        System.out.println("Paquet reçu de :" + this.packet.getAddress()
                            + "\nport :" + this.packet.getPort()
                            + "\ntaille :" + this.packet.getLength());
    }

    /**
     * Displays the message received
     */
    public void getMessage(){
        System.out.println("message :" + new String(this.packet.getData()));
    }

    /**
     * Closes the socket
     */
    public void close(){
        this.socket.close();
    }
}
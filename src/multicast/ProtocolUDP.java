package multicast;

import java.net.*;
import java.io.*;
import java.lang.*;

public class ProtocolUDP {

    private MulticastSocket socket;
    private DatagramPacket packet;

    /**
     * Creates an instance of ProtocolUDP
     * @param port The port to bind to the socket
     */
    public ProtocolUDP(int port){
        try{
            this.socket = new MulticastSocket(port);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        this.packet = new DatagramPacket(new byte[512], 512);
    }

    /**
     * Sends a message
     * @param message the message to send
     * @param address the address on which the message is sent
     */
    public void send(String message, String address){
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
package unicast;

public class ReceiveUDP{
    public static void main(String[] args){
        int port = Integer.parseInt(args[0]);
        ProtocolUDP receiver = new ProtocolUDP(port);
        System.out.println("Waiting for a message...");
        receiver.read();
        receiver.close();
    }
}
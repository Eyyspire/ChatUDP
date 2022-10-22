package multicast;

public class SendUDP{
    
    public static void main(String[] args){

        String address = args[0];
        int port = Integer.parseInt(args[1]);
        String message = args[2];

        ProtocolUDP s = new ProtocolUDP(port);

        s.send(message, address);
        System.out.println("Sent.");
        s.close();
    }

}
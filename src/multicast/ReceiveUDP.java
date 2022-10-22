package multicast;

public class ReceiveUDP{
    public static void main(String[] args){
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        ProtocolUDP receiver = new ProtocolUDP(port);
        try{
            receiver.joinGroup(address);
            while(true){
                System.out.println("Waiting for a message...");
                receiver.read();
            }
            // receiver.leaveGroup(address);
            // receiver.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
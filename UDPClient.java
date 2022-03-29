import java.io.*;
import java.net.*;

public class UDPClient{

    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(3000);
        byte[] b = new byte[1000];
        DatagramPacket reply = new DatagramPacket(b,b.length);

        while(true){
            socket.receive(reply);
            String str = new String(reply.getData(),0,reply.getLength());
            System.out.println( "client received: " + str );
        }

    }
}
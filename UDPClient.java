import java.io.*;
import java.net.*;

public class UDPClient{

    public static void main(String[] args){
        DatagramSocket socket = null;
        String str;
        try{
            socket = new DatagramSocket(3000);
            byte[] b = new byte[1000];

            while(true){
                DatagramPacket reply = new DatagramPacket(b,b.length);
                socket.receive(reply);
                str = new String(reply.getData(),0,reply.getLength());
                System.out.println( "client received: " + str );
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
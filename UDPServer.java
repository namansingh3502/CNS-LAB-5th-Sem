import java.io.*;
import java.net.*;

public class UDPServer{
	public static void main(String[] args){

		DatagramSocket socket = null;
 		int ch = 1;
		
		try{
			socket = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			while(ch==1){

				System.out.println("Enter the message: ");
				String msg = input.readLine();

				DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),msg.length(),ip,3000);
				socket.send(datagramPacket);

				System.out.println("Do you wish to continue: 0 for no 1 for yes");
				ch = Integer.parseInt(input.readLine());
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
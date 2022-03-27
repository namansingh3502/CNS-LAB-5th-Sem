import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serversocket = new ServerSocket(123);
        Socket socket = serversocket.accept();

        System.out.println("Connection established successfully");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String filename = input.readLine();
        File file = new File(filename);

        if (file.exists()) {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                output.writeBytes(str + "\n");
            }

        } else output.writeBytes("No" + "\n");
    }
}

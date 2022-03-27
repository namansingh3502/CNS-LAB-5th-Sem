import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 123);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the file name: ");
        String filename = input.readLine();

        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeBytes(filename + "\n");

        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;

        str = input.readLine();

        if (str.equals("Yes")) {
            while ((str = input.readLine()) != null)
                System.out.println(str);
        } else {
            System.out.println("File not found");
        }
    }
}

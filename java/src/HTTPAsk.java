import java.net.*;
import java.io.*;

public class HTTPAsk {
    public static void main( String[] args) throws IOException {
        // Your code here
        int port = Integer.parseInt(args[0]);

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try {

                Socket connectionSocket = serverSocket.accept();

                BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                DataOutputStream output = new DataOutputStream(connectionSocket.getOutputStream());



                String url = input.readLine();
                String[] params = url.split("? &/");

                System.out.println(params);

                StringBuilder sb = new StringBuilder("HTTP/1.1 200 OK\r\n\r\n");
                //output.writeBytes(sb.toString());

                System.out.println(connectionSocket.isConnected());

                System.out.println("klar");
                System.out.println(sb.toString());

                connectionSocket.close();
                output.close();
                input.close();
            } catch (Exception ex) {
                System.out.println("fail");
            }
        }
    }

}

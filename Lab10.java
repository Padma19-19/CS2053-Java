import java.io.*;
import java.net.*;

public class Lab10 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java Lab10 server OR java Lab10 client");
            return;
        }
        
        if (args[0].equals("server")) {
            runServer();
        } else if (args[0].equals("client")) {
            runClient();
        }
    }
    
    static void runServer() throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");
        
        Socket socket = server.accept();
        System.out.println("Client connected");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        String clientMsg, serverMsg;
        
        while (true) {
            clientMsg = in.readLine();
            if (clientMsg == null || clientMsg.equals("exit")) break;
            System.out.println("Client: " + clientMsg);
            
            System.out.print("Server: ");
            serverMsg = keyboard.readLine();
            out.println(serverMsg);
            if (serverMsg.equals("exit")) break;
        }
        
        socket.close();
        server.close();
        System.out.println("Server closed");
    }
    
    static void runClient() throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        String serverMsg, clientMsg;
        
        while (true) {
            System.out.print("Client: ");
            clientMsg = keyboard.readLine();
            out.println(clientMsg);
            if (clientMsg.equals("exit")) break;
            
            serverMsg = in.readLine();
            if (serverMsg == null || serverMsg.equals("exit")) break;
            System.out.println("Server: " + serverMsg);
        }
        
        socket.close();
        System.out.println("Client disconnected");
    }
}

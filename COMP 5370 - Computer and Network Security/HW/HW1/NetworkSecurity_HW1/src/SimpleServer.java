/**
 * Created by johncarroll on 15-09-01.
 *
 *
 * Write TCP/IP client-server socket programs such that when
 * client sends two numbers, server replies with their sum in
 * programming language of your choice.
 *
 */
import java.net.*;
import java.io.*;
public class SimpleServer {
    public static void main(String args[]) throws IOException {
        int serverPort = 4020;
        ServerSocket serverSocket = null;
        ObjectOutputStream toClient = null;
        ObjectInputStream fromClient = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Just connected to " +
                        socket.getRemoteSocketAddress());
                toClient = new ObjectOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()));
                fromClient = new ObjectInputStream(
                        new BufferedInputStream(socket.getInputStream()));
                Message msgRequest = (Message)fromClient.readObject();
                int number1 = msgRequest.number1;
                int number2 = msgRequest.number2;
                int sum = number1 + number2;
                toClient.writeObject(new Message(sum));
                toClient.flush();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

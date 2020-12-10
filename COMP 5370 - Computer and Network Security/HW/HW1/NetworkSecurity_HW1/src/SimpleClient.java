/**
 * Created by johncarroll on 15-09-01.
 */
// SimpleClient.java: A simple client program.
import java.net.*;
import java.io.*;
public class SimpleClient {
    public static void main(String args[]) throws IOException {
        int serverPort = 4020;
        Socket socket = null;
        ObjectOutputStream toServer = null;
        ObjectInputStream fromServer = null;
        try {
            if(args.length != 2) {
                System.out.println("Need 2 argument");
                System.exit(1);
            }
            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);
            InetAddress serverHost = InetAddress.getByName("localhost");
            System.out.println("Connecting to server on port " + serverPort);
            socket = new Socket(serverHost,serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            toServer = new ObjectOutputStream(
                    new BufferedOutputStream(socket.getOutputStream()));
            Message msgToSend = new Message(number1, number2);
            toServer.writeObject(msgToSend);
            toServer.flush();

            // This will block until the corresponding ObjectOutputStream
            // in the server has written an object and flushed the header
            fromServer = new ObjectInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            Message msgFromReply = (Message)fromServer.readObject();
            System.out.println(number1 + " + " + number2 + " = " + msgFromReply.sum);
            System.out.println("Sum: " + msgFromReply.sum);
        }
        catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            if(socket != null) {
                try {
                    socket.close();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

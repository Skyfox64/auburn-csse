import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.lang.ClassNotFoundException;import java.lang.Exception;import java.lang.String;import java.lang.System;import java.net.*;
import java.io.*;import java.net.InetAddress;import java.net.Socket;
public class ClientHW2 {

    public static final String BLOWFISH = "Blowfish";
    public static String x;
    public static String encryptedResult;
    public static String decryptedResult;

    public static void main(String args[]) throws Exception {

        int serverPort = 4020;
        Socket socket = null;
        ObjectOutputStream toServer = null;
        ObjectInputStream fromServer = null;
        try {
            if(args.length != 2) {
                System.out.println("Need 2 argument");
                System.exit(1);
            }
            String word1 = args[0];
            String word2 = args[1];

            InetAddress serverHost = InetAddress.getByName("localhost");
            System.out.println("Connecting to server on port " + serverPort);
            socket = new Socket(serverHost,serverPort);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));


            //Encrypt message
            MessageHW2 msgToSend1 = new MessageHW2(ClientHW2.encrypt(word1, word2), x);
            System.out.println("Client Blowfish Encryption: \"" + word1 + "\" + \"" + word2 + "\" INTO: " + msgToSend1.message);

            toServer.writeObject(msgToSend1);
            toServer.flush();


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
    public static String encrypt(String username, String password) throws Exception {
        x = new StringBuilder(username).append(password).toString();
        byte[] keyData = (x).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
        Cipher cipher = Cipher.getInstance(BLOWFISH);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(password.getBytes());
        encryptedResult = new BASE64Encoder().encode(result);
        System.out.println("Encrypted into " + encryptedResult);

        return encryptedResult;
    }
//    public static String decrypt(String param) throws Exception {
//        byte[] keyData = (x).getBytes();
//        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
//        Cipher cipher = Cipher.getInstance(BLOWFISH);
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//        byte[] result = cipher.doFinal(new BASE64Decoder().decodeBuffer(param));
//        decryptedResult = new String(result);
//        System.out.println("Decrypted into " + decryptedResult);
//
//        return decryptedResult;
//    }
}

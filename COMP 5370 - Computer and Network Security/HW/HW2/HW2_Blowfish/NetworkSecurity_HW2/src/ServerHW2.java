/**
 * Created by johncarroll on 15-09-01.
 *
 *
 * Write TCP/IP client-server socket programs such that when
 * client sends two numbers, server replies with their sum in
 * programming language of your choice.
 *
 */
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;import java.io.ObjectInputStream;import java.lang.ClassNotFoundException;import java.lang.Exception;import java.lang.String;import java.lang.System;import java.net.*;
import java.io.*;import java.net.ServerSocket;import java.net.Socket;
public class ServerHW2 {

    public static final String BLOWFISH = "Blowfish";
    public static String x;
    public static String encryptedResult;
    public static String decryptedResult;

    public static void main(String args[]) throws Exception {

        int serverPort = 4020;
        ServerSocket serverSocket = null;
        ObjectOutputStream toClient = null;
        ObjectInputStream fromClient = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                toClient = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                fromClient = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

                //Begin Decrypt

                MessageHW2 msgRequest1 = (MessageHW2) fromClient.readObject();
                x = msgRequest1.x;
                String encryptedMessage = msgRequest1.message;
                String decryptedMessage = decrypt(encryptedMessage);
                System.out.println("Server Blowfish Decryption: \"" + msgRequest1.message + "\" INTO: " + decryptedMessage);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
//    public static String encrypt(String username, String password) throws Exception {
//        x = new StringBuilder(username).append(password).toString();
//        byte[] keyData = (x).getBytes();
//        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
//        Cipher cipher = Cipher.getInstance(BLOWFISH);
//        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//        byte[] result = cipher.doFinal(password.getBytes());
//        encryptedResult = new BASE64Encoder().encode(result);
//        System.out.println("Encrypted into " + encryptedResult);
//
//        return encryptedResult;
//    }
    public static String decrypt(String param) throws Exception {
        byte[] keyData = (x).getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, BLOWFISH);
        Cipher cipher = Cipher.getInstance(BLOWFISH);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(new BASE64Decoder().decodeBuffer(param));
        decryptedResult = new String(result);
        System.out.println("Decrypted into " + decryptedResult);

        return decryptedResult;
    }
}

package studentcompanion;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class client {

    public static void main(String[] args) {
        client cl = new client();
    }

    public client() {
        try {
            Socket sock
                    = new Socket("127.0.0.1", 8000);
            System.out.println("Connected to Server");
            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

            dos.writeBytes(" hello server\r\n");
            while (true) {
                String s = dis.readLine();
                System.out.println("Server: " + s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

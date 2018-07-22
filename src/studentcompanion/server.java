/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anmol singh sethi
 */
public class server {

    public static void main(String[] args) {
        server ser = new server();
    }

    public server() {
        try {
            ServerSocket sersock = new ServerSocket(8000);

            System.out.println("Connection accepted");

            while (true) {
                Socket sock = sersock.accept();

                new Thread(new clienthandler(sock)).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class clienthandler implements Runnable {

        Socket sock;

        clienthandler(Socket sock) {
            this.sock = sock;
        }

        @Override
        public void run() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            try {
                DataOutputStream dos;
                dos = new DataOutputStream(sock.getOutputStream());

                DataInputStream dis;
                dis = new DataInputStream(sock.getInputStream());

                dos.writeBytes("hello client\r\n");

                while (true) {
                    String s = dis.readLine();
                    System.out.println("Client: " + s);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}

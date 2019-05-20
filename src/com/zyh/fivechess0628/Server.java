package com.zyh.fivechess0628;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 * <p>Title: chess server</p>
 * <p>Description: chess server</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class Server {
    public static final int PORT = 8180;
    public static ArrayList playerList = new ArrayList();
    public static ArrayList groupList = new ArrayList();
    public static void main(String[] args)throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Welcome using ChessWZQ1.0 server (alpha test)...\nAuthor:cylix\nCopyright:e-top\nMail:cylix_xtcc@sina.com");
        System.out.println("Server Started at port "+PORT+"...");

        try {
            while(true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    ServeOneClient server = new ServeOneClient(socket);
                    Player client = new Player();
                    client.selfSocket = server;
                    playerList.add(client);
                    //System.out.println("create a socket frome server");
                } catch(IOException e) {
                    // If it fails, close the socket,
                    // otherwise the thread will close it:

                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }

}///:-)

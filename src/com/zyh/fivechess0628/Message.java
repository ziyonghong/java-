package com.zyh.fivechess0628;

import java.io.Serializable;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */
/**
 * message list
 * type = 1 // request of connected,msg = connector's name
 * type = 2 // put chessman
 * type = 3 // request play with another
 * type = 4 // deny a request for play
 * type = 5 // agree with request
 * type = 6 // send victory message
 * type = 7 // send disconnection
 * type = 8 // save game but not to disk,it will be lost when next start
 * type = 9 // add new player to all client's player list
 * type = 10// response for message type ==1
 * type = 11// play with a player,msg save player's name ,game set by
 *          // the one who create game
 * type = 12// setting information
 * type = 13// setting player color
 * type = 14// msg for acceptor B to setting color and setings
 * type = 15// server update message
 * type = 16// send messages of control or errors
 * type = 17// failed in the game
 * type = 18// server socket close
 * type = 19// player end a game and refresh
 * tyep = 20// computer win / people win
 */

public class Message implements Serializable{
    byte type;            // message type ,eg.1=request of connection
    boolean setting;      //  «∑Ò…Ë÷√Ω˚ ÷
    int color;           // chessman color ,1 = black ,2 = white
    boolean forYourTurn;  // judge whether it is for receiver's turn
    int coordinateX;     // record the coordinate X from 0~14 ,save black or white
    int coordinateY;     // record the coordinate Y from 0~14 ,save black or white
    char[] msg;           // message body
    public Message(){
        setting=true;
        msg = new char[50];
//        StringBuffer ss = new StringBuffer(50);
    }
}///:-)

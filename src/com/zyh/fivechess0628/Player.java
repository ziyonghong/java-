package com.zyh.fivechess0628;

import java.net.Socket;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class Player {
    String self=null;
    ServeOneClient selfSocket=null;
    boolean setting = false;
    int color = 1;
    public Player(){}
/*    public Player(Player pp){
        self = new String(pp.self);
        selfSocket = pp.selfSocket;
        player = new String(pp.player);
        playerSocket = pp.playerSocket;
    }
*/
}///:-)
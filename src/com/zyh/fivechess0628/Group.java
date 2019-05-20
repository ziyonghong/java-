package com.zyh.fivechess0628;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class Group {
    String self=null;
    ServeOneClient selfSocket=null;
    String player = null;
    ServeOneClient playerSocket =null;
    int selfColor = 0;
    int playerColor = 0;
    boolean Setting = false;
    int board[][];

    public Group(){
        board = new int[15][15];
    }
}
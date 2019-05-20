package com.zyh.fivechess0628;

import java.io.*;
import java.net.*;

/**
 * <p>Title: chess server</p>
 * <p>Description: chess server</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class ServeOneClient extends Thread{
    private Socket socket;
    private String player=null;
    protected ObjectInputStream in;
    protected ObjectOutputStream out;
    public ServeOneClient(Socket s)
        throws IOException {
        socket = s;
        //System.out.println("server socket begin ...");

        in =new ObjectInputStream(
            socket.getInputStream());
        // Enable auto-flush:
        out = new ObjectOutputStream(
            socket.getOutputStream());
        //System.out.println("server socket in and out ...");

        // If any of the above calls throw an
        // exception, the caller is responsible for
        // closing the socket. Otherwise the thread
        // will close it.
        start(); // Calls run()
    }
    public void run() {

        Message obj=new Message();
        while (true) {
            try {
                obj =(Message)in.readObject();
                // write message by doMessage() function
                doMessage(obj);
            }catch(ClassNotFoundException er){}
            catch(IOException e){}
        }
    /*
        System.out.println("closing...");
        try {
            socket.close();
        }catch (IOException e) {}
     */

    }
    /**
     * deal with messages
     * @param msg
     * @return 1= victory request 2=socket closeed
     */
    public int doMessage(Message msg){
        //System.out.println("doMessage begin...type="+msg.type);
        switch(msg.type){
            case 1:{//new connect to the server
                sendNewPlayer(msg); //here client must reply with type==10
                addPlayer(msg);     // msg.msg == new player's name
                break;
            }
            case 2:{// put chessman
                putChessman(msg);
                break;
            }
            case 3:{//request for another to play
                requestAnother(msg);
                break;
            }
            case 4:{
                denyRequest(msg);
                break;
            }
            case 5:{
                acceptRequest(msg);
                break;
            }
            case 6:{//send victory
                checkVictory(msg);
                break;
            }
            case 7:{//send disconnection
                getdisconnect(msg);
                break;
            }
            case 8:{//save game
                break;
            }
            case 12:{//setting information
                boolean flag=true;
                setting(msg,flag);
                break;
            }
            case 13:{
                boolean flag=false;
                setting(msg,flag);
                break;
            }
            case 19:{
                playerRefresh(msg);
                break;
            }
            case 20:{
                try{
                    this.out.writeObject(msg);
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            }
            default:{
            }
        }//end switch
        return 0; // end correctly
    }
    /**
     * judge game and update all client's panel
     * type = 7 sender will close game
     * @param msg
     */
    public void getdisconnect(Message msg){
        Group gg = null;
        Player pp = null;
        String str=null;
        //if disconnector in a group
        for(int i=0;i<Server.groupList.size();i++){
            gg = (Group)Server.groupList.get(i);
            if(this.equals(gg.selfSocket)==true){
                //send gg.player win
                msg.type=6; // gg.player win
                try{
                    gg.playerSocket.out.writeObject(msg);
                }catch(IOException e){
                    e.printStackTrace();
                }
                sendLeftMsg(gg.self);
                //update groupList
                Server.groupList.remove(gg);
                return;
            }
            if(this.equals(gg.playerSocket)==true){
                msg.type=6;
                try{
                    gg.selfSocket.out.writeObject(msg);
                }catch(IOException e){
                    e.printStackTrace();
                }
                sendLeftMsg(gg.player);
                Server.groupList.remove(gg);
                return;
            }
        }

        // if disconnector in the playerList
        for(int i=0;i<Server.playerList.size();i++){// find disconnector
            pp = (Player)Server.playerList.get(i);
            if(this.equals(pp.selfSocket)==true){
                break;
            }
        }
        sendLeftMsg(pp.self);
        Server.playerList.remove(pp); // remove disconnector from list
        updateClient();
    }
    private void sendLeftMsg(String str){
        char cc;
        for(int i=0;i<50;i++){
            cc=str.charAt(i);
            if(cc!='\0')
                System.out.print(cc);
            else break;
        }
        System.out.print(" has left server ...\n");

    }
    /**
     * deny request of play
     * type ==4 msg == requestor's name
     * @param msg
     */
    public void denyRequest(Message msg){
        String denyName=null;
        Player pp=null;
        for(int i=0;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            if(this.equals(pp.selfSocket)==true){
                denyName = new String(pp.self);
                break;
            }
        }
        for(int i=0;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            if(arrayMatchString(msg.msg,pp.self)==true){
                Message ms = new Message();
                ms.type=4;
                strToCharArray(denyName,ms.msg);
                try{// requestor 's socket send msg to it's client
                    pp.selfSocket.out.writeObject(ms);
                }catch(IOException er){
                    er.printStackTrace();
                }
                break;
            }
        }

    }
    /**
     * B accept request of A server will update List
     * type ==5 msg == A's name
     * @param msg
     */
    public void acceptRequest(Message msg){
        Player pps=null,ppd=null;//ppd = B pps = A
        String acceptName=null;
        for(int i=0;i<Server.playerList.size();i++){
            ppd = (Player)Server.playerList.get(i);
            if(this.equals(ppd.selfSocket)==true){
                break;
            }
        }
        for(int i=0;i<Server.playerList.size();i++){
            pps = (Player)Server.playerList.get(i);
            if(arrayMatchString(msg.msg,pps.self)==true){
                break;
            }
        }

        Message ss = new Message();
        ss.type=14; // for B to set color and settings
        ss.color=msg.color;
        try{
            ppd.selfSocket.out.writeObject(ss);
        }catch(IOException e){
            e.printStackTrace();
        }
        ss.type=5; // B's accept A's requestion
        strToCharArray(ppd.self,ss.msg);
        try{
            pps.selfSocket.out.writeObject(ss);
        }catch(IOException e){
            e.printStackTrace();
        }
        //upload list display here, server will update Arraylist
        Group p1 = new Group();
        p1.self=new String(pps.self);
        p1.selfSocket = pps.selfSocket;
        p1.selfColor = pps.color;
        p1.player = new String(ppd.self);
        p1.playerSocket = ppd.selfSocket;
        if(p1.selfColor==1){
            p1.playerColor = 2;
        }else{
            p1.playerColor = 1;
        }
        p1.Setting = pps.setting;
        Server.groupList.add(p1);

        ///System.out.println(p1.self+p1.selfColor+" player "+p1.player+p1.playerColor);

        if(Server.playerList.size()==2){
            msg.type=15;
            try{
                pps.selfSocket.out.writeObject(msg);
                ppd.selfSocket.out.writeObject(msg);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        Server.playerList.remove(pps);
        Server.playerList.remove(ppd);

        //System.out.println(" after create a group,playerlist size  = "+Server.playerList.size());

        updateClient();
    }
    /**
     * update client List when new group create or player left
     */
    public void updateClient(){
        Message msg = new Message();
        Player pp = null,ppm = null;
        for(int i=0;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            msg.type=15;   //update client player list box
            try{  //clear client list box
   //             System.out.println("clear "+pp.self+"'s list box");
                pp.selfSocket.out.writeObject(msg);
            }catch(IOException e){
                e.printStackTrace();
            }
            for(int j=0;j<Server.playerList.size();j++){
                ppm=(Player)Server.playerList.get(j);
                strToCharArray(ppm.self,msg.msg);
                msg.type=9;
                try{
                    //System.out.println("updating ..."+pp.self+" list box about"+ppm.self);
                    pp.selfSocket.out.writeObject(msg);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        // later ,group player 's list box will be updateed here
    }
    /**
     * judge whether arr[] is equal to str
     * @param arr
     * @param str
     * @return
     */
    private boolean arrayMatchString(char []arr,String str){
        for(int i=0; i<50 && str.charAt(i)!='\0';i++){
            if(arr[i]!=str.charAt(i))
                return false;
        }
        return true;
    }
    /**
     * type ==3
     * @param msg
     */
    public void requestAnother(Message msg){
        Player pp = null;  // receiver
        Player spp = null; // sender
        String senderName=null;
        // get sender's name
        for(int i=0;i<Server.playerList.size();i++){
            spp = (Player)Server.playerList.get(i);
            if(this.equals(spp.selfSocket)==true){
                senderName = new String(spp.self);
                //System.out.println("requestor 's name = "+senderName);
                break;
            }
        }
        for(int i=0;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            if(arrayMatchString(msg.msg,pp.self)==true){
                Message ms = new Message();
                strToCharArray(senderName,ms.msg);
                ms.type=3;
                if(spp.color==1){
                    ms.color = 2; //set another's color
                }
                else{
                    ms.color = 1;
                }
                ms.setting=spp.setting;
                try{// player B socket send msg to B's Client
                    pp.selfSocket.out.writeObject(ms);
                    //System.out.println("type= "+ms.type+"  "+pp.self+ " send msg to name = "+ms.msg[0]+"with B's color"+ms.color);
                }catch(IOException er){
                    er.printStackTrace();
                }
                break;
            }
        }
    }
    // convert string to array which is end with '\0'
    public void strToCharArray(String str,char [] arr){
        int i=0;
        for(i=0;i<str.length()&&i<49;i++){
            arr[i] = str.charAt(i);
        }
        arr[i]='\0';
    }
    /**
     * setting information flag
     * @param msg
     */
    public void setting(Message msg,boolean flag){
        int i=0;
        Player pp=null;
        for(i=0;i<Server.playerList.size();i++){
            pp =(Player) Server.playerList.get(i);
            if(this.equals(pp.selfSocket)==true){
                if(flag==true)
                    pp.setting=msg.setting;
                else
                    pp.color=msg.color;
                //System.out.println("setting "+pp.setting+"color = "+pp.color);
            }
        }

    }

    /**
     * filter array 's black space which is end of the array
     * @param arr
     * @param str
     */
    public String arrayToString(char [] arr){
        int i=0,length=0;
        while(arr[i]!='\0' && i<50){
            i++;
        }
        length=i;
        char [] ss = new char[length];
        for(i=0;i<length;i++){
            ss[i]=arr[i];
        }
        String str = new String(ss);
        return str;
        //System.out.println("arraytoString "+str+"length = "+length);
    }

    /**
     * add new player to all client's Player List
     * ... read server player list and send msg to everyone of them
     * @param player
     */
    public void sendNewPlayer(Message player){
        Player pp=null;
        player.type=9;
//        System.out.println("send new Player ...");
        for(int i=0;i<Server.playerList.size();i++){
            pp=(Player)Server.playerList.get(i);
            try{
                if(pp.self!=null){//send message to all but itself
                    //System.out.println(pp.self+" add list "+player.msg[0]+"i = "+i);
                    pp.selfSocket.out.writeObject(player);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    /**
     * a player end a game and wait for a new one
     * @param msg
     */
    public void playerRefresh(Message player){
        Player ppo = new Player();
        Player pp = null;
        ppo.color = player.color;
        ppo.self = new String(player.msg);
        ppo.selfSocket = this;
        Server.playerList.add(ppo);

        for(int i=0;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            if(this.equals(pp.selfSocket)==false){
                Message msg = new Message();
                strToCharArray(pp.self, msg.msg);
                msg.type = 9;
                msg.color = pp.color;
//                System.out.println("refresh " + pp.self + "serverlist size " +
  //                                 Server.playerList.size());
                try {
                    this.out.writeObject(msg);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Message ms = new Message();
        strToCharArray(ppo.self, ms.msg);
        ms.type=10;
        try{
            this.out.writeObject(ms);
        }catch(IOException e){
            e.printStackTrace();
        }
        //Message ms = new Message();
        player.type=10;
        for(int i=0 ;i<Server.playerList.size();i++){
            pp = (Player)Server.playerList.get(i);
            if(this.equals(pp.selfSocket)!=true){
                try{
                    pp.selfSocket.out.writeObject(player);
                }catch(IOException e){
                    e.printStackTrace();
                }

            }
        }

    }
    /**
     * add the new player to server playerList
     * @param player
     */
    public void addPlayer(Message player){
        int i=0;
        Player pp=null,tp=null;

        for(i=0;i<Server.playerList.size();i++){
            pp=(Player)Server.playerList.get(i);
            if(this.equals(pp.selfSocket)==true){
                //System.out.println("match socket ok and send to itself...");
                pp.self = new String(player.msg);
                try{
                    for (int j = 0; j < Server.playerList.size(); j++) {
                        Message temp = new Message();
                        tp = (Player) Server.playerList.get(j);
                        if (tp.self != null) {
                            strToCharArray(tp.self, temp.msg);
                            //temp.coordinateX=(byte)j;
                            temp.type = 10; //reply for type==1
                            //System.out.println("host "+pp.self+" add list to client name = "+temp.coordinateX+temp.msg[0]);
                            pp.selfSocket.out.writeObject(temp);
                        }
                    }
                   // out.writeObject(player);
                }catch(IOException e){
                    e.printStackTrace();
                }
                break;
            }
        }/*
        System.out.print("welcome ");
        int k=0;
        while(true){
            if(player.msg[k]!='\0')
                System.out.print(player.msg[k++]);
            else break;
        }
        System.out.println();*/
        //System.out.println(" at "+pp.selfSocket.socket.toString());
    }
    public Socket getSocket(){
        return socket;
    }
    /**
     * check whether msg sender is win
     * type=6 msg = winner 's name
     * @param msg
     */
    public void checkVictory(Message msg){

    }
    /**
     * type = 2 ,(msg.coordinateX,msg.coordinateY).msg.color
     * @param msg
     */
    public void putChessman(Message msg){
        Group gg = new Group();
        ServeOneClient soc=null;
        String tName=null;
        int color=0;
        // modify server board
        for(int i=0;i<Server.groupList.size();i++){
            gg = (Group)Server.groupList.get(i);
            if(this.equals(gg.selfSocket)==true){
                soc = gg.playerSocket;
                tName = new String(gg.player);
                color = gg.selfColor;
                break;
            }
            if(this.equals(gg.playerSocket)==true){
                soc = gg.selfSocket;
                tName = new String(gg.self);
                color = gg.playerColor;
                break;
            }
        }
        gg.board[msg.coordinateX][msg.coordinateY]=color;

        // whether someone win the game
        if(judge(gg,msg.coordinateX,msg.coordinateY)==true){// a man win
            // tell the two and remove them form the group list
            try{
                msg.type=6;  // win the game
                this.out.writeObject(msg);// tell this ,he win the game
                msg.type=17; // failed in the game
                soc.out.writeObject(msg); // tell soc ,he failed
//                System.out.println("send failed to "+tName);
            }catch(IOException e){
                e.printStackTrace();
            }
            Server.groupList.remove(gg); // remove from list
            return;
        }
        // send msg to another player
        try{
            //System.out.println("server put chess man "+msg.coordinateX+","+msg.coordinateY);
            soc.out.writeObject(msg);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * judge if a man win the game
     * @param gg a group for judge
     * @param x  the newest kid's x coordinate
     * @param y  the newest kid's y coordinate
     * @return
     */
    private boolean judge(Group gg,int x,int y){
        int i = 0, j = 0, count = 0;
        int color=gg.board[x][y];
        // x direction
        for (i = 0, count = 0; x - i >= 0 && i < 5; i++) {
            if (color == gg.board[x - i][y]) {
                count++;
            }
            else {
                break;
            }
//          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5)
                return true;
        }
        for (i = 1; x + i < 15 && i < 5; i++) {
            if (color == gg.board[x + i][y]) {
                count++;
            }
            else {
                break;
            }
            if (count == 5)
                return true;
        }
        // y direction
        for (i = 0, count = 0; y - i >= 0 && i < 5; i++) {
            if (color == gg.board[x][y - i]) {
                count++;
            }
            else {
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5)
                return true;
        }
        for (i = 1; y + i < 15 && i < 5; i++) {
            if (color == gg.board[x][y + i]) {
                count++;
            }
            else {
                break;
            }
//        System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5)
                return true;
        }
        // '\' direction
        for (i = 0, count = 0; x - i >= 0 && y - i >= 0 && i < 5; i++) {
            if (color == gg.board[x - i][y - i]) {
                count++;
            }
            else {
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5)
                return true;
        }
        for (i = 1; x + i < 15 && y + i < 15 && i < 5; i++) {
            if (color == gg.board[x + i][y + i]) {
                count++;
            }
            else {
                break;
            }
//          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5) {
                return true;
            }
        }
        // '/' direction
        for (i = 0, count = 0; x + i < 15 && y - i >= 0 && i < 5; i++) {
            if (color == gg.board[x + i][y - i]) {
                count++;
            }
            else {
                count = 0;
            }
//          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5)
                return true;
        }
        for (i = 1; x - i >= 0 && y + i < 15 && i < 5; i++) {
            if (color == gg.board[x - i][y + i]) {
                count++;
            }
            else {
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if (count == 5) {
                return true;
            }
        }
        return false;
    }
    /**
     * judge if a man win the game
     * @param gg a group for judge
     * @param x  the newest kid's x coordinate
     * @param y  the newest kid's y coordinate
     * @return
     */
/*    private boolean judge(Group gg,int x,int y){

        int borderX=0,borderY=0,counter=0,i=0;
        int color=gg.board[x][y];
        if(x-4<0)            borderX=0;
        else            borderX=x-4;
        if(y-4<0)            borderY=0;
        else            borderY=y-4;


        // x direction
        while(borderX+i<x+5 && borderX+i<15){
            if(color==gg.board[borderX+i][y]){
                counter++;
            }else{
                counter=0;
            }
            i++;
            if(counter==5){
//                System.out.println("color "+color+gg.board[borderX+i][y]+"return form x "+(borderX+i)+","+y+"x,y"+x+","+y);
                return true;
            }
        }
        // y direction
        i=0;counter=0;
        while(borderY+i<y+5 && borderY+i<15){
            if(color==gg.board[x][borderY+i]){
                counter++;
            }else{
                counter=0;
            }
            i++;
            if(counter==5){
//                System.out.println("color "+color+gg.board[x][borderY+i]+"return form y "+x+","+(borderY+i)+","+y+"x,y"+x+","+y);
                return true;
            }
        }
        // '\' direction
        if(borderX>borderY)
            borderX = x-(y-borderY);
        else
            borderY = y-(x-borderX);
        i=0;counter=0;
        while(borderX+i<x+5 && borderY+i<y+5 && borderY+i<15&&borderX+i<15){
            if(color==gg.board[borderX+i][borderY+i]){
//                System.out.println("coordinate  \\  "+(borderX+i)+","+(borderY+i)+","+y+"x,y"+x+","+y);
                counter++;
            }else{
                counter=0;
            }
            i++;
            if(counter==5){
//                System.out.println("return form  \\  "+(borderX+i)+","+(borderY+i)+","+y+"x,y"+x+","+y);
                return true;
            }
        }
        // '/' direction
        if(x+4>=15){
            borderX = 14;
        }
        else{
            borderX = x+4;
        }
        if(borderX-x<y-borderY){
            borderY = y - (borderX - x);
        }
        else{
            borderX = x + (y - borderY);
        }
        i=0;counter=0;
        while(borderX-i>x-5 && borderY+i<y+5 && borderX-i>=0 && borderY+i<15){
            if(color==gg.board[borderX-i][borderY+i]){
                counter++;
            }else{
                counter=0;
            }
            i++;
            if(counter==5){
//                System.out.println("color "+color+gg.board[borderX-i][borderY+i]+"return form '/'   "+(borderX-i)+","+(borderY+i)+","+y+"x,y"+x+","+y);
                return true;
            }
        }
        return false;
    }
*/

} ///:-)

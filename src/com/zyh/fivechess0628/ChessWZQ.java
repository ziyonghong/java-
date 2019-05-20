package com.zyh.fivechess0628;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.io.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class ChessWZQ extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();

    protected Image white = null;
    protected Image black = null;
    protected static int pColor; // people 's color
    protected static int cColor; // computer's color

    static boolean ptocFlag=false;
    boolean pFirst = false;
    private int bestX=0; // computer find the best x coordinate to put chess
    private int bestY=0; // computer find the best y coordinate to put chess
    private int RectX1=0; // rectangle bounds according to (x,y)
    private int RectY1=0; // length is 9
    private int RectX2=0; // size 9*9
    private int RectY2=0; // used to weight to each black position
    private int weightBoard[][];

    static Socket socket;
    private static int PORT;
    static ObjectInputStream in;
    static ObjectOutputStream out;
    String name=null ;
    String serverAddress=null;
    static char send[];
    public static Message message = new Message();
    public static boolean beginFlag = false;

    BoardPanel bpanel = new BoardPanel();
    JPanel jpanel3 = new JPanel();
    JLabel label1 = new JLabel("Player1");
    JLabel label2 = new JLabel(" VS ");
    JLabel label3 = new JLabel("Player2");
    JLabel label4 = new JLabel("Player List ");
    JLabel label5 = new JLabel("Message list... ");
    static JLabel label6 = new JLabel("welcome");
    JLabel label7 = new JLabel("Host");
    JLabel label8 = new JLabel("Player");
    JRadioButton jrbBlack = new JRadioButton("Black");
    JRadioButton jrbWhite = new JRadioButton("White");
    DefaultListModel lItems = new DefaultListModel();
    JList list = new JList(lItems);
    JMenuBar mb = new JMenuBar();
    JMenu create = new JMenu("Create");
    JMenu setting = new JMenu("Setting");
    JMenu quit = new JMenu("Quit");
    JMenu about = new JMenu("About");
    JMenuItem cPtoP = new JMenuItem("Play With people");
    JMenuItem cPtoC = new JMenuItem("Play With Computer");
    JMenuItem load = new JMenuItem("Load game...");
    JMenuItem save = new JMenuItem("Save ...");
//    JMenuItem sLimited = new JMenuItem("禁止禁手");
//    JMenuItem sNoLimited = new JMenuItem("允许禁手");


    public ChessWZQ() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        getContentPane().setLayout(null);
        weightBoard = new int [15][15]; // save each position 's weight

        PORT = Server.PORT;//set socket port
        send = new char[60];

        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        try {
            getContentPane().setLayout(null);

            jrbBlack.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    bpanel.setColor(1);
                    cColor=2;
                    jrbBlack.setEnabled(false);
                    jrbWhite.setEnabled(false);
                    drawChess(1);
                    jrbWhite.setSelected(true);
                    if(ptocFlag==true){
                        return;
                    }
                    Message ms = new Message();
                    ms.color=1;
                    ms.type=13;
                    try{
                        out.writeObject(ms);
                    }catch(IOException error){
                        error.printStackTrace();
                    }
                }
            });
            jrbWhite.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    bpanel.setColor(2);
                    cColor=1;
                    jrbWhite.setEnabled(false);
                    jrbBlack.setEnabled(false);
                    drawChess(2);
                    jrbBlack.setSelected(false);
                    if(ptocFlag==true){
                        return;
                    }
                    Message ms = new Message();
                    ms.color=2;
                    ms.type=13;
                    try{
                        out.writeObject(ms);
                    }catch(IOException error){
                        error.printStackTrace();
                    }
                }
            });
            about.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null,
                                                  "author: cylix \nCopyright (c) 2003 e-top\nmail:cylix_xtcc@sina.com",
                                                  "五子棋1.0(beta)",JOptionPane.INFORMATION_MESSAGE);
                }
            });
            quit.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    int flag=JOptionPane.showConfirmDialog(null,
                                                  "Quit the Program ?",
                                                  "Are you sure to quit ?",
                                                  JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(flag==0){       //press YES
                        // disconnect to server
                        sendDisconnect();
                        System.exit(0);
                    }
                }
            });
            setting.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){

                    Object selection[] = {"Forbiden","Allow any"};
                    Object set = JOptionPane.showInputDialog(null,
                        "Setting...","would you allow any method?",
                        JOptionPane.QUESTION_MESSAGE,null,selection,selection[0]);
                    if(ptocFlag==true){
                        return;
                    }
                    Message ms = new Message();
                    if(set==null){
                        return;
                    }
                    if(set.toString().equals(selection[0])){
                        ms.setting=false;
                    }
                    else{
                        ms.setting=true;
                    }
                    //System.out.println("setting begin..."+msg.setting);
                    ms.type=12;
                    try{
                        out.writeObject(ms);
                    }catch(IOException error){
                        error.printStackTrace();
                    }
                }
            });
            cPtoP.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ptocFlag=false;
                    JOptionPane.showMessageDialog(null,
                        "You can choose a player from the listBox on the right","Welcome...",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            });
            cPtoC.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(ptocFlag==true){
                        int flag=JOptionPane.showConfirmDialog(null,
                            "You give up... ?","Message",
                            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(flag==0){
                            newGame();
                            return;
                        }
                    }
                    label3.setText("Computer");
                    Object selection[] = {"Computer First","You First"};
                    Object set = JOptionPane.showInputDialog(null,
                        "choose who first...","setting...",
                        JOptionPane.QUESTION_MESSAGE,null,
                        selection,selection[0]);
                        ptocFlag = true;
                    if(set.toString().equals(selection[1])){
                        pFirst = true;
                    }else{
                        pFirst = false;
                    }
                    pColor=bpanel.getColor();
                    if(pColor==1){
                        jrbBlack.setSelected(true);
                        jrbWhite.setSelected(false);
                        cColor=2;
                    }
                    else{
                        jrbWhite.setSelected(true);
                        jrbBlack.setSelected(false);
                        cColor=1;
                    }
                    jrbBlack.setEnabled(false);
                    jrbWhite.setEnabled(false);
                    ptoComputer();
                }
            });

            create.setBounds(5,5,40,20);
            setting.setBounds(45,5,40,20);
            quit.setBounds(85,5,40,20);
            about.setBounds(125,5,40,20);
            create.add(cPtoP);
            create.add(cPtoC);
            create.add(load);
            create.add(save);
            mb.add(create);
            mb.add(setting);
            mb.add(quit);
            mb.add(about);
            this.setJMenuBar(mb);

            bpanel.setBounds(0,0,470,460);
            bpanel.setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.ORANGE));

            jpanel3.setLayout(null);
            jpanel3.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.DARK_GRAY));
            jpanel3.setBounds(470,0,180,460);
            label7.setBounds(10,10,30,20);
            label7.setBackground(Color.blue);
            label7.setForeground(Color.yellow);
            label8.setBounds(90,10,40,30);
            label8.setBackground(Color.blue);
            label8.setForeground(Color.yellow);
            label1.setBounds(10,40,50,20);
            label2.setForeground(Color.RED);
            label2.setBounds(60,40,50,20);
            label3.setBounds(90,40,70,20);
            label4.setForeground(Color.BLUE);
            label4.setBounds(10,78,70,20);
            label5.setBackground(Color.magenta);
            label5.setForeground(Color.RED);
            label5.setBounds(15,395,160,20);
            label6.setBounds(15,415,180,20);
            //label6.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.yellow));

            jrbBlack.setSelected(true);
            jrbBlack.setBounds(10,380,80,15);
            jrbWhite.setBounds(90,380,80,15);

            list.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
            list.setBounds(10,100,150,265);

            list.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    // double click to choose a player
                    if(e.getClickCount()==2){
                        String str = list.getSelectedValue().toString();
                        if(str.equals(name)==true){
                            label6.setText("You can't choose yourself");
                            return;
                        }
                        label3.setText(str);
                        list.setEnabled(false);

                        Message ms = new Message();
                        ms.type=3;  //request play with another
                        strToCharArray(str,ms.msg);
                        ms.color = bpanel.getColor();
                        //System.out.println("request for play with "+str);
                        try{
                            out.writeObject(ms);
                        }catch(IOException er){
                            er.printStackTrace();
                        }
                }
            }
        });
            jpanel3.add(label1);
            jpanel3.add(label2);
            jpanel3.add(label3);
            jpanel3.add(label4);
            jpanel3.add(label5);
            jpanel3.add(label6);
            jpanel3.add(label7);
//            jpanel3.add(label8);
            jpanel3.add(jrbBlack);
            jpanel3.add(jrbWhite);
            jpanel3.add(list);

            // getContentPane().add(jpanel1);
            getContentPane().add(bpanel);
            getContentPane().add(jpanel3);

           // lItems.add(0,"hugh");
           // lItems.add(0,"cylix");

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    //Component initialization
    private void jbInit() throws Exception  {
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(borderLayout1);
        this.setSize(new Dimension(660, 530));
        this.setTitle("五子棋客户端(beta)");
    }
    /**
     * send disconnection to server
     * type = 7
     */
    public void sendDisconnect(){
        Message ms = new Message();
        ms.type=7;
        try{
            out.writeObject(ms);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void drawChess(int col){
        Graphics g = jpanel3.getGraphics();
        if(col==1) g.setColor(Color.black);
        else g.setColor(Color.white);
        g.fillOval(50,10,20,20);
    }

    /**
     * <format> java ChessWZQ < server address> <player name>
     * @param args[0]=server address args[1]=player name
     */
    public static void main(String [] args){
        ChessWZQ wzq = new ChessWZQ();
        wzq.setResizable(false);
        wzq.setVisible(true);
        wzq.drawChess(1);   //default color is black

        Message ms = new Message();
        if(args[0]!=null)
        	wzq.serverAddress = new String(args[0]);
        else
        	wzq.serverAddress = new String("localhost");
        if(args[1]!=null)
        	wzq.name = new String(args[1]);
        else
        	wzq.name = new String("cylix");
        wzq.strToCharArray(wzq.name,ms.msg);
        try{
            // should get server name by command line
            InetAddress addr = InetAddress.getByName(wzq.serverAddress);
            //System.out.println("address "+ addr.toString()+" port: "+PORT);
            socket = new Socket(addr, PORT);
            //System.out.println("set socket successful...");

            out = new ObjectOutputStream(
                socket.getOutputStream());
            in = new ObjectInputStream(
                socket.getInputStream());

            ms.type=1;
            try{
                out.writeObject(ms);
            }catch(IOException e){
                e.printStackTrace();
            }
            while(true){
                try {
                    ms = (Message) in.readObject();
                    //System.out.println("get message from server...type = "+ms.type);
                    wzq.doMessage(ms);
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("ms.coordinateX + , + msg.coordinateY");
            //System.out.println(ms.color);
            //System.out.println("close ...");
            //socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * deal with message get from server
     * @param msg
     * @return
     */
    protected int doMessage(Message msg){
        String str=arrayToString(msg.msg);
        //System.out.println("msg name = "+str+" msg.type = "+msg.type);
        switch(msg.type){
            case 2:{//respones of put chessman
                putChessman(msg);
                break;
            }
            case 3:{//request from another player
                requestAnother(msg);
                break;
            }
            case 4:{ // B deny to play with A
                getDeny(msg);
                break;}
            case 5:{ // B accept A's requestion
                acceptToPlay(msg);
                break;}
            case 6:{
                getVictory(msg);
                break;}
            case 7:{
                getDisconnection(msg);
                break;}
            case 9:{//reply of adding new player to all client
                ///System.out.println("add new player to list type = 9 name = "+str+"msg[0]= "+msg.msg[0]);
                lItems.add(0,str);
                break;
            }
            case 10:{ //respones of connecting
                //System.out.println("add him self  type = 10 name = "+str+"msg[0]= "+msg.coordinateX+msg.msg[0]);
                label1.setText(str);
                label6.setText("welcome "+str);
                lItems.add(0,str);
                break;
            }
            case 14:{ //B have accept playing with A,then get msg
                      //to set color and settings
                break;
            }
            case 15:{
                lItems.clear();
                break;
            }
            case 17:{
                getFailed(msg);
                break;
            }
            case 20:{
                ptocWin(msg);
                break;
            }
        }
        return 0; //end correctly
    }
    private void ptocWin(Message ms){
        String str=this.arrayToString(ms.msg);
        JOptionPane.showMessageDialog(null,str+" win the game!","V the game",JOptionPane.INFORMATION_MESSAGE);
        newGame();
    }
    /**
     * failed the game and have a new one
     * type == 17
     * @param msg
     */
    public void getFailed(Message msg){
        bpanel.drawChess(msg.coordinateX,msg.coordinateY);
        JOptionPane.showMessageDialog(null,
                                      "Sorry,You've failed the game",
                                      "Try Again",
                                      JOptionPane.INFORMATION_MESSAGE);
        label3.setText("Player2");
        // have a new game to continue to play
        newGame();
    }
    /**
     * another player send disconnection msg,here will resolve it
     * type ==7
     * @param msg
     */
    public void getDisconnection(Message msg){
        getVictory(msg);
    }
    /**
     * win the game
     * type ==6
     * @param msg
     */
    public void getVictory(Message msg){
        JOptionPane.showMessageDialog(null,
                                      "You  Win  The  Game",
                                      "Congratulations",
                                      JOptionPane.INFORMATION_MESSAGE);
        // have a new game to continue to play
        label3.setText("Player2");
        newGame();
    }
    /**
     * when people win a game ,then he can start a new one
     * @param msg
     */
    public void newGame(){
        jrbBlack.setEnabled(true);
        jrbWhite.setEnabled(true);
        jrbBlack.setSelected(true);
        jrbWhite.setSelected(false);
        list.setEnabled(true);
        setting.setEnabled(true);
        bpanel.clearBoard();
        drawChess(1);
        pColor=1;cColor=2;
        if(ptocFlag==false){
            Message msg = new Message();
            msg.type = 19;
            strToCharArray(name, msg.msg);
            try {
                out.writeObject(msg);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        ptocFlag=false;
        beginFlag=false;
    }
    /**
     * precondition:get a msg from competitor of puting a chessman
     * fundition : deal with it
     * @param msg
     */
    public void putChessman(Message msg){
        if(ptocFlag==false){
            bpanel.updateBoard(msg.coordinateX,msg.coordinateY);
            bpanel.drawChess(msg.coordinateX,msg.coordinateY);
            beginFlag = true;
            return;
        }else{
            // update native board
            // search position to put chessman
        }
    }
    /**
     * A get a Ok msg from B and seting according with B
     * type= 5 B accept to play with A
     * @param msg = B's name
     */
    public void acceptToPlay(Message msg){
        String str=arrayToString(msg.msg);
        String ss=null;
        if(msg.color==1){
            ss = new String("white");
            bpanel.setColor(2);
        }
        else{
            ss = new String("black");
            bpanel.setColor(1);
        }
        JOptionPane.showMessageDialog(null,
                                      "OK. "+str+" have accepted your requestion\nYour color is"+ss,
                                      "Game will to begin...",JOptionPane.ERROR_MESSAGE);

        list.setEnabled(false);
        jrbBlack.setEnabled(false);
        jrbWhite.setEnabled(false);
        setting.setEnabled(false);
        beginFlag=true;
    }
    /**
     * A get a deny msg from B
     * type ==4 deny to play
     * @param msg
     */
    public void getDeny(Message msg){
        String str=arrayToString(msg.msg);
        JOptionPane.showMessageDialog(null,
                                      "I'm sorry\n"+str+" denied your requestion",
                                      "Sorry...",JOptionPane.ERROR_MESSAGE);
        list.setEnabled(true);
        label3.setText("Player2");
    }
    /**
     * A request play game with B,what below is B done
     * deal with request to paly
     * @param msg = requester 's name
     */
    public void requestAnother(Message msg){
        String str=arrayToString(msg.msg);
//        System.out.print("client requestAnother begin ...");
        int flag =JOptionPane.showConfirmDialog(null,
            "Player "+str+" want to play with you\nAre you OK?",
            "Play request...",JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(flag==0){// press YES
            msg.type=5; //agree with request
            if(msg.color==1){ // msg.color is B 's color ,different with A's
                drawChess(msg.color);
                jrbBlack.setSelected(true);
                jrbWhite.setSelected(false);
                bpanel.setColor(1);
            }
            else{
                drawChess(msg.color);
                jrbWhite.setSelected(true);
                jrbBlack.setSelected(false);
                bpanel.setColor(2);
            }
//                System.out.println("B's color is"+msg.color);
            list.setEnabled(false);
            label3.setText(str);
            setting.setEnabled(false);
            jrbBlack.setEnabled(false);
            jrbWhite.setEnabled(false);
            beginFlag=true;
        }
        if(flag==1){// press NO
            msg.type=4; // deny request
        }
        try{
            out.writeObject(msg);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        drawChess(bpanel.getColor());
    }
    /**
     * Overridden so we can exit when window is closed
     */
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
    // convert string to array which is end with '\0'
    public void strToCharArray(String str,char [] arr){
        int i;
        for(i=0;i<str.length()&&i<49;i++){
            arr[i] = str.charAt(i);
        }
        arr[i]='\0';
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
     * do people play with computer
     */
    public void ptoComputer(){
        int x=0,y=0;
        int position;
        if(pFirst==false){
            x=7;
            y=7;
            bpanel.updateBoard(x,y);
            bpanel.drawChess(x,y);
            beginFlag=true;
        }else{
            beginFlag=true;
        }
    }
    /**
     * choos a best position to put chessman
     * @param x the newest chessman's x coordinate
     * @param y the newest chessman's y coordinate
     */
    private void cPutChess(int x,int y){
        setRect(x,y);
        setWeight(x,y,pColor);
        getBetter(3);
    }
    /**
     * set a rectangle of 9*9
     * @param x center of rectangle
     * @param y center of rectangle
     */
    private void setRect(int x,int y){
        if(x-4>0)  RectX1=x-4;
        else       RectX1=0;
        if(x+4>14) RectX2=14;
        else       RectX2=x+4;
        if(y-4>0)  RectY1=y-4;
        else       RectY1=0;
        if(y+4>14) RectY2=14;
        else       RectY2=y+4;
        if(RectX1>RectY1) RectX1 = x-(y-RectY1);
        else              RectY1 = y-(x-RectX1);
        if(RectX2>RectY2) RectY2 = y+(RectX2-x);
        else              RectX2 = x+(RectY2-y);
    }
    /**
     * set each black position's weight in the rectangle
     * @param x rectangle center's x coordinate
     * @param y rectangle center's x coordinate
     */
    private void setWeight(int x,int y,int tcolor){
        int i=RectX1,j=RectY1,value=0,k=0,n=0,flag=0;
        // '--' direction
        for(i=RectX1,j=y;i<=RectX2;i++){
            if(BoardPanel.board[i][j]!=0){
                continue;
            }
            value=0;flag=0;
            for(k=1;i-k>=RectX1 && k<5;k++){
                if(BoardPanel.board[i-k][j]==tcolor){
                    value++;
                    continue;
                }
                if(BoardPanel.board[i-k][j]==0){//black space
                    flag++;
                    break;
                }
            }
            for(k=1;i+k<RectX2 && k<5;k++){
                if(BoardPanel.board[i+k][j]==tcolor){
                    value++;
                }
                if(BoardPanel.board[i+k][j]==0){
                    flag++;
                    break;
                }
            }
            n=weight(value,flag);
            if(weightBoard[i][j]<n){
                weightBoard[i][j]=n;
            }
        }
        // '|' direction
        for(i=x,j=RectY1;j<=RectY2;j++){
            if(BoardPanel.board[i][j]!=0){
                continue;
            }
            value=0;flag=0;
            for(k=1;j-k>=RectY1 && k<5;k++){
                if(BoardPanel.board[i][j-k]==tcolor){
                    value++;
                    continue;
                }
                if(BoardPanel.board[i][j-k]==0){
                    flag++;
                    break;
                }
            }
            for(k=1;j+k<RectY2 && k<5;k++){
                if(BoardPanel.board[i][j+k]==tcolor){
                    value++;
                }
                if(BoardPanel.board[i][j+k]==0){
                    flag++;
                    break;
                }
            }
            n=weight(value,flag);
            if(weightBoard[i][j]<n){
                weightBoard[i][j]=n;
            }
        }
        // '\' direction
        for(i=RectX1,j=RectY1;i<=RectX2;i++,j++){
            if(BoardPanel.board[i][j]!=0){
                continue;
            }
            value=0;flag=0;
            for(k=1;i-k>=RectX1 && k<5 ;k++){
                if(BoardPanel.board[i-k][j-k]==tcolor){
                    value++;
                    continue;
                }
                if(BoardPanel.board[i-k][j-k]==0){
                    flag++;
                    break;
                }
            }
            for(k=1;i+k<RectX2 && k<5;k++){
                if(BoardPanel.board[i+k][j+k]==tcolor){
                    value++;
                }
                if(BoardPanel.board[i+k][j+k]==0){
                    flag++;
                    break;
                }
            }
            n=weight(value,flag);
            if(weightBoard[i][j]<n){
                weightBoard[i][j]=n;
            }
        }
        // '/' direction
        for(i=RectX2,j=RectY1;i>=RectX1;i--,j++){
            if(BoardPanel.board[i][j]!=0){
                continue;
            }
            value=0;flag=0;
            for(k=1;i+k<=RectX2 && k<5;k++){
                if(BoardPanel.board[i+k][j-k]==tcolor){
                    value++;
                    continue;
                }
                if(BoardPanel.board[i+k][j-k]==0){
                    flag++;
                    break;
                }
            }
            for(k=1;i-k>=RectX1 && k<5;k++){
                if(BoardPanel.board[i-k][j+k]==tcolor){
                    value++;
                }
                if(BoardPanel.board[i-k][j+k]==0){
                    flag++;
                    break;
                }
            }
            n=weight(value,flag);
            if(weightBoard[i][j]<n){
                weightBoard[i][j]=n;
            }
        }
    }
    /**
     * return weight
     * @param count
     * @param flag
     * @return
     */
    private int weight(int count, int flag)
    {
        int weight=0;
        switch(count){
            case 0:{
                if(flag>0) weight=200;
                else weight=0;
                break;
            }
            case 1:{
                if(flag>0) weight=1000;
                else weight=0;
                break;
            }
            case 2:{
                if(flag>0) weight=5000;
                else weight=0;
                break;
            }
            case 3:{
                if(flag>0) weight=8000;
                else weight=0;
                break;
            }
            case 4:{
                if(flag>0) weight=10000;
                else weight=0;
                break;
            }
        }
        return weight;
    }
    /**
     * search all board and find the better count position
     * @param count better position's number default value is 3
     */
    private void getBetter(int count){
        int [][] better = new int [count][2];
        int [][] tempArray = new int [15][15];
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                tempArray[i][j]=weightBoard[i][j];
            }
        }
        for(int i=0;i<count;i++){
            getBiggest(tempArray,better[i][0],better[i][1]);
        }
        bestX=better[0][0];bestY=better[0][1];
    }
    /**
     *
     * @param arr
     * @param x
     * @param y
     */
    private void getBiggest(int [][] arr,int x,int y){
        int [] temp=new int[2];
        int swt=arr[0][0],tmp=0;
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                if(arr[i][j]>swt){
                    temp[0]=i;temp[1]=j;
                    swt=arr[i][j];
                }
            }
        }
        x=temp[0];
        y=temp[1];
        arr[x][y]=0;
    }


}///:-)
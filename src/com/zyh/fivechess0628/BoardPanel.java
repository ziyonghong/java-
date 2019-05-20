package com.zyh.fivechess0628;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import java.io.*;

/**
 * <p>Title: chesser</p>
 * <p>Description: wu zi qi game</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */

public class BoardPanel extends JPanel{
    private  static Image white = null;
    private  static Image black = null;
    private static int xp;           // position of x to put chessman
    private static int yp;           // position of y to put chessman
    private Cursor handCursor;
    private Cursor defaultCursor;
    protected static int board[][];    // record of each position black or white
    private int color=1;             // record player's chess color 1=black 2=white    
    
    int STEPCOUNTER=0;
    int BASE=5;
    int DEEPTH=3;
    int MINDEEPTH=3;
    int MAX1=5;
    long INVALID=9000000;
    int chessBoard[][];    

    // draw the line number with x/y direction
    String line = "a        b        c       d        e        f        g        h         i         j        k         l        m       n        o";
    char [] rowNum1 = {'1','2','3','4','5','6','7','8','9'};
    char [] rowNum2={'1','0','1','1','1','2','1','3','1','4','1','5'};

     public BoardPanel(){
//        this.wzq=wz;
        try {
            handCursor=new Cursor(12);
            defaultCursor = new Cursor(0);
            board = new int[15][15];
//            black = wzq.black;
//            white = wzq.white;

          //  this.setBackground(Color.yellow);
            //this.setForeground(Color.BLUE);
          //  this.setBorder(BorderFactory.createLoweredBevelBorder());

            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gc){
        super.paint(gc);
        //this.setBackground(Color.gray);
        //this.invalidate();
        gc.setColor(Color.blue);
        //gc.setColor(new Color(255, 255, 240));
        // draw number of X direction
        gc.drawString(line,25,15);
        // draw number of Y direction
        for(int i=0;i<9;i++){
            gc.drawChars(rowNum1,i,1,10,35+i*30);
        }
        for(int i=9,j=0;i<15;i++,j+=2){
            gc.drawChars(rowNum2,j,2,10,35+i*30);
        }
        // draw the chess board
        for (int i = 0; i < 15; i++) {
            gc.drawLine(30, 30 + i * 30, 450, 30 + i * 30); //draw raw
            gc.drawLine(30 + i * 30, 30, 30 + i * 30, 450); //draw column
        }
        gc.drawLine(25, 25, 455, 25);
        gc.drawLine(25, 25, 25, 455);
        gc.drawLine(25, 455, 455, 455);
        gc.drawLine(455, 25, 455, 455);

        //when window repaint to replay the original status of board
        for(int i=0;i<15;i++){
            for (int j = 0; j < 15; j++) {
                xp=16+i*30;
                yp=16+j*30;
                if (board[i][j] == 1){
                    gc.setColor(Color.black);
                    gc.fillOval(xp,yp,28,28);
                    //gc.drawImage(black, 16 + i * 30, 16 + j * 30, this);
                }
                if (board[i][j] == 2){
                    gc.setColor(Color.white);
                    gc.fillOval(xp,yp,28,28);
                    //gc.drawImage(white, 16 + i * 30, 16 + j * 30, this);
                }
            }
        }
    }

    private void jbInit() throws Exception {
        this.addMouseMotionListener(new ChessWZQ_this_mouseMotionAdapter(this));
        this.addMouseListener(new ChessWZQ_this_mouseAdapter(this));
    }
    public int getColor(){
        return color;
    }
    public void setColor(int cr){
        color=cr;
    }
    /**
     * clear board when updated
     */
    public void clearBoard(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++)
                board[i][j]=0;
        }
        repaint();
    }

    void this_mouseClicked(MouseEvent e) {
        int x=0,y=0;
        if(color==0){
            return;
        }
        x=e.getX();
        y=e.getY();
        if(x>20&&x<460&&y>20&&y<460&&(x%30<10||x%30>20)&&(y%30<10||y%30>20)){
            if(ChessWZQ.beginFlag==false){
                ChessWZQ.label6.setText("You may not do that");
                return;
            }
            xp = x / 30 * 30 - 14;
            yp = y / 30 * 30 - 14;
            if (x % 30 > 20) {
                xp += 30;
            }
            if (y % 30 > 20) {
                yp += 30;
            }
            x=xp/30;y=yp/30;
            if(board[x][y]!=0){
                return;
            }
            // client 's board
            board[xp / 30][yp / 30] = color;

            Graphics g=this.getGraphics();
            if(color==1){//black
                g.setColor(Color.black);
            }
            if(color==2){//white
                g.setColor(Color.white);
            }
            g.fillOval(xp, yp, 28, 28);

            ChessWZQ.beginFlag=false;

            // setting coordinate (x,y)
//            x=xp/30;y=yp/30;
            if(ChessWZQ.ptocFlag==false){
                Message msg = new Message();
                msg.color = color;
                msg.coordinateX = x;
                msg.coordinateY = y;
                msg.type = 2; //press chessman

                //send message to server
                try {
                    ChessWZQ.out.writeObject(msg);
                }
                catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
           char cc = (char)(x+65);
           ChessWZQ.label6.setText("put on ( "+cc+" , "+(y+1)+" )");
           /// computer to put
           if(ChessWZQ.ptocFlag==true){
               if(judge(xp/30,yp/30,color)==true){
                   //System.out.println("people win");
                   Message ms = new Message();
                   ms.type=20;
                   strToCharArray("You",ms.msg);
                   try{
                       ChessWZQ.out.writeObject(ms);
                   }catch(IOException er){
                       er.printStackTrace();
                   }
               }
               ChessWZQ.beginFlag = false;
               int position = 0, bestX = 0, bestY = 0;
               Analyse aa = new Analyse(BoardPanel.board);
               position = aa.computerDo();
               bestY = position % 100 - 1;
               bestX = position / 100 - 1;
               updateBoard(bestX, bestY);
               drawChess(bestX, bestY);
               ChessWZQ.beginFlag = true; //for people to put
               cc=(char)(bestX+65);
               ChessWZQ.label6.setText("put on ( "+cc+" , "+(bestY+1)+" )");
               if(judge(bestX,bestY,ChessWZQ.cColor)==true){
                   //System.out.println("computer win");
                   Message msg = new Message();
                   msg.type=20;
                   strToCharArray("Computer",msg.msg);
                   try{
                       ChessWZQ.out.writeObject(msg);
                   }catch(IOException err){
                       err.printStackTrace();
                   }
               }
           }
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
     * return the chessman's x coordinate  0<=x<15
     * @return
     */
    protected int getXP(){
        return xp/30;
    }
    protected int getYP(){
        return yp/30;
    }
    /**
     * put a chessman and display it (x,y) position on the panel
     * draw chessman on (x,y)
     * @param x
     * @param y
     */
    public void drawChess(int x,int y){
        Graphics g=this.getGraphics();
        char cc = (char)(x+65);
        int temp = y+1;
        x=x*30+16;
        y=y*30+16;
        if(color==1)
            g.setColor(Color.white);
        else
            g.setColor(Color.black);
        g.fillOval(x, y, 28, 28);
        ChessWZQ.label6.setText("Player put on ( "+cc+" , "+temp+" )");
    }
    /**
     * update board status when B put a chessman
     * @param x B's chessman's X coordinate 0<=x<15
     * @param y B's chessman's Y coordinate 0<=y<15
     */
    public void updateBoard(int x,int y){
        int tcolor=0;
        if(color==1) tcolor=2;
        else tcolor=1;
        board[x][y]=tcolor;
    }

    public char intToChar(int x){
        char temp='\0';
        if(x>=0&&x<=9)
            temp=(char)(48+x);
        else if(x>=10 &&x<=15){
            temp=(char)(55+x);
        }
        return temp;
    }

    /**
     * mouseMoved Event
     * @param e
     */
    void this_mouseMoved(MouseEvent e) {
        int x=0,y=0;
        x=e.getX();
        y=e.getY();
        if(x>20&&x<460&&y>20&&y<460&&(x%30<10||x%30>20)&&(y%30<10||y%30>20)){
            this.setCursor(handCursor); //HAND_CURSOR
        }
        else{
            this.setCursor(defaultCursor);
        }
    }
    /**
     * judge if a man win the game
     * @param x  the newest kid's x coordinate
     * @param y  the newest kid's y coordinate
     * @return
     */
    protected boolean judge(int x,int y,int clr){
        int i=0,j=0,count=0;
        // x direction
        for(i=0,count=0;x-i>=0&&i<5;i++){
            if (clr==board[x-i][y]){
                count++;
            }else{
                break;
            }
  //          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5)
                return true;
        }
        for(i=1;x+i<15&&i<5;i++){
            if(clr==board[x+i][y]){
                count++;
            }else{
                break;
            }
            if(count==5)
                return true;
        }
        // y direction
        for(i=0,count=0;y-i>=0&&i<5;i++){
            if (clr==board[x][y-i]){
                count++;
            }else{
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5)
                return true;
        }
        for(i=1;y+i<15&&i<5;i++){
            if(clr==board[x][y+i]){
                count++;
            }else{
                break;
            }
    //        System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5)
                return true;
        }
        // '\' direction
        for(i=0,count=0;x-i>=0&&y-i>=0&&i<5;i++){
            if(clr==board[x-i][y-i]){
                count++;
            }else{
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5)
                return true;
        }
        for(i=1;x+i<15&&y+i<15&&i<5;i++){
            if(clr==board[x+i][y+i]){
                count++;
            }else{
                break;
            }
  //          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5){
                return true;
            }
        }
        // '/' direction
        for(i=0,count=0;x+i<15 && y-i>=0 &&i<5; i++){
            if(clr==board[x+i][y-i]){
                count++;
            }else{
                count=0;
            }
  //          System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5)
                return true;
        }
        for(i=1;x-i>=0 && y+i<15 &&i<5;i++){
            if(clr==board[x-i][y+i]){
                count++;
            }else{
                break;
            }
//            System.out.println("( "+x+" , "+y+" )"+"count = "+count);
            if(count==5){
                return true;
            }
        }
        return false;
    }
    class Queue{
        int position;
        long mark;
    } ;
    
    class Analyse {
    
    Analyse(int chessc[][]){
        int i, j;
        chessBoard = new int[17][17];
        for (i = 0; i <= 16; i++) {
            for (j = 0; j <= 16; j++) {
                if (i == 0 || j == 0 || i == 16 || j == 16) {
                    chessBoard[i][j] = 4;
                }
                else {
                    chessBoard[i][j] = chessc[i - 1][j - 1];
                }
            }
        }
    }
    /**
     *
     * @param base
     * @param pow
     * @return
     */
    private long pow(int base, int pow){
       int i;
       long result=1;
       for(i=1;i<=pow;i++){
           result*=base;
       }
       return result;
   }
   /**
    *
    * @param x
    * @param y
    * @param side
    * @return
    */
   private long analyseUd(int x, int y, int side){
       int tt[][] = new int[17][17];
       int i, j;
       int tempx, tempy;
       long mark = 0;
       int base = BASE;
       int uppersign = 0;
       int downsign = 0;
       int c_count = 1;

       for (i = 0; i < 17; i++) {
           for (j = 0; j < 17; j++) {
               tt[i][j] = chessBoard[i][j];
           }
       }
       tt[y][x] = side;
      // up and down
       tempx = x;
       tempy = y;
       if (tt[tempy - 1][tempx] != side) {
           if (tt[tempy - 1][tempx] == 0) {
               uppersign = 1;
           }
           if (tt[tempy - 1][tempx] != 0) {
               uppersign = 0;
           }
       }
       else {
           tempy -= 1;
           while (tt[tempy][tempx] == side) {
               c_count += 1;
               tempy--;
           }
           if (tt[tempy][tempx] == 0) {
               uppersign = 1;
           }
           if (tt[tempy][tempx] != 0) {
               uppersign = 0;
           }
       }
       tempx = x;
       tempy = y;
       if (tt[tempy + 1][tempx] != side) {
           if (tt[tempy + 1][tempx] == 0) {
               downsign = 1;
           }
           if (tt[tempy + 1][tempx] != 0) {
               downsign = 0;
           }
       }
       else {
           tempy += 1;
           while (tt[tempy][tempx] == side) {
               c_count += 1;
               tempy++;
           }
           if (tt[tempy][tempx] == 0) {
               downsign = 1;
           }
           if (tt[tempy][tempx] != 0) {
               downsign = 0;
           }
       }
       mark += pow(base, c_count);
       if ( (uppersign + downsign) > 0) {
           if ( (uppersign + downsign) == 2) {
               mark *= (uppersign + downsign);
           }
           if ( (uppersign + downsign) == 1) {
               mark = mark / 2;
           }
       }
       else if (c_count == 5) {
           mark *= 4;
       }
       else {
           mark = 0;
       }
       if (c_count == 5) {
           mark += INVALID;
       }
       return mark;
   }
   /**
    *
    * @param x
    * @param y
    * @param side
    * @return
    */
   private long analyseLr(int x, int y, int side){
       int tt[][] = new int[17][17];
       int i, j,tx, ty;
       long mark = 0;

       int base = BASE,uppersign = 0,downsign = 0,c_count = 1;
       for (i = 0; i < 17; i++) {
           for (j = 0; j < 17; j++) {
               tt[i][j] = chessBoard[i][j];
           }
       }
       tt[y][x] = side;
       // left and right
       tx = x;
       ty = y;
       if (tt[ty][tx - 1] != side) {
           if (tt[ty][tx - 1] == 0) {
               uppersign = 1;
           }
           if (tt[ty][tx - 1] != 0) {
               uppersign = 0;
           }
       }
       else {
           tx -= 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx--;
           }
           if (tt[ty][tx] == 0) {
               uppersign = 1;
           }
           if (tt[ty][tx] != 0) {
               uppersign = 0;
           }
       }
       tx = x;
       ty = y;
       if (tt[ty][tx + 1] != side) {
           if (tt[ty][tx + 1] == 0) {
               downsign = 1;
           }
           if (tt[ty][tx + 1] != 0) {
               downsign = 0;
           }
       }
       else {
           tx += 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx++;
           }
           if (tt[ty][tx] == 0) {
               downsign = 1;
           }
           if (tt[ty][tx] != 0) {
               downsign = 0;
           }
       }
       mark += pow(base, c_count);
       if ( (uppersign + downsign) > 0) {
           if ( (uppersign + downsign) == 2) {
               mark *= (uppersign + downsign);
           }
           if ( (uppersign + downsign) == 1) {
               mark = mark / 2;
           }
       }
       else if (c_count == 5) {
           mark *= 4;
       }
       else {
           mark = 0;
       }
       if (c_count == 5) {
           mark += INVALID;
       }
       return mark;
   }
   /**
    *
    * @param x
    * @param y
    * @param side
    * @return
    */
   private long analyseLdru(int x, int y, int side){
       int tt[][] = new int[17][17];
       int i, j;
       int tx, ty;
       long mark = 0;

       int base = BASE;
       int uppersign = 0;
       int downsign = 0;
       int c_count = 1;
       for (i = 0; i < 17; i++) {
           for (j = 0; j < 17; j++) {
               tt[i][j] = chessBoard[i][j];
           }
       }
       tt[y][x] = side;
       /* left down and right upper */
       tx = x;
       ty = y;
       if (tt[ty - 1][tx - 1] != side) {
           if (tt[ty - 1][tx - 1] == 0) {
               uppersign = 1;
           }
           if (tt[ty - 1][tx - 1] != 0) {
               uppersign = 0;
           }
       }
       else {
           tx -= 1;
           ty -= 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx--;
               ty--;
           }
           if (tt[ty][tx] == 0) {
               uppersign = 1;
           }
           if (tt[ty][tx] != 0) {
               uppersign = 0;
           }
       }
       tx = x;
       ty = y;
       if (tt[ty + 1][tx + 1] != side) {
           if (tt[ty + 1][tx + 1] == 0) {
               downsign = 1;
           }
           if (tt[ty + 1][tx + 1] != 0) {
               downsign = 0;
           }
       }
       else {
           tx += 1;
           ty += 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx++;
               ty++;
           }
           if (tt[ty][tx] == 0) {
               downsign = 1;
           }
           if (tt[ty][tx] != 0) {
               downsign = 0;
           }
       }
       mark += pow(base, c_count);
       if ( (uppersign + downsign) > 0) {
           //mark*=(uppersign+downsign);
           if ( (uppersign + downsign) == 2) {
               mark *= (uppersign + downsign);
           }
           if ( (uppersign + downsign) == 1) {
               mark = mark / 2;
           }
       }
       else if (c_count == 5) {
           mark *= 4;
       }
       else {
           mark = 0;
       }
       if (c_count == 5) {
           mark += INVALID;
       }
       return mark;
   }
   private long analyseRdlu(int x, int y, int side){
       int tt[][] = new int[17][17];
       int i, j;
       int tx, ty;
       long mark = 0;

       int base = BASE;
       int uppersign = 0;
       int downsign = 0;
       int c_count = 1;
       for (i = 0; i < 17; i++) {
           for (j = 0; j < 17; j++) {
               tt[i][j] = chessBoard[i][j];
           }
       }
       tt[y][x] = side;
       /* left down and right upper */
       tx = x;
       ty = y;
       if (tt[ty - 1][tx + 1] != side) {
           if (tt[ty - 1][tx + 1] == 0) {
               uppersign = 1;
           }
           if (tt[ty - 1][tx + 1] != 0) {
               uppersign = 0;
           }
       }
       else {
           tx += 1;
           ty -= 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx++;
               ty--;
           }
           if (tt[ty][tx] == 0) {
               uppersign = 1;
           }
           if (tt[ty][tx] != 0) {
               uppersign = 0;
           }
       }
       tx = x;
       ty = y;
       if (tt[ty + 1][tx - 1] != side) {
           if (tt[ty + 1][tx - 1] == 0) {
               downsign = 1;
           }
           if (tt[ty + 1][tx - 1] != 0) {
               downsign = 0;
           }
       }
       else {
           tx -= 1;
           ty += 1;
           while (tt[ty][tx] == side) {
               c_count += 1;
               tx--;
               ty++;
           }
           if (tt[ty][tx] == 0) {
               downsign = 1;
           }
           if (tt[ty][tx] != 0) {
               downsign = 0;
           }
       }
       mark += pow(base, c_count);
       if ( (uppersign + downsign) > 0) {
           if ( (uppersign + downsign) == 2) {
               mark *= (uppersign + downsign);
           }
           if ( (uppersign + downsign) == 1) {
               mark = mark / 2;
           }
       }
       else if (c_count == 5) {
           mark *= 4;
       }
       else {
           mark = 0;
       }
       if (c_count == 5) {
           mark += INVALID;
       }
       return mark;
   }
   /**
    *
    * @param x
    * @param y
    * @param side
    * @return
    */
   private long analyse(int x, int y, int side){
       long mark = 0;
       mark += analyseUd(x, y, side);
       mark += analyseLr(x, y, side);
       mark += analyseLdru(x, y, side);
       mark += analyseRdlu(x, y, side);
       return mark;
   }
   /**
    *
    * @param chess
    * @param deepth
    * @return
    */
   private Queue searchPoint(int chess[][],int deepth){
       //temp
       int cx, cy;
       //int newdeepth;
       char s[] = new char[10];
       //temp
       Queue pq[] = null, pq_temp[] = null, pq_final;
       int temp_chess[][] = new int[17][17];
       long mark = 0;
       int duce;
       int i, j;
       int m, n, p, q;
       int media;
       int MAX;
       int k, b;
       //mark
       MAX=MAX1<=(225-STEPCOUNTER)?MAX1:(225-STEPCOUNTER);
            if(MAX==(225-STEPCOUNTER)){
        MINDEEPTH=1;
            }
       pq = new Queue[MAX + 1];
       for (m = 0; m < MAX; m++) {
           pq[m] = new Queue();
       }
       for (m = 0; m < MAX; m++) {
           pq[m].mark = 0;
           pq[m].position = 0;
       }
       for (i = 1; i <= 15; i++) {
         //  System.out.println();
           for (j = 1; j <= 15; j++) {
               if (chess[i][j] != 0) {
                   mark = 0;
               }
               else {
                   mark = analyse(j, i, 1) / 2 + analyse(j, i, 2);
           //        System.out.print("\t" + mark);
               }

               //tempboard[i][j]=mark;
               for (m = 0; m < MAX; m++) {
                   if (mark > pq[m].mark) {
                       for (n = MAX - 1; n > m; n--) {
                           pq[n].mark = pq[n - 1].mark;
                           pq[n].position = pq[n - 1].position;
                       }
                       pq[m].mark = mark;
                       pq[m].position = i * 100 + j;
                       break;
                   }
               }
           }
       }
       //newdeepth=maxdeepth;
       if (pq[0].mark >= INVALID / 2) {
           MINDEEPTH = deepth;
       }
       if (deepth < MINDEEPTH) {
           for (m = 0; m < MAX; m++) {
               for (p = 0; p <= 16; p++) {
                   for (q = 0; q <= 16; q++) {
                       temp_chess[p][q] = chess[p][q];
                   }
               }
               if (deepth % 2 == 1) {
                   media = 2;
               }
               else {
                   media = 1;
               }
               temp_chess[pq[m].position / 100][pq[m].position % 100] = media;
               pq[m] = searchPoint(temp_chess, deepth + 1);
           }
       }
       pq_temp = new Queue[MAX + 1];
       for (m = 0; m < MAX; m++) {
           pq_temp[m] = new Queue();
       }

       for (p = 0; p < MAX; p++) {
           pq_temp[p].mark = 0;
           pq_temp[p].position = 0;
       }
       for (p = 0; p < MAX; p++) {
           for (q = 0; q < MAX; q++) {
               if (pq[p].mark > pq_temp[q].mark) {
                   for (i = MAX - 1; i > q; i--) {
                       pq_temp[i] = pq_temp[i - 1];
                   }
                   pq_temp[q] = pq[p];
                   break;
               }
           }
       }
       pq_final = pq_temp[0];
       return pq_final;
   }
   public int computerDo(){
       int position = 0;
       int cx, cy;
       position = (searchPoint(chessBoard, 3)).position;
       cx = position % 100;
       cy = position / 100;
//       System.out.print("\n" + cy + "\t" + cx + "\n");
       if (cx == 0 && cy == 0) {
           return 1;
       }
       return position;
   }
} ///:-)


}///:-)
/**
 * mouse Adapter
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */
class ChessWZQ_this_mouseAdapter extends java.awt.event.MouseAdapter {
    BoardPanel adaptee;

    ChessWZQ_this_mouseAdapter(BoardPanel adaptee) {
        this.adaptee = adaptee;
    }
    public void mouseClicked(MouseEvent e) {
        adaptee.this_mouseClicked(e);
    }
}///:-)
/**
 * mouse Adapter
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: e-top</p>
 * @author cylix
 * @version 1.0
 */
class ChessWZQ_this_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
    BoardPanel adaptee;

    ChessWZQ_this_mouseMotionAdapter(BoardPanel adaptee) {
        this.adaptee = adaptee;
    }
    public void mouseMoved(MouseEvent e) {
        adaptee.this_mouseMoved(e);
    }
}///:-)

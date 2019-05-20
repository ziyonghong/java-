package com.zyh.weather0707;



import java.net.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import javax.swing.*;

public class WebFilter {
    private String urladd , imgtag , mcity;
    private LinkedList<String> webcontent ;
    /** 去除HTML的标签内容 ，转化html -> 文本  */
    public WebFilter(String add , String imgUrl) {
        urladd = add;
        imgtag = imgUrl;
//        mcity = placein;
        webcontent = new LinkedList();
    }
    public void getData() throws IOException ,SocketTimeoutException {
        URLConnection connection;
        try {
            //set connection
            URL url = new URL(urladd);
            connection = url.openConnection();
            connection.setConnectTimeout(10000);
           // System.out.println(connection);
            for(int i =0 ;i<5;i++)
                try {
                    connection.connect();
                    break;
                } catch (SocketTimeoutException ex) {
                    // timeout retry 5times.
                    throw ex;
                } catch (IOException ex){
                    throw ex;
                }
           
            //deal city
            Pattern htmlC = Pattern.compile("(>[^&^<]\\s?.+\\s?</{1})|(img "+imgtag +"=\"{1}.*\"{1}\\s{1})" ,Pattern.CASE_INSENSITIVE);
            Scanner in = new Scanner(connection.getInputStream());
            String str ;

            while(in.hasNextLine()){
                str = in.findInLine(htmlC);
                if(str != null){
                    webcontent.add(str);                                            
                }
                in.nextLine();
            }
            
        } catch (UnknownHostException ex1){
            throw ex1;
        }catch (IOException ex){
            ex.printStackTrace();
            throw ex;          
        }
        //for debug
//        printToFile(webcontent);
    }
    
    public  void adapted(Map<String,String> weather){
        String key, value, temp;
        key=null;
        try {       
            for(int i =0 ;i<27;i++)
                webcontent.removeFirst();
            for(int i =0;i<4;i++)
                webcontent.removeLast();

            Iterator<String> iter = webcontent.iterator();
            key = "city";
            value =delTag(webcontent.get(0));
            value = value.replace("&gt;",".");
            weather.put(key,value);
            key = "reportTime";
            value = delTag(webcontent.get(2)).replace("预报发布时间","预报时间");
            weather.put(key,value);
            // get 5 days data
            int iNo = 0 , iNoindex = 0;
            Pattern dateHead = Pattern.compile("^>\\s?[0-1]?[0-9]{1}.*[0-3]?[0-9].*\\s?</$");
            Pattern indexNumber = Pattern.compile("^>.?[\u4e00-\u9fa5]{1,5}指数</{1}$");
            while(iter.hasNext()){
                temp =iter.next();
                if(dateHead.matcher(temp).matches()){
                    key="day" + iNo;
                    value = delTag(temp);
                    //got image url
                    temp=delTag(iter.next()) + delTag(iter.next()); 
                    value = value + ": " + delTag(iter.next()).replace(" ","-") + "," + delTag(iter.next()); 
                    weather.put(key,value);
                    //stroe image url in one key
                    key = "day" + iNo +"_image";
                    weather.put(key,temp);
                    iNo++;
                }
                if(indexNumber.matcher(temp).matches()){
                    key = "detail_" + iNoindex;
                    String s1,s2;
                    s1=iter.next();
                    s2=iter.next();
                    value=">>>" + delTag(temp) + " :  " ;
                    if(Pattern.matches(">.+</" , s2) && Pattern.matches(">.+</" , s1) )
                        value = value+ delTag(s1) + "<<<\n    "+delTag(s2)+"\n";
                    else{
                        if(Pattern.matches(">.+</" , s1))
                            value = value+  "<<<\n    " +delTag(s1) + "\n";
                        if(Pattern.matches(">.+</" , s2))
                            value = value+  "<<<\n    " +delTag(s2) + "\n";
                    }
                    //  img src="imageszhishu_10.gif" width="50"
                    value = value.replaceAll("\\s?img\\s?src=\".*\\.gif\"\\s?width=\"[0-9]{0,2}\"\\s?"," "); 
                    weather.put(key,value);
                    iNoindex++;
                }
            }
        }catch (NoSuchElementException ex){
        }catch (java.lang.IndexOutOfBoundsException ex){
        }
        //for debug
//        printToFile(weather);
    }
    

    private String delTag(String str){
        str =str.replaceAll("<\\s?.*\\s?>","");
        str =str.replace("/","");
        str =str.replace(">","");
        str =str.replace("<","");
        str = str.trim();
        return str;
    }
    
    
    private void printToFile(Map<String,String> testm){
        File file = new File("map.txt");
        try {
            PrintWriter out =new PrintWriter(file);
            for(Map.Entry<String,String> entry : testm.entrySet())
                out.println(entry);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
              
    }
    private void printToFile(List<String> testm){
        File file = new File("filted_Html.txt");
        try {
            PrintWriter out =new PrintWriter(file);
            for(String entry : testm)
                out.println(entry);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
              
    }
      
}
    
    
    

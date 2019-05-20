package com.zyh.day0917;
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.OutputStreamWriter; 
import java.util.ArrayList; 
import java.util.List; 
   
public class CSVUtil2 { 
   
    public static void main(String[] args) { 
        
         
       
   
        // 测试 导入 
        List<String> dataList = importCsv(new File("D:/test.csv")); 
        if (dataList != null && !dataList.isEmpty()) { 
            for (String data : dataList) { 
              //  System.out.println(data); 
            } 
        } 
        System.out.println(dataList.size());
        
        boolean isSuccess = exportCsv(new File("D:/test.csv"), dataList); 
       
        System.out.println(isSuccess); 
    } 
   
    /**
     * 导出
     * 
     * @param file
     *            csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList
     *            数据
     * @return
     */ 
    public static boolean exportCsv(File file, List<String> dataList) { 
        boolean isSucess = false; 
   
        FileOutputStream out = null; 
        OutputStreamWriter osw = null; 
        BufferedWriter bw = null; 
        try { 
        	System.out.println(file);
            out = new FileOutputStream(file); 
            osw = new OutputStreamWriter(out); 
            bw = new BufferedWriter(osw); 
            if (dataList != null && !dataList.isEmpty()) { 
            	for (int j = 0; j < 10; j++) {
            		dataList.remove(j);
				}
            	//dataList.remove(1);
            	
            	
            	
                for (String data : dataList) { 
                    bw.append(data).append("\r\n"); 
                } 
            } 
            isSucess = true; 
        } catch (Exception e) { 
            isSucess = false; 
        } finally { 
            if (bw != null) { 
                try { 
                    bw.close(); 
                    bw = null; 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            if (osw != null) { 
                try { 
                    osw.close(); 
                    osw = null; 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            if (out != null) { 
                try { 
                    out.close(); 
                    out = null; 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
        } 
   
        return isSucess; 
    } 
   
    /**
     * 导入
     * 
     * @param file
     *            csv文件(路径+文件)
     * @return
     */ 
    public static List<String> importCsv(File file) { 
        List<String> dataList = new ArrayList<String>(); 
   
        BufferedReader br = null; 
        try { 
            br = new BufferedReader(new FileReader(file)); 
            String line = ""; 
            while ((line = br.readLine()) != null) { 
                dataList.add(line); 
            } 
        } catch (Exception e) { 
        } finally { 
            if (br != null) { 
                try { 
                    br.close(); 
                    br = null; 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
        } 
   
        return dataList; 
    } 
   
} 
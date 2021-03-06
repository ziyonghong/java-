package com.zyh.mofang0607;

//Finishing www.codefans.net


import javax.swing.JFrame ;
import javax.swing.JTable ;
import javax.swing.JScrollPane ;
import java.util.Vector ;
import java.awt.Container ;
import javax.swing.table.DefaultTableModel ;
import java.awt.BorderLayout ;
import java.io.Serializable ;
import javax.swing.JFileChooser ;
import java.io.FileOutputStream ;
import java.io.ObjectOutputStream ;
import javax.swing.JOptionPane ;

class MoFanfZhuangTaiSouSuo implements Serializable 
{
  Vector bianHuanTable=new Vector();
  Vector statusList=new Vector();
  
  
  void setupBianHuanBiao()
  {
      //创建状态变化表的通用算法。
      //输入:初始状态
      //输出1：变化表，填入构成int数组，一个数组代表一行
      //输出2：状态链表
      
      //这里往链表里加入初始状态对象,这里是一个魔方状态对象
      statusList.add(new MofangStatusMessage("new"));
      
      //第一次往表里填入第一行的整型数组
      int i=0 ;
      
      //声明每次处理的状态对象
      MofangStatusMessage inMofangStatusMessage ;
      
      //处理到下一个状态为空为止
      while(i<statusList.size())
      {
          System.out.println(String.valueOf(statusList.size()));
          System.out.println(String.valueOf(i));
          //if(i>100){break;}
          
          //取当前处理的状态
          inMofangStatusMessage=(MofangStatusMessage)(statusList.get(i));
          
          
          //准备一个空的数组
          //N为变化规则数量
          //int N=27;
          int[]statusNo=
          {
              0,0,0,0,0,0,0,0,0,
              0,0,0,0,0,0,0,0,0,
              0,0,0,0,0,0,0,0,0,
          }
          ;
          
          //取不同的规则，这里共27个
          for(int type=0;type<3;type++)
          for(int layer=0;layer<3;layer++)
          for(int arg=0;arg<3;arg++)
          {
              //根据输入状态和当前的规则，调用函数计算得到输出状态
              MofangStatusMessage outMofangStatusMessage=jiSuanMofangStatusMessage(inMofangStatusMessage,type,layer,arg);
              
              //调用函数，将产生的结点加入到链表中，如果是新结点，返回一个新的编号。
              //否则返回原有编号
              int outNumber=addTolist(outMofangStatusMessage);
              
              //将该编号填入表中
              statusNo[type*9+layer*3+arg]=outNumber ;
              
          }
          
          //将得到的N个编号形成的数组加入变化表
          bianHuanTable.add(statusNo);
          
          //如果有，处理下一个状态
          i++;
      }
      
      //调用打印输出函数，输出变化表
      //
  }
  //根据规则生成下一个状态
  MofangStatusMessage jiSuanMofangStatusMessage(MofangStatusMessage inMofangStatusMessage,int type,int layer,int arg)
  {
      //--------------------------------------
      //分别对应着type=012,layer=012,arg=90 180 -90组合共计27种变化规则
      //例如：第一个为规则type=0,layer=0,arg=90的变化后的结果
      int[]argArray=
      {
          90,180,-90 
      }
      ;
      //arg的取值表。变化数组下标即可取到每一种值
      //---------------------------------------
      //复制状态
      MofangStatusMessage newMofangStatusMessage=new MofangStatusMessage(inMofangStatusMessage);
      //变化
      newMofangStatusMessage.moFang3DRotate(type,layer,argArray[arg]);
      //返回新状态
      return newMofangStatusMessage ;
  }
  
  //不允许重复地加入链表，返回位置
  int addTolist(MofangStatusMessage outMofangStatusMessage)
  {
      MofangStatusMessage willCompareMofangStatusMessage ;
      int i ;
      for(i=0;i<statusList.size();i++)
      {
          //依次取每一个状态
          willCompareMofangStatusMessage=(MofangStatusMessage)(statusList.get(i));
          
          //调用比较函数，如果相等，则不加入链表，返回位置
          if(compareMofangStatusMessage(willCompareMofangStatusMessage,outMofangStatusMessage)==0)
          {
              return i ;
          }
      }
      
      //没有一个相等，则将新状态加入链表末尾
      statusList.add(outMofangStatusMessage);
      return i ;
      
  }
  //比较两个状态是否相等
  int compareMofangStatusMessage(MofangStatusMessage m1,MofangStatusMessage m2)
  {
      /*	for(int i=0;i<3;i++)
      		for(int j=0;j<3;j++)
      		for(int k=0;k<3;k++)
      		{
      			if(m1.dataMessage[i][j][k].blockCenter.x!=m2.dataMessage[i][j][k].blockCenter.x)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockCenter.y!=m2.dataMessage[i][j][k].blockCenter.y)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockCenter.z!=m2.dataMessage[i][j][k].blockCenter.z)
      			{return -1;}
      
      			if(m1.dataMessage[i][j][k].blockEx.x!=m2.dataMessage[i][j][k].blockEx.x)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEx.y!=m2.dataMessage[i][j][k].blockEx.y)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEx.z!=m2.dataMessage[i][j][k].blockEx.z)
      			{return -1;}
      
      			if(m1.dataMessage[i][j][k].blockEy.x!=m2.dataMessage[i][j][k].blockEy.x)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEy.y!=m2.dataMessage[i][j][k].blockEy.y)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEy.z!=m2.dataMessage[i][j][k].blockEy.z)
      			{return -1;}
      
      			if(m1.dataMessage[i][j][k].blockEz.x!=m2.dataMessage[i][j][k].blockEz.x)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEz.y!=m2.dataMessage[i][j][k].blockEz.y)
      			{return -1;}
      			if(m1.dataMessage[i][j][k].blockEz.z!=m2.dataMessage[i][j][k].blockEz.z)
      			{return -1;}
      		}
      	return 0;
      
      	*/
      
      //相对位置算法：可以使魔方的状态数为24分之一
      
      //=============================
      int[]p1=
      {
          0,0,0 
      }
      ;
      int[]p2=
      {
          0,0,0 
      }
      ;
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEx.x ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEx.y ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEx.z ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEx.x ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEx.y ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEx.z ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      //====================
      
      
      //=============================
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEy.x ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEy.y ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEy.z ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEy.x ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEy.y ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEy.z ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEz.x ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEz.y ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEz.z ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEz.x ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEz.y ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEz.z ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEx.x*2 ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEx.y*2 ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEx.z*2 ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEx.x*2 ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEx.y*2 ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEx.z*2 ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEy.x*2 ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEy.y*2 ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEy.z*2 ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEy.x*2 ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEy.y*2 ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEy.z*2 ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      
      {
          //-----------------
          p1[0]=m1.dataMessage[0][0][0].blockCenter.x+m1.dataMessage[0][0][0].blockEz.x*2 ;
          p1[1]=m1.dataMessage[0][0][0].blockCenter.y+m1.dataMessage[0][0][0].blockEz.y*2 ;
          p1[2]=m1.dataMessage[0][0][0].blockCenter.z+m1.dataMessage[0][0][0].blockEz.z*2 ;
          //----------------
          p2[0]=m2.dataMessage[0][0][0].blockCenter.x+m2.dataMessage[0][0][0].blockEz.x*2 ;
          p2[1]=m2.dataMessage[0][0][0].blockCenter.y+m2.dataMessage[0][0][0].blockEz.y*2 ;
          p2[2]=m2.dataMessage[0][0][0].blockCenter.z+m2.dataMessage[0][0][0].blockEz.z*2 ;
          //------------------------
          if(compareBianHaoANDXiangDuiZiZhuan(m1,p1,m2,p2)==-1)
          {
              return-1 ;
          }
          
      }
      //====================
      
      return 0 ;
  }
  
  //根据状态1的位置和状态2的位置，比较编号和相对于000的自转是否相等
  int compareBianHaoANDXiangDuiZiZhuan(MofangStatusMessage m1,int[]p1,MofangStatusMessage m2,int[]p2)
  {
      
      int[]bianHao1=getBianHaoByPosition(m1,p1[0],p1[1],p1[2]);
      int[]bianHao2=getBianHaoByPosition(m2,p2[0],p2[1],p2[2]);
      //----------------------------------
      for(int i=0;i<3;i++)
      {
          if(bianHao1[i]!=bianHao2[i])
          {
              return-1 ;
          }
      }
      //----------------------------------------
      //----------------------------------
      
      int[][]arrayEXYZ1=
      {
          {
              m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEx.x,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEy.x,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEz.x 
          }
          ,
          {
              m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEx.y,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEy.y,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEz.y 
          }
          ,
          {
              m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEx.z,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEy.z,m1.dataMessage[bianHao1[0]][bianHao1[1]][bianHao1[2]].blockEz.z 
          }
          ,
      }
      ;
      int[][]arrayA1=
      {
          {
              m1.dataMessage[0][0][0].blockEx.x,m1.dataMessage[0][0][0].blockEy.x,m1.dataMessage[0][0][0].blockEz.x 
          }
          ,
          {
              m1.dataMessage[0][0][0].blockEx.y,m1.dataMessage[0][0][0].blockEy.y,m1.dataMessage[0][0][0].blockEz.y 
          }
          ,
          {
              m1.dataMessage[0][0][0].blockEx.z,m1.dataMessage[0][0][0].blockEy.z,m1.dataMessage[0][0][0].blockEz.z 
          }
          ,
      }
      ;
      int[][]arrayA1Yi=qiuYi(arrayA1);
      int[][]arrayEXYZ1XiangDui=jiSuanJuZhen(arrayA1Yi,arrayEXYZ1);
      //-------------------------------
      int[][]arrayEXYZ2=
      {
          {
              m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEx.x,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEy.x,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEz.x 
          }
          ,
          {
              m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEx.y,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEy.y,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEz.y 
          }
          ,
          {
              m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEx.z,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEy.z,m2.dataMessage[bianHao2[0]][bianHao2[1]][bianHao2[2]].blockEz.z 
          }
          ,
      }
      ;
      int[][]arrayA2=
      {
          {
              m2.dataMessage[0][0][0].blockEx.x,m2.dataMessage[0][0][0].blockEy.x,m2.dataMessage[0][0][0].blockEz.x 
          }
          ,
          {
              m2.dataMessage[0][0][0].blockEx.y,m2.dataMessage[0][0][0].blockEy.y,m2.dataMessage[0][0][0].blockEz.y 
          }
          ,
          {
              m2.dataMessage[0][0][0].blockEx.z,m2.dataMessage[0][0][0].blockEy.z,m2.dataMessage[0][0][0].blockEz.z 
          }
          ,
      }
      ;
      int[][]arrayA2Yi=qiuYi(arrayA2);
      int[][]arrayEXYZ2XiangDui=jiSuanJuZhen(arrayA2Yi,arrayEXYZ2);
      //---------------------------------
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      {
          if(arrayEXYZ1XiangDui[i][j]!=arrayEXYZ2XiangDui[i][j])
          {
              return-1 ;
          }
      }
      return 0 ;
  }
  
  //计算两个3X3矩阵的乘法，用于相对坐标系的坐标变换
  int[][]jiSuanJuZhen(int[][]intArray,int[][]aChengShuZhen)
  {
      //输入矩阵放右边
      int[][]outArray=
      {
          {
              0,0,0,
          }
          ,
          {
              0,0,0,
          }
          ,
          {
              0,0,0 
          }
          ,
      }
      ;
      // MyPrintln.println("乘法计算");
      // MyPrintln.println(aChengShuZhen,3,3);
      // MyPrintln.println("in");
      // MyPrintln.println(intArray,3,3);
      
      //
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      {
          outArray[i][j]=0 ;
          for(int k=0;k<3;k++)
          {
              outArray[i][j]+=aChengShuZhen[i][k]*intArray[k][j];
          }
      }
      //
      //MyPrintln.println("out");
      //MyPrintln.println(outArray,3,3);
      return outArray ;
  }
  
  //计算逆矩阵
  int[][]qiuYi(int[][]inArray)
  {
      //MyPrintln.println (inArray,3,3);
      int[][]outArray=
      {
          {
              1,0,0 
          }
          ,
          {
              0,1,0 
          }
          ,
          {
              0,0,1 
          }
          ,
      }
      ;
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              if((inArray[i][j]==1||inArray[i][j]==-1)&&(j!=i))
              {
                  for(int k=0;k<3;k++)
                  {
                      int l ;
                      l=inArray[k][i];
                      inArray[k][i]=inArray[k][j];
                      inArray[k][j]=l ;
                      
                      l=outArray[k][i];
                      outArray[k][i]=outArray[k][j];
                      outArray[k][j]=l ;
                  }
                  
              }
              
          }
      }
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              if(inArray[i][j]==-1)
              {
                  for(int k=0;k<3;k++)
                  {
                      inArray[k][j]*=-1 ;
                      outArray[k][j]*=-1 ;
                  }
                  
              }
              
          }
      }
      //MyPrintln.println (inArray,3,3);
      //MyPrintln.println (outArray,3,3);
      return outArray ;
      
  }
  
  void pritlnbianHuanTableToWindow(JTable table)
  {
      //创建表头
      String[]tableHeads=
      {
          "编号","状态数据",
          
          "X 0 90","X 0 180","X 0 -90",
          "X 1 90","X 1 180","X 1 -90",
          "X 2 90","X 2 180","X 2 -90",
          
          "Y 0 90","Y 0 180","Y 0 -90",
          "Y 1 90","Y 1 180","Y 1 -90",
          "Y 2 90","Y 2 180","Y 2 -90",
          
          "Z 0 90","Z 0 180","Z 0 -90",
          "Z 1 90","Z 1 180","Z 1 -90",
          "Z 2 90","Z 2 180","Z 2 -90",
      }
      ;
      Vector tableHeadName=new Vector();
      
      for(int l=0;l<tableHeads.length;l++)
      {
          tableHeadName.add(tableHeads[l]);
      }
      
      
      Vector row=new Vector();
      for(int i=0;i<statusList.size();i++)
      {
          //if(i>100){break;}
          
          //处理每一行=cell
          Vector cell=new Vector();
          
          //编号
          cell.add(String.valueOf(i));
          
          //状态数据
          MofangStatusMessage willShowMofangStatusMessage ;
          willShowMofangStatusMessage=(MofangStatusMessage)(statusList.get(i));
          String statusDataToString="" ;
          for(int i1=0;i1<3;i1++)
          for(int j1=0;j1<3;j1++)
          for(int k1=0;k1<3;k1++)
          {
              //27个方块
              
              statusDataToString+="[ " 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.x)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.y)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.z);
              
              statusDataToString+=" ],[ " 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEx.x)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEx.y)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEx.z);
              
              statusDataToString+=" ],[ " 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEy.x)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEy.y)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEy.z);
              
              statusDataToString+=" ],[ " 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEz.x)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEz.y)+"," 
              +String.valueOf(willShowMofangStatusMessage.dataMessage[i1][j1][k1].blockEz.z);
              
              statusDataToString+=" ]" ;
          }
          cell.add(statusDataToString);
          
          
          //27种操作对应的数组
          int[]intArray ;
          intArray=(int[])(bianHuanTable.get(i));
          String bianHuanTableToString ;
          for(int j=0;j<27;j++)
          {
              bianHuanTableToString=String.valueOf(intArray[j]);
              cell.add(bianHuanTableToString);
          }
          
          
          row.add(cell);
      }
      
      
      DefaultTableModel tableModel=new DefaultTableModel();
      tableModel.setDataVector(row,tableHeadName);
      
      //测试码：
      //System.out.println("statusList.size="+String.valueOf (statusList.size()));
      table.setModel(tableModel);
      //MoFang.theMainFrame.totlePanel.table1.setModel(tableModel);
      //MoFang.theMainFrame.totlePanel.table1.setGridColor(Color.GREEN);
      
      
  }
  
  //测试码：
  int[]getBianHaoByPosition(MofangStatusMessage aMofangStatusMessage,int px,int py,int pz)
  {
      int[]bianHao=
      {
          0,0,0 
      }
      ;
      for(int i1=0;i1<3;i1++)
      for(int j1=0;j1<3;j1++)
      for(int k1=0;k1<3;k1++)
      {
          if(
          (aMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.x==px)
          &&(aMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.y==py)
          &&(aMofangStatusMessage.dataMessage[i1][j1][k1].blockCenter.z==pz)
          
          )
          {
              bianHao[0]=i1 ;
              bianHao[1]=j1 ;
              bianHao[2]=k1 ;
              return bianHao ;
          }
      }
      System.out.println("error");
      return bianHao ;
  }
  
  public static void main(String args[])
  {
      
      JFrame frame=new JFrame();
      Container c=frame.getContentPane();
      c.setLayout(new BorderLayout());
      
      JTable table=new JTable();
      JScrollPane jScrollPaneOfTable=new JScrollPane(table);
      c.add(jScrollPaneOfTable,BorderLayout.CENTER);
      
      frame.setSize(600,600);
      frame.show();
      
      
      MoFanfZhuangTaiSouSuo aMoFanfZhuangTaiSouSuo=new MoFanfZhuangTaiSouSuo();
      //---------------------
      int[][]inArray=
      {
          {
              0,0,-1 
          }
          ,
          {
              -1,0,0 
          }
          ,
          {
              0,1,0 
          }
          ,
      }
      ;
      aMoFanfZhuangTaiSouSuo.qiuYi(inArray);
      
      //------------------------
      aMoFanfZhuangTaiSouSuo.setupBianHuanBiao();
      
      //========================
      JFileChooser chooser=new JFileChooser();
      int returnVal=chooser.showSaveDialog(c);
      if(returnVal==JFileChooser.APPROVE_OPTION)
      {
          try 
          {
              FileOutputStream ostream=new FileOutputStream(chooser.getSelectedFile());
              ObjectOutputStream p=new ObjectOutputStream(ostream);
              p.writeObject(aMoFanfZhuangTaiSouSuo);
              p.flush();
              p.close();
              ostream.close();
          }
          catch(Exception ee)
          {
              ee.printStackTrace();
          }
          JOptionPane.showMessageDialog(null,"已保存状态到文件:"+chooser.getSelectedFile().getPath()+chooser.getSelectedFile().getName(),"保存状态文件...",1);
      }
      //===============
      aMoFanfZhuangTaiSouSuo.pritlnbianHuanTableToWindow(table);
      
  }
  
  
}

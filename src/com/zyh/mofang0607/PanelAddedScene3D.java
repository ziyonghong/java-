package com.zyh.mofang0607;



import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet ;
import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.picking.PickTool ;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame ;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.image.TextureLoader ;
import java.text.DateFormat ;
import java.util.Date ;
import java.util.StringTokenizer ;
import javax.swing.table.*;
import javax.swing.table.*;
import java.util.*;
import java.applet.Applet ;
import java.awt.*;
import java.awt.BorderLayout ;
import com.sun.j3d.utils.universe.SimpleUniverse ;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame.*;
import com.sun.j3d.utils.picking.*;
import com.sun.j3d.internal.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.media.j3d.*;
import javax.vecmath.*;
class PanelAddedScene3D extends Applet 
{
  //���̷߳�ʽ����
  //��Applet���Ե������ӵ������У���������Ϊ��ҳ
  //���������һ��״̬��ħ��
  int layerNumber=8 ;
  SimpleUniverse u ;
  Canvas3D c ;
  BranchGroup[]branchGroupArray=new BranchGroup[layerNumber];
  boolean[]controlArray ;
  String[]typeArray ;
  
  
  PanelAddedScene3D()
  {
      //public static
      
      boolean[]getControlArray=
      {
          true,true,true,true,true,true,true,true 
      }
      ;
      controlArray=getControlArray ;
  }
  
  
  
  void prepare()
  {
      //Applet thisApplet=this;
      //-----------------
      setLayout(new BorderLayout());
      GraphicsConfiguration config=SimpleUniverse.getPreferredConfiguration();
      c=new Canvas3D(config);
      add("Center",c);
      
      u=new SimpleUniverse(c);
      
      u.getViewingPlatform().setNominalViewingTransform();
      //u.addChild(TransGroup);
  }
  
  
  void addAllbranchGroupToU(boolean[]controlLayerArray)
  {
      //ֻ�����һ�ʵ���
      
      
      controlArray=controlLayerArray ;
      
      
      //��ʼ����
      
      //��֧��0 ħ��������
      //��֧��1 ħ��������
      //��֧��2 ħ���ڲ����
      //��֧��3 ħ����������
      //��֧��4 ħ��С������
      //��֧��5 ħ��������Ϣ��
      //��֧��6 ħ�����������Ϊ��
      //��֧��7 ħ��2D��Ϣ��
      
      
      if(controlArray[0]==true)
      {
          MyPrintln.println("c0.."+typeArray[0]);
          branchGroupArray[0]=newMyBranchGroup(typeArray[0]);
          u.addBranchGraph(branchGroupArray[0]);
      }
      if(controlArray[1]==true)
      {
          MyPrintln.println("c1.."+typeArray[1]);
          branchGroupArray[1]=newMyBranchGroup(typeArray[1]);
          u.addBranchGraph(branchGroupArray[1]);
      }
      if(controlArray[2]==true)
      {
          MyPrintln.println("c2.."+typeArray[2]);
          branchGroupArray[2]=newMyBranchGroup(typeArray[2]);
          u.addBranchGraph(branchGroupArray[2]);
      }
      if(controlArray[3]==true)
      {
          MyPrintln.println("c3.."+typeArray[3]);
          branchGroupArray[3]=newMyBranchGroup(typeArray[3]);
          
          u.addBranchGraph(branchGroupArray[3]);
          //������󣬲�����removeChild
          // ColorCube abColorCube=((BranchGroup3)(branchGroupArray[3])).aColorCube;
          //    ((BranchGroup3)(branchGroupArray[3])).meTransformGroup.removeChild(abColorCube);
          
      }
      
      if(controlArray[4]==true)
      {
          MyPrintln.println("c4.."+typeArray[4]);
          branchGroupArray[4]=newMyBranchGroup(typeArray[4]);
          u.addBranchGraph(branchGroupArray[4]);
      }
      if(controlArray[5]==true)
      {
          MyPrintln.println("c5.."+typeArray[5]);
          branchGroupArray[5]=newMyBranchGroup(typeArray[5]);
          u.addBranchGraph(branchGroupArray[5]);
      }
      if(controlArray[6]==true)
      {
          MyPrintln.println("c6.."+typeArray[6]);
          branchGroupArray[6]=newMyBranchGroup(typeArray[6]);
          u.addBranchGraph(branchGroupArray[6]);
      }
      if(controlArray[7]==true)
      {
          MyPrintln.println("c7.."+typeArray[7]);
          branchGroupArray[7]=newMyBranchGroup(typeArray[7]);
          u.addBranchGraph(branchGroupArray[7]);
      }
      
  }
  
  void addBranchGraphToU(int i)
  {
      if(branchGroupArray[i]==null)
      {
          
          if(controlArray[i]==false)
          {
              branchGroupArray[i]=newMyBranchGroup(typeArray[i]);
              u.addBranchGraph(branchGroupArray[i]);
              controlArray[i]=true ;
          }
          
      }
      else 
      {
          if(controlArray[i]==false)
          {
              //branchGroupArray[i]=newMyBranchGroup(typeArray[i]);
              u.addBranchGraph(branchGroupArray[i]);
              controlArray[i]=true ;
          }
      }
  }
  
  void removebranchGroupInU(int i,boolean dead)
  {
      //do it = null
      if(dead==true)
      {
          
          if(controlArray[i]==true)
          {
              //branchGroupArray[i].detach();
              
              branchGroupArray[i]=null ;
              controlArray[i]=false ;
          }
          
          
      }
      
      else 
      {
          if(controlArray[i]==true)
          {
              branchGroupArray[i].detach();
              //branchGroupArray[i]=null;
              controlArray[i]=false ;
          }
      }
  }
  
  
  
  
  
  
  
  public BranchGroup newMyBranchGroup(String type)
  {
      if(type.compareTo("0")==0)
      {
          return new BranchGroup0(this);
      }
      else if(type.compareTo("1")==0)
      {
          return new BranchGroup1(this);
      }
      else if(type.compareTo("2")==0)
      {
          return new BranchGroup2(this);
      }
      else if(type.compareTo("3")==0)
      {
          return new BranchGroup3(this);
      }
      else if(type.compareTo("4")==0)
      {
          return new BranchGroup4(this);
      }
      else if(type.compareTo("5")==0)
      {
          return new BranchGroup5(this);
      }
      else if(type.compareTo("6")==0)
      {
          return new BranchGroup6(this);
      }
      else if(type.compareTo("7")==0)
      {
          return new BranchGroup7(this);
      }
      else return null ;
  }
  
}
//��ʼ����

//��֧��0 ħ��������
//��֧��2 ħ���ڱ���㣨����ʱ����Ϊʵ�ģ�
//��֧��3 ħ������㣨��������棩
//��֧�� ħ����������
//��֧�� ħ��С������
//��֧�� ħ��������Ϣ��
//��֧�� ħ�����������Ϊ��
//��֧��1 ħ��2D��Ϣ��
class BranchGroup0 extends BranchGroup 
{
  String picTure="IMG\\backGround.jpg" ;
  
  BranchGroup0(Applet theApplet)
  {
      MyPrintln.println("new backgroud");
      if(theApplet==null)
      {
          MyPrintln.println("null1");
      }
      BoundingSphere bounds=new BoundingSphere(new Point3d(0.0,0.0,0.0),1.0f);
      TextureLoader bgTexture=new TextureLoader(picTure,theApplet);
      //Image aImage=bgTexture.getImage();
      Background bg=new Background(bgTexture.getImage());
      bg.setImageScaleMode(Background.SCALE_FIT_ALL);
      bg.setApplicationBounds(bounds);
      this.addChild(bg);
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
  
}

class BranchGroup1 extends BranchGroup 
{
  int labelNumberLeftMax=5 ;
  int labelNumberLeft=0 ;
  //ʵ�ʵĸ���
  Text2D numberShapeLeft[]=new Text2D[labelNumberLeftMax];
  //��ߵ�label����
  
  int labelNumberDownMax=3 ;
  int labelNumberDown=0 ;
  //ʵ�ʵĸ���
  Text2D numberShapeDown[]=new Text2D[labelNumberDownMax];
  //�±ߵ�label����
  
  //TransformGroup myTransformGroup;
  //Transform3D myTransform3D;
  
  BranchGroup1(Applet theApplet)
  {
      MyPrintln.println("new text2D");
      
      //myTransform3D=new Transform3D();
      //myTransform3D.setTranslation(new Vector3d(0.0f,0.0f,-1.1f));
      
      //myTransformGroup=new TransformGroup(myTransform3D);
      //myTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      //myTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      
      //-----------
      
      //-----------
      //addChild(myTransformGroup);
      creteQueueLeftAndDown(22);
      //addAStringToLeft("rfoi");
      //addAStringToLeft("ghfjgh");
      //addAStringToLeft("gfgi");
      //addAStringToLeft("ghfjgh");
      //addAStringToDown("kiufoliuluil");
      //addAStringToDown("222222");
      MyTimerBehavior runTime=new MyTimerBehavior(this,1000);
      runTime.setSchedulingBounds(new BoundingSphere());
      this.addChild(runTime);
      
      
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
      //new TimeRun(this).start();
  }
  
  
  void initializeParam()
  {
      
      for(int i=0;i<labelNumberLeftMax;i++)
      {
          numberShapeLeft[i]=new Text2D("leftlabel"+String.valueOf(i),new Color3f(0.0f,0.0f,0.0f),"Serif",40,Font.HANGING_BASELINE);
      }
      
      for(int i=0;i<labelNumberDownMax;i++)
      {
          numberShapeDown[i]=new Text2D("downlabel"+String.valueOf(i),new Color3f(0.0f,0.0f,0.0f),"Serif",40,Font.HANGING_BASELINE);
      }
      
  }
  
  void addLabelLeft(float thex1,float they1,float thez1,int theFontSize,int which)
  {
      
      float x1 ;
      float y1 ;
      float z1 ;
      int fontSize ;
      
      x1=thex1 ;
      y1=they1 ;
      z1=thez1 ;
      fontSize=theFontSize ;
      
      //�����õ�Ĭ��ֵ
      //x1=0.8f;
      //y1=0.0f;
      //z1=-0.9f;
      //fontSize=40;
      
      //�����õ�Ĭ��ֵ
      //x1=0.8f;
      //y1=0.0f;
      //z1=-0.9f;
      //fontSize=40;
      
      TransformGroup numberTransformGroup=new TransformGroup();
      Transform3D numberTransform3D=new Transform3D();
      //numberTransformGroup.addChild(new BranchGroup());
      //Label1
      //Text2D�����е��ַ�����������Ҫ�������ó��㣬���������ִ����ȳ�����ʱ����������ȫ��ʾ
      numberShapeLeft[which]=new Text2D("#                                                                        #" 
      ,new Color3f(1.0f,1.0f,1.0f),"Verdana",fontSize,Font.ITALIC);
      numberShapeLeft[which].setCapability(Shape3D.ALLOW_APPEARANCE_READ);
      //  numberShapeLeft[which].
      Appearance app=((Shape3D)numberShapeLeft[which]).getAppearance();
      app.setCapability(Appearance.ALLOW_TEXTURE_READ);
      app.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
      
      //TextureLoader loader=new  TextureLoader("IMG\\text2D.jpg",MoFang.testPanelAddedScene3D);
      //    ImageComponent2D myImage=loader.getImage();
      
      //  Texture myTex=app.getTexture();
      //       myTex.setCapability(myTex.ALLOW_IMAGE_READ);
      //  myTex.setCapability(myTex.ALLOW_IMAGE_WRITE);
      // myTex.setCapability(myTex.ALLOW_SIZE_READ);
      // myTex.setCapability(myTex.ALLOW_BOUNDARY_MODE_READ);
      // myTex.setCapability(myTex.ALLOW_FILTER_READ);
      //     myTex.setImage(0,myImage);
      //app.setTexture(myTex);
      
      Material mm=new Material();
      mm.setLightingEnable(true);
      app.setMaterial(mm);
      
      //���Ͻ�λ��
      
      numberTransform3D.setTranslation(new Vector3f(x1,y1,z1-1.1f));
      numberTransformGroup.addChild(numberShapeLeft[which]);
      //numberTransform3D[i].rotY(Math.PI);
      //numberTransform3D1[i].rotZ(-Math.PI);
      //numberTransform3D[i].rotY(Math.PI);
      numberTransformGroup.setTransform(numberTransform3D);
      addChild(numberTransformGroup);
      
  }
  
  void addLabelDown(float thex1,float they1,float thez1,int theFontSize,int which)
  {
      float x1 ;
      float y1 ;
      float z1 ;
      int fontSize ;
      
      x1=thex1 ;
      y1=they1 ;
      z1=thez1 ;
      fontSize=theFontSize ;
      
      //�����õ�Ĭ��ֵ
      //x1=0.8f;
      //y1=0.0f;
      //z1=-0.9f;
      //fontSize=40;
      
      TransformGroup numberTransformGroup=new TransformGroup();
      Transform3D numberTransform3D=new Transform3D();
      
      //Label1
      numberShapeDown[which]=new Text2D("#                                                                        #" 
      ,new Color3f(1.0f,1.0f,1.0f),"Verdana",fontSize,Font.ITALIC);
      numberShapeDown[which].setCapability(Shape3D.ALLOW_APPEARANCE_READ);
      //numberShapeDown[which].setCapability(Shape3D.ALLOW_APPEARANCE_WRITE);
      
      Appearance app=((Shape3D)numberShapeDown[which]).getAppearance();
      app.setCapability(Appearance.ALLOW_TEXTURE_READ);
      app.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
      
      //Texture myTex=app.getTexture();
      // myTex.setCapability(myTex.ALLOW_IMAGE_READ);
      // myTex.setCapability(myTex.ALLOW_IMAGE_WRITE);
      // myTex.setCapability(myTex.ALLOW_SIZE_READ);
      // myTex.setCapability(myTex.ALLOW_BOUNDARY_MODE_READ);
      // myTex.setCapability(myTex.ALLOW_FILTER_READ);
      //myTex.setImage(0,myImage);
      //app.setTexture(myTex);
      
      Material mm=new Material();
      mm.setLightingEnable(true);
      app.setMaterial(mm);
      
      numberTransform3D.setTranslation(new Vector3f(x1,y1,z1-1.1f));
      numberTransformGroup.addChild(numberShapeDown[which]);
      //numberTransform3D[i].rotY(Math.PI);
      //numberTransform3D1[i].rotZ(-Math.PI);
      //numberTransform3D[i].rotY(Math.PI);
      numberTransformGroup.setTransform(numberTransform3D);
      addChild(numberTransformGroup);
      
  }
  
  //�Զ����������ַ���
  public void addAStringToLeft(String theString)
  {
      
      //	String standardString="1111111111111111111111111111111111111111111111111111111";
      //	String blackString="                                                          ";
      String standardString="1111111111111111111111111111111111" ;
      String blackString="                                                          " ;
      
      theString+=blackString ;
      //MyPrintln.println(theString+"end");
      theString=theString.substring(0,standardString.length());
      //MyPrintln.println(theString+"end");
      
      //�����ж�����Ƿ��Ѿ�����
      if(labelNumberLeft>=labelNumberLeftMax)
      {
          //���ˣ�forѭ��ȫ����ֵ����,Ȼ��ӵ�ĩ��
          
          //for()
          String aString ;
          //������ʱ���ַ���
          for(int i=0;i<labelNumberLeftMax-1;i++)
          {
              aString=numberShapeLeft[i+1].getString();
              numberShapeLeft[i].setString(aString);
          }
          //
          numberShapeLeft[labelNumberLeftMax-1].setString(theString);
      }
      else 
      {
          //ֱ�����
          numberShapeLeft[labelNumberLeft++].setString(theString);
      }
  }
  
  //�Զ����������ַ���
  public void addAStringToDown(String theString)
  {
      
      
      //String standardString="1111111111111111111111111111111111111111111111111111111";
      //String blackString="                                                          ";
      
      
      String standardString="1111111111111111111111111111111111" ;
      String blackString="                                                          " ;
      
      
      theString+=blackString ;
      //MyPrintln.println(theString+"end");
      theString=theString.substring(0,standardString.length());
      //MyPrintln.println(theString+"end");
      
      //�����ж�����Ƿ��Ѿ�����
      if(labelNumberDown>=labelNumberDownMax)
      {
          //���ˣ�forѭ��ȫ����ֵ����,Ȼ��ӵ�ĩ��
          
          //for()
          String aString ;
          for(int i=0;i<labelNumberDownMax-1;i++)
          {
              aString=numberShapeDown[i+1].getString();
              numberShapeDown[i].setString(aString);
          }
          //
          numberShapeDown[labelNumberDownMax-1].setString(theString);
      }
      else 
      {
          //ֱ�����
          numberShapeDown[labelNumberDown++].setString(theString);
      }
  }
  
  public void creteQueueLeftAndDown(int fontSize)
  {
      //��ʼ�����Ѿ��ֱ�Ϊ0
      
      //��ʼ����������
      initializeParam();
      
      //������ߵĶ���
      
      float x1 ;
      float y1 ;
      float z1 ;
      
      x1=-1.4f ;
      //������ߵĵ�һ��label������(x1,y1,z1),����������Զ�����
      y1=1.20f ;
      z1=0.0f ;
      for(int i=0;i<labelNumberLeftMax;i++,y1-=0.10f)
      {
          //�����ʼλ��(x1,y1,z1)��ÿ�����±���0.2f
          addLabelLeft(x1,y1,z1,fontSize,i);
          //x,y,z�ֱ�Ϊ���Ͻǵ��ң��ϣ���
      }
      
      x1=-1.4f ;
      //�����±ߵĵ�һ��label������(x1,y1,z1),����������Զ�����
      y1=-1.1f ;
      z1=0.0f ;
      //�����±ߵĶ���
      for(int i=0;i<labelNumberDownMax;i++,y1-=0.10f)
      {
          //�ұ���ʼλ��(x1,y1,z1)��ÿ�����±���0.2f
          addLabelDown(x1,y1,z1,fontSize,i);
          //x,y,z�ֱ�Ϊ���Ͻǵ��ң��ϣ���
      }
  }
}

//neiBiaoMianWaiTao

class BranchGroup2 extends BranchGroup 
{
  BranchGroup2(Applet atheApplet)
  {
      MyPrintln.println("new BranchGroup2");
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
}
class BlockRotateStatusTableAndSouSuo 
{
  //ע�⣬������ľ���ȫ����x��������y������,z������
  //------
  public static String souSuoType="" ;
  public static int shenDuControl=0 ;
  //----------
  //BlockRotateStatusTableAndSouSuo.getShortLuJing();
  public static Vector bianHuanTable=new Vector();
  //��ʼ����,2
  //0 x x x y y y z z z
  //public static int[] statusJuZhenNo;//={
  //	0,0,0,0,0,0,0,0,0
  //};
  
  public static Vector statusJuZhenList=new Vector();
  //statusJuZhenNoList.
  //public static Vector statusJuZhenList=new Vector();
  public static int[][]statusJuZhen=
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
  //XYZ������
  public static int[][][]chengShuZhen=
  {
      Point3D.bianHuanJuZhenX90,
      Point3D.bianHuanJuZhenX180,
      Point3D.bianHuanJuZhenX270,
      Point3D.bianHuanJuZhenY90,
      Point3D.bianHuanJuZhenY180,
      Point3D.bianHuanJuZhenY270,
      Point3D.bianHuanJuZhenZ90,
      Point3D.bianHuanJuZhenZ180,
      Point3D.bianHuanJuZhenZ270,
  }
  ;
  
  public static Vector[][]souSuoBiao=new Vector[24][24];
  //����������ִ�,���һ������Ϊ���ָ���
  public static int souSuoBiaoFeiNullGeShu=0 ;
  //
  
  public static boolean haveCreated=false ;
  
  
  public static int findInList(int[][]inArray)
  {
      int[][]intArray ;
      int i ;
      for(i=0;i<statusJuZhenList.size();i++)
      {
          intArray=(int[][])(statusJuZhenList.get(i));
          if(comparyintArray(inArray,intArray,3,3)==0)
          {
              return i ;
          }
      }
      // statusJuZhenList.add(inArray);
      MyPrintln.println("error=not finded");
      MyPrintln.println(inArray,3,3);
      //pritlnbianHuanTable();
      return-1 ;
  }
  
  
  
  
  
  //
  public static Vector getAllLuJingShenDuControll(int[][]oldArray,int[][]newArray,int aShenDuControl)
  {
      if(haveCreated==false)
      {
          haveCreated=true ;
          //
          setupBianHuanBiao();
          setupSouSuoBiao();
          //MyPrintln.println (souSuoBiao[0][0].toString ());
          
          // Mywait.myWait ();
          
      }
      else 
      {
      }
      int row=0 ;
      int column=0 ;
      //========
      if(souSuoType.compareTo("shenDuControlGetAll")!=0||shenDuControl!=aShenDuControl)
      {
          souSuoType="shenDuControlGetAll" ;
          shenDuControl=aShenDuControl ;
          setupSouSuoBiao();
      }
      //=============
      row=findInList(oldArray);
      column=findInList(newArray);
      
      //row=0;
      //column=1;
      
      //MyPrintln.println ("row="+String.valueOf(row));
      //MyPrintln.println (oldArray,3,3);
      //MyPrintln.println("column="+String.valueOf(column));
      //MyPrintln.println (newArray,3,3);
      //MyPrintln.println("AllLuJing="+souSuoBiao[row][column].toString ());
      //pritlnbianHuanTable();
      //MyPrintln.println(souSuoBiao[1][1].toString ());
      
      Vector<?> findedVector=(Vector<?>)(souSuoBiao[row][column]);
      //MyPrintln.println ("return AllLuJing");
      return findedVector ;
  }
  
  
  public static Vector<?> getShortLuJing(int[][]oldArray,int[][]newArray)
  {
      if(haveCreated==false)
      {
          haveCreated=true ;
          //
          setupBianHuanBiao();
          
          //MyPrintln.println (souSuoBiao[0][0].toString ());
          
          // Mywait.myWait ();
          
      }
      else 
      {
      }
      int row=0 ;
      int column=0 ;
      
      //========
      if(souSuoType!="short")
      {
          souSuoType="short" ;
          //shenDuControl=aShenDuControl;
          setupSouSuoBiao();
      }
      //=============
      row=findInList(oldArray);
      column=findInList(newArray);
      
      //row=0;
      //column=1;
      
      //MyPrintln.println ("row="+String.valueOf(row));
      //MyPrintln.println (oldArray,3,3);
      //MyPrintln.println("column="+String.valueOf(column));
      //MyPrintln.println (newArray,3,3);
      //MyPrintln.println("AllLuJing="+souSuoBiao[row][column].toString ());
      //pritlnbianHuanTable();
      //MyPrintln.println(souSuoBiao[1][1].toString ());
      
      Vector<?> findedVector=(Vector<?>)(souSuoBiao[row][column].get(1));
      //MyPrintln.println ("return LuJing��"+String.valueOf (1));
      //MyPrintln.println ("findedVector");
      return findedVector ;
  }
  
  
  public static void setupSouSuoBiaoDiGui(int status,int shenDu,int hang,Vector luJing)
  {
      //hang only for output
      
      
      
      for(int nextstatusXiaBiao=0;nextstatusXiaBiao<9;nextstatusXiaBiao++)
      {
          Vector[]newluJing=new Vector[9];
          newluJing[nextstatusXiaBiao]=(Vector)(luJing.clone());
          newluJing[nextstatusXiaBiao].add(String.valueOf(nextstatusXiaBiao));
          
          int[]nextStatusArray=(int[])(bianHuanTable.get(status));
          int nextstatus=nextStatusArray[nextstatusXiaBiao];
          //
          //===============================================
          
          if(souSuoBiao[hang][nextstatus].size()==0)
          {
              //souSuoBiao[hang][nextstatus].remove (0);
              souSuoBiao[hang][nextstatus].add(0,String.valueOf(shenDu));
              souSuoBiao[hang][nextstatus].add(1,newluJing[nextstatusXiaBiao]);
              
              
              souSuoBiaoFeiNullGeShu++;
              //MyPrintln.println("����:"+String.valueOf (souSuoBiaoFeiNullGeShu));
              
          }
          
          else 
          {
              //����ŵ���ȷλ��
              
              //souSuoBiao[hang][nextstatus].add(String.valueOf(shenDu));
              //souSuoBiao[hang][nextstatus].add(newluJing[nextstatusXiaBiao]);
              ///=======
              int i1 ;
              for(i1=0;i1<souSuoBiao[hang][nextstatus].size();i1+=2)
              {
                  String oldshenDu=(String)(souSuoBiao[hang][nextstatus].get(i1));
                  if(shenDu<Integer.parseInt(oldshenDu))
                  {
                      break ;
                  }
              }
              //--------
              souSuoBiao[hang][nextstatus].add(i1,String.valueOf(shenDu));
              souSuoBiao[hang][nextstatus].add(i1+1,newluJing[nextstatusXiaBiao]);
              
              //======
              
              
              //oldshenDu.
          }
          
          
          
      }
      //=======================================
      //�����ú������ı�λ�õ����棬�����������
      //=====================================
      
      shenDu++;
      
      if((souSuoType.compareTo("shenDuControlGetAll")==0&&shenDu<=shenDuControl)
      ||(souSuoType.compareTo("short")==0&&souSuoBiaoHangFull(hang)!=1)
      )
      //if(souSuoBiaoHangFull(hang)!=1)//�����򷵻�
      //�������ǵõ����·���ķ�����ֻ�õ�һ����������ù��������������ô��һ�����������Ҫ�Ľ��
      /// if(shenDu<=2)//�������ǵõ�����3���ڵķ�������̵��Զ��ŵ���ǰ��
      {
          //int[]nextStatusArray=bianHuanTable.get(status);
          for(int nextstatusXiaBiao=0;nextstatusXiaBiao<9;nextstatusXiaBiao++)
          {
              Vector[]newluJing=new Vector[9];
              newluJing[nextstatusXiaBiao]=(Vector)(luJing.clone());
              newluJing[nextstatusXiaBiao].add(String.valueOf(nextstatusXiaBiao));
              
              int[]nextStatusArray=(int[])(bianHuanTable.get(status));
              int nextstatus=nextStatusArray[nextstatusXiaBiao];
              //===============
              // souSuoBiao[status][nextstatus].add(String.valueOf(nextstatusXiaBiao));
              // souSuoBiao[status][nextstatus].add(String.valueOf(1));
              //---------------------
              // int[]lastStatusArray=bianHuanTable.get(nextstatus);
              // for(int laststatusXiaBiao=0;laststatusXiaBiao<9;laststatusXiaBiao++)
              // {
              //     int laststatus=lastStatusArray[lastXiaBiao];
              //----------
              
              //     souSuoBiao[status][laststatus].add(String.valueOf(nextstatusXiaBiao));
              //     souSuoBiao[status][laststatus].add(String.valueOf(laststatusXiaBiao));
              //     souSuoBiao[status][laststatus].add((2));
              
              //----------
              //}
              //
              // if(souSuoBiao[hang][nextstatus].size()==0)
              //  {
              //      souSuoBiao[hang][nextstatus].add(String.valueOf(nextstatusXiaBiao));
              //      souSuoBiao[hang][nextstatus].add(String.valueOf(++shenDu));
              // souSuoBiaoFeiNullGeShu++;
              // MyPrintln.println("����:"+String.valueOf (souSuoBiaoFeiNullGeShu));
              //  }
              //
              
              
              setupSouSuoBiaoDiGui(nextstatus,shenDu,hang,newluJing[nextstatusXiaBiao]);
              
              //=====================
              
          }
      }
  }
  
  
  public static int souSuoBiaoHangFull(int hang)
  {
      
      for(int j=0;j<24;j++)
      {
          if(souSuoBiao[hang][j].size()==0)
          return-1 ;
      }
      
      return 1 ;
  }
  
  public static int souSuoBiaoFull()
  {
      for(int i=0;i<24;i++)
      for(int j=0;j<24;j++)
      {
          if(souSuoBiao[i][j].size()==0)
          return-1 ;
      }
      
      return 1 ;
  }
  
  public static void setupSouSuoBiao()
  {
      for(int i=0;i<24;i++)
      {
          souSuoBiao[i]=new Vector[24];
          for(int j=0;j<24;j++)
          {
              souSuoBiao[i][j]=new Vector();
          }
      }
      
      
      for(int i=0;i<24;i++)
      {
          //�Խ�Ԫ�϶�Ϊ�գ�ֻ������0����ʾ���貽��
          souSuoBiao[i][i].add(String.valueOf(0));
          //Vector luJing=new Vector();
          souSuoBiao[i][i].add(new Vector());
      }
      
      
      
      for(int hang=0;hang<24;hang++)
      {
          int status=hang ;
          Vector luJing=new Vector();
          setupSouSuoBiaoDiGui(status,1,hang,luJing);
      }
      
      //-------------------------
      MyPrintln.println("souSuoBiao created:");
      //          for(int i=0;i<24;i++)
      //           for(int j=0;j<24;j++)
      //   {
      //MyPrintln.println(souSuoBiao[i][j].toString ());
      //      }
      
      //-------------------------------------------
      MyPrintln.println("����:"+String.valueOf(souSuoBiaoFeiNullGeShu));
      
      
      //------
      if(souSuoBiaoFull()==1)
      {
          MyPrintln.println("full");
      }
      
      //  Mywait.myWait ();
      //---------
      pritlnSouSuoBiaoToWindow();
  }
  
  public static void setupBianHuanBiao()
  {
      
      statusJuZhenList.add(statusJuZhen);
      //statusJuZhenNoList.add(0);
      
      //	boolean exitFlag=false;
      int i=0 ;
      int[][]intArray ;
      //intArray=(int[][])(statusJuZhenList.get(i));
      while(i+1<=statusJuZhenList.size())
      {
          //pritlnbianHuanTable();
          
          //System.out.println(statusJuZhenList.size ());
          intArray=(int[][])(statusJuZhenList.get(i));
          //MyPrintln.println(intArray,3,3);
          int[]statusJuZhenNo=
          {
              0,0,0,0,0,0,0,0,0 
          }
          ;
          
          
          
          for(int j=0;j<9;j++)
          {
              //
              int[][]outArray ;
              
              outArray=jiSuanJuZhen(intArray,chengShuZhen[j]);
              int outNumber ;
              outNumber=addTolist(outArray);
              statusJuZhenNo[j]=outNumber ;
              //pritlnbianHuanTable();
              
              //int[][] intArray=bianHuan()[]
              //	BlockMessage aBlockMessage=new BlockMessage(intArray[0][],);
          }
          bianHuanTable.add(statusJuZhenNo);
          
          i++;
      }
      
      MyPrintln.println("setupBianHuanBiao:");
      //pritlnbianHuanTable();
      
      pritlnbianHuanTableToWindow();
  }
  
  static int[][]jiSuanJuZhen(int[][]intArray,int[][]aChengShuZhen)
  {
      //���������ұ�
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
      // MyPrintln.println("�˷�����");
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
  
  static int addTolist(int[][]inArray)
  {
      
      
      int[][]intArray ;
      int i ;
      for(i=0;i<statusJuZhenList.size();i++)
      {
          intArray=(int[][])(statusJuZhenList.get(i));
          if(comparyintArray(inArray,intArray,3,3)==0)
          {
              return i ;
          }
      }
      
      statusJuZhenList.add(inArray);
      return i ;
  }
  
  
  static int comparyintArray(int[][]inArray1,int[][]inArray2,int hang,int lie)
  {
      for(int i=0;i<hang;i++)
      for(int j=0;j<lie;j++)
      {
          if(inArray1[i][j]!=inArray2[i][j])
          {
              return-1 ;
          }
      }
      return 0 ;
  }
  
  
  static void pritlnbianHuanTableToWindow()
  {
      System.out.println("");
      System.out.println("����任�� outToATable");
      
      String[]tableHeads=
      {
          "���","����","x90","x180","x-90","y90","y180","y-90","z90","z180","z-90" 
      }
      ;
      Vector tableHeadName=new Vector();
      
      for(int l=0;l<tableHeads.length;l++)
      {
          tableHeadName.add(tableHeads[l]);
      }
      
      
      Vector row=new Vector();
      //row.add(tableHeadName);
      for(int i=0;i<statusJuZhenList.size();i++)
      {
          //if(statusJuZhenList.size ()==24){System.out.println("24��״̬");}
          Vector cell=new Vector();
          
          cell.add(String.valueOf(i));
          
          int[][]intArray ;
          intArray=(int[][])(statusJuZhenList.get(i));
          String statusJuZhenToString="" ;
          for(int j=0;j<3;j++)
          {
              statusJuZhenToString+="[ " ;
              for(int k=0;k<3;k++)
              {
                  statusJuZhenToString+=String.valueOf(intArray[k][j])+"," ;
              }
              statusJuZhenToString+=" ]," ;
          }
          cell.add(statusJuZhenToString);
          
          int[]intArray2 ;
          intArray2=(int[])(bianHuanTable.get(i));
          String bianHuanTableToString ;
          for(int j=0;j<9;j++)
          {
              bianHuanTableToString=String.valueOf(intArray2[j]);
              cell.add(bianHuanTableToString);
          }
          
          
          row.add(cell);
      }
      
      
      DefaultTableModel tableModel=new DefaultTableModel();
      tableModel.setDataVector(row,tableHeadName);
      
      
      MoFang.theMainFrame.totlePanel.table1.setModel(tableModel);
      MoFang.theMainFrame.totlePanel.table1.setGridColor(Color.GREEN);
      
      
  }
  //public static Vector[][]souSuoBiao=new Vector[24][24];
  
  static void pritlnSouSuoBiaoToWindow()
  {
      System.out.println("");
      System.out.println("����״̬��״̬·���� outToATable");
      
      String[]tableHeads=
      {
          "���","����","0��","1��","2��","3��","4��","5��","6��","7��","8��","9��","10��","11��","12��","13��","14��","15��","16��","17��","18��","19��","20��","21��","22��","23��" 
      }
      ;
      Vector tableHeadName=new Vector();
      
      for(int l=0;l<tableHeads.length;l++)
      {
          tableHeadName.add(tableHeads[l]);
      }
      
      
      Vector row=new Vector();
      //row.add(tableHeadName);
      for(int i=0;i<statusJuZhenList.size();i++)
      {
          //if(statusJuZhenList.size ()==24){System.out.println("24��״̬");}
          Vector cell=new Vector();
          
          cell.add(String.valueOf(i));
          
          int[][]intArray ;
          intArray=(int[][])(statusJuZhenList.get(i));
          String statusJuZhenToString="" ;
          for(int j=0;j<3;j++)
          {
              statusJuZhenToString+="[ " ;
              for(int k=0;k<3;k++)
              {
                  statusJuZhenToString+=String.valueOf(intArray[k][j])+"," ;
              }
              statusJuZhenToString+=" ]," ;
          }
          cell.add(statusJuZhenToString);
          
          //public static Vector[][]souSuoBiao=new Vector[24][24];
          for(int j=0;j<statusJuZhenList.size();j++)
          {
              Vector luJingArray=(Vector)souSuoBiao[i][j];
              String iToJAllLuJing=luJingArray.toString();
              cell.add(iToJAllLuJing);
          }
          
          
          
          
          row.add(cell);
      }
      
      
      DefaultTableModel tableModel=new DefaultTableModel();
      tableModel.setDataVector(row,tableHeadName);
      
      
      MoFang.theMainFrame.totlePanel.table2.setModel(tableModel);
      MoFang.theMainFrame.totlePanel.table2.setGridColor(Color.cyan);
      
      
  }
  
  
  
  
  static Vector calculateControledRotateSelf(int[]saiXuanJi,int[][]test1,int[][]test2,int position,int teDingTypeXYZ012,int shenDu)
  {
      //��ѡ���Ĺ���������飬����{0,1,0,1,0,1,1,0,0}��1��ʾ����
      //positionָ�����ĸ�λ�ö�������Ҫ��
      //teDingTypeXYZѡ��
      //���position����teDingTypeXYZ012������Χ�����޶�
      //�������Ҫ�޶���Ӧ����-1��
      //position����-2ʱ����ʾ�����һ���޶�
      //��������������������������ѡ����Ϊ3*3������
      /*
                                  int[][]test1=
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
                          }
                          ;
                          int[][]test2=
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
                          }
                          ;
      
                          test2[0][0]=dataMessage[i][j][k].blockEx.x ;
                          test2[1][0]=dataMessage[i][j][k].blockEx.y ;
                          test2[2][0]=dataMessage[i][j][k].blockEx.z ;
      
                          test2[0][1]=dataMessage[i][j][k].blockEy.x ;
                          test2[1][1]=dataMessage[i][j][k].blockEy.y ;
                          test2[2][1]=dataMessage[i][j][k].blockEy.z ;
      
                          test2[0][2]=dataMessage[i][j][k].blockEz.x ;
                          test2[1][2]=dataMessage[i][j][k].blockEz.y ;
                          test2[2][2]=dataMessage[i][j][k].blockEz.z ;
                          */
      
      //MyPrintln.println("��תǰ");
      //MyPrintln.println(test1,3,3);
      //MyPrintln.println("��ת��");
      //MyPrintln.println(test2,3,3);
      //��Ϊ������
      //        MyPrintln.println (BlockRotateStatusTableAndSouSuo.getShortLuJing(test1,test2).toString());
      
      
      Vector myVectorArray=BlockRotateStatusTableAndSouSuo.getAllLuJingShenDuControll(test1,test2,shenDu);
      //�������Ϊ{"2",{"3","4"},"3",{"5","6"},...}��ʽ
      //�̵���ǰ��
      //MyPrintln.println("lujingArray="+myVectorArray.toString());
      //MyPrintln.println("============");
      //        MyPrintln.println("��ѡ��");
      //       MyPrintln.println("λ��"+String.valueOf (position)+"��Ҫ��(x=0,y=1,z=2)������"+String.valueOf (teDingTypeXYZ012));
      //        MyPrintln.println(saiXuanJi,9);
      //===============
      Vector myVector ;
      
      if(myVectorArray.size()!=0)
      {
          int k1 ;
          for(k1=1;k1<myVectorArray.size();k1+=2)
          //����ǰ·����λ��---------------
          {
              // saiXuanJi[]
              myVector=(Vector)(myVectorArray.get(k1));
              //ȡ����ǰ·��
              //int goNextK1=0;
              int y1 ;
              for(y1=0;y1<myVector.size();y1++)
              {
                  //��ÿ���ڵ���м��
                  String typeNow=(String)(myVector.get(y1));
                  //if(typeNow.compareTo ("0")==0)
                  int intType ;
                  intType=Integer.parseInt(typeNow);
                  // for(int z1=0;z1<9;z1++)
                  // {
                  if(saiXuanJi[intType]==0)
                  {
                      //�����౻�ܾ���,��·����Ч
                      //goNextK1=1;
                      break ;
                  }
                  
                  //
                  //int position,int teDingTypeXYZ012
                  if(position==y1)
                  {
                      //confined
                      if(intType/3==teDingTypeXYZ012)
                      {
                          ;
                      }
                      else 
                      {
                          //��λ�����಻��Ҫ����߷�0��1��2������
                          break ;
                      }
                  }
                  else if(position==-2&&y1==myVector.size()-1)
                  {
                      //!=y1
                      if(intType/3==teDingTypeXYZ012)
                      {
                          ;
                      }
                      else 
                      {
                          //��λ�����಻��Ҫ����߷�0��1��2������
                          break ;
                      }
                  }
                  else 
                  {
                      ;
                      //û���position
                  }
                  //  }
              }
              if(y1<myVector.size())
              {
                  //���ܾ�ʱ
                  System.out.println("���ܾ�,���趨����ѡ��");
                  Mywait.myWait();
                  continue ;
              }
              else 
              {
                  //·����Ч
                  
                  //MyPrintln.println(myVector.toString());
                  return myVector ;
              }
          }
      }
      System.out.println("error,no any LuJing,I can't return a Vector.because size=0 means you neddn't rotate");
      Mywait.myWait();
      return new Vector();
      //���ؿյ�
      
      
      
  }
  
  
  
  
  
  
}


class DongHuaAll implements Runnable 
//extends Thread
{
  public static int delayNumber=50 ;
  public static int changeJiaoDu=5 ;
  //ÿ����ת�Ĳ���
  int typeXYZ012=0 ;
  int layer012=0 ;
  int jiaoDu=0 ;
  
  BranchGroup3 aBranchGroup3 ;
  
  DongHuaAll(BranchGroup3 abBranchGroup3)
  {
      aBranchGroup3=abBranchGroup3 ;
  }
  
  public void run()
  {
    //  TimeRun.rotateTimes++;
      dongHua();
  }
  
  synchronized void dongHua()
  {
      if(typeXYZ012==0)
      {
          //MoFang.aMofangStatusMessage.moFang3DRotate (0,layer012,jiaoDu);
          
          dongHuaX(layer012,jiaoDu);
          //Mywait.myWait ();
          //         BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
          // aBranchGroup3.setStatus (MoFang.aMofangStatusMessage.dataMessage);
          
      }
      else if(typeXYZ012==1)
      {
          dongHuaY(layer012,jiaoDu);
      }
      else if(typeXYZ012==2)
      {
          dongHuaZ(layer012,jiaoDu);
      }
      else 
      {
          ;
          //error;}
      }
      
      //״̬����ˢ�µ�����ͳ���
      MoFang.aMofangStatusMessage.outToATable();
      
  }
  
  void dongHuaX(int layer,int jiaoDu)
  {
      //��ת�ƣ�����ת��������á�ֱ������ħ�����µ�״̬
      System.out.println("X layer="+String.valueOf(layer)+" jiaoDu="+String.valueOf(jiaoDu));
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //get(Vector3d trans) dataMessage
          //Vector3d trans=new Vector3d();
          //trans=blockTransform3D[i][j][k].get(trans);
          if(aBranchGroup3.centerPointSaved[i][j][k].x==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
          }
          //Mywait.myWait ();
          //helpTransformGroup.addChild(blockBranchGroup[layer][i][j]);
      }
      System.out.println("removed");
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //blockBranchGroup[layer][i][j].detach();
          
          //Mywait.myWait ();
          if(aBranchGroup3.centerPointSaved[i][j][k].x==layer-1)
          //	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              try 
              {
                  aBranchGroup3.helpTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
          }
      }
      //----------------
      System.out.println("added");
      //Mywait.myWait();
      aBranchGroup3.helpTransform3D=new Transform3D();
      
      
      if(jiaoDu>0)
      {
          for(int nowJiaoDu=0;nowJiaoDu<=jiaoDu;nowJiaoDu+=changeJiaoDu)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotX(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
          
      }
      else 
      {
          for(int nowJiaoDu=0;nowJiaoDu>=jiaoDu;nowJiaoDu-=changeJiaoDu)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotX(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
      }
      //helpTransform3D.rotX(Math.toRadians(jiaoDu));
      //helpTransformGroup.setTransform(helpTransform3D);
      
      //-----------------------
      System.out.println("rotated");
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].x==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
              //aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
          }
      }
      
      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
      aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
      
      
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].x==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              //aBranchGroup3.blockBranchGroup[i][j][k].detach();
              try 
              {
                  aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
          }
      }
      
      
  }
  
  
  void dongHuaY(int layer,int jiaoDu)
  {
      //��ת�ƣ�����ת��������á�ֱ������ħ�����µ�״̬
      System.out.println("Y layer="+String.valueOf(layer)+" jiaoDu="+String.valueOf(jiaoDu));
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //get(Vector3d trans) dataMessage
          //Vector3d trans=new Vector3d();
          //trans=blockTransform3D[i][j][k].get(trans);
          if(aBranchGroup3.centerPointSaved[i][j][k].y==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
          }
          //Mywait.myWait ();
          //helpTransformGroup.addChild(blockBranchGroup[layer][i][j]);
      }
      System.out.println("removed");
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //blockBranchGroup[layer][i][j].detach();
          
          //Mywait.myWait ();
          if(aBranchGroup3.centerPointSaved[i][j][k].y==layer-1)
          //	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              try 
              {
                  aBranchGroup3.helpTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
          }
      }
      //----------------
      System.out.println("added");
      //Mywait.myWait();
      aBranchGroup3.helpTransform3D=new Transform3D();
      //aBranchGroup3.helpTransform3D.rotY(Math.toRadians(jiaoDu));
      //aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
      
      if(jiaoDu>0)
      {
          for(int nowJiaoDu=0;nowJiaoDu<=jiaoDu;nowJiaoDu+=10)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotY(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
          
      }
      else 
      {
          for(int nowJiaoDu=0;nowJiaoDu>=jiaoDu;nowJiaoDu-=changeJiaoDu)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotY(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
      }
      //-----------------------
      System.out.println("rotated");
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].y==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
              // aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
          }
      }
      
      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
      aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
      
      
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].y==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              try 
              {
                  
                  
                  aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
              //aBranchGroup3.blockBranchGroup[i][j][k].detach();
          }
      }
      
      
  }
  
  void dongHuaZ(int layer,int jiaoDu)
  {
      
      
      //��ת�ƣ�����ת��������á�ֱ������ħ�����µ�״̬
      System.out.println("Z layer="+String.valueOf(layer)+" jiaoDu="+String.valueOf(jiaoDu));
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //get(Vector3d trans) dataMessage
          //Vector3d trans=new Vector3d();
          //trans=blockTransform3D[i][j][k].get(trans);
          if(aBranchGroup3.centerPointSaved[i][j][k].z==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
          }
          //Mywait.myWait ();
          //helpTransformGroup.addChild(blockBranchGroup[layer][i][j]);
      }
      System.out.println("removed");
      
      
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //blockBranchGroup[layer][i][j].detach();
          
          //Mywait.myWait ();
          if(aBranchGroup3.centerPointSaved[i][j][k].z==layer-1)
          //	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              try 
              {
                  
                  
                  aBranchGroup3.helpTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
              
          }
      }
      //----------------
      System.out.println("added");
      //Mywait.myWait();
      aBranchGroup3.helpTransform3D=new Transform3D();
      //aBranchGroup3.helpTransform3D.rotZ(Math.toRadians(jiaoDu));
      //  aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
      if(jiaoDu>0)
      {
          for(int nowJiaoDu=0;nowJiaoDu<=jiaoDu;nowJiaoDu+=changeJiaoDu)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotZ(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
          
      }
      else 
      {
          for(int nowJiaoDu=0;nowJiaoDu>=jiaoDu;nowJiaoDu-=changeJiaoDu)
          {
              //nowJiaoDu+=1;
              aBranchGroup3.helpTransform3D.rotZ(Math.toRadians(nowJiaoDu));
              aBranchGroup3.helpTransformGroup.setTransform(aBranchGroup3.helpTransform3D);
              
              try 
              {
                  Thread.sleep(delayNumber);
              }
              catch(Exception e)
              {
                  e.printStackTrace();
              }
          }
      }
      //-----------------------
      System.out.println("rotated");
      //Mywait.myWait();
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].z==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              aBranchGroup3.blockBranchGroup[i][j][k].detach();
              //aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
          }
      }
      
      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
      aBranchGroup3.setStatus(MoFang.aMofangStatusMessage.dataMessage);
      
      
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(aBranchGroup3.centerPointSaved[i][j][k].z==layer-1)
          // 	if(blockBranchGroup[i][j][k].blockCenter.x==layer-1)
          {
              //aBranchGroup3.blockBranchGroup[i][j][k].detach();
              try 
              {
                  
                  
                  aBranchGroup3.rootTransformGroup.addChild(aBranchGroup3.blockBranchGroup[i][j][k]);
              }
              
              catch(Exception e)
              {
                  ;
                  // e.printStackTrace();;
              }
          }
      }
      
      
  }
}

class BranchGroup3 extends BranchGroup 
{
  //false��ʾû�б�ѡ�У�����ʾ;trueѡ�У���ʾ
  boolean[][][]blockSelected=
  {
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
  }
  ;
  
  boolean[][][]bufferBlockSelected=
  {
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
  }
  ;
  
  boolean[][][]lastBufferBlockSelected=
  {
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
      {
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
          {
              false,false,false,
          }
          ,
      }
      ,
  }
  ;
  
  //0��ʾ����ʾ��ѡ���飬1��ʾѡ���˵���x�����ڲ㣬2Ϊ����y�����ڲ�,3Ϊ����z�����ڲ�
  int[][][]blockSelectedStatus=
  {
      {
          {
              0,0,0,
          }
          ,
          {
              0,0,0 
          }
          ,
          {
              0,0,0 
          }
          ,
      }
      ,
      {
          {
              0,0,0,
          }
          ,
          {
              0,0,0 
          }
          ,
          {
              0,0,0 
          }
          ,
      }
      ,
      {
          {
              0,0,0,
          }
          ,
          {
              0,0,0 
          }
          ,
          {
              0,0,0 
          }
          ,
      }
      ,
  }
  ;
  
  //------------------------------------
  TransparencyAttributes[][][][]biaoMianTransparencyAttributes=new TransparencyAttributes[3][3][3][6];
  //========================
  
  public static float zuoBiaoZhouSmallDingDian=0.09f ;
  //С���궥��λ��
  public static float zuoBiaoZhouSmallDingXi=0.02f ;
  //С���궥��ɡ�İ뾶
  public static float zuoBiaoZhouSmallDingChang=0.07f ;
  //С���궥��ɡ�ĳ���
  public static float zuoBiaoZhouSmallWeiDian=-0.09f ;
  //С����β�͵�λ��
  
  
  
  public static float zuoBiaoZhouBigDingDian=1.0f ;
  //�����궥��λ��
  public static float zuoBiaoZhouBigDingXi=0.04f ;
  //�����궥��ɡ�İ뾶
  public static float zuoBiaoZhouBigDingChang=0.8f ;
  //�����궥��ɡ�ĳ���
  public static float zuoBiaoZhouBigWeiDian=-1.0f ;
  //������β�͵�λ��
  
  //-----------
  //
  int[][][]blockBianHaoMoRen=
  {
      {
          {
              0,1,2 
          }
          ,
          {
              3,4,5 
          }
          ,
          {
              6,7,8 
          }
          ,
      }
      ,
      {
          {
              9,10,11 
          }
          ,
          {
              12,13,14 
          }
          ,
          {
              15,16,17 
          }
          ,
      }
      ,
      {
          {
              18,19,20 
          }
          ,
          {
              21,22,23 
          }
          ,
          {
              24,25,26 
          }
          ,
      }
      ,
      
  }
  ;
  
  int[][][]blockBianHaoZiDingYi=
  {
      {
          {
              0,1,2 
          }
          ,
          {
              3,4,5 
          }
          ,
          {
              6,7,8 
          }
          ,
      }
      ,
      {
          {
              9,10,11 
          }
          ,
          {
              12,13,14 
          }
          ,
          {
              15,16,17 
          }
          ,
      }
      ,
      {
          {
              18,19,20 
          }
          ,
          {
              21,22,23 
          }
          ,
          {
              24,25,26 
          }
          ,
      }
      ,
      
  }
  ;
  Text3D[][][]text3DArray ;
  //==============================
  
  public static float fangKuaiBanJing=0.12f ;
  
  //ÿ�����ɫ,����Ϊ:+x,-x,+y,-y,+z,-z,no
  public static Color3f[]mianColor=
  {
      new Color3f(1.0f,0.0f,0.0f),
      new Color3f(0.0f,1.0f,0.0f),
      new Color3f(0.0f,0.0f,1.0f),
      new Color3f(1.0f,1.0f,0.0f),
      new Color3f(1.0f,0.0f,1.0f),
      new Color3f(0.0f,1.0f,1.0f),
      new Color3f(0.2f,0.2f,0.2f)
  }
  ;
  String[]mianImageFile=new String[7];
  
  
  //��ƫ����
  static float kuaiZhongXinWeizhi=0.25f ;
  
  //��������ʱҪ�õ�,��������,����һ��applet����
  Component observer ;
  //===============================================
  
  //BoundingSphere bounds=new BoundingSphere(new Point3d(0.0,0.0,0.0),1.0f);
  //========================
  //ȫ�ֱ�������ط�������
  TransformGroup rootTransformGroup ;
  //TransformGroup meTransformGroup;
  TransformGroup helpTransformGroup ;
  
  
  //==============
  BranchGroup[][][]blockBranchGroup ;
  
  BranchGroup daZuoBiaoWaiTaoBranchGroup ;
  
  TransformGroup[][][]blockTransformGroup ;
  TransformGroup[][][]blockTransformGroup1 ;
  TransformGroup[][][]blockTransformGroup2 ;
  
  BranchGroup[][][]neiBiaoMianWaiTaoBranchGroup ;
  BranchGroup[][][]waiBiaoMianWaiTaoBranchGroup ;
  BranchGroup[][][]xiaoZuoBiaoWaiTaoBranchGroup ;
  BranchGroup[][][]blockBianHaoBranchGroup ;
  BranchGroup[][][]showBlockSelectedBranchGroup ;
  
  //===========
  Transform3D helpTransform3D ;
  
  Transform3D[][][]blockTransform3D ;
  Transform3D[][][]blockTransform3D1 ;
  Transform3D[][][]blockTransform3D2 ;
  
  
  //-----------------
  //Shape3D[][][] shape3DArray;
  //-----------------
  //ColorCube aColorCube;
  //
  Point3D[][][]centerPointSaved ;
  // Applet theApplet;
  
  //
  
  //=====================================
  BoundingSphere bounds=new BoundingSphere(new Point3d(0.0,0.0,0.0),1.0f);
  
  //==========================
  
  Shape3D shapeMaker(Component observer,String filename,Point3f[]p,int i,int j,int k,int l,boolean isBiaoMian)
  {
      
      //MyPrintln.println (p[0].x);
      //�ò��ʣ��Ķ������鴴��һ���ı��棬��Ҫapplet����observer
      
      
      //������ͼ�����
      TextureLoader loader=new TextureLoader(filename,observer);
      ImageComponent2D myImage=loader.getImage();
      Texture myTex=loader.getTexture();
      myTex.setImage(0,myImage);
      
      //ʹ�ı�����������ɼ�������ֻ�ܴ����濴��
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      
      biaoMianTransparencyAttributes[i][j][k][l]=new TransparencyAttributes(TransparencyAttributes.NONE,0.4f);
      biaoMianTransparencyAttributes[i][j][k][l].setCapability(TransparencyAttributes.ALLOW_VALUE_READ);
      biaoMianTransparencyAttributes[i][j][k][l].setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);
      biaoMianTransparencyAttributes[i][j][k][l].setCapability(TransparencyAttributes.ALLOW_MODE_READ);
      biaoMianTransparencyAttributes[i][j][k][l].setCapability(TransparencyAttributes.ALLOW_MODE_WRITE);
      
      Material mm=new Material();
      mm.setLightingEnable(false);
      
      //PointAttributes pa = new PointAttributes();
      //pa.setPointSize(4.0f);
      //appearance.setPointAttributes(pa);
      
      Appearance appear=new Appearance();
      appear.setTexture(myTex);
      appear.setPolygonAttributes(polyAttrib);
      appear.setMaterial(mm);
      //appear.setPointAttributes(pa);
      
      
      if(isBiaoMian==true)
      {
          appear.setTransparencyAttributes(biaoMianTransparencyAttributes[i][j][k][l]);
      }
      
      
      //�ı��ζ���
      //  QuadArray tri=new QuadArray(dingdian.length,QuadArray.COORDINATES|QuadArray.COLOR_3|QuadArray.TEXTURE_COORDINATE_2);
      QuadArray tri=new QuadArray(4,QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);
      //GeometryArray
      tri.setCoordinates(0,p);
      //tri.setColors(0,color);
      
      //���ı��ζ��������
      TexCoord2f texCoords=new TexCoord2f();
      //��������
      texCoords.set(0.0f,1.0f);
      //ȡ���½�
      tri.setTextureCoordinate(0,0,texCoords);
      //Ϊ���Ͻ�
      texCoords.set(0.0f,0.0f);
      //
      tri.setTextureCoordinate(0,1,texCoords);
      //
      texCoords.set(1.0f,0.0f);
      //
      tri.setTextureCoordinate(0,2,texCoords);
      //
      texCoords.set(1.0f,1.0f);
      //
      tri.setTextureCoordinate(0,3,texCoords);
      //
      //------------------------
      
      //tri.setCapability(GeometryArray.ALLOW_COLOR_READ);
      //tri.setCapability(GeometryArray.ALLOW_NORMAL_READ);
      //tri.setCapability(GeometryArray.ALLOW_INTERSECT);
      
      //tri.setCapability(GeometryArray.ALLOW_TEXCOORD_READ);
      //tri.setCapability(GeometryArray.ALLOW_COUNT_READ);
      //tri.setCapability(GeometryArray.ALLOW_FORMAT_READ);
      // tri.setCapability(GeometryArray.ALLOW_COORDINATE_READ);
      //tri.setCapability(GeometryArray.ALLOW_INTERSECT);
      //--------------------
      Shape3D shape=new Shape3D(tri,appear);
      //---------------------------
      //Geometry geom = new ColorCube1();
      //Appearance appearance = new Appearance();
      //Shape3D 	shape = new Shape3D(geom,appearance);
      //shape.setCapability(Shape3D.ALLOW_APPEARANCE_READ);
      //shape.setCapability(Shape3D.ALLOW_APPEARANCE_WRITE);
      //shape.setCapability(Shape3D.ENABLE_PICK_REPORTING);
      PickTool.setCapabilities(shape,PickTool.INTERSECT_FULL);
      //shape.setPickable(false);
      
      
      //-----------------------------
      
      //
      
      return shape ;
  }
  
  public static void addShowSelectedShape3D(Group parentGroup)
  {
      Appearance ap=new Appearance();
      
      //�Ӳ������ԣ���ɫ�����
      Material mat=new Material();
      mat.setEmissiveColor(new Color3f(1.0f,1.0f,1.0f));
      ap.setMaterial(mat);
      
      TransparencyAttributes ta=new TransparencyAttributes();
      ta.setTransparency(0.4f);
      ta.setTransparencyMode(TransparencyAttributes.BLENDED);
      ap.setTransparencyAttributes(ta);
      
      ColoringAttributes ca=new ColoringAttributes();
      ca.setColor(0.0f,0.0f,1.0f);
      ap.setColoringAttributes(ca);
      
      Box b=new Box(0.14f,0.14f,0.14f,ap);
      b.setPickable(false);
      parentGroup.addChild(b);
      
  }
  
  public static void zuoBiaoZhuSmallXShape3D(Group trans)
  {
      
      
      //����С���������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(zuoBiaoZhouSmallDingDian,0.0f,0.0f);
              colors[i]=mianColor[0];
          }
          else 
          {
              z1=(float)(zuoBiaoZhouSmallDingXi*Math.cos(i*2*Math.PI/25));
              x1=zuoBiaoZhouSmallDingChang ;
              y1=(float)(zuoBiaoZhouSmallDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[0];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(zuoBiaoZhouSmallDingDian,0.0f,0.0f);
              colors[27+i]=mianColor[0];
          }
          else 
          {
              z1=(float)(0.005f*Math.cos(i*2*Math.PI/12));
              x1=zuoBiaoZhouSmallWeiDian ;
              y1=(float)(0.005f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[1];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      //PickTool.setCapabilities(shape, PickTool.INTERSECT_FULL);
      shape.setPickable(false);
      //PickTool.setCapabilities(shape,PickTool.INTERSECT_FULL);
      //trans.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
      
      
      
      //System.out.print("zuoBiaoZhuSmallX ���� ���");
      
      trans.addChild(shape);
      
      
      //�����С��������󴴽����
      
      
  }
  
  
  
  
  public static void zuoBiaoZhuSmallYShape3D(Group trans)
  {
      
      
      //����С���������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(0.0f,zuoBiaoZhouSmallDingDian,0.0f);
              colors[i]=mianColor[2];
          }
          else 
          {
              x1=(float)(zuoBiaoZhouSmallDingXi*Math.cos(i*2*Math.PI/25));
              y1=zuoBiaoZhouSmallDingChang ;
              z1=(float)(zuoBiaoZhouSmallDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[2];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(0.0f,zuoBiaoZhouSmallDingDian,0.0f);
              colors[27+i]=mianColor[2];
          }
          else 
          {
              x1=(float)(0.005f*Math.cos(i*2*Math.PI/12));
              y1=zuoBiaoZhouSmallWeiDian ;
              z1=(float)(0.005f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[3];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      // PickTool.setCapabilities(shape, PickTool.INTERSECT_FULL);
      shape.setPickable(false);
      //shape.setPickable(false);
      //PickTool.setCapabilities(shape,PickTool.INTERSECT_FULL);
      //trans.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
      
      
      
      //System.out.print("zuoBiaoZhuSmallY ���� ���");
      
      trans.addChild(shape);
      
      
      //�����С��������󴴽����
      
      
  }
  
  
  
  
  public static void zuoBiaoZhuSmallZShape3D(Group trans)
  {
      
      
      //����С���������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(0.0f,0.0f,zuoBiaoZhouSmallDingDian);
              colors[i]=mianColor[4];
          }
          else 
          {
              y1=(float)(zuoBiaoZhouSmallDingXi*Math.cos(i*2*Math.PI/25));
              z1=zuoBiaoZhouSmallDingChang ;
              x1=(float)(zuoBiaoZhouSmallDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[4];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(0.0f,0.0f,zuoBiaoZhouSmallDingDian);
              colors[27+i]=mianColor[4];
          }
          else 
          {
              y1=(float)(0.005f*Math.cos(i*2*Math.PI/12));
              z1=zuoBiaoZhouSmallWeiDian ;
              x1=(float)(0.005f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[5];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      //PickTool.setCapabilities(shape,PickTool.INTERSECT_FULL);
      //trans.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
      //shape.setPickable(false);
      //PickTool.setCapabilities(shape, PickTool.INTERSECT_FULL);
      
      shape.setPickable(false);
      
      //System.out.print("zuoBiaoZhuSmallZ ���� ���");
      
      trans.addChild(shape);
      
      
      //�����С��������󴴽����
      
      
  }
  
  
  
  
  
  void reAddNeiBiaoMian()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup2[i][j][k].addChild(neiBiaoMianWaiTaoBranchGroup[i][j][k]);
                  //blockTransformGroup2[i][j][k].addChild(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  //   blockTransformGroup1[i][j][k].addChild(blockTransformGroup2[i][j][k]);
                  
              }
          }
          ///
      }
  }
  
  void reAddWaiBiaoMian()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup2[i][j][k].addChild(waiBiaoMianWaiTaoBranchGroup[i][j][k]);
                  //blockTransformGroup2[i][j][k].addChild(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  //   blockTransformGroup1[i][j][k].addChild(blockTransformGroup2[i][j][k]);
                  
              }
          }
          ///
      }
  }
  void reAddXiaoZuoBiao()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  // blockTransformGroup2[i][j][k].addChild(neiBiaoMianWaiTaoBranchGroup[i][j][k]);
                  blockTransformGroup2[i][j][k].addChild(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  //   blockTransformGroup1[i][j][k].addChild(blockTransformGroup2[i][j][k]);
                  
              }
          }
          ///
      }
  }
  
  void reAddDaZuoBiao()
  {
      rootTransformGroup.addChild(daZuoBiaoWaiTaoBranchGroup);
      
  }
  
  void reMoveNeiBiaoMian()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  neiBiaoMianWaiTaoBranchGroup[i][j][k].detach();
              }
          }
          ///
      }
  }
  void reMoveWaiBiaoMian()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  waiBiaoMianWaiTaoBranchGroup[i][j][k].detach();
              }
          }
          ///
      }
  }
  
  
  void reMoveXiaoZuoBiao()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  xiaoZuoBiaoWaiTaoBranchGroup[i][j][k].detach();
              }
          }
          ///
      }
  }
  void reMoveDaZuoBiao()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  daZuoBiaoWaiTaoBranchGroup.detach();
              }
          }
          ///
      }
  }
  
  //center�������������ɫ
  //���任�����һ�����飬��ͬ��λ���и��ԵĽ��
  void add3DCube(int centerx,int centery,int centerz,Group myTransGroup,boolean onlyBiaoMian)
  {
      
      //System.out.println("���ڻ��ÿ�.....");
      //System.out.println("���ڻ��ÿ�....."+String.valueOf (centerx)+String.valueOf (centery)+String.valueOf (centerz));
      //��ɫ���ݽṹ
      int[]compare=new int[6];
      compare[0]=centerx ;
      //x
      compare[1]=centerx ;
      //x
      compare[2]=centery ;
      //y
      compare[3]=centery ;
      //y
      compare[4]=centerz ;
      //z
      compare[5]=centerz ;
      //z
      
      int[]compareWith=new int[6];
      compareWith[0]=1 ;
      compareWith[1]=-1 ;
      compareWith[2]=1 ;
      compareWith[3]=-1 ;
      compareWith[4]=1 ;
      compareWith[5]=-1 ;
      
      
      Color3f presentMianColor ;
      
      //��ͼ
      String presentImageFile ;
      //ÿ��Ĳ���,����Ϊ:+x,-x,+y,-y,+z,-z,no
      
      mianImageFile[0]="IMG\\coverRight.jpg" ;
      mianImageFile[1]="IMG\\coverLeft.jpg" ;
      mianImageFile[2]="IMG\\coverUp.jpg" ;
      mianImageFile[3]="IMG\\coverDown.jpg" ;
      mianImageFile[4]="IMG\\coverFront.jpg" ;
      mianImageFile[5]="IMG\\coverBehind.jpg" ;
      mianImageFile[6]="IMG\\coverCenter.jpg" ;
      
      
      //�����ݽṹ
      Vector3f mianxin=new Vector3f();
      
      Vector3f[]mianxinpianyi=new Vector3f[6];
      mianxinpianyi[0]=new Vector3f(1,0,0);
      mianxinpianyi[1]=new Vector3f(-1,0,0);
      mianxinpianyi[2]=new Vector3f(0,1,0);
      mianxinpianyi[3]=new Vector3f(0,-1,0);
      mianxinpianyi[4]=new Vector3f(0,0,1);
      mianxinpianyi[5]=new Vector3f(0,0,-1);
      
      Vector3f[]dingdianPianyiX=new Vector3f[4];
      
      dingdianPianyiX[0]=new Vector3f(0.0f,1.0f,1.0f);
      dingdianPianyiX[1]=new Vector3f(0.0f,-1.0f,1.0f);
      dingdianPianyiX[2]=new Vector3f(0.0f,-1.0f,-1.0f);
      dingdianPianyiX[3]=new Vector3f(0.0f,1.0f,-1.0f);
      
      Vector3f[]dingdianPianyiY=new Vector3f[4];
      dingdianPianyiY[0]=new Vector3f(1.0f,0.0f,1.0f);
      dingdianPianyiY[1]=new Vector3f(1.0f,0.0f,-1.0f);
      dingdianPianyiY[2]=new Vector3f(-1.0f,0.0f,-1.0f);
      dingdianPianyiY[3]=new Vector3f(-1.0f,0.0f,1.0f);
      
      Vector3f[]dingdianPianyiZ=new Vector3f[4];
      dingdianPianyiZ[0]=new Vector3f(1.0f,1.0f,0.0f);
      dingdianPianyiZ[1]=new Vector3f(-1.0f,1.0f,0.0f);
      dingdianPianyiZ[2]=new Vector3f(-1.0f,-1.0f,0.0f);
      dingdianPianyiZ[3]=new Vector3f(1.0f,-1.0f,0.0f);
      
      //ͨ��for,���ϵ���������
      Point3f[][]vert=new Point3f[6][4];
      //Color3f[] color=new Color3f[6];
      // String[] imageFile=new String[6];
      
      for(int i=0;i<=5;i++)
      {
          
          //������� ��ɫ����ͼ
          if(compare[i]==compareWith[i])
          {
              presentMianColor=mianColor[i];
              presentImageFile=mianImageFile[i];
              if(onlyBiaoMian==false)
              {
                  continue ;
              }
          }
          else 
          {
              presentMianColor=mianColor[6];
              presentImageFile=mianImageFile[6];
              //6����ɫ�ǰ�ɫ�������ɫΪ��ɫ����������
              //continue����������
              if(onlyBiaoMian==true)
              {
                  continue ;
              }
          }
          
          try 
          {
              //System.in.read();//��ͣ
          }
          catch(Exception e)
          {
          }
          
          //������� ����
          mianxin.x=mianxinpianyi[i].x ;
          mianxin.y=mianxinpianyi[i].y ;
          mianxin.z=mianxinpianyi[i].z ;
          
          //������� �ĸ���
          Vector3f[]dingdian=new Vector3f[4];
          
          for(int j=0;j<=3;j++)
          {
              
              
              dingdian[j]=new Vector3f();
              
              if(i==0||i==1)
              {
                  dingdian[j].x=mianxin.x+dingdianPianyiX[j].x ;
                  dingdian[j].y=mianxin.y+dingdianPianyiX[j].y ;
                  dingdian[j].z=mianxin.z+dingdianPianyiX[j].z ;
              }
              else if(i==2||i==3)
              {
                  dingdian[j].x=mianxin.x+dingdianPianyiY[j].x ;
                  dingdian[j].y=mianxin.y+dingdianPianyiY[j].y ;
                  dingdian[j].z=mianxin.z+dingdianPianyiY[j].z ;
              }
              else if(i==4||i==5)
              {
                  dingdian[j].x=mianxin.x+dingdianPianyiZ[j].x ;
                  dingdian[j].y=mianxin.y+dingdianPianyiZ[j].y ;
                  dingdian[j].z=mianxin.z+dingdianPianyiZ[j].z ;
              }
              
              
              /*
                                            if(i==1)
                                              {
                                                  dingdian[3-j].x=mianxin.x+dingdianPianyiX[j].x ;
                                                  dingdian[3-j].y=mianxin.y+dingdianPianyiX[j].y ;
                                                  dingdian[3-j].z=mianxin.z+dingdianPianyiX[j].z ;
                                              }
                                              else if(i==3)
                                              {
                                                  dingdian[3-j].x=mianxin.x+dingdianPianyiY[j].x ;
                                                  dingdian[3-j].y=mianxin.y+dingdianPianyiY[j].y ;
                                                  dingdian[3-j].z=mianxin.z+dingdianPianyiY[j].z ;
                                              }
                                              else if(i==5)
                                              {
                                                  dingdian[3-j].x=mianxin.x+dingdianPianyiZ[j].x ;
                                                  dingdian[3-j].y=mianxin.y+dingdianPianyiZ[j].y ;
                                                  dingdian[3-j].z=mianxin.z+dingdianPianyiZ[j].z ;
                                              }
                                  */
              
          }
          
          
          
          //�ö������ɫ�� ����
          
          //���淽��һ,��vector3D���󴫽�ȥ��������ת��Ϊfloat����
          //Shape3D shape=mian1of6CubeShape3D(observer,dingdian,presentImageFile,presentMianColor);
          
          //���淽��������vector3D������ת��Ϊpoint3f���飬�ٴ���ȥ��ת������
          Point3f[]vertArray=new Point3f[4];
          //Point3f[] vert2=new Point3f[4];
          //4�������Ϣ
          for(int k=0;k<=3;k++)
          {
              //������Ϊ�����棬������Ϊ������
              // if(i==0||i==2||i==4)
              //  {
              
              vertArray[3-k]=new Point3f(fangKuaiBanJing*dingdian[k].x,fangKuaiBanJing*dingdian[k].y,fangKuaiBanJing*dingdian[k].z);
              
              // }
              // else if(i==1||i==3||i==5)
              // {
              // 	vertArray[k]=new Point3f(fangKuaiBanJing*dingdian[k].x ,fangKuaiBanJing*dingdian[k].y,fangKuaiBanJing*dingdian[k].z);
              
              // }
              // vert2[3-k]=new Point3f(fangKuaiBanJing*dingdian[k].x ,fangKuaiBanJing*dingdian[k].y,fangKuaiBanJing*dingdian[k].z);
          }
          
          //vertArray[k]=new Point3f(fangKuaiBanJing*dingdian[k].x ,fangKuaiBanJing*dingdian[k].y,fangKuaiBanJing*dingdian[k].z);
          
          
          // void add3DCube(int centerx,int centery,int centerz,Group myTransGroup,boolean onlyBiaoMian)
          if(onlyBiaoMian==true)
          {
              Shape3D shape=shapeMaker(observer,presentImageFile,vertArray,centerx+1,centery+1,centerz+1,i,true);
              myTransGroup.addChild(shape);
          }
          else 
          {
              Shape3D shape=shapeMaker(observer,presentImageFile,vertArray,centerx+1,centery+1,centerz+1,i,false);
              myTransGroup.addChild(shape);
          }
          // TransparencyAttributes aTransparencyAttributes=new TransparencyAttributes(2,0.5f);
          // aTransparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_READ);
          //getTransparency(float);
          // aTransparencyAttributes.setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);
          //setTransparency()
          //    appear.setTransparencyAttributes(aTransparencyAttributes) ;
          
          //shape.
          // Shape3D shape2=shapeMaker(observer,presentImageFile,vert2);
          //���������һ��
          
          
          
          
          //��ʧ���� ���Ա��⣬ԭ���Ǹ����νӵ㲻�غϣ�dingdian[k].x����fangKuaiBanJing������������
          
          
          
          //�ҵ��Լ�������ϵ
          
          //myTransGroup.addChild(shape2);
          
          //����3
          
          // for(int j=0;j<=3;j++)
          //  {
          // vert[i][j]=new Point3f(fangKuaiBanJing*dingdian[j].x ,fangKuaiBanJing*dingdian[j].y,fangKuaiBanJing*dingdian[j].z);
          //	}
          //color[i]=presentMianColor;
          // imageFile[i]=presentImageFile;
          
      }
      
      //����3
      
      // box3D(observer,myTransGroup,vert,color,imageFile);
      
      
      //System.out.println("��"+whickBlockPainted+"����ϡ�");
      System.out.print('.');
      //whickBlockPainted++;
  }
  
  BranchGroup3(Applet atheApplet)
  {
      //theApplet=theApplet;
      MyPrintln.println("new BranchGroup3");
      //this.setPickable(true);
      //PickTool.setCapabilities(this,PickTool.INTERSECT_FULL);
      
      
      //new Thread(this,"BranchGroup3").start();
      
      //==================
      /*
              int[][] test1={{1,0,0,},{0,1,0,},{0,0,1}};
              int[][] test2={
              	{1,0,0},
              	{0,-1,0},
              	{0,0,-1},
              	};
      
                      MyPrintln.println (BlockRotateStatusTableAndSouSuo.getShortLuJing(test1,test2).toString());
                      */
      //�Ȳ�ʹ�ñ任���������Ӻ����ף�����ֻ���ǽṹ
      //========================================
      //���ý��-�����Ĺ���-BranchGroup-��ȥ��
      this.setCapability(BranchGroup.ALLOW_DETACH);
      //this.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
      //rootTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
      //rootTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
      
      //=====================================
      //�������-�����
      rootTransformGroup=new TransformGroup();
      
      //���ý��-�����Ĺ���-rootTransformGroup-���ó�������λ�ú�ĳ���������ת��
      rootTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      rootTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      //neiBiaoMianWaiTao
      rootTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
      rootTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
      rootTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
      //rootTransformGroup.setCapability(BranchGroup.ENABLE_PICK_REPORTING);
      
      //-----------------------------
      helpTransformGroup=new TransformGroup();
      //���ڶ�̬��ת
      helpTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      helpTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      
      helpTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
      helpTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
      helpTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
      
      helpTransformGroup.setPickable(false);
      //======================
      daZuoBiaoWaiTaoBranchGroup=new BranchGroup();
      daZuoBiaoWaiTaoBranchGroup.setCapability(BranchGroup.ALLOW_DETACH);
      daZuoBiaoWaiTaoBranchGroup.setPickable(false);
      //============
      //��������Զ�������¼�
      MyKeyBoardBehavior aMyBehavior=new MyKeyBoardBehavior();
      aMyBehavior.setSchedulingBounds(bounds);
      this.addChild(aMyBehavior);
      //=============
      blockBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockBranchGroup[i][j][k]=new BranchGroup();
                  blockBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  blockBranchGroup[i][j][k].setCapability(BranchGroup.ENABLE_PICK_REPORTING);
              }
          }
      }
      //====================================
      blockTransformGroup=new TransformGroup[3][3][3];
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup[i][j][k]=new TransformGroup();
                  //�����ڶ�ÿ����µ�λ���������»�,��ת�ķ�ʽ���ԣ��ؽ��ÿ�ļ���ͼ���
                  //��Ȼÿ��ֻ��������9����
                  blockTransformGroup[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                  blockTransformGroup[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
                  //blockTransformGroup[i][j][k].setCapability(TransformGroup.ENABLE_PICK_REPORTING);
                  //blockTransformGroup[i][j][k].setPickable(false);//////
                  
                  //=============================
                  //blockTransform3D[i][j][k]  ;
                  //blockTransform3D[i][j][k] blockTransform3D1 ;
                  //blockTransform3D[i][j][k] blockTransform3D2 ;
                  
              }
          }
          ///
          ///
      }
      //
      
      
      
      blockTransformGroup1=new TransformGroup[3][3][3];
      //blockTransform3D1=new Transform3D[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup1[i][j][k]=new TransformGroup();
                  // blockTransform3D1[i][j][k]=new Transform3D();
                  // blockTransform3D1[i][j][k].rotX(Math.toRadians(0));
                  
                  blockTransformGroup1[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                  blockTransformGroup1[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
                  //blockTransformGroup1[i][j][k].setCapability(TransformGroup.ENABLE_PICK_REPORTING);
                  
              }
          }
          ///
      }
      //
      
      blockTransformGroup2=new TransformGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup2[i][j][k]=new TransformGroup();
                  
                  blockTransformGroup2[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
                  blockTransformGroup2[i][j][k].setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
                  
                  blockTransformGroup2[i][j][k].setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
                  blockTransformGroup2[i][j][k].setCapability(TransformGroup.ALLOW_CHILDREN_READ);
                  blockTransformGroup2[i][j][k].setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
                  
                  //blockTransformGroup2[i][j][k].setCapability(TransformGroup.ENABLE_PICK_REPORTING);
                  
              }
          }
          ///
      }
      
      neiBiaoMianWaiTaoBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  neiBiaoMianWaiTaoBranchGroup[i][j][k]=new BranchGroup();
                  
                  neiBiaoMianWaiTaoBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  //neiBiaoMianWaiTaoBranchGroup[i][j][k].setCapability(TransformGroup.ENABLE_PICK_REPORTING);
                  
              }
          }
          ///
      }
      waiBiaoMianWaiTaoBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  waiBiaoMianWaiTaoBranchGroup[i][j][k]=new BranchGroup();
                  
                  waiBiaoMianWaiTaoBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  //waiBiaoMianWaiTaoBranchGroup[i][j][k].setCapability(TransformGroup.ENABLE_PICK_REPORTING);
                  
              }
          }
          ///
      }
      xiaoZuoBiaoWaiTaoBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]=new BranchGroup();
                  
                  xiaoZuoBiaoWaiTaoBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  xiaoZuoBiaoWaiTaoBranchGroup[i][j][k].setPickable(false);
              }
          }
          ///
      }
      
      blockBianHaoBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockBianHaoBranchGroup[i][j][k]=new BranchGroup();
                  
                  blockBianHaoBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  //blockBianHaoBranchGroup[i][j][k].setPickable(false);
              }
          }
          ///
      }
      
      showBlockSelectedBranchGroup=new BranchGroup[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  showBlockSelectedBranchGroup[i][j][k]=new BranchGroup();
                  
                  showBlockSelectedBranchGroup[i][j][k].setCapability(BranchGroup.ALLOW_DETACH);
                  showBlockSelectedBranchGroup[i][j][k].setPickable(false);
              }
          }
          ///
      }
      
      //neiBiaoMianWaiTaoBranchGroup
      
      
      // blockTransform3D=new Transform3D[3][3][3];
      // blockTransform3D1=new Transform3D[3][3][3];
      //blockTransform3D2=new Transform3D[3][3][3];
      //
      
      
      //==========================
      
      //meTransformGroup=new TransformGroup();
      //���ý��-�����Ĺ���-meTransformGroup-���ó�������λ�ú�ĳ���������ת��
      //meTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      //meTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      //=======================================
      //����Ҷ��-�������
      //    aColorCube=new ColorCube(0.5f);
      //===============================
      //����Ҷ��-��Ϊ����
      //�����ת��Ϊ
      MouseRotate behavior=new MouseRotate();
      behavior.setTransformGroup(rootTransformGroup);
      behavior.setSchedulingBounds(bounds);
      this.addChild(behavior);
      //   setPickMode(PickCanvas.BOUNDS);
      //} else if (value == geometryString) {
      // setPickMode(PickCanvas.GEOMETRY);
      //} else if (value == geometryIntersectString) {
      //  setPickMode(PickCanvas.GEOMETRY_INTERSECT_INFO);
      //}
      
      //  setPickTolerance(0.0f);
      //} else if (value == tolerance2String) {
      // setPickTolerance(2.0f);
      //} else if (value == tolerance4String) {
      //   setPickTolerance(4.0f);
      // } else if (value == tolerance8String) {
      //  setPickTolerance(8.0f);
      
      
      
      //PickRotateBehavior aPickRotateBehavior=new PickRotateBehavior(this,MoFang.testPanelAddedScene3D.c,new BoundingSphere(new Point3d(0.0,0.0,0.0), 1.0f),PickTool.GEOMETRY);
      //aPickRotateBehavior.setMode(PickCanvas.BOUNDS);
      //aPickRotateBehavior.setMode(PickCanvas.BOUNDS);
      //aPickRotateBehavior.setTolerance(4.0f);
      //MoFang.testPanelAddedScene3D.u.getViewer().getView().setProjectionPolicy(View.PARALLEL_PROJECTION);
      //this.addChild(aPickRotateBehavior);
      
      //
      MyPickMouseBehavior aMyPickMouseBehavior=new MyPickMouseBehavior(MoFang.testPanelAddedScene3D.c,this,new BoundingBox(new Point3d(-fangKuaiBanJing,-fangKuaiBanJing,-fangKuaiBanJing),new Point3d(fangKuaiBanJing,fangKuaiBanJing,fangKuaiBanJing)));
      aMyPickMouseBehavior.setSchedulingBounds(new BoundingBox(new Point3d(-fangKuaiBanJing,-fangKuaiBanJing,-fangKuaiBanJing),new Point3d(fangKuaiBanJing,fangKuaiBanJing,fangKuaiBanJing)));
      this.addChild(aMyPickMouseBehavior);
      
      //=====================================
      //-----------------------------------------
      //����Ҷ��-���ϵ�����װ��������������װ.
      //���ϵ���
      this.addChild(rootTransformGroup);
      rootTransformGroup.addChild(helpTransformGroup);
      
      
      
      rootTransformGroup.addChild(daZuoBiaoWaiTaoBranchGroup);
      zuoBiaoZhuBigXShape3D(daZuoBiaoWaiTaoBranchGroup);
      zuoBiaoZhuBigYShape3D(daZuoBiaoWaiTaoBranchGroup);
      zuoBiaoZhuBigZShape3D(daZuoBiaoWaiTaoBranchGroup);
      //27������װ�����ϡ��ö���ʱ��װ9����helpTransformGroup��
      // zuoBiaoZhuBigXShape3D(daZuoBiaoWaiTaoBranchGroup);
      
      
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  rootTransformGroup.addChild(blockBranchGroup[i][j][k]);
                  
              }
          }
      }
      
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockBranchGroup[i][j][k].addChild(blockTransformGroup[i][j][k]);
                  blockTransformGroup[i][j][k].addChild(blockTransformGroup1[i][j][k]);
                  blockTransformGroup1[i][j][k].addChild(blockTransformGroup2[i][j][k]);
                  
                  
              }
          }
          ///
      }
      
      
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup2[i][j][k].addChild(neiBiaoMianWaiTaoBranchGroup[i][j][k]);
                  blockTransformGroup2[i][j][k].addChild(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  blockTransformGroup2[i][j][k].addChild(waiBiaoMianWaiTaoBranchGroup[i][j][k]);
                  blockTransformGroup2[i][j][k].addChild(blockBianHaoBranchGroup[i][j][k]);
                  
                  //ȥ���˸��У���ʾ�������ʾ����ѡ��򣬷���ȫ��ʾ���ǲ���Ч��
                  //blockTransformGroup2[i][j][k].addChild(showBlockSelectedBranchGroup[i][j][k]);
                  
                  
              }
          }
          ///
      }
      //------------------------
      //      shape3DArray=new Shape3D[3][3][3];
      
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  add3DCube(i-1,j-1,k-1,neiBiaoMianWaiTaoBranchGroup[i][j][k],false);
                  //add3DCube(i-1,j-1,k-1,blockTransformGroup[i][j][k],false);
                  
              }
          }
          ///
      }
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  add3DCube(i-1,j-1,k-1,waiBiaoMianWaiTaoBranchGroup[i][j][k],true);
                  //add3DCube(i-1,j-1,k-1,blockTransformGroup[i][j][k],true);
                  
              }
          }
          ///
      }
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  zuoBiaoZhuSmallXShape3D(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  zuoBiaoZhuSmallYShape3D(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  zuoBiaoZhuSmallZShape3D(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  
              }
          }
          ///
      }
      
      text3DArray=new Text3D[3][3][3];
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  text3DArray[i][j][k]=addText3DDonghua(blockBianHaoBranchGroup[i][j][k],String.valueOf(blockBianHaoMoRen[i][j][k]),new Point3f(0.0f,0.0f,0.0f),0.05f,0);
              }
          }
          ///
      }
      
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  //text3DArray[i][j][k]=addText3DDonghua(blockBianHaoBranchGroup[i][j][k],String.valueOf(blockBianHaoMoRen[i][j][k]),new Point3f(0.0f,0.0f,0.0f),0.05f,0);
                  addShowSelectedShape3D(showBlockSelectedBranchGroup[i][j][k]);
              }
          }
          ///
      }
      //------------------------
      
      //
      //BranchGroup trtr=new BranchGroup();
      //trtr.setCapability(BranchGroup.ALLOW_DETACH);
      //this.addChild(trtr);
      //BranchGroup trtrt5=new BranchGroup();
      //trtrt5.setCapability(BranchGroup.ALLOW_DETACH);
      //rootTransformGroup.addChild(trtrt5);
      
      //rootTransformGroup.moveTo(this);
      //this.removeChild(rootTransformGroup) ;
      //-------rootTransformGroup.addChild(behavior);
      //this.rootTransformGroup.addChild(behavior);
      //�ӵ�ͬ����ӵ��ϲ��Ч
      //rootTransformGroup.addChild(meTransformGroup);
      //rootTransformGroup.removeChild(meTransformGroup) ;
      //meTransformGroup.addChild(aColorCube);
      //meTransformGroup.removeChild(aColorCube);
      //-------------------------
      
      
      
      //
      
      //meTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_EXTEND);
      //meTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_READ);
      //meTransformGroup.setCapability(TransformGroup.ALLOW_CHILDREN_WRITE);
      
      //=====================================
      
      //this.setCapability
      //------------------------
      //������߲����룬�����ǽ����Ż���֮������ʹ��removeChild��ֻ�з�֧����ʹ��
      this.compile();
      //rootTransformGroup.removeChild(meTransformGroup);
      //rootTransformGroup.removeChild(trtrt5);
      
      
      //addChild,moveChild�����ڱ����ʹ��
      //��Ϊ����ȥ��֧��
      //moveTo���ر��addChild
      //detach���ر��moveChild
      
      //ȥ���������ǣ�
      //���Ƿ�֧����߱任��
      //���Ƿ�֧��
      //������������ҲҪ������
      
      //������ÿһ������ȥ��
      //��Ҫ��ÿһ���任������һ����֧��
      //ÿһ���任��ɼӼ�
      //ÿһ����֧���detach
  }
  
  //ֻ�з�֧�����
  
  
  Text3D addText3DDonghua(Group parentTrg,String textString,Point3f myPoint3f,float sl,int donghua)
  {
      //s1��scale��myPoint3f��λ�ã�daxiao�Ǵ�С
      //�ֵ����½�Ĭ�����½����е㣬��tl=0.1ʱ��Ҫ������10�ŵ����
      //��shape3d�ϼ���һ���任�飬���ڿ��ƴ�С
      //�Զ���trg
      //Transform3D trgtra=new Transform3D();
      //TransformGroup trg=new TransformGroup(trgtra);
      //trg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      //trg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      //trg.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
      
      
      double tessellation=-0.0 ;
      String fontName="vadana" ;
      // Create the root of the branch graph
      
      
      // Create a Transformgroup to scale all objects so they
      // appear in the scene.
      //TransformGroup objScale=new TransformGroup();
      Transform3D t3d=new Transform3D();
      // Assuming uniform size chars, set scale to fit string in view
      TransformGroup trg=new TransformGroup();
      
      t3d.setScale(sl);
      
      trg.setTransform(t3d);
      // trg.addChild(objScale);
      
      // Create the transform group node and initialize it to the
      // identity.  Enable the TRANSFORM_WRITE capability so that
      // our behavior code can modify it at runtime.  Add it to the
      // root of the subgraph.
      
      //objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      //objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
      
      //objScale.addChild(objTrans);
      
      
      Font3D f3d ;
      if(tessellation>0.0)
      {
          f3d=new Font3D(new Font(fontName,Font.PLAIN,2),
          tessellation,
          new FontExtrusion());
      }
      else 
      {
          f3d=new Font3D(new Font(fontName,Font.PLAIN,2),
          new FontExtrusion());
      }
      
      
      Text3D txt=new Text3D(f3d,textString,
      myPoint3f);
      txt.setCapability(txt.ALLOW_STRING_WRITE);
      
      //--------------------
      /*	Appearance app=((Shape3D)txt).getAppearance();
              	app.setCapability(Appearance.ALLOW_TEXTURE_READ);
              		app.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
      
              Texture 	texture1=app.getTexture();
              	texture1.setCapability(texture1.ALLOW_IMAGE_READ);
              	texture1.setCapability(texture1.ALLOW_IMAGE_WRITE);
      
              objTrans.addChild(txt);
              */
      //-----------------
      Material mm=new Material();
      mm.setLightingEnable(true);
      
      //Texture texture1=new Texture();
      //texture1.setCapability(Texture.ALLOW_IMAGE_READ);
      //texture1.setCapability(Texture.ALLOW_IMAGE_WRITE);
      //������ͼ�����
      TextureLoader loader=new TextureLoader("IMG\\text3D.jpg",observer);
      ImageComponent2D myImage=loader.getImage();
      Texture myTex=loader.getTexture();
      myTex.setImage(0,myImage);
      
      
      
      
      
      Appearance app=new Appearance();
      //Texture3D texture1=new Texture3D();
      //texture1.setCapability(Texture.ALLOW_IMAGE_READ);
      //texture1.setCapability(Texture.ALLOW_IMAGE_WRITE);
      
      //app.setCapability(Appearance.ALLOW_TEXTURE_READ);
      //app.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
      
      app.setMaterial(mm);
      app.setTexture(myTex);
      //app.setTexture(texture1);
      
      //-----------------------
      Shape3D sh=new Shape3D();
      sh.setGeometry(txt);
      sh.setAppearance(app);
      
      //PickTool.setCapabilities(sh,PickTool.INTERSECT_FULL);
      //trg.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
      
      
      sh.setPickable(false);
      trg.addChild(sh);
      
      
      
      
      //if(donghua==1)
      //{
      //��trg���Զ��壩,������ת���
      //        Alpha alpha1=new Alpha(-1,Alpha.INCREASING_ENABLE|Alpha.DECREASING_ENABLE,0,0,5000,300,100000,5000,300,100000);
      //        RotationInterpolator myRoTate=new RotationInterpolator(alpha1,trg,trgtra,0.0f,(float)Math.PI*30);
      //myRoTate.setSchedulingBounds(bounds);
      //trg.addChild(myRoTate);
      //trgtra.rotZ(Math.PI/2);
      //trg.setTransform(trgtra);
      //System.out.println("\n�ı� ���� ����:"+donghua);
      //}
      
      
      parentTrg.addChild(trg);
      
      //
      //txt.setString("OK");
      return txt ;
  }
  
  void showABlockSelectedStatusByBuffer(int i,int j,int k)
  {
      //		boolean[][][] lastBufferBlockSelected={
      //{{false,false,false,},{false,false,false,},{false,false,false,},},
      //{{false,false,false,},{false,false,false,},{false,false,false,},},
      //{{false,false,false,},{false,false,false,},{false,false,false,},},
      //	};//bufferBlockSelected
      
      if(bufferBlockSelected[i][j][k]==false&&lastBufferBlockSelected[i][j][k]==true)
      {
          
          showBlockSelectedBranchGroup[i][j][k].detach();
      }
      
      
      else if(bufferBlockSelected[i][j][k]==true&&lastBufferBlockSelected[i][j][k]==false)
      {
          //showBlockSelectedBranchGroup[i][j][k].detach();
          //blockTransformGroup2.addChild(showBlockSelectedBranchGroup[i][j][k]);
          blockTransformGroup2[i][j][k].addChild(showBlockSelectedBranchGroup[i][j][k]);
          
      }
      
      else 
      {
          //ǰ��״̬һ����û�仯�����Բ�����
      }
      
      //============
      //����״̬
      lastBufferBlockSelected[i][j][k]=bufferBlockSelected[i][j][k];
      
      //============
  }
  
  void showAllBlockSelectedStatus()
  {
      
      //================�������
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          
          bufferBlockSelected[i][j][k]=false ;
          
      }
      
      //=================���ɻ��壬�ҳ�Ӧ����ʾ�Ŀ�
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          if(blockSelected[i][j][k]==true)
          {
              //������ѡ��״̬���д���
              if(blockSelectedStatus[i][j][k]==0)
              {
                  //��ѡ�иÿ�״̬
                  bufferBlockSelected[i][j][k]=true ;
                  
              }
              else if(blockSelectedStatus[i][j][k]==1)
              {
                  //ѡ�иò�״̬��=xͬ���Ҳ��ʾ
                  
                  for(int l=0;l<3;l++)
                  for(int m=0;m<3;m++)
                  for(int n=0;n<3;n++)
                  {
                      if(MoFang.aMofangStatusMessage.dataMessage[l][m][n].blockCenter.x==
                      MoFang.aMofangStatusMessage.dataMessage[i][j][k].blockCenter.x 
                      )
                      {
                          bufferBlockSelected[l][m][n]=true ;
                      }
                  }
              }
              
              else if(blockSelectedStatus[i][j][k]==2)
              {
                  //ѡ�иò�״̬��=yͬ���Ҳ��ʾ
                  
                  for(int l=0;l<3;l++)
                  for(int m=0;m<3;m++)
                  for(int n=0;n<3;n++)
                  {
                      if(MoFang.aMofangStatusMessage.dataMessage[l][m][n].blockCenter.y==
                      MoFang.aMofangStatusMessage.dataMessage[i][j][k].blockCenter.y 
                      )
                      {
                          bufferBlockSelected[l][m][n]=true ;
                      }
                  }
              }
              else if(blockSelectedStatus[i][j][k]==3)
              {
                  //ѡ�иò�״̬��=zͬ���Ҳ��ʾ
                  
                  for(int l=0;l<3;l++)
                  for(int m=0;m<3;m++)
                  for(int n=0;n<3;n++)
                  {
                      if(MoFang.aMofangStatusMessage.dataMessage[l][m][n].blockCenter.z==
                      MoFang.aMofangStatusMessage.dataMessage[i][j][k].blockCenter.z 
                      )
                      {
                          bufferBlockSelected[l][m][n]=true ;
                      }
                  }
              }
          }
      }
      
      //==================��ʾ���
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          showABlockSelectedStatusByBuffer(i,j,k);
      }
      
      
  }
  
  
  void zuoBiaoZhuBigXShape3D(Group trans)
  {
      
      
      //���������������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      
      addText3DDonghua(trans,"X",new Point3f(zuoBiaoZhouBigDingDian*10,0.0f,0.0f),0.1f,0);
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(zuoBiaoZhouBigDingDian,0.0f,0.0f);
              colors[i]=mianColor[0];
          }
          else 
          {
              z1=(float)(zuoBiaoZhouBigDingXi*Math.cos(i*2*Math.PI/25));
              x1=zuoBiaoZhouBigDingChang ;
              y1=(float)(zuoBiaoZhouBigDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[0];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(zuoBiaoZhouBigDingDian,0.0f,0.0f);
              colors[27+i]=mianColor[0];
          }
          else 
          {
              z1=(float)(0.01f*Math.cos(i*2*Math.PI/12));
              x1=zuoBiaoZhouBigWeiDian ;
              y1=(float)(0.01f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[1];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      
      
      
      //System.out.print("zuoBiaoZhuBigX ���� ���\n");
      shape.setPickable(false);
      trans.addChild(shape);
      
      
      //���������������󴴽����
      
      
  }
  
  
  
  
  void zuoBiaoZhuBigYShape3D(Group trans)
  {
      
      
      //���������������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      
      addText3DDonghua(trans,"Y",new Point3f(-1.0f,zuoBiaoZhouBigDingDian*10,0.0f),0.1f,0);
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(0.0f,zuoBiaoZhouBigDingDian,0.0f);
              colors[i]=mianColor[2];
          }
          else 
          {
              x1=(float)(zuoBiaoZhouBigDingXi*Math.cos(i*2*Math.PI/25));
              y1=zuoBiaoZhouBigDingChang ;
              z1=(float)(zuoBiaoZhouBigDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[2];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(0.0f,zuoBiaoZhouBigDingDian,0.0f);
              colors[27+i]=mianColor[2];
          }
          else 
          {
              x1=(float)(0.01f*Math.cos(i*2*Math.PI/12));
              y1=zuoBiaoZhouBigWeiDian ;
              z1=(float)(0.01f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[3];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      
      
      
      // System.out.print("zuoBiaoZhuBigY ���� ���\n");
      shape.setPickable(false);
      trans.addChild(shape);
      
      
      //���������������󴴽����
      
      
  }
  
  
  
  
  void zuoBiaoZhuBigZShape3D(Group trans)
  {
      
      
      //���������������
      
      int i ;
      float x1,x2,y1,y2,z1,z2 ;
      addText3DDonghua(trans,"Z",new Point3f(-1.0f,0.0f,zuoBiaoZhouBigDingDian*10),0.1f,0);
      
      Point3f[]vert=new Point3f[41];
      Color3f[]colors=new Color3f[41];
      for(i=0;i<27;i++)
      {
          if(i==0)
          {
              vert[i]=new Point3f(0.0f,0.0f,zuoBiaoZhouBigDingDian);
              colors[i]=mianColor[4];
          }
          else 
          {
              y1=(float)(zuoBiaoZhouBigDingXi*Math.cos(i*2*Math.PI/25));
              z1=zuoBiaoZhouBigDingChang ;
              x1=(float)(zuoBiaoZhouBigDingXi*Math.sin(i*2*Math.PI/25));
              vert[i]=new Point3f(x1,y1,z1);
              colors[i]=mianColor[4];
          }
      }
      
      for(i=0;i<14;i++)
      {
          if(i==0)
          {
              vert[27+i]=new Point3f(0.0f,0.0f,zuoBiaoZhouBigDingDian);
              colors[27+i]=mianColor[4];
          }
          else 
          {
              y1=(float)(0.01f*Math.cos(i*2*Math.PI/12));
              z1=zuoBiaoZhouBigWeiDian ;
              x1=(float)(0.01f*Math.sin(i*2*Math.PI/12));
              vert[27+i]=new Point3f(x1,y1,z1);
              colors[27+i]=mianColor[5];
          }
      }
      
      
      
      
      int count[]=new int[2];
      count[0]=27 ;
      count[1]=14 ;
      
      TriangleFanArray tri=new TriangleFanArray(
      vert.length,
      TriangleFanArray.COORDINATES|TriangleStripArray.COLOR_3,
      count 
      );
      tri.setCoordinates(0,vert);
      tri.setColors(0,colors);
      
      
      Appearance app=new Appearance();
      
      PolygonAttributes polyAttrib=new PolygonAttributes();
      polyAttrib.setCullFace(PolygonAttributes.CULL_NONE);
      //polyAttrib.setPolygonMode(PolygonAttributes.POLYGON_LINE);
      app.setPolygonAttributes(polyAttrib);
      
      Shape3D shape=new Shape3D(tri,app);
      
      shape.setPickable(false);
      
      //System.out.print("zuoBiaoZhuBigZ ���� ���\n");
      
      trans.addChild(shape);
      
      
      //���������������󴴽����
      
      
  }
  
  void setupBlockAllNew()
  {
      MofangStatusMessage allNewMofangStatusMessage=new MofangStatusMessage("new");
      BlockMessage[][][]dataMessage ;
      dataMessage=allNewMofangStatusMessage.dataMessage ;
      setStatus(dataMessage);
  }
  
  void setStatus(BlockMessage[][][]dataMessage)
  {
      //MofangStatusMessage
      setRotateSelf(dataMessage);
      setPosition(dataMessage);
      
  }
  
  void setPosition(BlockMessage[][][]dataMessage)
  {
      //--------
      centerPointSaved=new Point3D[3][3][3];
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          centerPointSaved[i][j][k]=new Point3D(
          dataMessage[i][j][k].blockCenter.x,
          dataMessage[i][j][k].blockCenter.y,
          dataMessage[i][j][k].blockCenter.z);
      }
      //---------
      
      blockTransform3D=new Transform3D[3][3][3];
      //blockTransform3D1=new Transform3D[3][3][3];
      //blockTransform3D2=new Transform3D[3][3][3];
      
      //     System.out.println("");
      //      System.out.println("ƽ����:");
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          float fx ;
          float fy ;
          float fz ;
          
          //  	System.out.print(String.valueOf(dataMessage[i][j][k].blockCenter.x));
          //  System.out.print(" "+String.valueOf(dataMessage[i][j][k].blockCenter.y));
          //  System.out.print(" "+String.valueOf(dataMessage[i][j][k].blockCenter.z)+"    ");
          //    System.out.println("");
          fx=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.x ;
          fy=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.y ;
          fz=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.z ;
          Vector3f newVector3f=new Vector3f(fx,fy,fz);
          blockTransform3D[i][j][k]=new Transform3D();
          blockTransform3D[i][j][k].setTranslation(newVector3f);
          blockTransformGroup[i][j][k].setTransform(blockTransform3D[i][j][k]);
      }
  }
  /*���񲻸÷�������
          void calculateRotateSelf(int[] saiXuanJi)
          {//��ѡ���Ĺ���������飬����{0,1,0,1,0,1,1,0,0}��1��ʾ����
              //��������������������������ѡ����Ϊ3*3������
                      int[][]test1=
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
              }
              ;
              int[][]test2=
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
              }
              ;
              test2[0][0]=dataMessage[i][j][k].blockEx.x ;
              test2[1][0]=dataMessage[i][j][k].blockEx.y ;
              test2[2][0]=dataMessage[i][j][k].blockEx.z ;
  
              test2[0][1]=dataMessage[i][j][k].blockEy.x ;
              test2[1][1]=dataMessage[i][j][k].blockEy.y ;
              test2[2][1]=dataMessage[i][j][k].blockEy.z ;
  
              test2[0][2]=dataMessage[i][j][k].blockEz.x ;
              test2[1][2]=dataMessage[i][j][k].blockEz.y ;
              test2[2][2]=dataMessage[i][j][k].blockEz.z ;
  
              MyPrintln.println("��תǰ");
              MyPrintln.println(test1,3,3);
              MyPrintln.println("��ת��");
              MyPrintln.println(test2,3,3);
              //��Ϊ������
              //        MyPrintln.println (BlockRotateStatusTableAndSouSuo.getShortLuJing(test1,test2).toString());
  
  
              Vector myVectorArray=BlockRotateStatusTableAndSouSuo.getAllLuJingShenDuControll(test1,test2,3);
              //�������Ϊ{"2",{"3","4"},"3",{"5","6"},...}��ʽ
              //�̵���ǰ��
              MyPrintln.println("lujingArray="+myVectorArray.toString());
              MyPrintln.println("============");
              //===============
  
              if(myVectorArray.size()!=0)
              {
              int k1;
              for(k1=1;k1<myVectorArray.size();k1++)
              //---------------
               {
               	Vector myVector=(Vector)(myVectorArray.get(k1));
  
            // String typeNow=(String)(myVector.get(0));
  
               }
              }
          }
          */
  
  void setRotateSelf(BlockMessage[][][]dataMessage)
  {
      //
      blockTransform3D1=new Transform3D[3][3][3];
      blockTransform3D2=new Transform3D[3][3][3];
      //blockTransform3D1=new Transform3D[3][3][3];
      //blockTransform3D2=new Transform3D[3][3][3];
      
      
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      {
          //Mywait.myWait ();
          //blockTransform3D1[i][j][k]=new Transform3D();
          //blockTransform3D2[i][j][k]=new Transform3D();
          
          //MyPrintln.println("");
          
          //MyPrintln.println("����xyz="+String.valueOf(i)+String.valueOf(j)+String.valueOf(k));
          //int r1=0;
          //int r2=0;
          //=================
          int[][]test1=
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
          }
          ;
          int[][]test2=
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
          }
          ;
          test2[0][0]=dataMessage[i][j][k].blockEx.x ;
          test2[1][0]=dataMessage[i][j][k].blockEx.y ;
          test2[2][0]=dataMessage[i][j][k].blockEx.z ;
          
          test2[0][1]=dataMessage[i][j][k].blockEy.x ;
          test2[1][1]=dataMessage[i][j][k].blockEy.y ;
          test2[2][1]=dataMessage[i][j][k].blockEy.z ;
          
          test2[0][2]=dataMessage[i][j][k].blockEz.x ;
          test2[1][2]=dataMessage[i][j][k].blockEz.y ;
          test2[2][2]=dataMessage[i][j][k].blockEz.z ;
          
          // MyPrintln.println("");
          // MyPrintln.println("��תǰ����������");
          // MyPrintln.println(test1,3,3);
          // MyPrintln.println("��ת������������");
          // MyPrintln.println(test2,3,3);
          //��Ϊ������
          //  MyPrintln.println (BlockRotateStatusTableAndSouSuo.getShortLuJing(test1,test2).toString());
          
          //=============
          //Vector myVector=BlockRotateStatusTableAndSouSuo.getShortLuJing(test1,test2);
          
          int[]controlInt=
          {
              1,1,1,1,1,1,1,1,1 
          }
          ;
          Vector myVector=BlockRotateStatusTableAndSouSuo.calculateControledRotateSelf(controlInt,test1,test2,-1,-1,2);
          //===============
          //�������Ϊ{"2",{"3","4"},"3",{"5","6"},...}��ʽ
          //�̵���ǰ��
          //MyPrintln.println("lujing="+myVector.toString());
          //MyPrintln.println("============");
          //===============
          if(myVector.size()==0)
          {
              //MyPrintln.println("����Ϊ"+String.valueOf(myVector.size())+"��1,2��ûת���ı任");
              //	blockTransform3D2[i][j][k]=new Transform3D();
              //	blockTransform3D2[i][j][k].rotX(Math.toRadians(0));
              blockTransformGroup2[i][j][k].setTransform(new Transform3D());
              
              //  blockTransform3D1[i][j][k]=new Transform3D();
              // 	blockTransform3D1[i][j][k].rotX(Math.toRadians(0));
              blockTransformGroup1[i][j][k].setTransform(new Transform3D());
              
          }
          else 
          {
              //MyPrintln.println("����Ϊ"+String.valueOf(myVector.size())+"��������transform");
              
              //---------------
              
              
              String type22=(String)(myVector.get(0));
              int type2=Integer.parseInt(type22);
              blockTransform3D2[i][j][k]=new Transform3D();
              if(type2==0)
              {
                  blockTransform3D2[i][j][k].rotX(Math.toRadians(90));
              }
              else if(type2==1)
              {
                  blockTransform3D2[i][j][k].rotX(Math.toRadians(180));
              }
              else if(type2==2)
              {
                  blockTransform3D2[i][j][k].rotX(Math.toRadians(-90));
              }
              else if(type2==3)
              {
                  blockTransform3D2[i][j][k].rotY(Math.toRadians(90));
              }
              else if(type2==4)
              {
                  blockTransform3D2[i][j][k].rotY(Math.toRadians(180));
              }
              else if(type2==5)
              {
                  blockTransform3D2[i][j][k].rotY(Math.toRadians(-90));
              }
              else if(type2==6)
              {
                  blockTransform3D2[i][j][k].rotZ(Math.toRadians(90));
              }
              else if(type2==7)
              {
                  blockTransform3D2[i][j][k].rotZ(Math.toRadians(180));
              }
              else if(type2==8)
              {
                  blockTransform3D2[i][j][k].rotZ(Math.toRadians(-90));
              }
              else 
              {
                  System.out.println(type2+" is a error rotate string ");
                  // blockTransform3D2[i][j][k].rotZ(Math.toRadians(270));
              }
              blockTransformGroup2[i][j][k].setTransform(blockTransform3D2[i][j][k]);
              
              if(myVector.size()==1)
              {
                  //MyPrintln.println("1����任");
                  blockTransformGroup1[i][j][k].setTransform(new Transform3D());
                  
              }
              else 
              {
                  
                  //MyPrintln.println("����Ϊ"+String.valueOf(myVector.size())+"��������transform");
                  
                  
                  //  String type1=(String)(myVector.get(1));
                  String type11=(String)(myVector.get(1));
                  int type1=Integer.parseInt(type11);
                  //r1=Integer.parseInt (rls)/3;
                  //r2=Integer.parseInt (rls)%3;
                  //===============
                  //System.out.print(String.valueOf(dataMessage[i][j][k].blockCenter.x));
                  //System.out.print(" "+String.valueOf(dataMessage[i][j][k].blockCenter.y));
                  //System.out.print(" "+String.valueOf(dataMessage[i][j][k].blockCenter.z)+"    ");
                  
                  // 	fx=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.x;
                  // 	fy=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.y;
                  // 	fz=kuaiZhongXinWeizhi*dataMessage[i][j][k].blockCenter.z;
                  // 	Vector3f newVector3f=new Vector3f(fx,fy,fz);
                  blockTransform3D1[i][j][k]=new Transform3D();
                  //--------
                  
                  
                  if(type1==0)
                  {
                      blockTransform3D1[i][j][k].rotX(Math.toRadians(90));
                  }
                  else if(type1==1)
                  {
                      blockTransform3D1[i][j][k].rotX(Math.toRadians(180));
                  }
                  else if(type1==2)
                  {
                      blockTransform3D1[i][j][k].rotX(Math.toRadians(-90));
                  }
                  else if(type1==3)
                  {
                      blockTransform3D1[i][j][k].rotY(Math.toRadians(90));
                  }
                  else if(type1==4)
                  {
                      blockTransform3D1[i][j][k].rotY(Math.toRadians(180));
                  }
                  else if(type1==5)
                  {
                      blockTransform3D1[i][j][k].rotY(Math.toRadians(-90));
                  }
                  else if(type1==6)
                  {
                      blockTransform3D1[i][j][k].rotZ(Math.toRadians(90));
                  }
                  else if(type1==7)
                  {
                      blockTransform3D1[i][j][k].rotZ(Math.toRadians(180));
                  }
                  else if(type1==8)
                  {
                      blockTransform3D1[i][j][k].rotZ(Math.toRadians(-90));
                  }
                  else 
                  {
                      System.out.println(type1+" is a error rotate string ");
                      // blockTransform3D2[i][j][k].rotZ(Math.toRadians(270));
                  }
                  
                  
                  
                  //  blockTransform3D1[i][j][k].rotX(Math.toRadians(r1));
                  //--------------
                  //blockTransform3D[i][j][k].setTranslation(newVector3f);
                  blockTransformGroup1[i][j][k].setTransform(blockTransform3D1[i][j][k]);
                  
                  
                  //�任��
                  //transx.rotX(Math.toRadians(0));//anglex
                  //transy.rotY(Math.toRadians(0));
                  //transz.rotZ(Math.toRadians(0));
                  //transp.setTranslation(new Vector3f(fx,fy,fz));
                  
                  
                  //��Ч
                  //transGroupp.setTransform(transp);
                  //transGroupx.setTransform(transx);
                  //transGroupy.setTransform(transy);
                  //transGroupz.setTransform(transz);
                  //
              }
          }
      }
  }
  
  
  
  
  
  void dongHua(String typeXYZ012String,String layer012String,String jiaoDuString)
  {
      int jiaoDu=Integer.parseInt(jiaoDuString);
      int typeXYZ012=Integer.parseInt(typeXYZ012String);
      int layer012=Integer.parseInt(layer012String);
      //=Integer.parseInt (typeXYZ012String);
      dongHua(typeXYZ012,layer012,jiaoDu);
  }
  
  void dongHua(int atypeXYZ012,int alayer012,int ajiaoDu)
  {
      
      DongHuaAll aDongHuaAll=new DongHuaAll(this);
      aDongHuaAll.typeXYZ012=atypeXYZ012 ;
      aDongHuaAll.layer012=alayer012 ;
      aDongHuaAll.jiaoDu=ajiaoDu ;
      //aDongHuaAll.start();
      new Thread(aDongHuaAll,"aDongHuaAll").start();
  }
  
  
  
  
  void setAllMianTouMing(int transparencyMode,float touMingDu)
  {
      //setTransparencyMode(int transparencyMode)
      
      for(int i=0;i<3;i++)
      for(int j=0;j<3;j++)
      for(int k=0;k<3;k++)
      for(int l=0;l<6;l++)
      {
          biaoMianTransparencyAttributes[i][k][j][l].setTransparency(touMingDu);
          biaoMianTransparencyAttributes[i][k][j][l].setTransparencyMode(transparencyMode);
          
          //========================
      }
  }
  
  void resetBianHaoToABlock(int px,int py,int pz,int biaohao)
  {
      //	int[] blockBianHaoMoRen={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
      //int[] blockBianHaoZiDingYi={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
      //Text3D[][][] text3DArray;
      text3DArray[px][py][pz].setString(String.valueOf(biaohao));
      
  }
  
  void defaultBianHaoToAllBlock()
  {
      
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  resetBianHaoToABlock(i,j,k,blockBianHaoMoRen[i][j][k]);
              }
          }
          ///
      }
  }
  
  
  
  void ziDingYiBianHaoToAllBlock()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  resetBianHaoToABlock(i,j,k,blockBianHaoZiDingYi[i][j][k]);
              }
          }
          ///
      }
  }
  
  void reAddBiaoHao()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  blockTransformGroup2[i][j][k].addChild(blockBianHaoBranchGroup[i][j][k]);
                  //blockTransformGroup2[i][j][k].addChild(xiaoZuoBiaoWaiTaoBranchGroup[i][j][k]);
                  //   blockTransformGroup1[i][j][k].addChild(blockTransformGroup2[i][j][k]);
                  
              }
          }
          ///
      }
      //showAllBlockSelectedStatus();
  }
  
  void reMoveBiaoHao()
  {
      for(int i=0;i<3;i++)
      {
          for(int j=0;j<3;j++)
          {
              for(int k=0;k<3;k++)
              {
                  ///shape3DArray[i][j][k]=new Shape3D;
                  // if(j==0)
                  blockBianHaoBranchGroup[i][j][k].detach();
              }
          }
          ///
      }
  }
  
}















class BranchGroup4 extends BranchGroup 
{
  BranchGroup4(Applet theApplet)
  {
      MyPrintln.println("new BranchGroup4");
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
}

class BranchGroup5 extends BranchGroup 
{
  BranchGroup5(Applet theApplet)
  {
      MyPrintln.println("new BranchGroup5");
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
}

class BranchGroup6 extends BranchGroup 
{
  BranchGroup6(Applet theApplet)
  {
      MyPrintln.println("new BranchGroup6");
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
}

class BranchGroup7 extends BranchGroup 
{
  BranchGroup7(Applet theApplet)
  {
      MyPrintln.println("new BranchGroup7");
      this.setCapability(BranchGroup.ALLOW_DETACH);
      this.compile();
  }
}


class Mywait 
{
  
  //**************************************************************************
  /**
         * Produce to break off the interruption
         */
  //**************************************************************************
  public static void myWait()
  {
      try 
      {
          System.in.read();
          
          System.in.read();
          //pause
      }
      catch(Exception e)
      {
      }
  }
}



class MyKeyBoardBehavior extends Behavior 
{
  
  //double oldArg;//��¼��ǰ��ת��
  double oldScale ;
  double oldPositionX ;
  double oldPositionY ;
  double oldPositionZ ;
  
  static double liangScale ;
  static double liangOldPositionX ;
  static double liangOldPositionY ;
  static double liangOldPositionZ ;
  
  static boolean[]isShow=new boolean[10];
  
  
  
  static int biaoHaoStatusNow ;
  //biaoHaoStatus={"MoRen","ZiDingYi","NoBiaoHao"}
  //-----------------
  static int touMingMode ;
  //NONE,TransparencyAttributes.FASTEST,TransparencyAttributes.NICEST,TransparencyAttributes.SCREEN_DOOR,TransparencyAttributes.BLENDED
  int[]transparencyMode=
  {
      TransparencyAttributes.NONE,TransparencyAttributes.FASTEST,TransparencyAttributes.NICEST,TransparencyAttributes.SCREEN_DOOR,TransparencyAttributes.BLENDED 
  }
  ;
  
  float[]touMingDu=
  {
      0.2f,0.4f,0.6f,0.8f 
  }
  ;
  //0.2,0.4,0.6,0.8
  MyKeyBoardBehavior()
  {
      
      
      oldScale=1.0f ;
      oldPositionX=0.0f ;
      oldPositionY=0.0f ;
      oldPositionZ=0.0f ;
      
      liangScale=0.1f ;
      liangOldPositionX=0.1f ;
      liangOldPositionY=0.1f ;
      liangOldPositionZ=0.1f ;
      
      isShow[0]=MoFang.controlLayerArray[0];
      //�����㿪��
      isShow[1]=MoFang.controlLayerArray[1];
      //��Ļ��
      isShow[2]=true ;
      isShow[3]=true ;
      //�ڱ���
      isShow[4]=true ;
      //��������
      isShow[5]=true ;
      //С������
      
      biaoHaoStatusNow=0 ;
      //�����ΪĬ�ϱ��
      touMingMode=0 ;
      //�����Ϊ��͸��
      
      //oldScale
      // public static boolean[] controlLayerArray={false,false,false,true,false,false,false,false};
      //;
      
  }
  
  public void initialize()
  {
      wakeupOn(new WakeupOnAWTEvent(KeyEvent.KEY_RELEASED));
  }
  
  public void processStimulus(Enumeration criteria)
  {
      
      WakeupOnAWTEvent ev ;
      WakeupCriterion genericEvt ;
      AWTEvent[]events ;
      KeyEvent event ;
      //Vector3f position=new Vector3f();
      
      while(criteria.hasMoreElements())
      {
          genericEvt=(WakeupCriterion)criteria.nextElement();
          if(genericEvt instanceof WakeupOnAWTEvent)
          {
              ev=(WakeupOnAWTEvent)genericEvt ;
              events=ev.getAWTEvent();
              if(events[0]instanceof KeyEvent)
              {
                  event=(KeyEvent)events[0];
                  int keyInt ;
                  char[]aChar=new char[1];
                  String aString ;
                  
                  keyInt=event.getKeyCode();
                  aChar[0]=(char)keyInt ;
                  aString=String.valueOf(aChar);
                  System.out.println("You pressed a key"+aChar[0]+" "+String.valueOf(keyInt)+aString);
                  if(event.getKeyCode()==KeyEvent.VK_F1)
                  {
                      
                      System.out.println("F1-ȥ������ӱ�����");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F1-ȥ������ӱ�����");
                      
                      if(isShow[0]==false)
                      {
                          MoFang.testPanelAddedScene3D.addBranchGraphToU(0);
                          isShow[0]=true ;
                      }
                      else 
                      {
                          MoFang.testPanelAddedScene3D.removebranchGroupInU(0,false);
                          isShow[0]=false ;
                      }
                      // PanelAddedScene3D.testPanelAddedScene3D.removebranchGroupInU (0,false);
                      
                      
                      /*
                                                                                              		//��С
                                                                                              		System.out.println("F1");
                      
                      
                      
                                                                                              		//Flower.t3d.set(0.5f);//��������ԭ�е����б任�����ã�����setScale
                      
                                                                                              		scale+=0.1f;
                                                                                              		myTransform3D.setScale(scale);
                                                                                                      myTransformGroup.setTransform(Flower.t3d);
                      
                                                                                              		//double scale1;
                                                                                              		//scale1=Flower.t3d.getScale();
                      
                                                                                              		System.out.println("scale="+String.valueOf(scale));
                                                                                              */
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F2)
                  {
                      //System.out.println("F2");
                      System.out.println("F2-ȥ���������Ļ��");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F2-ȥ���������Ļ��");
                      
                      if(isShow[1]==false)
                      {
                          MoFang.testPanelAddedScene3D.addBranchGraphToU(1);
                          isShow[1]=true ;
                      }
                      else 
                      {
                          MoFang.testPanelAddedScene3D.removebranchGroupInU(1,false);
                          isShow[1]=false ;
                      }
                      /*
                                                                                              			System.out.println("F2");
                                                                                              		//ar=0;//��ʼ��
                      
                                                                                              		ar+=2*Math.PI/fenshu;
                                                                                              	    //������ת
                                                                                                      Flower.t3d.rotY(ar);
                                                                                                      myTransformGroup.setTransform(Flower.t3d);
                      
                                                                                                      //��ΪrotY��ʹscale��Ч�����ٷ���scaleֵ
                      
                                                                                                      			myTransform3D.setScale(scale);
                                                                                                      Flower.trans.setTransform(Flower.t3d);
                                                                                              	*/
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F3)
                  {
                      System.out.println("F3-�����Ŵ�");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F3-�����Ŵ�");
                      
                      System.out.println("old scale="+String.valueOf(oldScale));
                      
                      oldScale+=0.1f ;
                      //new TransformGroup.
                      // Transform3D  rootTransform3D//=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]).;
                      TransformGroup rootTransformGroup=((BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3])).rootTransformGroup ;
                      //Transform3D
                      Transform3D t1=new Transform3D();
                      rootTransformGroup.getTransform(t1);
                      //rootTransform3D=rootTransformGroup.
                      t1.setScale(oldScale);
                      
                      rootTransformGroup.setTransform(t1);
                      System.out.println("new scale="+String.valueOf(oldScale));
                      // isShow[0]=true; /*
                      System.out.println("F3");
                      //���trasform3D�����з���ֵ
                      //	System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                      
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F4)
                  {
                      System.out.println("F4");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F4-������С");
                      
                      System.out.println("F4-������С");
                      System.out.println("old scale="+String.valueOf(oldScale));
                      
                      oldScale-=0.1f ;
                      //new TransformGroup.
                      // Transform3D  rootTransform3D//=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]).;
                      TransformGroup rootTransformGroup=((BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3])).rootTransformGroup ;
                      //Transform3D
                      Transform3D t1=new Transform3D();
                      rootTransformGroup.getTransform(t1);
                      //rootTransform3D=rootTransformGroup.
                      t1.setScale(oldScale);
                      
                      rootTransformGroup.setTransform(t1);
                      System.out.println("new scale="+String.valueOf(oldScale));
                      
                      /*
                                                                                              		//���trasform3D�����б���
                                                                                              			System.out.println("F4");
                                                                                              			System.out.println("SCALE="+String.valueOf(Flower.t3d.SCALE));
                                                                                              			System.out.println("AFFINE="+String.valueOf(Flower.t3d.AFFINE));
                                                                                              			System.out.println("CONGRUENT="+String.valueOf(Flower.t3d.CONGRUENT));
                                                                                              			System.out.println("NEGATIVE_DETERMINANT="+String.valueOf(Flower.t3d.NEGATIVE_DETERMINANT));
                                                                                              			System.out.println("ORTHOGONAL="+String.valueOf(Flower.t3d.ORTHOGONAL));
                                                                                              			System.out.println("RIGID="+String.valueOf(Flower.t3d.RIGID));
                                                                                              			System.out.println("TRANSLATION="+String.valueOf(Flower.t3d.TRANSLATION));
                                                                                              			System.out.println("ZERO="+String.valueOf(Flower.t3d.ZERO));
                                                                                              			//myTransformGroup.
                                                                                              			*/
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F5)
                  {
                      System.out.println("F5-δ���幦��");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F5-δ���幦��");
                      
                      //System.out.println("old scale="+String.valueOf (oldScale));
                      
                      
                      /*	//�Ŵ�
                      
                                                                                              		scale-=0.1f;
                                                                                              		myTransform3D.setScale(scale);
                                                                                              		myTransformGroup.setTransform(Flower.t3d);
                                                                                                      System.out.println("scale="+String.valueOf(scale));
                                                                                              	}
                                                                                              		else if(event.getKeyCode()==KeyEvent.VK_F6)
                                                                                              	{
                                                                                              		//��ת2
                      
                                                                                              			System.out.println("F2");
                                                                                              		//ar=0;//��ʼ��
                      
                                                                                              		ar-=2*Math.PI/fenshu;
                                                                                              	    //������ת
                                                                                                      myTransform3D.rotY(ar);
                                                                                                      myTransformGroup.setTransform(Flower.t3d);
                      
                                                                                                      //��ΪrotY��ʹscale��Ч�����ٷ���scaleֵ
                      
                                                                                                      				Flower.t3d.setScale(scale);
                                                                                                      myTransformGroup.setTransform(Flower.t3d);
                                                                                              	}*/
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F6)
                  {
                      System.out.println("F6");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F6-�ڱ����л�");
                      
                      System.out.println("F6-�ڱ����л�");
                      
                      if(isShow[3]==false)
                      {
                          System.out.println("false");
                          // PanelAddedScene3D.testPanelAddedScene3D.addBranchGraphToU(1);
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reAddNeiBiaoMian();
                          isShow[3]=true ;
                      }
                      else 
                      
                      {
                          System.out.println("true");
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reMoveNeiBiaoMian();
                          isShow[3]=false ;
                      }
                      /*
                                                                                              			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  
                  else if(event.getKeyCode()==KeyEvent.VK_F7)
                  {
                      System.out.println("F7-������л�");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F7-������л�");
                      
                      if(isShow[2]==false)
                      {
                          System.out.println("false");
                          // PanelAddedScene3D.testPanelAddedScene3D.addBranchGraphToU(1);
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reAddWaiBiaoMian();
                          isShow[2]=true ;
                      }
                      else 
                      {
                          System.out.println("true");
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reMoveWaiBiaoMian();
                          isShow[2]=false ;
                      }
                      /*                     			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  
                  else if(event.getKeyCode()==KeyEvent.VK_F8)
                  {
                      System.out.println("F8-�������л�");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F8-�������л�(4��)��"+"�����С��-����-��-С��-�����С��");
                      
                      
                      
                      if(isShow[5]==true&&isShow[4]==true)
                      {
                          isShow[5]=false ;
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reMoveXiaoZuoBiao();
                          
                      }
                      else if(isShow[5]==false&&isShow[4]==true)
                      {
                          isShow[4]=false ;
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reMoveDaZuoBiao();
                          isShow[4]=false ;
                          
                          
                      }
                      else if(isShow[5]==false&&isShow[4]==false)
                      {
                          isShow[5]=true ;
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reAddXiaoZuoBiao();
                          
                          
                      }
                      else if(isShow[5]==true&&isShow[4]==false)
                      {
                          isShow[4]=true ;
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.reAddDaZuoBiao();
                          
                      }
                      /*
                                                                                              			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  
                  
                  else if(event.getKeyCode()==KeyEvent.VK_F9)
                  {
                      //System.out.println("F7");
                      System.out.println("F9-�����л�");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F9-�����л�(0.25-0.26-...-0.50-0.23)");
                      
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.kuaiZhongXinWeizhi+=0.01f ;
                      if(aBranchGroup3.kuaiZhongXinWeizhi>0.50f)
                      {
                          //0.25-0.26-...-0.50-0.23
                          aBranchGroup3.kuaiZhongXinWeizhi=0.23f ;
                      }
                      aBranchGroup3.setPosition(MoFang.aMofangStatusMessage.dataMessage);
                      
                      /*
                                                                                              			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F10)
                  {
                      System.out.println("F10-δ���幦��");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F10-δ���幦��");
                      /*
                                                                                              			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F11)
                  {
                      System.out.println("F11-͸��ģʽ�л�����17��),5��͸��(NONE,FASTEST,NICEST,SCREEN_DOOR,BLENDED)��4��͸����(20%,40%,60%,80%)");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F11-͸��ģʽ�л�����17��),5��͸��(NONE,FASTEST,NICEST,SCREEN_DOOR,BLENDED)��4��͸����(20%,40%,60%,80%)");
                      
                      
                      touMingMode++;
                      if(touMingMode<3)
                      {
                          touMingMode=3 ;
                      }
                      int nowMode=touMingMode%20 ;
                      int ii=nowMode/4 ;
                      int jj=nowMode%4 ;
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      
                      
                      aBranchGroup3.setAllMianTouMing(transparencyMode[ii],touMingDu[jj]);
                      
                      
                      //static int touMingMode;//NONE,TransparencyAttributes.FASTEST,TransparencyAttributes.NICEST,TransparencyAttributes.SCREEN_DOOR,TransparencyAttributes.BLENDED
                      //0.2,0.4,0.6,0.8
                      
                      
                      /*
                                                  void setAllMianTouMing()
                                               {
                      
                                               }
                      
                                               void setAllMianNoTouMing()                                             			System.out.println("F3");
                                                                                              		//���trasform3D�����з���ֵ
                                                                                              			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                                              */
                  }
                  else if(event.getKeyCode()==KeyEvent.VK_F12)
                  {
                      System.out.println("F12-�Զ����ź�Ĭ�ϱ���л�����");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F12-�Զ����ź�Ĭ�ϱ���л�����(����)��Ĭ�ϱ��-�Զ�����-�ޱ��-Ĭ�ϱ��");
                      //static String[] biaoHaoStatus={"MoRen","ZiDingYi","NoBiaoHao"};
                      //static int biaoHaoStatusNow;
                      if(biaoHaoStatusNow==0)
                      {
                          biaoHaoStatusNow=1 ;
                          //��Ĭ�ϱ���л����Զ�����
                          MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"��Ĭ�ϱ���л����Զ�����");
                          BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                          aBranchGroup1.addAStringToLeft("F12-System Nuber");
                          
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          
                          aBranchGroup3.ziDingYiBianHaoToAllBlock();
                      }
                      else if(biaoHaoStatusNow==1)
                      {
                          MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"���Զ������л���û�б��");
                          BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                          aBranchGroup1.addAStringToLeft("F12-No Nuber");
                          
                          biaoHaoStatusNow=2 ;
                          //���Զ������л���û�б��
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          
                          aBranchGroup3.reMoveBiaoHao();
                      }
                      else if(biaoHaoStatusNow==2)
                      {
                          BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                          aBranchGroup1.addAStringToLeft("F12-YourSelf Nuber");
                          
                          MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"��û�б���л���Ĭ�ϱ��");
                          
                          biaoHaoStatusNow=0 ;
                          //��û�б���л���Ĭ�ϱ��
                          BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          
                          aBranchGroup3.reAddBiaoHao();
                          aBranchGroup3.defaultBianHaoToAllBlock();
                      }
                      else 
                      {
                          System.out.println("biao hao status error");
                      }
                      /*
                                                                      			System.out.println("F3");
                                                                      		//���trasform3D�����з���ֵ
                                                                      			System.out.println("determinant()="+String.valueOf(Flower.t3d.determinant()));
                                                                      */
                  }
                  
                  else if(event.getKeyCode()=='Q')
                  {
                      System.out.println("Q");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      aBranchGroup1.addAStringToLeft("Q(E):type=0,layer=0,arg=90");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"Q(E):type=0,layer=0,arg=90");
                      
                      //״̬���ݱ仯
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,0,90);
                      
                      //���⶯������
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,0,90);
                  }
                  else if(event.getKeyCode()=='W')
                  {
                      System.out.println("W");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"W(W):type=0,layer=0,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("W(W):type=0,layer=0,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,0,180);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,0,180);
                  }
                  else if(event.getKeyCode()=='E')
                  {
                      System.out.println("E");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      
                      aBranchGroup1.addAStringToLeft("E(Q):type=0,layer=0,arg=-90");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"E(Q):type=0,layer=0,arg=-90");
                      
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,0,-90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,0,-90);
                      
                      
                  }
                  else if(event.getKeyCode()=='A')
                  {
                      System.out.println("A");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      
                      aBranchGroup1.addAStringToLeft("A(D):type=0,layer=1,arg=90");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"A(D):type=0,layer=1,arg=90");
                      
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,1,90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,1,90);
                  }
                  else if(event.getKeyCode()=='S')
                  {
                      System.out.println("S");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      
                      aBranchGroup1.addAStringToLeft("S(S):type=0,layer=1,arg=180");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"S(S):type=0,layer=1,arg=180");
                      
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,1,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,1,180);
                  }
                  else if(event.getKeyCode()=='D')
                  {
                      System.out.println("D");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      
                      aBranchGroup1.addAStringToLeft("D(A):type=0,layer=1,arg=-90");
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"D(A):type=0,layer=1,arg=-90");
                      
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,1,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,1,-90);
                  }
                  else if(event.getKeyCode()=='Z')
                  {
                      System.out.println("Z");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"Z(C):type=0,layer=2,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("Z(C):type=0,layer=2,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,2,90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,2,90);
                  }
                  else if(event.getKeyCode()=='X')
                  {
                      System.out.println("X");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"X(X):type=0,layer=2,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("X(X):type=0,layer=2,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,2,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,2,180);
                  }
                  else if(event.getKeyCode()=='C')
                  {
                      System.out.println("C");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"C(Z):type=0,layer=2,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("C(Z):type=0,layer=2,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(0,2,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(0,2,-90);
                  }
                  else if(event.getKeyCode()=='R')
                  {
                      System.out.println("R");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"R(Y):type=1,layer=0,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("R(Y):type=1,layer=0,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,0,90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,0,90);
                      
                      //aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);
                      //aBranchGroup3.setPosition(aMofangStatusMessage.dataMessage);
                      //aBranchGroup3.reAddWaiBiaoMian ();
                      //Mywait.myWait ();
                  }
                  else if(event.getKeyCode()=='T')
                  {
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"T(T):type=1,layer=0,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("T(T):type=1,layer=0,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,0,180);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,0,180);
                  }
                  else if(event.getKeyCode()=='Y')
                  {
                      System.out.println("Y");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"Y(R):type=1,layer=0,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("Y(R):type=1,layer=0,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,0,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,0,-90);
                  }
                  else if(event.getKeyCode()=='F')
                  {
                      System.out.println("F");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"F(H):type=1,layer=1,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("F(H):type=1,layer=1,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,1,90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,1,90);
                  }
                  else if(event.getKeyCode()=='G')
                  {
                      System.out.println("G");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"G(G):type=1,layer=1,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("G(G):type=1,layer=1,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,1,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,1,180);
                      
                  }
                  else if(event.getKeyCode()=='H')
                  {
                      System.out.println("H");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"H(F):type=1,layer=1,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("H(F):type=1,layer=1,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,1,-90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,1,-90);
                      
                  }
                  else if(event.getKeyCode()=='V')
                  {
                      System.out.println("V");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"V(N):type=1,layer=2,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("V(N):type=1,layer=2,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,2,90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,2,90);
                  }
                  else if(event.getKeyCode()=='B')
                  {
                      System.out.println("B");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"B(B):type=1,layer=2,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("B(B):type=1,layer=2,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,2,180);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,2,180);
                  }
                  else if(event.getKeyCode()=='N')
                  {
                      System.out.println("N");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"N(V):type=1,layer=2,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("N(V):type=1,layer=2,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(1,2,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(1,2,-90);
                  }
                  else if(event.getKeyCode()=='U')
                  {
                      System.out.println("U");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"U(O):type=2,layer=0,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("U(O):type=2,layer=0,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,0,90);
                      
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,0,90);
                      //aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);
                      //aBranchGroup3.setPosition(aMofangStatusMessage.dataMessage);
                      //aBranchGroup3.reAddWaiBiaoMian ();
                      //Mywait.myWait ();
                  }
                  else if(event.getKeyCode()=='I')
                  {
                      System.out.println("I");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"I(I):type=2,layer=0,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("I(I):type=2,layer=0,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,0,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,0,180);
                  }
                  else if(event.getKeyCode()=='O')
                  {
                      System.out.println("O");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"O(U):type=2,layer=0,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("O(U):type=2,layer=0,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,0,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,0,-90);
                  }
                  else if(event.getKeyCode()=='J')
                  {
                      System.out.println("J");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"J(L):type=2,layer=1,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("J(L):type=2,layer=1,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,1,90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,1,90);
                  }
                  else if(event.getKeyCode()=='K')
                  {
                      System.out.println("K");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"K(K):type=2,layer=1,arg=180");
                      
                      aBranchGroup1.addAStringToLeft("K(K):type=2,layer=1,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,1,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,1,180);
                  }
                  else if(event.getKeyCode()=='L')
                  {
                      System.out.println("L");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"L(J):type=2,layer=1,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft("L(J):type=2,layer=1,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,1,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,1,-90);
                  }
                  else if(event.getKeyCode()=='M')
                  {
                      System.out.println("M");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"M(M):type=2,layer=2,arg=90");
                      
                      aBranchGroup1.addAStringToLeft("M(M):type=2,layer=2,arg=90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,2,90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,2,90);
                  }
                  else if(event.getKeyCode()==',')
                  {
                      System.out.println(",");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+",(.):type=2,layer=2,arg=180");
                      
                      aBranchGroup1.addAStringToLeft(",(.):type=2,layer=2,arg=180");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,2,180);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,2,180);
                  }
                  else if(event.getKeyCode()=='.')
                  {
                      System.out.println(".");
                      BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+".(M):type=2,layer=2,arg=-90");
                      
                      aBranchGroup1.addAStringToLeft(".(M):type=2,layer=2,arg=-90");
                      MoFang.aMofangStatusMessage.moFang3DRotate(2,2,-90);
                      BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(2,2,-90);
                  }
                  
                  
              }
          }
          wakeupOn(new WakeupOnAWTEvent(KeyEvent.KEY_RELEASED));
      }
      
      
  }
}


/*
//�Զ�������¼�
class MyBehavior extends Behavior  {
//TransformGroup targetTG ;

MyBehavior(//TransformGroup targetTG
) {
  //this.targetTG=targetTG ;
}

public void initialize() {
  this.wakeupOn(new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED));
//ֻҪ�����̣����WakeupOnAWTEvent�����б���
}

public void processStimulus(Enumeration criteria) {
 //----------
  WakeupCriterion aWakeupCriterion=null ;
  AWTEvent[]event=null ;
///------------
  aWakeupCriterion=(WakeupCriterion)(criteria.nextElement());

  if(aWakeupCriterion instanceof WakeupOnAWTEvent) {
  	//�Ӷ�����ѡ��WakeupOnAWTEvent���󣬲�ȡ����
    event=((WakeupOnAWTEvent)aWakeupCriterion).getAWTEvent();
    //WakeupOnAWTEvent������ȡ��AWTEvent�б�
    KeyEvent keyevent=(KeyEvent)event[0];
    //ȡ����ͷ����AWTEvent
    System.out.println("You pressed:"+String.valueOf(keyevent.getKeyCode()));

    //if(keyevent.getKeyCode()==61) {
      //SomeBranchGroup.qiuTransformGroup.setTransform(new Transform3D());
      //SomeBranchGroup.xianTransformGroup.setTransform(new Transform3D());
    //}
  }

  //��Ϊ�ղŵĽ��ն����ѱ�ȡ��������µĶ���
  this.wakeupOn(new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED));
}
}

*/




class MyPickMouseBehavior extends PickMouseBehavior 
{
  BranchGroup1 aBranchGroup1 ;
  BranchGroup3 aBranchGroup3 ;
  //�л����Ĺ���
  static boolean mouseIsRotate=false ;
  //�������ѡ���Ŀ�
  static int[]lastSelectedBlock=
  {
      0,0,0 
  }
  ;
  
  public MyPickMouseBehavior(Canvas3D canvas,BranchGroup root,Bounds bounds)
  {
      super(canvas,root,bounds);
      //------------------
      setMode(PickCanvas.GEOMETRY);
      //setMode(PickCanvas.BOUNDS);
      //-------------
  }
  
  
  private void processMouseEvent(MouseEvent event,int idI,int idJ,int idK)
  {
      
      
      int eventID=event.getID();
      int eventButton=event.getButton();
      int eventClickCount=event.getClickCount();
      // BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
      aBranchGroup1.addAStringToLeft("Mouse Event:"+String.valueOf(eventID)+","+String.valueOf(eventButton)+","+String.valueOf(eventClickCount));
      
      //========================================
      if(eventID==MouseEvent.MOUSE_CLICKED)
      {
          System.out.println("got a MOUSE_CLICKED");
          
          if(eventButton==MouseEvent.BUTTON1)
          {
              System.out.println("You clicked button 1");
              //���������1��
              if(eventClickCount==1)
              {
                  System.out.println("Single clicked.");
                  
                  if(mouseIsRotate==false)
                  {
                      //BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      
                      for(int i1=0;i1<3;i1++)
                      for(int j1=0;j1<3;j1++)
                      for(int k1=0;k1<3;k1++)
                      {
                          aBranchGroup3.blockSelected[i1][j1][k1]=false ;
                      }
                      aBranchGroup3.blockSelected[idI][idJ][idK]=true ;
                      //------------------
                      // ����ˢ��
                      aBranchGroup3.showAllBlockSelectedStatus();
                      //--------------------
                      lastSelectedBlock[0]=idI ;
                      lastSelectedBlock[1]=idJ ;
                      lastSelectedBlock[2]=idK ;
                  }
                  else 
                  {
                      //������һ��ѡ��Ŀ鴦����ʾ״̬���������Ϊ��0������ת
                      //BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      
                      if(
                      (aBranchGroup3.blockSelected[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]]==true)
                      &&(aBranchGroup3.blockSelectedStatus[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]]!=0)
                      )
                      {
                          String[][][]ziMuBiao=
                          {
                              {
                                  {
                                      "Q(E)","W(W)","E(Q)" 
                                  }
                                  ,
                                  {
                                      "A(D)","S(S)","D(A)" 
                                  }
                                  ,
                                  {
                                      "Z(C)","X(X)","C(Z)" 
                                  }
                                  ,
                              }
                              //X 012 90,180,270
                              ,
                              {
                                  {
                                      "R(Y)","T(T)","Y(R)" 
                                  }
                                  ,
                                  {
                                      "F(H)","G(G)","H(F)" 
                                  }
                                  ,
                                  {
                                      "V(N)","B(B)","N(V)" 
                                  }
                                  ,
                              }
                              //Y
                              ,
                              {
                                  {
                                      "U(O)","I(I)","O(U)" 
                                  }
                                  ,
                                  {
                                      "J(L)","K(K)","L(J)" 
                                  }
                                  ,
                                  {
                                      "M(M)",".(.)",".(M)" 
                                  }
                                  ,
                              }
                              //Z
                              ,
                          }
                          ;
                          
                          int type=aBranchGroup3.blockSelectedStatus[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]]-1 ;
                          int layer=0 ;
                          if(type==0)
                          {
                              layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.x+1 ;
                          }
                          else if(type==1)
                          {
                              layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.y+1 ;
                          }
                          else if(type==2)
                          {
                              layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.z+1 ;
                          }
                          else 
                          {
                              System.out.println("type="+String.valueOf(type)+" error");
                          }
                          int arg=90 ;
                          //��ʾ
                          //                        BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                          aBranchGroup1.addAStringToLeft(ziMuBiao[type][layer][0]+":type="+String.valueOf(type)+",layer="+String.valueOf(layer)+",arg="+String.valueOf(arg));
                          MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+ziMuBiao[type][layer][0]+":type="+String.valueOf(type)+",layer="+String.valueOf(layer)+",arg="+String.valueOf(arg));
                          
                          //״̬���ݱ仯
                          MoFang.aMofangStatusMessage.moFang3DRotate(type,layer,arg);
                          
                          //���⶯������
                          //aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                          aBranchGroup3.dongHua(type,layer,arg);
                      }
                      //;
                  }
                  //=======================
                  
                  
              }
              //���������2��
              else if(eventClickCount==2)
              {
                  /*System.out.println("Double clicked.");
                              if(mouseIsRotate==false)
                              // System.out.println("����="+String.valueOf(pickResult.length));
                              {
                                    //-----------------
                                  //˫�������ı�������ѡ��״̬
                                  // for(int i1=0;i1<3;i1++)
                                  // for(int j1=0;j1<3;j1++)
                                  // for(int k1=0;k1<3;k1++)
                                  // {
                                  // 	blockSelected[i1][j1][k1]==false;
                                  // }
                                  BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                  
                                  aBranchGroup3.blockSelected[idI][idJ][idK]=true ;
                                  //------------------
                                  // ����ˢ��
                                  aBranchGroup3.showAllBlockSelectedStatus();
                                  //--------------------
                  
                              }
                              else
                              {
                                  //������һ��ѡ��Ŀ鴦����ʾ״̬���������Ϊ��0������ת
                              }
                              //=======================
                             */
              }
              
          }
          
          //�������������������м�
          else if(eventButton==MouseEvent.BUTTON2)
          {
              System.out.println("You clicked button 2");
              if(mouseIsRotate==false)
              {
                  mouseIsRotate=true ;
              }
              else if(mouseIsRotate==true)
              {
                  mouseIsRotate=false ;
              }
              //���������1��
              if(eventClickCount==1)
              {
                  System.out.println("center Clicked.");
                  
              }
              //���������2��
              else if(eventClickCount==2)
              {
                  System.out.println("center Double clicked.");
              }
          }
          // int eventID=event.getID();
          //int eventButton=event.getButton();
          //int eventClickCount=event.getClickCount();
          //�������������������Ҽ�
          else if(eventButton==MouseEvent.BUTTON3)
          {
              System.out.println("You clicked button 3");
              //���������1��
              if(eventClickCount==1)
              {
                  if(mouseIsRotate==false)
                  {
                      //-----------------
                      //�Ҽ��������ı�ÿ��ѡ��״̬
                      //BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      
                      aBranchGroup3.blockSelectedStatus[idI][idJ][idK]++;
                      if(aBranchGroup3.blockSelectedStatus[idI][idJ][idK]>=4)
                      {
                          aBranchGroup3.blockSelectedStatus[idI][idJ][idK]=0 ;
                      }
                      //------------------
                      // ����ˢ��
                      aBranchGroup3.showAllBlockSelectedStatus();
                      //--------------------
                      // lastSelectedBlock[0]=idI;
                      //lastSelectedBlock[1]=idJ;
                      // lastSelectedBlock[2]=idK;
                  }
                  else 
                  {
                      //������һ��ѡ��Ŀ鴦����ʾ״̬���������Ϊ��0������ת
                      //�����࣬��ͽǶ�  ���
                      String[][][]ziMuBiao=
                      {
                          {
                              {
                                  "Q(E)","W(W)","E(Q)" 
                              }
                              ,
                              {
                                  "A(D)","S(S)","D(A)" 
                              }
                              ,
                              {
                                  "Z(C)","X(X)","C(Z)" 
                              }
                              ,
                          }
                          //X 012 90,180,270
                          ,
                          {
                              {
                                  "R(Y)","T(T)","Y(R)" 
                              }
                              ,
                              {
                                  "F(H)","G(G)","H(F)" 
                              }
                              ,
                              {
                                  "V(N)","B(B)","N(V)" 
                              }
                              ,
                          }
                          //Y
                          ,
                          {
                              {
                                  "U(O)","I(I)","O(U)" 
                              }
                              ,
                              {
                                  "J(L)","K(K)","L(J)" 
                              }
                              ,
                              {
                                  "M(M)",".(.)",".(M)" 
                              }
                              ,
                          }
                          //Z
                          ,
                      }
                      ;
                      //ȷ������
                      int type=aBranchGroup3.blockSelectedStatus[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]]-1 ;
                      //ȷ����
                      int layer=0 ;
                      if(type==0)
                      {
                          layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.x+1 ;
                      }
                      else if(type==1)
                      {
                          layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.y+1 ;
                      }
                      else if(type==2)
                      {
                          layer=MoFang.aMofangStatusMessage.dataMessage[lastSelectedBlock[0]][lastSelectedBlock[1]][lastSelectedBlock[2]].blockCenter.z+1 ;
                      }
                      else 
                      {
                          System.out.println("type="+String.valueOf(type)+" error");
                          //������ڵ�ѡ״̬�����˳�
                          return ;
                      }
                      //ȷ���Ƕ�
                      int arg=-90 ;
                      //��ʾ
                      //                        BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
                      aBranchGroup1.addAStringToLeft(ziMuBiao[type][layer][2]+":type="+String.valueOf(type)+",layer="+String.valueOf(layer)+",arg="+String.valueOf(arg));
                      MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+ziMuBiao[type][layer][2]+":type="+String.valueOf(type)+",layer="+String.valueOf(layer)+",arg="+String.valueOf(arg));
                      
                      //״̬���ݱ仯
                      MoFang.aMofangStatusMessage.moFang3DRotate(type,layer,arg);
                      
                      //���⶯������
                      //aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                      aBranchGroup3.dongHua(type,layer,arg);
                  }
                  //=======================
                  
              }
              //���������2��
              else if(eventClickCount==2)
              {
                  System.out.println("Double clicked.");
              }
          }
          
          
          
      }
      //======================================
      return ;
      
  }
  
  public void processStimulus(Enumeration criteria)
  {
      WakeupCriterion wakeup ;
      AWTEvent[]evt=null ;
      int xpos=0,ypos=0 ;
      
      while(criteria.hasMoreElements())
      {
          wakeup=(WakeupCriterion)criteria.nextElement();
          if(wakeup instanceof WakeupOnAWTEvent)
          evt=((WakeupOnAWTEvent)wakeup).getAWTEvent();
      }
      
      if(evt[0]instanceof MouseEvent)
      {
          mevent=(MouseEvent)evt[0];
          
          
          System.out.println("got mouse event");
          //processMouseEvent((MouseEvent)evt[0]);
          //�ŵ���Ҫ��λ��ȥ��
          xpos=mevent.getPoint().x ;
          ypos=mevent.getPoint().y ;
      }
      
      System.out.println("mouse position "+xpos+" "+ypos);
      
      
      updateScene(xpos,ypos);
      
      wakeupOn(wakeupCondition);
  }
  
  
  public void initialize()
  {
      
      conditions=new WakeupCriterion[1];
      conditions[0]=new WakeupOnAWTEvent(MouseEvent.MOUSE_CLICKED);
      //conditions[0] = new WakeupOnAWTEvent(MouseEvent.BUTTON2);
      //conditions[2] = new WakeupOnAWTEvent(MouseEvent.BUTTON3);
      wakeupCondition=new WakeupOr(conditions);
      
      wakeupOn(wakeupCondition);
  }
  
  
  public void updateScene(int xpos,int ypos)
  {
      //�ڴ����б�����
      BranchGroup tg=null ;
      
      // if (!mevent.isMetaDown() && !mevent.isAltDown())
      {
          
          pickCanvas.setShapeLocation(xpos,ypos);
          PickResult pr=pickCanvas.pickClosest();
          //pr.setFirstIntersectOnly(true) ;
          
          if((pr!=null)&&
          ((tg=(BranchGroup)pr.getNode(PickResult.BRANCH_GROUP))
          !=null))
          {
              //==================
              
              System.out.println("picked a object");
              aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
              aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
              
              int idI=0 ;
              int idJ=0 ;
              int idK=0 ;
              
              for(int i=0;i<3;i++)
              for(int j=0;j<3;j++)
              for(int k=0;k<3;k++)
              {
                  //BranchGroup3 aBranchGroup3=(BranchGroup3)(MoFang.testPanelAddedScene3D.branchGroupArray[3]);
                  
                  
                  if(aBranchGroup3.blockBranchGroup[i][j][k]==tg)
                  {
                      
                      
                      idI=i ;
                      idJ=j ;
                      idK=k ;
                  }
              }
              //--------------
              //BranchGroup1 aBranchGroup1=(BranchGroup1)(MoFang.testPanelAddedScene3D.branchGroupArray[1]);
              aBranchGroup1.addAStringToLeft("Selected:"+String.valueOf(idI*9+idJ*3+idK)+"("+String.valueOf(idI)+","+String.valueOf(idJ)+","+String.valueOf(idK)+")");
              MoFang.theMainFrame.totlePanel.textPane.setText(MoFang.theMainFrame.totlePanel.textPane.getText()+(char)13+(char)10+"Selected:"+String.valueOf(idI*9+idJ*3+idK)+"("+String.valueOf(idI)+","+String.valueOf(idJ)+","+String.valueOf(idK)+")");
              
              //=================================
              processMouseEvent(mevent,idI,idJ,idK);
              //===============================
              System.out.println("..");
              freePickResult(pr);
          }
      }
      
  }
  void freePickResult(PickResult pr)
  {
     // UtilFreelistManager.pickResultFreelist.add(pr);
  }
}
//
//
class MyTimerBehavior extends Behavior 
{
  BranchGroup1 aBranchGroup1 ;
  int oldhour ;
  int oldfen ;
  int oldmiao ;
  //int oldri ;
  static long rotateTimes=0 ;
  //TimeRun.rotateTimes=
  Date myDate ;
  DateFormat df2 ;
  StringTokenizer st2 ;
  int hour ;
  int fen ;
  int miao ;
  private long millisecond ;
  
  MyTimerBehavior(BranchGroup1 aaBranchGroup1,long millisecond)
  {
      this.millisecond=millisecond ;
      
      //---------------
      aBranchGroup1=aaBranchGroup1 ;
      
      myDate=new Date();
      // DateFormat df1=DateFormat.getDateInstance();//ȡ����
      DateFormat df2=DateFormat.getTimeInstance();
      //ȡʱ��
      
      //	StringTokenizer st1=new StringTokenizer(df1.format(myDate));
      st2=new StringTokenizer(df2.format(myDate));
      
      hour=Integer.parseInt(st2.nextToken(":"));
      fen=Integer.parseInt(st2.nextToken(":"));
      miao=Integer.parseInt(st2.nextToken(":"));
      
      //int nian=Integer.parseInt (st1.nextToken("-"));
      //int yue=Integer.parseInt (st1.nextToken("-"));
      //	 int ri=Integer.parseInt (st1.nextToken("-"));
      
      
      oldhour=hour ;
      oldfen=fen ;
      oldmiao=miao ;
      //oldri=ri;
  }
  
  public void initialize()
  {
      wakeupOn(new WakeupOnElapsedTime(millisecond));
  }
  
  public void processStimulus(Enumeration criteria)
  {
      WakeupCriterion wakeup ;
      while(criteria.hasMoreElements())
      {
          wakeup=(WakeupCriterion)criteria.nextElement();
          //---------------
          renew();
          //---------------
          this.wakeupOn(new WakeupOnElapsedTime(millisecond));
      }
  }
  
  void renew()
  {
      myDate=new Date();
      //  DateFormat df1=DateFormat.getDateInstance();//ȡ����
      df2=DateFormat.getTimeInstance();
      //ȡʱ��
      
      //	StringTokenizer st1=new StringTokenizer(df1.format(myDate));
      st2=new StringTokenizer(df2.format(myDate));
      
      hour=Integer.parseInt(st2.nextToken(":"));
      fen=Integer.parseInt(st2.nextToken(":"));
      miao=Integer.parseInt(st2.nextToken(":"));
      
      //int nian=Integer.parseInt (st1.nextToken("-"));
      //int yue=Integer.parseInt (st1.nextToken("-"));
      //int ri=Integer.parseInt (st1.nextToken("-"));
      aBranchGroup1.addAStringToDown("Start Time:"+String.valueOf(oldhour)+":"+String.valueOf(oldfen)+":"+String.valueOf(oldmiao));
      
      aBranchGroup1.addAStringToDown("Time Now:"+String.valueOf(hour)+":"+String.valueOf(fen)+":"+String.valueOf(miao));
      
      //long jiShi;
      //jiShi=(((ri-oldri)*24+(hour-oldhour))*60+(fen-oldfen))*60+(miao-oldmiao);
      //aBranchGroup1.addAStringToDown ("Used:  "+String.valueOf (jiShi)+"  minite");
      aBranchGroup1.addAStringToDown("Rotate  "+String.valueOf(rotateTimes)+"  Times");
      //oldhour=hour;
      //oldfen=fen;
      //oldmiao=miao;
      //oldri=ri;
  }
}
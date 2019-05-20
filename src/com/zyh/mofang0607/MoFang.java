package com.zyh.mofang0607;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

import javax.swing.*;
import javax.swing.JFrame.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.picking.*;
import com.sun.j3d.utils.picking.behaviors.*;
import com.sun.j3d.utils.picking.PickTool;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.image.TextureLoader;

public class MoFang {
	// ������
	public static String[] newTypeArray = { "0", "1", "2", "3", "4", "5", "6", "7" };
	public static boolean[] controlLayerArray = { true, true, false, true, false, false, false, false };

	// ���������������
	// ��ά��ʾģ��
	public static PanelAddedScene3D testPanelAddedScene3D = new PanelAddedScene3D();
	// ħ��״̬���ݼ��仯ģ��
	public static MofangStatusMessage aMofangStatusMessage = new MofangStatusMessage("new");;
	// ����ͽ���
	public static MyMainFrame theMainFrame = new MyMainFrame();

	public static void main(String args[]) {

		// ��ʾ����
		testPanelAddedScene3D.typeArray = newTypeArray;
		testPanelAddedScene3D.prepare();
		testPanelAddedScene3D.addAllbranchGroupToU(controlLayerArray);
		theMainFrame.totlePanel.tab.add("3D����", testPanelAddedScene3D);

		// ��ʾ����
		theMainFrame.setSize(650, 650);
		theMainFrame.setVisible(true);

		// ��ʼ״̬������ʾ������ͳ���
		aMofangStatusMessage.outToATable();
		BranchGroup3 aBranchGroup3 = (BranchGroup3) (testPanelAddedScene3D.branchGroupArray[3]);
		aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);

		theMainFrame.repaint();

		// ����====================
		// �¸��汾��ʹ�ü��̿���״̬�仯

		// ״̬���ݱ仯
		System.out.println("will 1,0,90");
		Mywait.myWait();
		aMofangStatusMessage.moFang3DRotate(1, 0, 90);

		// ���⶯������
		aBranchGroup3.dongHua(1, 0, 90);
		Mywait.myWait();

		// ״̬ˢ�µ�����ͳ���
		aMofangStatusMessage.outToATable();
		aBranchGroup3 = (BranchGroup3) (testPanelAddedScene3D.branchGroupArray[3]);
		aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);

		/*
		 * ���� //״̬���ݱ仯 //System.out.println("will 2,1,90"); Mywait.myWait();
		 * aMofangStatusMessage.moFang3DRotate(2,1,90);
		 * 
		 * //���⶯������ aBranchGroup3.dongHua(2,1,90); Mywait.myWait();
		 * 
		 * //״̬ˢ�µ�����ͳ��� aMofangStatusMessage.outToATable();
		 * aBranchGroup3=(BranchGroup3)(testPanelAddedScene3D.branchGroupArray[3
		 * ]); aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);
		 * 
		 * //״̬���ݱ仯 //System.out.println ("will 0,2,-90"); Mywait.myWait();
		 * aMofangStatusMessage.moFang3DRotate(0,2,-90);
		 * 
		 * //���⶯������ aBranchGroup3.dongHua(0,2,-90); Mywait.myWait();
		 * 
		 * //״̬ˢ�µ�����ͳ��� aMofangStatusMessage.outToATable();
		 * aBranchGroup3=(BranchGroup3)(testPanelAddedScene3D.branchGroupArray[3
		 * ]); aBranchGroup3.setStatus(aMofangStatusMessage.dataMessage);
		 */

	}
}

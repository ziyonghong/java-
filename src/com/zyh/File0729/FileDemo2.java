package com.zyh.File0729;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 {
	public static void main(String[] args) {
		File dir = new File("G:/����/JAVA����Դ���ղ�");

		// ��ȡ��ǰĿ¼�����е��ļ�
		File[] fs = dir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return new File(dir, name).isFile() && name.endsWith(".txt");

			}
		});
		for (File file : fs) {
			System.out.println(file);
		}
	}
}

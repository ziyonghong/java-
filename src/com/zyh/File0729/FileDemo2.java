package com.zyh.File0729;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 {
	public static void main(String[] args) {
		File dir = new File("G:/资料/JAVA百万源码收藏");

		// 获取当前目录下所有的文件
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

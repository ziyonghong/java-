package com.zyh.File0729;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("G:/资料");
		listAllFile(dir);
	}

	// 列出所有的文件
	private static void listAllFile(File f) {
		System.out.println(f);
		// 第一级子目录
		File[] fs = f.listFiles();
		// for (File file : fs) {
		// System.out.println(file);
		// // 第二级
		// if (file.isDirectory()) {
		// File[] fs2 = file.listFiles();
		// for (File file2 : fs2) {
		// System.out.println(file2);
		// }
		// }

		// 递归
		for (File file : fs) {
			// 如果子文件是文件，则打印
			System.out.println(file);
			// 如果子文件是目录，继续递归
			if (file.isDirectory()) {
				listAllFile(file);
			}

		}
	}
}

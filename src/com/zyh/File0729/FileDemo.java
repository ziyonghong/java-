package com.zyh.File0729;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("G:/����");
		listAllFile(dir);
	}

	// �г����е��ļ�
	private static void listAllFile(File f) {
		System.out.println(f);
		// ��һ����Ŀ¼
		File[] fs = f.listFiles();
		// for (File file : fs) {
		// System.out.println(file);
		// // �ڶ���
		// if (file.isDirectory()) {
		// File[] fs2 = file.listFiles();
		// for (File file2 : fs2) {
		// System.out.println(file2);
		// }
		// }

		// �ݹ�
		for (File file : fs) {
			// ������ļ����ļ������ӡ
			System.out.println(file);
			// ������ļ���Ŀ¼�������ݹ�
			if (file.isDirectory()) {
				listAllFile(file);
			}

		}
	}
}

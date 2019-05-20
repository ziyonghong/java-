package com.zyh.File0729;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//File���г��ļ��ķֲ�ṹ
public class FileDemo1 {
	public static void main(String[] args) {
		String file = "G:/����/PS CC 2017-64λ/resources/Dictionary/zh_TW/stringTable.zdct";
		File f = new File(file);

		// ����Ŀ¼
		System.out.println(f.getParentFile().getName());
		// ����Ŀ¼�ĸ���Ŀ¼
		System.out.println(f.getParentFile().getParentFile().getName());

		List<String> parentName = new ArrayList<>();
		listAllParent(parentName, f);
		System.out.println(parentName);
		Collections.reverse(parentName);
		System.out.println(parentName);
	}

	private static void listAllParent(List<String> parentName, File f) {
		parentName.add(f.getParentFile().getName());
		if (f.getParentFile().getParentFile() != null) {
			listAllParent(parentName, f.getParentFile());
		}

	}
}

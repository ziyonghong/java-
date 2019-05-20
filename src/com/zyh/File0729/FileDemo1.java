package com.zyh.File0729;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//File类列出文件的分层结构
public class FileDemo1 {
	public static void main(String[] args) {
		String file = "G:/资料/PS CC 2017-64位/resources/Dictionary/zh_TW/stringTable.zdct";
		File f = new File(file);

		// 父级目录
		System.out.println(f.getParentFile().getName());
		// 父级目录的父级目录
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

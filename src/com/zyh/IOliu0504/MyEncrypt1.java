package com.zyh.IOliu0504;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyEncrypt1 {
	public static void main(String[] args) {
		try {
			// ¶ÁÃÜÔ¿ÎÄ¼ş
			int[] key = new int[128];
			File keyFile = new File("c:/work/key.key");
			FileInputStream keyFis = new FileInputStream(keyFile);
			for (int i = 0; i < 128; i++) {
				key[i] = keyFis.read();
			}

			// ¼ÓÃÜ
			File inFile = new File("c:/work/test.txt");
			File outFile = new File("c:/work/test1.txt");
			FileInputStream fis = new FileInputStream(inFile);
			FileOutputStream fos = new FileOutputStream(outFile);
			int length = fis.available();
			for (int i = 0; i < length; i++)
				fos.write(fis.read() + key[i % 128]);
		} catch (Exception e) {
		}
	}
}

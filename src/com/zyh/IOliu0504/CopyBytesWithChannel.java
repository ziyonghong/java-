package com.zyh.IOliu0504;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyBytesWithChannel {

	private static final int BSIZE = 1024;// ���建������С

	public static void main(String[] args) throws IOException {
		FileInputStream ins = new FileInputStream("c:/work/test.txt");
		FileOutputStream fos = new FileOutputStream("c:/work/test2.txt");

		FileChannel inChannel = ins.getChannel();// ��ȡ���ļ���������ͨ��
		FileChannel outChannel = fos.getChannel();// ��ȡ���ļ��������ͨ��
		// System.out.println(ins.read());
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);// ����������
		while (inChannel.read(buffer) != -1) {
			buffer.flip(); // ʹ������׼����д����
			outChannel.write(buffer);
			buffer.clear();
		}
		ins.close();
		fos.close();
		//System.out.println("read end");
	}
}

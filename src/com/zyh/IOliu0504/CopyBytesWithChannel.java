package com.zyh.IOliu0504;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyBytesWithChannel {

	private static final int BSIZE = 1024;// 定义缓冲区大小

	public static void main(String[] args) throws IOException {
		FileInputStream ins = new FileInputStream("c:/work/test.txt");
		FileOutputStream fos = new FileOutputStream("c:/work/test2.txt");

		FileChannel inChannel = ins.getChannel();// 获取该文件输入流的通道
		FileChannel outChannel = fos.getChannel();// 获取该文件输出流的通道
		// System.out.println(ins.read());
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);// 创建缓冲区
		while (inChannel.read(buffer) != -1) {
			buffer.flip(); // 使缓冲区准备好写操作
			outChannel.write(buffer);
			buffer.clear();
		}
		ins.close();
		fos.close();
		//System.out.println("read end");
	}
}

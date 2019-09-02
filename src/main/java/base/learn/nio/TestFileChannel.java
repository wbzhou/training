package base.learn.nio;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel {
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		FileChannel channel = outputStream.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		String string = "java nio";
		buffer.put(string.getBytes());
		buffer.flip(); // 此处必须要调用buffer的flip方法
		channel.write(buffer);
		channel.close();
		outputStream.close();
	}

	public void testFileInputSteam() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Java/jdk1.6.0_18/LICENSE");

		// 得到文件通道
		FileChannel fc = fis.getChannel();

		// 分配与文件尺寸等大的缓冲区
		ByteBuffer bf = ByteBuffer.allocate((int) fc.size());

		// 整个文件内容全读入缓冲区，即是内存映射文件
		fc.read(bf);

		// 把缓冲中当前位置回复为零
		bf.rewind();

		// 输出缓冲区中的内容
		while (bf.hasRemaining()) {
			System.out.print((char) bf.get());
		}
	}
}
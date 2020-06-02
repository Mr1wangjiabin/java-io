package byteStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 从文件中读取数据
 */
public class FileOutPutStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("out.dat");
        byte[] bytes = "你好".getBytes();
        fos.write(bytes);
        fos.close();

        FileInputStreamTest.printHex("out.dat");
    }
}

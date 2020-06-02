package byteStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取指定文件内容，按照16进制输出到控制台。并且每输出10个byte换行
 * 批量读取
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        printHex("file.txt");
    }

    public static void printHex(String filename) throws IOException{
        FileInputStream fis = new FileInputStream(filename);
        byte[] bytes = new byte[8 * 1024];
        int b = 0;
        int j = 1;
        while ((b = fis.read(bytes,0,bytes.length)) != -1){
            for (int i = 0; i < b; i++) {
                System.out.print(Integer.toHexString(bytes[i] & 0xff) + "  ");
                if(((j++)%10)==0){
                    System.out.println();
                }
            }

        }

        fis.close();
    }

}

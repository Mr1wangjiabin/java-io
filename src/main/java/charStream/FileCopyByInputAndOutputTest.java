package charStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *  InputStreamReader && OutputStreamWriter 实现文件复制
 */
public class FileCopyByInputAndOutputTest {
    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("fileOut3.txt"));

        char[] chars = new char[8 * 1024];
        int c;

        while ((c = isr.read(chars,0,chars.length)) != -1){
            osw.write(chars,0,c);
            osw.flush();
        }

        isr.close();
        osw.close();
    }
}

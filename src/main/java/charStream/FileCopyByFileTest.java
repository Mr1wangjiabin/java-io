package charStream;

import java.io.FileReader;
import java.io.FileWriter;

/**
 *  InputStreamReader && OutputStreamWriter 实现文件复制
 */
public class FileCopyByFileTest {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("file.txt");
        FileWriter fw = new FileWriter("fileOut4.txt");

        char[] chars = new char[8 * 1024];
        int d;

        while ((d = fr.read(chars,0,chars.length)) != -1){
            fw.write(chars,0,d);
        }

        fr.close();
        fw.close();
    }
}

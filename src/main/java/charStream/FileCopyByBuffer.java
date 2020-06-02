package charStream;

import java.io.*;

public class FileCopyByBuffer {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
        PrintWriter pw = new PrintWriter(
                new FileOutputStream("fileOut5.txt"),true);//在文件参数为 OutputStream时，可以设置自动清空缓存

        String line;
        while ((line = br.readLine()) != null){
            pw.println(line);
        }

        br.close();
        pw.close();

    }
}

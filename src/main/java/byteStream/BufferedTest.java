package byteStream;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws Exception{
        copyFile(new File("E:\\Project\\io\\src\\main\\java\\file\\FileDemo.java"),
        new File("fileOut2.txt"));

    }

    public static void copyFile(File srcFile, File destFile) throws Exception{
        if(!srcFile.exists()){
            throw new IllegalAccessException("文件" + srcFile + "不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalAccessException("文件" + srcFile + "不是文件");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        int c;
        while ((c = bis.read())!= -1){
            bos.write(c);
            bos.flush();
        }

        bis.close();
        bos.close();

    }
}

package byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 完成文件的复制
 */
public class FileCopyTest {

    public static void main(String[] args) throws Exception {
        fileCopy(new File("file.txt"),new File("fileout.txt"));
    }

    /**
     * 文件复制
     * 问什么传入参数不用文件名？
     *      需要判断源文件是否存在
     * @param srcFile
     * @param destFile
     */
    public static void fileCopy(File srcFile,File destFile) throws Exception{
        if(!srcFile.exists()){
            throw new IllegalAccessException("文件" + srcFile + "不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalAccessException("文件" + srcFile + "不是文件");
        }

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        byte[] bytes = new byte[8 * 1024];
        int b = 0;

        if((b = fis.read(bytes,0,bytes.length)) != -1){
            fos.write(bytes,0,b);
            fos.flush();
        }

        fis.close();
        fos.close();

    }
}

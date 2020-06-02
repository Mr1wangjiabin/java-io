package file;

import java.io.File;

/**
 * list 返回目录/文件下的所有文件名
 * listFiles 返回文件下的所有文件
 *
 * 练习，完成目录下所有子目录的查询
 */
public class FileUtils {
    public static void main(String[] args) throws IllegalAccessException {
        File file = new File("E:/Project/io");
        FileUtils.listFile(file);

    }

    public static void listFile(File file) throws IllegalAccessException {
        //首先判断文件是否存在以及文件是文件夹
        if(!file.exists()){
            throw new IllegalAccessException(file + " 不存在");
        }
        if (!file.isDirectory()){
            throw new IllegalAccessException(file + " 不是一个文件夹");
        }

        File[] files = file.listFiles();
        if (files.length > 0 && files != null){
            for (File file1 : files) {
                if (file1.isDirectory()){
                    FileUtils.listFile(file1);
                }else {
                    System.out.println(file);
                }
            }
        }



    }
}

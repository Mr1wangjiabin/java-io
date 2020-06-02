package file;

import java.io.File;
import java.io.IOException;

/**
 * File 的构造函数：
 *  File(filepath) filepath为文件全目录
 *  File(filepath,filepath1,filepath2...) filepath1为filepath的子目录
 * File.separator 文件分隔符
 * exists 验证file是否存在
 * mkdir 创建一个文件夹/目录
 * mkdir 创建多级目录
 * delete 删除文件
 * isDirectory 判断file 是否是文件夹
 * isFile 判断file 是否是文件
 * getAbsolutePath 获取全路径
 * getName 获取文件名称
 * createNewFile 创建一个新文件
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Project\\io\\test");
        File file1 = new File("E:" + File.separator
                + "Project" + File.separator
                + "io"+ File.separator
                + "test.text");

        if(!file.exists()){
            file.mkdir();
        }else {
            file.delete();
        }
        System.out.println(file.isDirectory());//判断file 是否是文件夹
        System.out.println(file.isFile());//判断file 是否是文件
        System.out.println(file.getAbsolutePath());//获取全路径
        System.out.println(file.getName());//获取文件名称

        if (!file1.exists()){
            file1.createNewFile();
        }else {
            file1.delete();
        }

    }
}

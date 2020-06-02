package file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 ** java 文件模型
 *      在硬盘上是 byte byte 存储的，是数据的集合
 *  打开文件
 *      有两种模式："rw"（读写） "r"（只读）
 *      RandomAccessFile raf = new RandomAccessFile("rw")
 *      文件指针，打开文件时，文件指针在开头 pointer = 0
 * 写方法
 *      raf.writer() -->只写一个字节（后8位）同时指针指向下一个位置，准备再次写入
 * 读方法
 *      int b = raf.read() --> 读一个字节
 * 文件读写完成一定要关闭
 *
 * 其他API
 * getFilePointer 获取指针当前所在位置
 *
 *
 */
public class RandomAccessFileDmo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File file = new File("demo");
        if(!file.exists()){
            file.mkdir();
        }
        File file1 = new File(file, "raf.dat");
        if(!file1.exists()){
            file1.createNewFile();
        }

        //对文件的读写操作
        RandomAccessFile raf = new RandomAccessFile(file1, "rw");
        System.out.println("指针当前所在位置为：" + raf.getFilePointer());//获取指针当前所在位置

        //写入一个字节
        //默认编码UTF-8，一个汉字 3 个字节，一个字母 1 个字节
        raf.write('A');
        System.out.println("指针当前所在位置为：" + raf.getFilePointer());//获取指针当前所在位置

        int i = 0x7fffffff;
        //用write方法每次只能写一个字节，如果要把i写进去就得写4次
        raf.write((i >>> 24) & 0xff);//右移 24 位，并清空其余的0值
        raf.write((i >>> 16) & 0xff);
        raf.write((i >>> 8) & 0xff);
        raf.write((i) & 0xff);
        System.out.println("指针当前所在位置为：" + raf.getFilePointer());//获取指针当前所在位置

        //可以直接写一个 int 型变量,底层实现和上面的方法一样
        raf.writeInt(i);

        //写一个汉字
        String s = "中";
        byte[] bytes = s.getBytes();
        raf.write(bytes);
        System.out.println("指针当前所在位置为：" + raf.getFilePointer());//获取指针当前所在位置

        //读文件，必须把指针移动到头部
        raf.seek(0);
        //把文件中的内容都读取到字节数组中
        byte[] bytes1 = new byte[(int) raf.length()];
        raf.read(bytes1);

        System.out.println(Arrays.toString(bytes1));//将数组输出
        //将字节数组转换为字符串输出
        String s1 = new String(bytes1);
        System.out.println(s1);

        raf.close();

    }
}

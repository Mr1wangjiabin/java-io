package encode;

public class EncodeDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 文本文件，可以是任意编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文件只认识ANSI编码
         *
         * 字节序列只能进行同种编码间的传输，如果编码方式不一致，会出现乱码
         */
        //UTF-8 输出e6 b5 8b e8 af 95 41 42 43
        //一个汉字 3 个字节，字母 1 个字节
        String s = "测试ABC";
        byte[] bytes1 = s.getBytes();//转换成字节是项目默认的编码 UTF-8
        System.out.println("UTF-8编码：");
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");//将字节转换为 16进制 int型输出
        }
        System.out.println();

        //GBK输出b2 e2 ca d4 41 42 43
        //一个汉字 2 个字节，字母 1 个字节
        System.out.println("GBK编码：");
        byte[] bytes2 = s.getBytes("gbk");
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        //UTF-16be 输出6d 4b 8b d5 0 41 0 42 0 43
        //一个汉字 2 个字节，字母 2 个字节
        System.out.println("UTF-16be编码：");
        byte[] bytes3 = s.getBytes("utf-16be");
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
    }
}

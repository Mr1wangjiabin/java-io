package SerializableTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

    public static void main(String[] args) throws Exception{
        //对象序列化
        ObjectSerializable();
        //对象反序列化
        ObjectInSerializable();
    }

    /**
     * 对象序列化
     * @throws Exception
     */
    public static void ObjectSerializable() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));
        Student student = new Student(1L, "小王");
        oos.writeObject(student);
        oos.flush();
        oos.close();
    }

    public static void ObjectInSerializable() throws  Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.dat"));
        Student student = (Student) ois.readObject();
        System.out.println(student);
        ois.close();
    }

}

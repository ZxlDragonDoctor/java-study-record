package zxl.filetest;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileTest_1 {
    public static void main(String[] args)  throws IOException {
        String srcpath  = "D:\\ok.txt";
        Properties ois = new Properties();
        ois.setProperty("name","??");
        ois.setProperty("age","18");
        ois.setProperty("??","???");
        ois.store(new BufferedWriter(new FileWriter(srcpath)),null);
        ois.load(new FileReader(srcpath));
        ois.list(System.out);
        String user = ois.getProperty("name");
        System.out.println("name=" + user);
        //  public synchronized Object setProperty(String key, String value) {
        //        return put(key, value);
        //    }
    }
}
class Dog {
    String name = "????";
    int age = 18;
    String employee = "???";

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", employee='" + employee + '\'' +
                '}';
    }
}

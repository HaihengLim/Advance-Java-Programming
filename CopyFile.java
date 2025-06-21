import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws Exception{
        FileInputStream f1 = new FileInputStream("d:\\Programming\\text\\text.txt");
        FileOutputStream f2 = new FileOutputStream("d:\\Programming\\Andvance Java Programming\\RUPP\\text2.txt");
        int c; String data = ""; char s = '\n';
        while(true){
            c = f1.read();
            if(c == -1) break;
            data = data + (char)c;
        }
        f1.close();
        for(int i = 0; i < data.length(); i++)
            f2.write((int) data.charAt(i));
        f2.write((int)s);
        f2.close();
        System.out.println("Copy Successful");
    }
}

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws Exception{
        FileInputStream f = new FileInputStream("d:\\Programming\\text\\text.txt");
        int c; String data = "";
        while(true){
            c = f.read();
            if(c == -1) break;
            data = data + (char)c;
        }
        f.close();
        System.out.println("Cotent of file is \n" + data);
    }
}

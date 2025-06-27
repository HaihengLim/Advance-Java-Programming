import java.io.FileInputStream;
import java.io.DataInputStream;

public class Bin_ReadFile{
    public static void main(String[] args) throws Exception{
        FileInputStream f = new FileInputStream("d:\\Programming\\Text\\integer.bin");
        DataInputStream dw = new DataInputStream(f); int x;
        while(true){
            x = dw.readInt();
            if(x == -1) break;
            System.out.print(" " + x);
        }
        dw.close();
    }
}

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;

public class Bin_ReadFile_ArrayList {
    public static void main(String[] args) throws Exception {
        FileInputStream f = new FileInputStream("d:\\Programming\\Text\\integer.bin");
        DataInputStream dw = new DataInputStream(f);
        ArrayList<Integer> al = new ArrayList<Integer>(); int x;
        try {
            while(true){
                x = dw.readInt();
                al.add(x);
            }
        } catch (Exception e) {
           System.out.println("Read File Successfully:");
        }
        dw.close();
        for(int i = 0; i < al.size(); i++)
            System.out.print(" " + al.get(i));
    }
}

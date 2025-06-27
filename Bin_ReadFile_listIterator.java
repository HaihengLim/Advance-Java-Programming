import java.util.ListIterator;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class Bin_ReadFile_listIterator {
    public static void main(String[] args) throws Exception{
        FileInputStream f = new FileInputStream("d:\\Programming\\Text\\integer.bin");
        DataInputStream dw = new DataInputStream(f);
        ArrayList<Integer> al = new ArrayList<>();
        int x;
        while(true){
            x = dw.readInt();
            if(x == -1) break;
            al.add(x);
        }
        dw.close();
        ListIterator<Integer> li = al.listIterator();
        while(li.hasNext())
            System.out.print(" " + li.next());
    }
}

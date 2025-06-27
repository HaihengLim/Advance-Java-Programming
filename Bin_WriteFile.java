import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Bin_WriteFile {
    public static void main(String[] args) throws Exception{
        FileOutputStream obj = new FileOutputStream("d:\\Programming\\Text\\integer.bin");
        DataOutputStream f = new DataOutputStream(obj);
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); int x;
        System.out.print("Number Integer to write: "); int n = sc.nextInt();
        sc.close();
        for(int i = 1; i < n; i++){
            x = rand.nextInt(100);
            f.writeInt(x);
        }
        f.writeInt(-1);
        f.close();
        System.out.println("Write to file successfully!");
    }
}

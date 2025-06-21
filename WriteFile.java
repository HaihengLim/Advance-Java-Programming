import java.util.Scanner;
import java.io.*;

public class WriteFile {
    public static void main(String[] args) throws Exception{
        System.out.println("Open text file to write: ");
        FileOutputStream f = new FileOutputStream("d:\\Programming\\text\\text.txt");
        Scanner sc = new Scanner(System.in);
        String str;
        char s = '\n';
        System.out.print("Input a string: "); str = sc.nextLine();
        for(int i = 0; i < str.length(); i++)
            f.write((int) str.charAt(i));
        f.write((int)s);
        f.close();
        sc.close();
        System.out.println("Successful:");
    }
}

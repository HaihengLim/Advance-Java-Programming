import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Drink implements Serializable {
    private int code;
    private String name;
    private float price;

    public Drink() {}

    public Drink(int c, String n, float p) {
        code = c;
        name = n;
        price = p;
    }

    public void input(Scanner sc) {
        System.out.print("Enter Code: ");
        code = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Price: ");
        price = sc.nextFloat();
    }

    public void output() {
        System.out.println(code + "\t" + name + "\t" + price);
    }
}

public class Output_Product {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream f1;
        FileOutputStream s1 = new FileOutputStream("d:\\Programming\\Text\\product.dat");
        f1 = new ObjectOutputStream(s1);

        Scanner sc = new Scanner(System.in);
        int n;
        ArrayList<Drink> al = new ArrayList<>();

        System.out.print("Number of Products: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Drink " + (i + 1) + ": ");
            Drink p = new Drink();
            p.input(sc); // pass Scanner to input()
            al.add(p);
        }

        f1.writeObject(al);
        f1.close();

        // Reading from file
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("d:\\Programming\\Text\\product.dat"));
        ArrayList<Drink> list = (ArrayList<Drink>) f.readObject();
        f.close();

        System.out.println("\nStored Drink List:");
        for (Drink d : list) {
            d.output();
        }

        sc.close(); // close only at the very end
    }
}

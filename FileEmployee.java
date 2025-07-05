import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Employee implements Serializable{
    private int id;
    private String name;
    private float salary;
    public Employee(){id = 0; name = "non"; salary = 0;}
    public Employee(int i, String n, float s){id = i; name = n; salary = s;}
    public void input(Scanner sc){
        System.out.print("Enter Id: "); id = sc.nextInt();
        System.out.print("Enter Name: "); sc.nextLine(); name = sc.nextLine();
        System.out.print("Enter Salary: "); salary = sc.nextFloat();
    }
    public void output(){
        String st = id + "\t" + name + "\t" + salary;
        System.out.println(st);
    }
    public int getId(){return id;}
    public float getSalary(){return salary;}
    public void setSalary(float s){salary = s;}
}

public class FileEmployee {
    public static void inputAll(ArrayList<Employee> emp, int n, Scanner sc){
        for(int i = -0; i < n; i++){
            System.out.println("Employee " + (i + 1));
            Employee e = new Employee();
            e.input(sc);
            emp.add(e);
        }
    }
    public static void outputAll(ArrayList<Employee> emp){
        for(int i = 0; i < emp.size(); i++)
            emp.get(i).output();
    }

    public static void writeToFile(ArrayList<Employee> emp){
        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("d:\\Programming\\Text\\EmployeeSaveList3.bin"))){
            os.writeObject(emp);
            os.close();
            System.out.println("Write File Successfully");       
        } catch(IOException e){System.out.println("Write File Failed " + e.getMessage());}
    }

    @SuppressWarnings("unchecked")
    public static void readFromFile(ArrayList<Employee> emp){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\Programming\\Text\\EmployeeSaveList3.bin"))){
            emp.clear();
            ArrayList<Employee> list = (ArrayList<Employee>)in.readObject();
            emp.addAll(list);
            in.close();
            for(int i = 0; i < emp.size(); i++)
                emp.get(i).output();
        } catch(EOFException e){System.out.println("Read File Successfully");}
        catch(IOException e){
            System.out.print("Read File Failed " + e.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
    public static void newSalary(ArrayList<Employee> emp, int idd){
        int index = -1;
        float newSal;
        for(int i = 0; i < emp.size(); i++)
            if(idd == emp.get(i).getId())
                index = i;
        if(index != -1) {
            newSal = (float)((emp.get(index).getSalary() * 0.2) + emp.get(index).getSalary());
            emp.get(index).setSalary(newSal);
            emp.get(index).setSalary(newSal);
            System.out.println("New salary for employee with ID " + idd + " is: " + newSal);
        } else {
            System.out.println("Employee with ID " + idd + " not found.");
        }
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int n, idSearch;
            System.out.print("Enter Number of Employee: "); n = sc.nextInt();
            ArrayList<Employee> emp = new ArrayList<Employee>();
            inputAll(emp, n, sc);
            writeToFile(emp);
            readFromFile(emp);
            System.out.print("Enter Id Employee that you want to increase salary: "); idSearch = sc.nextInt();
            newSalary(emp, idSearch);
            writeToFile(emp);
            readFromFile(emp);
        }
    }
}

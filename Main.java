

import java.util.ArrayList;
import java.util.List;
import java .util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {

    private List<Employee> employeeList;//private Arraylist<Integer>employeelist=new Arraylist<>();

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
	 {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;//variable
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
	//System.out.println(*************Full time Employee*******************);

	System.out.println("Enter a id");
	int id=sc.nextInt();

	System.out.println("Enter a name");
	String name=sc.next();
	

	System.out.println("Enter a monthly salary");
	double montlysalary=sc.nextDouble();

        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee(name , id ,montlysalary);

	//System.out.println(*************Part time Employee*******************);
	System.out.println("Enter a id");
	int pid=sc.nextInt();

	System.out.println("Enter a name");
	String pname=sc.next();
	
	System.out.println("Enter a hours of worker");
	int hoursWorked=sc.nextInt();

	System.out.println("Enter a houly rate");
	double hourlyRate=sc.nextDouble();

        PartTimeEmployee emp2 = new PartTimeEmployee(pname,pid,hoursWorked,hourlyRate);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }
}

import java.util.ArrayList; //imported ArrayList package

// Creating an abstract employee class to 
// emprove security using encapsulation property

abstract class Employee {
  private String name;
  private int id;

  public Employee(String name, int id) { // construction to assign value to the variable
    this.name = name;
    this.id = id;
  }

  public String getName() { // get method for getting name
    return name;
  }

  public int getId() { // get method for getting id
    return id;
  }

  // an abstract method to improve security and because the class is a abstract
  // class
  public abstract double calculateSalary();

  // using override methods for manual modification into inbuilt library
  @Override
  public String toString() {
    return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
  }

}

// creating child class using inheritannce concept to inherit Employee parent
// class methods and properties
class FullTimeEmployee extends Employee {

  private double monthlySalary;

  // constructor to assign values

  public FullTimeEmployee(String name, int id, double monthlySalary) {
    super(name, id); // using super keyword we can assign values to parent class variable
    this.monthlySalary = monthlySalary;
  }

  @Override
  public double calculateSalary() {
    return monthlySalary;
  }
}

// creating child class using inheritannce concept to inherit Employee parent
// class methods and properties
class PartTimeEmployee extends Employee {

  private int hoursWorked;
  private double hourlyRate;

  public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
    super(name, id); // using super keyword we can assign values to parent class variable
    this.hoursWorked = hoursWorked;
    this.hourlyRate = hourlyRate;

  }

  @Override
  public double calculateSalary() {
    return hourlyRate * hoursWorked;
  }
}

// Creating another class for actual implimentation of this project

class PayrollSystem {
  private ArrayList<Employee> employeeList;

  public PayrollSystem() {
    employeeList = new ArrayList<>();

  }

  public void addEmployee(Employee employee) {
    employeeList.add(employee);
  }

  public void removeEmployee(int id) {
    Employee employeeToRemove = null;
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

// main calss execution starts here....
public class Main {

  // entry of execution.....
  public static void main(String[] args) {
    PayrollSystem payrollSystem = new PayrollSystem();
    FullTimeEmployee emp1 = new FullTimeEmployee("Avi", 1, 60000.0);
    PartTimeEmployee emp2 = new PartTimeEmployee("Vikash", 2, 50, 200);

    payrollSystem.addEmployee(emp1);
    payrollSystem.addEmployee(emp2);

    System.out.println("Initial employee details: ");
    payrollSystem.displayEmployees();

    System.out.println("Removing employee: ");
    payrollSystem.removeEmployee(2);

    System.out.println("Remaining employee details: ");
    payrollSystem.displayEmployees();
  }
}
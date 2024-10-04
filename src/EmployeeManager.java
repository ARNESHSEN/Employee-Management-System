import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private static ArrayList<Employee> employeeList = new ArrayList<>();

    // Add Employee
    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    // View All Employees
    public static void viewAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employeeList) {
                employee.displayEmployeeDetails();
                System.out.println("---------------------------");
            }
        }
    }

    // Update Employee
    public static void updateEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new name: ");
                employee.setName(scanner.nextLine());
                System.out.print("Enter new department: ");
                employee.setDepartment(scanner.nextLine());
                System.out.print("Enter new salary: ");
                employee.setSalary(scanner.nextDouble());
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Delete Employee
    public static void deleteEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee type (1 for Employee, 2 for Manager): ");
                    int empType = scanner.nextInt();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    if (empType == 1) {
                        addEmployee(new Employee(id, name, department, salary));
                    } else if (empType == 2) {
                        System.out.print("Enter Bonus: ");
                        double bonus = scanner.nextDouble();
                        addEmployee(new Manager(id, name, department, salary, bonus));
                    }
                    break;

                case 2:
                    viewAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    updateEmployee(updateId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

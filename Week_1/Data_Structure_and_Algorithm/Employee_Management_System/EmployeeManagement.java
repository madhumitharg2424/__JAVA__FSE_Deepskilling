import java.util.Arrays;
import java.util.Comparator;

public class EmployeeManagement {

    public static Employee searchEmployee(
            Employee[] employees,
            int employeeId) {

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Employee[] employees = {

            new Employee(101, "Madhu", "IT", 65000),
            new Employee(102, "Ramya", "HR", 50000),
            new Employee(103, "Priya", "Finance", 70000),
            new Employee(104, "Karthik", "Development", 60000),
            new Employee(105, "Anu", "Marketing", 55000)

        };

        System.out.println("===== EMPLOYEE LIST =====");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getEmployeeId() + " | " +
                    employee.getEmployeeName() + " | " +
                    employee.getDepartment() + " | " +
                    employee.getSalary());
        }

        int searchId = 103;

        Employee foundEmployee =
                searchEmployee(employees, searchId);

        System.out.println("\n===== SEARCH RESULT =====");

        if (foundEmployee != null) {

            System.out.println("Employee Found");
            System.out.println("ID         : "
                    + foundEmployee.getEmployeeId());

            System.out.println("Name       : "
                    + foundEmployee.getEmployeeName());

            System.out.println("Department : "
                    + foundEmployee.getDepartment());

            System.out.println("Salary     : "
                    + foundEmployee.getSalary());

        } else {

            System.out.println("Employee Not Found");
        }

        Arrays.sort(employees,
                Comparator.comparingDouble(
                        Employee::getSalary).reversed());

        System.out.println("\n===== EMPLOYEES SORTED BY SALARY =====");

        for (Employee employee : employees) {

            System.out.println(
                    employee.getEmployeeName() + " - ₹" +
                    employee.getSalary());
        }

        System.out.println("\nTime Complexity");
        System.out.println("Linear Search : O(n)");
        System.out.println("Sorting       : O(n log n)");
    }
}
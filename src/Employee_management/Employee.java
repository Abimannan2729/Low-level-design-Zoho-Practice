package Employee_management;

public class Employee {
    int employee_id;
    String name;
    int age;
    String department;
    String designation;
    String reporting;
     Employee(int employee_id, String name, int age, String department, String designation, String reporting) {
         this.employee_id = employee_id;
         this.age = age;
         this.name = name;
         this.department = department;
         this.designation = designation;
         this.reporting = reporting;
     }
} 
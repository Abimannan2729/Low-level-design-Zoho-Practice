package Employee_management;
import java.util.*;
public class EmployeeManagement {
    public static void main(String[] args) {
        TaskManagement management= new TaskManagement();
        while(true) {
            System.out.println("================== Employee Management ===================");

            System.out.println("1. Show Records");
            System.out.println("2. Search And Update");
            System.out.println("3. Remove Employee");
            System.out.println("4. Manager Report");
            System.out.println("5. Reporting To Tree");
            System.out.println("6. Summary Reports");
            System.out.println("7. Exit");
            System.out.println("Enter Your Choice");
            Scanner tempScan = new Scanner(System.in);
            int choice = tempScan.nextInt();
            switch(choice) {
                case 1:
                      management.ShowRecords();
                      break;
                case 2:
                	 management.SearchAndUpdate();
                	 break;
                case 3:
                    management.RemoveEmployee();
                    break;
                case 4:
                    management.ManagerReport();
                    break;
                case 5:
                    management.ReportingToTree();
                    break;
                case 6:
                    management.SummaryReports();
                    break;
                case 7:
                    System.out.println("Exiting.....");
                    System.exit(0);
            }

        }
        
    }
}
package Employee_management;

import java.util.*;
public class TaskManagement {
    EmployeeRecords employeeRecords = new EmployeeRecords();

    public void ShowRecords() {
        System.out.println("All Employee Records:");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-5s %-15s %-20s %-15s \n","ID","Name","Age","Department","Designation","Reporting To");
        System.out.println("----------------------------------------------------------------------------------");
        for(Employee employee: employeeRecords.employees){
            System.out.printf("%-5d %-15s %-5d %-15s %-20s %-15s \n",employee.employee_id,employee.name,employee.age,employee.department,employee.designation,employee.reporting);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();
    }
    public void filterByNumeric(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
		System.out.println("1.Filter by ID");
		System.out.println("2. Filter by Age");
		int filterNumericchoice = tempScan.nextInt();
		switch(filterNumericchoice) {
		case 1:
			filterByID(filteredRecords);
			return;  
		case 2:
			filterByAge(filteredRecords);
			return;
		}
    }
    public void filterByID(ArrayList<Employee> filteredRecord) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter ID to filter");
    	int filterByAId= tempScan.nextInt();
    	System.out.println("1. Filter By Less than ID "+ filterByAId);
    	System.out.println("2. Filter By Greater than ID "+ filterByAId);
    	System.out.println("3. Filter By equal to ID "+ filterByAId);
    	System.out.println("4. Filter By Not Eqaual to ID "+ filterByAId);
    	int filterByIdchoice=tempScan.nextInt();
    	Iterator<Employee> itr = filteredRecord.iterator();
        while (itr.hasNext()) {
            Employee employee = itr.next();
            switch (filterByIdchoice) {
                case 1: if (employee.employee_id >= filterByAId) itr.remove(); break;
                case 2: if (employee.employee_id <= filterByAId) itr.remove(); break;
                case 3: if (employee.employee_id != filterByAId) itr.remove(); break;
                case 4: if (employee.employee_id == filterByAId) itr.remove(); break;
            }
        }
    }
    public void filterByAge(ArrayList<Employee> filteredRecord) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter Age to filter");
    	int filterByAge= tempScan.nextInt();
    	System.out.println("1. Filter By Less than Age "+ filterByAge);
    	System.out.println("2. Filter By Greater than Age "+ filterByAge);
    	System.out.println("3. Filter By equal to Age "+ filterByAge);
    	System.out.println("4. Filter By Not Eqaual to Age "+ filterByAge);
    	int filterByAgechoice=tempScan.nextInt();
    	 Iterator<Employee> itr = filteredRecord.iterator();
    	    while(itr.hasNext()) {
    	        Employee employee = itr.next();
    	        switch(filterByAgechoice) {
    	            case 1: if(employee.age >= filterByAge) itr.remove(); break;
    	            case 2: if(employee.age <= filterByAge) itr.remove(); break;
    	            case 3: if(employee.age != filterByAge) itr.remove(); break;
    	            case 4: if(employee.age == filterByAge) itr.remove(); break;
    	        }
    	    }
    	}
    
    public void filterByString(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
		System.out.println("1. Filter by Name");
		System.out.println("2. Filter by Department");
		System.out.println("3. Filter by Designation");
		System.out.println("4. Filter by Reporting to");
		
		int filterByStringChoice = tempScan.nextInt();
		switch(filterByStringChoice) {
		case 1:
			filterByName(filteredRecords);
			break;
			
		case 2:
			filterByDepartment(filteredRecords);
			break;
		
		case 3:
			filterByDesignation(filteredRecords);
			break;
			
		case 4:
			filterByReportingTo(filteredRecords);
		}
    }
    public void filterByName(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter Name to filter");
    	String filterByName= tempScan.nextLine();
    	System.out.println("1. Filter By Equals of Name "+ filterByName);
    	System.out.println("2. Filter By Not Equals of Name "+ filterByName);
    	System.out.println("3. Filter By Starts With of Name "+ filterByName);
    	System.out.println("4. Filter By Ends With of Name "+ filterByName);
    	int filterByNamechoice=tempScan.nextInt();
    	 Iterator<Employee> itr = filteredRecords.iterator();
    	    while(itr.hasNext()) {
    	        Employee employee = itr.next();
    	        switch(filterByNamechoice) {
    	            case 1: if(!employee.name.equalsIgnoreCase(filterByName)) itr.remove(); break;
    	            case 2: if(employee.name.equalsIgnoreCase(filterByName)) itr.remove(); break;
    	            case 3: if(!employee.name.startsWith(filterByName)) itr.remove(); break;
    	            case 4: if(!employee.name.endsWith(filterByName)) itr.remove(); break;
    	        }
    	    }
    }
    public void filterByDepartment(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter Name to filter");
    	String filterByDepartment= tempScan.nextLine();
    	System.out.println("1. Filter By Equals of Department "+ filterByDepartment);
    	System.out.println("2. Filter By Not Equals of Department"+ filterByDepartment);
    	System.out.println("3. Filter By Starts With of  Department "+ filterByDepartment);
    	System.out.println("4. Filter By Ends With of Department "+ filterByDepartment);
    	int filterByDepartmentchoice=tempScan.nextInt();
    	 Iterator<Employee> itr = filteredRecords.iterator();
    	    while(itr.hasNext()) {
    	        Employee employee = itr.next();
    	        switch(filterByDepartmentchoice) {
    	            case 1: if(!employee.department.equalsIgnoreCase(filterByDepartment)) itr.remove(); break;
    	            case 2: if(employee.department.equalsIgnoreCase(filterByDepartment)) itr.remove(); break;
    	            case 3: if(!employee.department.startsWith(filterByDepartment)) itr.remove(); break;
    	            case 4: if(!employee.department.endsWith(filterByDepartment)) itr.remove(); break;
    	        }
    	    }
    }
    public void filterByDesignation(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter Name to filter");
    	String filterByDesignation= tempScan.nextLine();
    	System.out.println("1. Filter By Equals of Designation "+ filterByDesignation);
    	System.out.println("2. Filter By Not Equals of Designation "+ filterByDesignation);
    	System.out.println("3. Filter By Starts With of Designation "+ filterByDesignation);
    	System.out.println("4. Filter By Ends With of Designation "+ filterByDesignation);
    	int filterByDesignationchoice=tempScan.nextInt();
    	 Iterator<Employee> itr = filteredRecords.iterator();
    	    while(itr.hasNext()) {
    	        Employee employee = itr.next();
    	        switch(filterByDesignationchoice) {
    	            case 1: if(!employee.designation.equalsIgnoreCase(filterByDesignation)) itr.remove(); break;
    	            case 2: if(employee.designation.equalsIgnoreCase(filterByDesignation)) itr.remove(); break;
    	            case 3: if(!employee.designation.startsWith(filterByDesignation)) itr.remove(); break;
    	            case 4: if(!employee.designation.endsWith(filterByDesignation)) itr.remove(); break;
    	        }
    	    }
    }

    public void filterByReportingTo(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
    	System.out.print("Enter Name to filter");
    	String filterByReportingTo= tempScan.nextLine();
    	System.out.println("1. Filter By Equals of Reporting To "+ filterByReportingTo);
    	System.out.println("2. Filter By Not Equals of Reporting To "+ filterByReportingTo);
    	System.out.println("3. Filter By Starts With of Reporting To "+ filterByReportingTo);
    	System.out.println("4. Filter By Ends With of Reporting To "+ filterByReportingTo);
    	int filterByReportingTochoice=tempScan.nextInt();
    	 Iterator<Employee> itr = filteredRecords.iterator();
    	    while(itr.hasNext()) {
    	        Employee employee = itr.next();
    	        switch(filterByReportingTochoice) {
    	            case 1: if(!employee.reporting.equalsIgnoreCase(filterByReportingTo)) itr.remove(); break;
    	            case 2: if(employee.reporting.equalsIgnoreCase(filterByReportingTo)) itr.remove(); break;
    	            case 3: if(!employee.reporting.startsWith(filterByReportingTo)) itr.remove(); break;
    	            case 4: if(!employee.reporting.endsWith(filterByReportingTo)) itr.remove(); break;
    	        }
    	    }
     }
    public void addFilter(ArrayList<Employee> filteredRecords) {
    	Scanner tempScan= new Scanner(System.in);
		System.out.println("1. Filter by Nummeric");
		System.out.println("2. Filter by String");
		int addfilterchoice = tempScan.nextInt();
		switch(addfilterchoice) {
		case 1:
			filterByNumeric(filteredRecords);
			return;  
		case 2:
			filterByString(filteredRecords);
			return;
		}
    }
    public void SearchAndUpdate() {
    	ArrayList<Employee> filteredRecords = new ArrayList<>(employeeRecords.employees);
    	boolean updateClicked=true;
    	while(updateClicked) {
    		Scanner tempScan= new Scanner(System.in);
    		System.out.println("1. Add Filter");
    		System.out.println("2. Update Filtered Records");
    		int searchAndUpdatechoice= tempScan.nextInt();
    		switch(searchAndUpdatechoice) {
    		case 1:
    			addFilter(filteredRecords);
    			System.out.println("Filter operation done.....");
    			System.out.println("Filtered employee recoords.....");
    			System.out.println("----------------------------------------------------------------------------------");
    	        System.out.printf("%-5s %-15s %-5s %-15s %-20s %-15s \n","ID","Name","Age","Department","Designation","Reporting To");
    	        System.out.println("----------------------------------------------------------------------------------");
    	        for(Employee employee:filteredRecords){
    	            System.out.printf("%-5d %-15s %-5d %-15s %-20s %-15s \n",employee.employee_id,employee.name,employee.age,employee.department,employee.designation,employee.reporting);
    	        }
    	        System.out.println("----------------------------------------------------------------------------------");
    			break;
    		case 2:
    			updateClicked=false;
    			ArrayList<Employee> updatedRecords = updateFilteredRecords (filteredRecords);
    			System.out.println("Updation Done.....");
    			System.out.println("Updated employee recoords.....");
    			System.out.println("----------------------------------------------------------------------------------");
    	        System.out.printf("%-5s %-15s %-5s %-15s %-20s %-15s \n","ID","Name","Age","Department","Designation","Reporting To");
    	        System.out.println("----------------------------------------------------------------------------------");
    	        for(Employee employee:updatedRecords){
    	            System.out.printf("%-5d %-15s %-5d %-15s %-20s %-15s \n",employee.employee_id,employee.name,employee.age,employee.department,employee.designation,employee.reporting);
    	        }
    	        System.out.println("----------------------------------------------------------------------------------");
    			break;
    		}
    	}
    }
    public ArrayList<Employee> updateFilteredRecords (ArrayList<Employee> filteredRecords) {
    	ArrayList<Employee> updatedEmployeeRecords= new ArrayList<>();
    	Scanner sc= new Scanner(System.in);
    	System.out.println("=========== Update Menu ============");
    	System.out.println("1.Update Name");
    	System.out.println("2.Update Age");
    	System.out.println("3.Update Department");
    	System.out.println("4.Update Designation");
    	System.out.println("5.Update Reporting To");
    	int updateMenuChoice = sc.nextInt();
    	switch(updateMenuChoice) {
    	 
    	case 1:
    		return updatedEmployeeRecords=updateName(filteredRecords);
    	case 2:
    		return updatedEmployeeRecords=updateAge(filteredRecords);    		
    	case 3:
    		return updatedEmployeeRecords=updateDepartment(filteredRecords);
    	case 4:
    		return updatedEmployeeRecords=updateDesignation(filteredRecords);
 
    	case 5:
    		return updatedEmployeeRecords=updateReportingTo(filteredRecords);
    	}
    	return updatedEmployeeRecords;
    }
    
    
    public ArrayList<Employee> updateName(ArrayList<Employee> filteredRecords ){
    	
    	ArrayList<Integer> employeeID= new ArrayList<>();
    	for(Employee employee :filteredRecords ) {
    		employeeID.add(employee.employee_id);
    	}
    	System.out.println("Enter Update Name Value:");
    	Scanner sc= new Scanner(System.in);
    	String updatingName= sc.nextLine();
    	for(int updateEmployeeID : employeeID ) {
    		for(Employee employee :employeeRecords.employees) {
    			if(employee.employee_id==updateEmployeeID) {
    				employee.name= updatingName;
    			}
    		}
    	}
    	return employeeRecords.employees;
    }
    
    public ArrayList<Employee> updateAge(ArrayList<Employee> filteredRecords ){
	
    	ArrayList<Integer> employeeID= new ArrayList<>();
    	for(Employee employee :filteredRecords ) {
    		employeeID.add(employee.employee_id);
    	}
    	System.out.println("Enter Update Age Value:");
    	Scanner sc= new Scanner(System.in);
    	int updatingAge= sc.nextInt();
    	for(int updateEmployeeID : employeeID ) {
    		for(Employee employee :employeeRecords.employees) {
    			if(employee.employee_id ==updateEmployeeID) {
    				employee.age= updatingAge;
    			}
    		}
    	}
    	
    	return employeeRecords.employees;
    }
    public ArrayList<Employee> updateDepartment(ArrayList<Employee> filteredRecords ){
	
    	
    	ArrayList<Integer> employeeID= new ArrayList<>();
    	for(Employee employee :filteredRecords ) {
    		employeeID.add(employee.employee_id);
    	}
    	System.out.println("Enter Update Name Value:");
    	Scanner sc= new Scanner(System.in);
    	String updatingDepartment= sc.nextLine();
    	for(int updateEmployeeID : employeeID ) {
    		for(Employee employee :employeeRecords.employees) {
    			if(employee.employee_id==updateEmployeeID) {
    				employee.department= updatingDepartment;
    			}
    		}
    	}
    	return employeeRecords.employees;
    }
    
    public ArrayList<Employee> updateDesignation(ArrayList<Employee> filteredRecords ){
	
    	ArrayList<Integer> employeeID= new ArrayList<>();
    	for(Employee employee :filteredRecords ) {
    		employeeID.add(employee.employee_id);
    	}
    	System.out.println("Enter Update Name Value:");
    	Scanner sc= new Scanner(System.in);
    	String updatingDesignation= sc.nextLine();
    	for(int updateEmployeeID : employeeID ) {
    		for(Employee employee :employeeRecords.employees) {
    			if(employee.employee_id==updateEmployeeID) {
    				employee.designation = updatingDesignation;
    			}
    		}
    	}
    	return employeeRecords.employees;
    }
    
    public ArrayList<Employee> updateReportingTo(ArrayList<Employee> filteredRecords ){
    	
    	ArrayList<Integer> employeeID= new ArrayList<>();
    	for(Employee employee :filteredRecords ) {
    		employeeID.add(employee.employee_id);
    	}
    	System.out.println("Enter Update Reporting To Value:");
    	Scanner sc= new Scanner(System.in);
    	String updatingReportingTo= sc.nextLine();
    	for(int updateEmployeeID : employeeID ) {
    		for(Employee employee :employeeRecords.employees) {
    			if(employee.employee_id==updateEmployeeID) {
    				employee.reporting = updatingReportingTo;
    			}
    		}
    	}
    	return employeeRecords.employees;
    }
    
    
    
    
    public void ManagerReport() {
        Scanner tempScan = new Scanner(System.in);
        System.out.println("Enter the Manager Name:");
        String ManagerName = tempScan.nextLine();
        System.out.println("--------------------------------");
        System.out.println("Employees Under "+ManagerName+":");
        for(Employee employee : employeeRecords.employees) {
            if(ManagerName.equalsIgnoreCase(employee.reporting)) {
                System.out.println(employee.name);
            }
        }
        System.out.println("--------------------------------");

    }
    public void SummaryReports() {
        System.out.println("1.Summary Records By Department");
        System.out.println("2.Summary Records By Designation");
        Scanner tempScan= new Scanner(System.in);
        int SummaryChoice = tempScan.nextInt();
        switch(SummaryChoice) {
            case 1:
                SummaryByDepartment();
                break;
            case 2:
                SummaryByDesignation();
                break;
        }


    }
    public void SummaryByDepartment() {
        HashMap<String, Integer> ReportCount = new HashMap<>();
        for(Employee employee : employeeRecords.employees) {
            ReportCount.put(employee.department, ReportCount.getOrDefault(employee.department, 0) + 1);
        }

        System.out.println("Summary Report By Department");
        System.out.printf("%-15s %-5s\n","Department","Employees");
        System.out.println("--------------------------------------");
        for(Map.Entry<String, Integer> report : ReportCount.entrySet()) {
            System.out.printf("%-15s  %-5d\n",report.getKey() , report.getValue());
        }
        System.out.println("--------------------------------------");
    }
    public void SummaryByDesignation() {
        HashMap<String, Integer> ReportCount = new HashMap<>();
        for(Employee employee : employeeRecords.employees) {
            ReportCount.put(employee.designation, ReportCount.getOrDefault(employee.designation, 0) + 1);
        }

        System.out.println("Summary Report By Designation");
        System.out.printf("%-15s %-5s\n","Designation","Employees");
        System.out.println("--------------------------------------");
        for(Map.Entry<String, Integer> report : ReportCount.entrySet()) {
            System.out.printf("%-15s  %-5d\n",report.getKey() , report.getValue());
        }
        System.out.println("--------------------------------------");
    }
    
    
    public void ReportingToTree() {
        HashMap<String, String> reportingToTreeMap = new HashMap<>();
        Scanner tempScan = new Scanner(System.in);

        System.out.println("Enter the Employee Name");
        String employeeName = tempScan.nextLine();

        // Build map: name -> reporting_to
        for (Employee employee : employeeRecords.employees) {
            reportingToTreeMap.put(employee.name, employee.reporting);
        }

        System.out.println("--------------------------------------");
        System.out.println("Reporting To Tree");
        System.out.println("--------------------------------------");

        // Traverse upwards in the hierarchy
        System.out.print(employeeName);
        while (reportingToTreeMap.containsKey(employeeName) &&
               reportingToTreeMap.get(employeeName) != null &&
               !reportingToTreeMap.get(employeeName).isEmpty()) {

            String reportingTo = reportingToTreeMap.get(employeeName);
            System.out.print(" -> " + reportingTo);
            employeeName = reportingTo; // move up in the tree
        }

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();
    }

    
    public void RemoveEmployee() {
        System.out.println("Enter The Employee Name To Remove");
        Scanner tempScan = new Scanner(System.in);
        String RemoveEmployeeName = tempScan.nextLine();
        System.out.println("**********************----- Warning! -----**********************");
        System.out.println("You Are Trying To Remove " + RemoveEmployeeName + " So Choose One Option");
        System.out.println("1. Add Another Employee for "+RemoveEmployeeName+"\'s Position");
        System.out.println("2. Assign Immediate Employee for "+RemoveEmployeeName+"\'s Position");
        int RemoveChoice = tempScan.nextInt();
        tempScan.nextLine(); 

        switch(RemoveChoice) {
            case 1:
                System.out.println("Enter another Employee to replace:");
                String ReplaceEmployee = tempScan.nextLine();
                ReplaceAndRemove(ReplaceEmployee, RemoveEmployeeName,false);
                break;
            case 2:
                ImmediateFinder(RemoveEmployeeName,true);
        }

    }
    public void ReplaceAndRemove(String ReplaceEmployeeName, String RemoveEmployeeName,boolean immediate) {
        
        for(Employee employee : employeeRecords.employees) {
            if(RemoveEmployeeName.equalsIgnoreCase(employee.reporting)) {
                employee.reporting = ReplaceEmployeeName;
            }
        }
        employeeRecords.employees.removeIf(e -> e.name.equalsIgnoreCase(RemoveEmployeeName));
        
        if(!immediate) {
        	Scanner  tempScan= new Scanner(System.in);
        	System.out.println("Add Replace Employee ID");
        	int id= tempScan.nextInt();
        	System.out.println("Add Replace Employee Age");
        	int Age= tempScan.nextInt();
        	tempScan.nextLine();
        	System.out.println("Add Replace Employee Department");
        	String Department= tempScan.nextLine();
        	System.out.println("Add Replace Employee Designation");
        	String Designation= tempScan.nextLine();
        	System.out.println("Add Replace Employee Reporting To ");
        	String Reporting= tempScan.nextLine();
        	
        	employeeRecords.addEmployee(id, ReplaceEmployeeName, Age, Department, Designation, Reporting);
        }
        
        System.out.println("Removed "+ RemoveEmployeeName);
        System.out.println("Added "+ ReplaceEmployeeName);
        
        System.out.println("-----------------------------------------------");
        
    }
    public void ImmediateFinder(String RemoveEmployeeName,boolean immediate) {
        int ImmediateCount = 0;
        for(Employee employee : employeeRecords.employees) {
            if(ImmediateCount == 1) {
                ReplaceAndRemove(employee.name, RemoveEmployeeName,true);
                break;
            }
            if(RemoveEmployeeName.equalsIgnoreCase(employee.name)) {
                ImmediateCount = 1;
            }
        }
    }
}
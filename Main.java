import java.util.*;
import java.time.*;

public class Main {

    public static void main(String[] args) {

        List<Inventory> records = new ArrayList<Inventory>();
        List<Input> inputDevice = new ArrayList<Input>();
        List<Output> outputDevice = new ArrayList<Output>();
        List<Inout> inoutDevice = new ArrayList<Inout>();
        List<Available> availableDevice = new ArrayList<Available>();
        List<NotAvailable> notAvailableDevice = new ArrayList<NotAvailable>();
        List<Employee> employeeName = new ArrayList<Employee>();

        try (Scanner input = new Scanner(System.in)) {
            int option;
            String userCode;
            String employeeAssigned = " ";
            do {
                System.out.println("----------Welcome to DOrSU Inventory System----------");
                System.out.println(
                        "1. Add New Peripheral\n2. View Record\n3. Edit Record\n4. Delete Record\n5. Show Report\n0. Close Inventory ");
                System.out.print("Enter Your Choice:");
                option = input.nextInt();

                switch (option) {

                    case 1:
                        Iterator<Inventory> rec = records.iterator();
                        Iterator<Input> in = inputDevice.iterator();
                        Iterator<Output> out = outputDevice.iterator();
                        Iterator<Inout> inout = inoutDevice.iterator();
                        Iterator<Available> available = availableDevice.iterator();
                        Iterator<NotAvailable> notAvailable = notAvailableDevice.iterator();
                        Iterator<Employee> emp = employeeName.iterator();

                        System.out.println("---------------Add New Peripheral-----------------");
                        Year currentYear = Year.now();

                        userCode = currentYear + "-" + CreateCode();

                        System.out.print("Enter Name of the PC Hardware:");
                        String nameOfHardware = " ";
                        nameOfHardware += input.next();
                        
                        String kindOfPeripheral;
                        do {
                            System.out.print("Enter Kind of Peripheral( Type 'input', 'output' or 'input/output'):");
                            kindOfPeripheral = input.next();
                            if (!kindOfPeripheral.equals("input") & !kindOfPeripheral.equals("output")
                                    & !kindOfPeripheral.equals("input/output"))
                                System.out.println(
                                        "INVALID INPUT!!! CHOICE AMONG THE CHOICES ONLY('input', 'output','input/output')!");

                            if (kindOfPeripheral.equals("input")) {
                                inputDevice.add(new Input(nameOfHardware,userCode));

                            } else if (kindOfPeripheral.equals("output")) {
                                outputDevice.add(new Output(nameOfHardware, userCode));
                            } else if (kindOfPeripheral.equals("input/output")) {
                                inoutDevice.add(new Inout(nameOfHardware, userCode));
                            }

                        } while (!kindOfPeripheral.equals("input") & !kindOfPeripheral.equals("output")
                                & !kindOfPeripheral.equals("input/output")); {

                        System.out.print(
                                "Enter Name of the Assigned Employee for the Peripheral(Type 'none' if no assigned employee):");

                        employeeAssigned = input.nextLine();
                        employeeAssigned += input.nextLine();

                        if (!employeeAssigned.equals("none")) {
                            employeeName.add(new Employee(employeeAssigned));
                            notAvailableDevice.add(new NotAvailable(nameOfHardware, employeeAssigned, userCode));
                            System.out.println();

                        } else if (employeeAssigned.equals("none")) {
                            availableDevice.add(new Available(nameOfHardware, userCode));
                        }

                        System.out.println("|-------------------------------------------------|");
                        System.out.println("  Data Succesfully Added! Your Code is:" + userCode);
                        System.out.println("|-------------------------------------------------|");

                        records.add(new Inventory(userCode, nameOfHardware, kindOfPeripheral));
                    }
                        break;

                    case 2:

                        System.out.println("----------Select Option to View----------");
                        System.out.println(
                                "1.View All Peripherals\n2.View Available Peripherals\n3.View Not Available Peripherals\n4.View All Input Devices\n5.View All Output Devices\n6.View Input/Output Devices\n7.View All Employees");
                        System.out.print("Enter Choice:");
                        int choice = input.nextInt();

                        switch (choice) {
                            case 1:
                                int num = 1;
                                System.out.println("----------All Peripherals----------");
                                rec = records.iterator();
                                while (rec.hasNext()) {
                                    Inventory showAllPeripherals = rec.next();

                                    System.out.println(num++ + ". " + showAllPeripherals.getNameOfHardware());
                                }
                                break;
                            case 2:
                                num = 1;
                                System.out.println("----------Available Peripherals----------");
                                available = availableDevice.iterator();
                                while (available.hasNext()) {
                                    Available showAvailable = available.next();

                                    System.out.println(
                                            num++ + ". " + showAvailable.getNameOfHardware() + showAvailable.getCode());
                                }

                                break;
                            case 3:
                                num = 1;
                                System.out.println("----------Unavailable Pheripherals---------");
                                notAvailable = notAvailableDevice.iterator();
                                while (notAvailable.hasNext()) {
                                    NotAvailable showNotAvailable = notAvailable.next();

                                    System.out.println(num++ + ". Peripheral:" + showNotAvailable.getNameOfHardware()
                                            + " ======= " + "Assigned Employee:"
                                            + showNotAvailable.getNameOfAssignedEmployee());
                                }

                                break;
                            case 4:
                                num = 1;
                                System.out.println("----------Input Devices----------");
                                in = inputDevice.iterator();
                                while (in.hasNext()) {
                                    Input showInput = in.next();

                                    System.out.println(num++ + ". " + showInput.getNameOfHardware());
                                    System.out.println("-----------------------------");

                                }

                                break;

                            case 5:
                                num = 1;
                                System.out.println("----------Output Devices----------");
                                out = outputDevice.iterator();
                                while (out.hasNext()) {
                                    Output showOutput = out.next();

                                    System.out.println(num++ + ". " + showOutput.getNameOfHardware());
                                    System.out.println("-----------------------------");

                                }

                                break;
                            case 6:
                                num = 1;
                                System.out.println("----------Input/Output Devices----------");
                                inout = inoutDevice.iterator();
                                while (inout.hasNext()) {
                                    Inout showInout = inout.next();

                                    System.out.println(num++ + ". " + showInout.getNameOfHardware());
                                    System.out.println("-----------------------------");
                                }
                                break;

                            case 7:
                                num = 1;
                                System.out.println("----------All Employees----------");
                                emp = employeeName.iterator();
                                while (emp.hasNext()) {
                                    Employee showAllEmployee = emp.next();

                                    System.out.println(num++ + ". " + showAllEmployee.getNameOfAssignedEmployee());
                                    System.out.println("-----------------------------");

                                }
                        }
                        break;

                    case 3:
                    boolean found = false;
                        System.out.println(
                                "Whatt Would You Like To Do?\n1. Edit Pheripheral Name and Type\n2. Unassign Employee for a Peripheral");
                        System.out.print("Enter Choice: ");
                        int userChoice = input.nextInt();
                     
                        String userOption;

                        switch (userChoice) {
                            

                            case 1:
                            System.out.print("Enter Peripheral Record Code to Update:");
                            userOption = input.next();
                            
                               ListIterator<Inventory> inventory = records.listIterator();
                               ListIterator<Output> opt = outputDevice.listIterator();
                               ListIterator<Inout> inopt = inoutDevice.listIterator();
                               ListIterator<Input>inpt = inputDevice.listIterator();
                               
                               
                               String updateKindOfPeripheral;

                               while(inventory.hasNext()){

                                Inventory showInventory = inventory.next();
                             
                               // Inout showinopt = inopt.next();
                                //Input showinpt = inpt.next();
                                //Output showopt = opt.next();
                                
                      
                                

                                if(showInventory.getCode().equals(userOption)){
                                    System.out.print("Enter Updated Hardware Name:");
                                   String updateNameOfHardware = " ";
                                   updateNameOfHardware += input.next();

                                  
                                    System.out.print("Enter Updated Hardware Type(input, output or input/output:)");
                                      updateKindOfPeripheral = input.next();

                                      if(updateKindOfPeripheral.equals("output")){
                                       
                                        opt.add(new Output(updateNameOfHardware, userOption));
                                       
                                        
                                        

                                        
                                        
                                      }else if(updateKindOfPeripheral.equals("input")){
                                        
                                        inpt.add(new Input(updateNameOfHardware, userOption));

                                      }else if(updateKindOfPeripheral.equals("input/output")){

                                        inopt.add(new Inout(updateNameOfHardware, userOption));
                                      }
                                     
                                
                            
                                     System.out.print("Enter Peripheral Code Again To Confirm Changes:");
                                     userOption = input.next();
                                    
                                     if(showInventory.getCode().equals(userOption)){
                                        inventory.set(new Inventory(userOption,updateNameOfHardware,updateKindOfPeripheral));
                                        
                                        
                                        System.out.println("-----Record Updated Successfully-----");
                                     }else if(!showInventory.getCode().equals(userOption)){
                                        System.out.println("-----Wrong Code. Updates not Saved-----");
                                     }

                                    
                                }else if(!showInventory.getCode().equals(userOption)){
                                    System.out.println("-----Record Not Found Try Again-----");
                                }
                               }

                                break;

                            case 2:

                                ListIterator<NotAvailable> notAvlble = notAvailableDevice.listIterator();
                                found = false;

                                while (notAvlble.hasNext()) {
                                    NotAvailable showntAvlble = notAvlble.next();

                                    System.out.print("Enter Code To Unassign Employee:");
                                     userOption = input.next();

                                    if (showntAvlble.getCode().equals(userOption)) {
                                        found = true;
                                        System.out.println(
                                                "-----Peripheral is Now Unassigned. Peripheral is Availble-----");

                                        String nameofHardware = showntAvlble.getCode();
                                        String usersCode = showntAvlble.getNameOfHardware();
                                        availableDevice.add(new Available(nameofHardware, usersCode));

                                        notAvlble.remove();

                                    } else if (!found) {
                                        System.out
                                                .println("-----Peripheral Not Found in the Assigned Pheripheral-----");
                                    }
                                }
                        }
                    

                        break;

                    case 4:

                        System.out.print("Enter Peripheral Code to Remove Peripheral:");
                        String code = input.next();

                        available = availableDevice.iterator();

                         found = false;

                        while (available.hasNext()) {

                            Available showUserCode = available.next();

                            if (showUserCode.getCode().equals(code)) {
                                found = true;

                                available.remove();
                                System.out.println("Peripheral Record Succesfully Removed");

                            }
                        }

                        if (found == false) {
                            System.out.println("Peripheral Record Not Found or Still Assigned Please Check First!");
                        }

                        break;

                    case 5:
                        System.out.println("----------View Reports----------");
                        System.out.println("Total Number of Available Peripherals:" + availableDevice.size());
                        System.out.println("Total Number of Assigned Peripherals:" + notAvailableDevice.size());
                        System.out.println("Total Number of Input Device:" + inputDevice.size());
                        System.out.println("Total Number of Output Device:" + outputDevice.size());
                        System.out
                                .println("Total Number of Employees With Peripherals Assigned:" + employeeName.size());

                }
            } while (option != 0);
        }

        {
            System.out.println("----------System Closed----------");
        }
    }

    public static int number;

    public static String CreateCode() {

        String newCode = String.format("%04d", number++);
        return newCode;
    }

}

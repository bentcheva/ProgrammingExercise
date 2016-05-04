package exercise.coding;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is entry point of the PayRollApp.
 * @author Bobi
 *
 */
public class PayRoll {
	
	/**
	 * This method prompts the user to enter the Employee's details in the required format.
	 * Takes the appropriate actions to generate the PaySlip data and prints them out to the Console.
	 * @param input
	 */
	public boolean subMenu(Scanner input){

		System.out.println("Enter the employees details in a format: "
				+ "First Name, Surname, Annual Salary, Pension Rate, Month");
		
		String empEntry= input.next();
		Employee employee = Employee.generateEpmloyee(empEntry);
		
		if(employee != null){
			PaySlip ps = PaySlip.generatePaySlip(employee);
			System.out.println(ps.toString());
			System.out.println("Employee's name: " + ps.getEmployee().getForName() + " " + ps.getEmployee().getSurName());
			System.out.println("Period: " + ps.getEmployee().getPeriod() + " month.");
			System.out.println("Gross income: " + ps.getGrossIncome());
			System.out.println("Income tax: " + ps.getIncomeTax());
			System.out.println("Net income: " + ps.getNetIncome());
			System.out.println("Pension: " + ps.getPension());
			return true;
		}else {
				System.out.println("Invalid data.");
				return false;
		}
		
	    
	}
	/**
	 * This method prints in the console simple menu. Returns the user's menu selection
	 * as integer. 
	 * @param the Console reference
	 * @return user's selection as integer
	 */
	public int menu(Scanner input) {

        int selection;
       

        /***************************************************/

        System.out.println("\nSelect a menu item");
        System.out.println("-------------------------\n");
        System.out.println("1 - Enter an Employee's data");
        System.out.println("2 - Quit");
        try{
        	selection = input.nextInt();
        }catch(InputMismatchException e){
        	input.next();
        	return -1;
        }
        return selection;    
    }
	
	
	
	public static void main(String[] args){
		
		
		PayRoll pr = new PayRoll();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
		
			switch(pr.menu(scanner))
			{
				case 1: pr.subMenu(scanner);
					break;
				case 2: System.out.println("Exiting Pay Roll application");
					System.exit(0);
				default: System.out.println("Make valid menu selection.");
			
		     }
	
		}		
	}
}

package exercise.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import exercise.coding.MVP;
import exercise.coding.MVP.ModelOps;
import exercise.coding.Utils;
import exercise.model.Employee;
import exercise.presenter.Presenter;

/**
 * This class represents the View layer in MVP. The View is just a "pretty face", 
 * not responsible for containing any data structures or taking decisions. 
 * @author Bobi
 *
 */
public class PayRollView implements MVP.ViewOps{


	private Presenter presenter;
	
	/**
	 * Constructor of the View layer;
	 */
	public PayRollView(){
		presenter = new Presenter(this);
	}
	
	/**
	 * Returns the presenter associated with this view
	 * @return Presenter
	 */
	public Presenter getPresenter(){
		return presenter;
	}
	
	/**
	 * Main method . Entry point for the app.
	 * @param args
	 */
	public static void main(String[] args){
		
		PayRollView pvm = new PayRollView();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			
			switch(pvm.displayMenu(scanner))
			{
				case 1: pvm.displaySubMenu(scanner);
					break;
				case 2: pvm.displayMessage("Exiting PayRollAppMVP.");
					System.exit(0);
					break;
				default: System.out.println("Make valid menu selection.");
						 scanner.reset();	
						
			
		     }
		  
	
		}		
	}

	/**
	 * This method prints in the console simple menu. Returns the user's menu selection
	 * as integer. 
	 * @param the Console reference
	 * @return user's selection as integer
	 */
	 int displayMenu(Scanner sc) {
		// TODO Auto-generated method stub
		 int selection;
	      

	        /***************************************************/

	        System.out.println("Select a menu item");
	        System.out.println("-------------------------\n");
	        System.out.println("1 - Enter an Employee's data");
	        System.out.println("2 - Quit");
	        try{
	        	selection = sc.nextInt();
	        }catch(InputMismatchException e)
	        {
	        	sc.next();
	        	return -1;
	        }
	        return selection;    
		
	}

	/**
	 * This method displays sub menu 
	 * @param sc Scanner
	 */
	void displaySubMenu(Scanner sc) {
		// TODO Auto-generated method stub
		
			System.out.println("Enter the employees details in a format: "
					+ "First Name, Surname, Annual Salary, Pension Rate, Month");
			String empEntry;
		    empEntry= sc.next();
		    presenter.generatePaySlip(empEntry);
		   
		}
	
	/**
	 * This method sends message to the View layer
	 * @param str message to be viewed in the View layer
	 */
	@Override
	public void displayMessage(String str) {
		// TODO Auto-generated method stub
		System.out.println("" + str);
		
		
	}
}

package exercise.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import exercise.coding.Employee;
import exercise.coding.Utils;

/**
 * This class test Employee class. It contains six use cases covering one correct data input format
 * and five incorrect. The objective here is to test the correct handling of incorrect user input without 
 * the program breaking.
 * @author Bobi
 *
 */

public class EmployeeTest {
	
	
	
	private String employee0 = "Joe,Doe,-7889,8,kkk";
	private String employee1 = "Joe,Doe,34500,8,9";
	private String employee1Expected = "Joe,Doe,34500.0,8.0,9";
	
	private String employee2 = "Joe,Doe,hhhhh,8,9";
	private String employee3 = "Joe,Doe,34567,hh,9";
	private String employee4 = "Joe,Doe,34567,8,kkk";
	private String employee5 = "Joe,Doe,34567,-8,9";
	
	
	
	
	@Test
	public void test() {
		System.out.println("\n************************************");
		System.out.println(getClass().getSimpleName());
		//tests if negative salary entered
		Utils.useCase(employee0);
		assertEquals(null, Employee.generateEpmloyee(employee0));
		//tests correct employee data format 
		Utils.useCase(employee1);
		assertEquals(employee1Expected, Employee.generateEpmloyee(employee1).toString());  
		//test incorrect salary format - non numerical
		Utils.useCase(employee2);
		assertEquals(null, Employee.generateEpmloyee(employee2));
		//tests incorrect pension rate format - non numerical
		Utils.useCase(employee3);
		assertEquals(null, Employee.generateEpmloyee(employee3));
		//test incorrect period format entered
		Utils.useCase(employee4);
		assertEquals(null, Employee.generateEpmloyee(employee4));
		//test incorrect pension rate format entered - negative
		Utils.useCase(employee5);
		assertEquals(null, Employee.generateEpmloyee(employee5));
		
	}
	
	

}

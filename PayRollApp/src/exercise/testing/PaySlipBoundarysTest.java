package exercise.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import exercise.coding.Employee;
import exercise.coding.PaySlip;
import exercise.coding.Utils;

public class PaySlipBoundarysTest {

	String employee1 = "Joe,Doe,60050,9,March";
	String employee1Expected = "Joe,Doe,March,5004,922,4082,450";
	
	String employee2 = "Joe,Doe,10000,9,March";
	String employee2Expected = "Joe,Doe,March,833,0,833,75";
	
	String employee3 = "Joe,Doe,18200,9,March";
	String employee3Expected = "Joe,Doe,March,1517,0,1517,137";
	
	String employee0 = "Joe,Doe,0,9,March";
	String employee0Expected = "Joe,Doe,March,0,0,0,0";
	
	String employee4 = "Joe,Doe,18201,9,March";
	String employee4Expected = "Joe,Doe,March,1517,0,1517,137";
	
	String employee5 = "Joe,Doe,37000,9,May";
	String employee5Expected = "Joe,Doe,May,3083,298,2785,278";
	
	String employee6 = "Joe,Doe,37001,9,april";
	String employee6Expected = "Joe,Doe,april,3083,298,2785,278";
	
	String employee7 = "Joe,Doe,80000,9,September";
	String employee7Expected = "Joe,Doe,September,6667,1462,5205,600";
	
	String employee8 = "Joe,Doe,80001,9,december";
	String employee8Expected = "Joe,Doe,december,6667,1462,5205,600";
	
	String employee9 = "Joe,Doe,180000,9,february";
	String employee9Expected = "Joe,Doe,february,15000,4546,10454,1350";
	
	String employee10 = "Joe,Doe,180001,9,february";
	String employee10Expected = "Joe,Doe,february,15000,4546,10454,1350";
	
	String employee11 = "Joe,Doe,180001,9,february";
	String employee11Expected = "Joe,Doe,february,15000,4546,10454,1350";
	
	
	@Test
	public void test() {
		System.out.println("\n************************************");
		System.out.println(getClass().getSimpleName());
		//The given example
		Utils.useCase(employee1);
		assertEquals(employee1Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee1)).toString());
		//Testing the first tax range
		Utils.useCase(employee2);
		assertEquals(employee2Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee2)).toString());
		//Testing the first tax range right boundary
		Utils.useCase(employee3);
		assertEquals(employee3Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee3)).toString());
		//Testing the first tax range left boundary 
		Utils.useCase(employee0);
		assertEquals(employee0Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee0)).toString());
		//Testing the second tax range left boundary 
		Utils.useCase(employee4);
		assertEquals(employee4Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee4)).toString());
		//Testing the second tax range right boundary 
		Utils.useCase(employee5);
		assertEquals(employee5Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee5)).toString());
		//Testing the third tax range left boundary 
		Utils.useCase(employee6);
		assertEquals(employee6Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee6)).toString());
		//Testing the third tax range right boundary 
		Utils.useCase(employee7);
		assertEquals(employee7Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee7)).toString());
		//Testing the fourth tax range left boundary 
		Utils.useCase(employee8);
		assertEquals(employee8Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee8)).toString());
		//Testing the fourth tax range right boundary 
		Utils.useCase(employee9);
		assertEquals(employee9Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee9)).toString());
		//Testing the fourth tax range right boundary 
		Utils.useCase(employee10);
		assertEquals(employee10Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee10)).toString());
		//Testing the fifth tax range left boundary 
		Utils.useCase(employee11);
		assertEquals(employee11Expected, PaySlip.generatePaySlip(Employee.generateEpmloyee(employee11)).toString());
	}

}

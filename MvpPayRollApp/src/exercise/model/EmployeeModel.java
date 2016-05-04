package exercise.model;

import exercise.coding.MVP;
import exercise.coding.Utils;
import exercise.coding.MVP.ModelOps;
import exercise.presenter.Presenter;
import exercise.presenter.TaxManager;
/**
 * This class represents the Model layer in MVP.
 * It's main roll is to hold the data structure/s and the relative logic 
 * @author Bobi
 *
 */
public class EmployeeModel implements  MVP.ModelOps{
	
	private Employee employee;
	private PaySlip payslip;

	
	/**
	 * Public constructor of EmployeeModel
	 */
	public EmployeeModel(){
		
	this.employee = new Employee();
		
	}

	/**
	 * This method sets the fields of the Employee object
	 * @param forName String
	 * @param surName String
	 * @param annualSalary double
	 * @param pensionRate double
	 * @param period String
	 */
	private void setEmployee(String forName, String surName,double annualSalary, double pensionRate
			, String period){
		employee.setForName(forName); 
		employee.setSurName(surName);
		employee.setAnnualSalary(annualSalary);
		employee.setPensionRate(pensionRate);
		employee.setPeriod(period);
	}


	@Override
	public Employee getModelData() {
		// TODO Auto-generated method stub
		return employee;
	}


	/**
	 * This method sets the fields of the Employee model
	 * and returns int code of corresponding to the success/fail of the setting
	 * 0 - wrong length format
	 * 1 - negative salary 
	 * 2 - non numerical salary
	 * 3 - negative pension
	 * 4 - non numerical pension
	 * 5 - incorrect period format
	 * 6 - success
	 */
	@Override
	public int setModel(String data) {
		// TODO Auto-generated method stub
		
		//verifys if there is data entry
	   
		double pension = 0;
		double annualSalary = 0;
		String[] empEntries = data.split(",");
		
		//verifying if the entered employee's data are the correct count
		if(empEntries.length != 5)
			return 0;
		
		String firstName = empEntries[0];
		String surName = empEntries[1];
		
		try{
			 annualSalary = Double.parseDouble(empEntries[2]);
			 if(annualSalary < 0)
				 return 1;
			
		}catch(NumberFormatException e){
			return 2;
		}
		
		try{
			pension = Double.parseDouble(empEntries[3]);
			if(pension < 0)
				 return 3;
		}catch(NumberFormatException e){
			return 4;
		}
		
		String period = empEntries[4];

		//validating the entered period
		if(Utils.validatePeriod(period) == 0)
			return 5;
		  
		setEmployee(firstName, surName, annualSalary, pension, period);
		
		return 6;
		
		
	}
	
		/**
		 * This method calls generates PaySlip object in the Model Layer
		 * @return true if success and false if not successful.
		 */
		public boolean generatePaySlip(){
				if(employee == null)
					return false;
			int incomeTax = TaxManager.calculateIncomeTax(employee.getAnnualSalary());
			payslip = new PaySlip(employee, TaxManager.grossIncome(employee.getAnnualSalary()),
				     incomeTax,
				     TaxManager.calculateNetIncome(employee.getAnnualSalary(), incomeTax),
				     TaxManager.calculatePensionContribution(employee.getAnnualSalary(), employee.getPensionRate()));
			return true;
				
			}
		/**
		 * Getter method 
		 * @return PaySlip
		 */
		public PaySlip getPaySlip(){
			return payslip;
		}

}

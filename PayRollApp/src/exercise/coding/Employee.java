package exercise.coding;
/**
 * POJO + static factory method to generate Employee object
 * @author Bobi
 *
 */
public class Employee {
	
	private String forName;
	private String surName;
	private double annualSalary;
	private double pensionRate;
	private String period;
	
	

	/**
	 * Constructor for Employee
	 * @param forName first name of the Employee as String value 
	 * @param surName surname of the Employee as String value
	 * @param annualSalary annual salary of the Employee as double
	 * @param pensionRate pension rate of the Employee as double
	 * @param period period for which the payslip is going to be generated
	 */
	public Employee(String forName, String surName,double annualSalary, double pensionRate
			, String period){
		this.forName = forName;
		this.surName = surName;
		this.annualSalary = annualSalary;
		this.pensionRate = pensionRate;
		this.period = period;
	}
	
	public String getForName() {
		return forName;
	}

	public void setForName(String forName) {
		this.forName = forName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public double getPensionRate() {
		return pensionRate;
	}

	public void setPensionRate(double pensionRate) {
		this.pensionRate = pensionRate;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	// static factory method
	/**
	 * This method validates the employees data format and generates Employee object
	 * @param data employee's data as String
	 * @return returns Employee object if data have been successfully validate 
	 * 			or null if the validation criteria have been violated. 
	 */
   public static Employee generateEpmloyee(String data){
		//verifys if there is data entry
	    if(data == null)
			return null;
	    
		double pension = 0;
		double annualSalary = 0;
		String[] empEntries = data.split(",");
		
		//verifying if the entered employee's data are the correct count
		if(empEntries.length != 5)
			return null;
		
		String firstName = empEntries[0];
		String surName = empEntries[1];
		
		try{
			 annualSalary = Double.parseDouble(empEntries[2]);
			 if(annualSalary < 0){
				 System.out.println("The Salary must be positive number.");
				 return null;
			 }
			
		}catch(NumberFormatException e){
			System.out.println("The salary must be in number format.");
			return null;
		}
		
		try{
			pension = Double.parseDouble(empEntries[3]);
			if(pension < 0){
				System.out.println("The pension must be positive number.");
				return null;
			}
		}catch(NumberFormatException e){
			System.out.println("The pension must be in number format.");
			return null;
		}
		
		String period = empEntries[4];
		//System.out.println("validated period " + Utils.validatePeriod(period));
		//validating the entered period
		if(Utils.validatePeriod(period) == 0){
			System.out.println("Incorrect period format.");
			return null;
		}
		return new Employee(firstName, surName, annualSalary, pension, period);
	}
   
  
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(this.forName);
		sb.append(",");
		sb.append(this.surName);
		sb.append(",");
		sb.append(this.annualSalary);
		sb.append(",");
		sb.append(this.pensionRate);
		sb.append(",");
		sb.append(this.period);
		return sb.toString();
	}
	

}

package exercise.model;


/**
 * This is simple POJO class representing the Employee's details
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
	Employee(String forName, String surName,double annualSalary, double pensionRate
			, String period){
		this.forName = forName;
		this.surName = surName;
		this.annualSalary = annualSalary;
		this.pensionRate = pensionRate;
		this.period = period;
	}
	
	Employee(){
		
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

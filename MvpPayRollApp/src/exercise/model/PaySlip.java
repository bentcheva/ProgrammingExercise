package exercise.model;

public class PaySlip {
	
	private Employee employee;
	private int grossIncome;
	private int incomeTax;
	private int netIncome;
	private int pension;
	
	public PaySlip(Employee employee, int grossIncome, int incomeTax, int netIncome, int pension) {
		
		this.employee = employee ;
		this.grossIncome = grossIncome;
		this.incomeTax = incomeTax;
		this.netIncome = netIncome;
		this.pension = pension;
	}
	
	/**
	 * Getter method returns the Employee member variable
	 * @return Employee
	 */
	public Employee getEmployee(){
		return this.employee;
	}
	/**
	 * Getter method returns the gross income
	 * @return int
	 */
	public int getGrossIncome(){
		return this.grossIncome;
	}
	/**
	 * Getter method returns the Income Tax
	 * @return int
	 */
	public int getIncomeTax(){
		return this.incomeTax;
	}
	/**
	 * Getter method returns the monthly net income
	 * @return int
	 */
	public int getNetIncome(){
		return this.netIncome;
	}
	/**
	 * Getter method returns the monthly pension
	 * @return int
	 */
	public int getPension(){
		return this.pension;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append(this.employee.getForName());
		sb.append(",");
		sb.append(this.employee.getSurName());
		sb.append(",");
		sb.append(this.employee.getPeriod());
		sb.append(",");
		sb.append(this.grossIncome);
		sb.append(",");
		sb.append(this.incomeTax);
		sb.append(",");
		sb.append(this.netIncome);
		sb.append(",");
		sb.append(this.pension);
		
		return sb.toString();
	}
}

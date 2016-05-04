package exercise.presenter;
/**
 * This class is responsible for the tax intelegence
 * @author Bobi
 *
 */
public class TaxManager {
	
	
	/**
	 * This method calculates the monthly income tax 
	 * @param salary the anual salary as double value
	 * @return  the monthly income tax as double
	 */
	public  static int calculateIncomeTax(double salary){
		
		double tax = 0;
		
		if(salary > 18200 && salary <= 37000)
			tax = roundDouble((salary - 18200)*0.19/12);
		
		if(salary > 37000 && salary <= 80000)
			tax = (3572 +(salary - 37000)*0.325)/12;
			
		
		if(salary > 80000 && salary <= 180000)
			tax = (17547 +(salary - 80000)*0.37)/12;
		
		if(salary > 180000)
			tax = (54547 +(salary - 180000)*0.45)/12;
		
		return roundDouble(tax);
	}
	/**
	 * This method returns the Employee's  pension contribution 
	 * @param salary the annual salary as double
	 * @param pensionRate the pension rate in percentage as double
	 * @return rounded monthly pension contribution as int
	 */
	public static  int calculatePensionContribution(double salary, double pensionRate){
		
		return roundDouble(salary * pensionRate/1200);
	}
	/**
	 * This method returns the rounded net income as integer
	 * @param annualIncome
	 * @param incomeTax
	 * @param pensionContribution
	 * @return net income as integer
	 */
    public static int calculateNetIncome(double annualIncome, double incomeTax){
		return roundDouble(annualIncome/12 - incomeTax);
	}
    /**
     * This method returns the rounded monthly gross income 
     * @param annualIncome the annual salary as double
     * @return rounded monthly gross income as int
     */
    public static int grossIncome(double annualIncome){
    	return roundDouble(annualIncome/12);
    }
    
    /**
     * This method rounds double number. 
     * If the decimal part is >= 0.5 it rounds to the next int higher the 
     * whole part of the number.
     * If the decimal part is < 0.5 it rounds it to down to the whole part of the number
     * @param num double number to be rounded
     * @return the rounded num as double
     */
    public static int roundDouble(double num){
    	int rounder = (int) num;
    	if((num - rounder) >= 0.5)
    		return rounder + 1;
    	return rounder;
    }

	
}

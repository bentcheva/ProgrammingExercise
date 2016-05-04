package exercise.coding;

/**
 * Utility class holding static utility methods 
 * @author Bobi
 *
 */
public class Utils {

	/**
	 * Static utility method to validate the month entry
	 * @param month month entry as string
	 * @return int number corresponding to the relevant month of the year.
	 * 			Returns 0 if the month entry is null or not valid month entry
	 */
	public static int validatePeriod(String month){
		if(month == null)
			return 0;
		
		if(month.equals("1") || month.equalsIgnoreCase("january"))
			return 1;
		if(month.equals("2") || month.equalsIgnoreCase("february"))
			return 2;
		if(month.equals("3") || month.equalsIgnoreCase("march"))
			return 3;
		if(month.equals("4") || month.equalsIgnoreCase("april"))
			return 4;
		if(month.equals("5") || month.equalsIgnoreCase("may"))
			return 5;
		if(month.equals("6") || month.equalsIgnoreCase("june"))
			return 6;
		if(month.equals("7") || month.equalsIgnoreCase("july"))
			return 7;
		if(month.equals("8") || month.equalsIgnoreCase("august"))
			return 8;
		if(month.equals("9") || month.equalsIgnoreCase("september"))
			return 9;
		if(month.equals("10") || month.equalsIgnoreCase("october"))
			return 10;
		if(month.equals("11") || month.equalsIgnoreCase("november"))
			return 11;
		if(month.equals("12") || month.equalsIgnoreCase("december"))
			return 12;
		return 0;
	}
	
	public static void useCase(String use){
		System.out.println("");
		System.out.println("Testing " + use + "  use case.");
		
	}
	
	
}

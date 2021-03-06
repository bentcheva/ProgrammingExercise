package exercise.testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PayRollTestRunner {
	
	public static void main(String[] args){
		
		Result result = JUnitCore.runClasses(JUnitTestSuite.class);
		for (Failure fail : result.getFailures()){
			System.out.println(fail.toString());
		}
		
		if(result.wasSuccessful())
			System.out.println("\nAll tests ran successfully!!!");
	}

}

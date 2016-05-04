package exercise.coding;

import java.util.Scanner;

import exercise.model.Employee;
import exercise.model.PaySlip;

/**
 * Provides interfaces for MVP implementation for the PayRoll example
 * @author Bobi
 *
 */
public interface MVP {

	
	/**
	 * This interface represents the basic View layer operations
	 * @author Bobi
	 *
	 */
	public interface ViewOps{
		
		/**
		 * This method sends message to the View layer
		 * @param str message to be viewed in the View layer
		 */
		public void displayMessage(String str);
		
		
	}
	/**
	 * This interface consists from the vasic methods required in the Model layer
	 * @author Bobi
	 *
	 */
	public interface ModelOps{
		/**
		 * This method sets the Model's data object while doing a validation at the same time
		 * @param data the model's data as string
		 * @return int value corresponding to the fail/pass code
		 */
		public int setModel(String data);
		/**
		 * Returns the model's data object
		 * @return Employees data
		 */
		public Employee getModelData();
		
		
		
		
	}
	
	/**
	 * Basic operations needed for the Presenter layer
	 * @author Bobi
	 *
	 */
	
public interface PresenterOps{
		
	//	public void setModelData(String data);
		/**
		 * This method returns the Model's data
		 * @return
		 */
		public Employee getModelData();
		/**
		 * This method returns the model layer
		 * @return
		 */
		public ModelOps getModel();
		/**
		 * This method generates PaySlip object
		 * @param str
		 */
		public void generatePaySlip(String str);
		
		
	}
	

	
}

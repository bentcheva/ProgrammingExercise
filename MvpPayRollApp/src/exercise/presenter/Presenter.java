package exercise.presenter;

import exercise.coding.MVP;
import exercise.coding.MVP.ModelOps;
import exercise.model.Employee;
import exercise.model.EmployeeModel;
import exercise.model.PaySlip;
import exercise.view.PayRollView;

/**
 * This class represents the Presenter layer in MVP.
 * This is the middle man between the View and the Model.
 * The Presenter is basically the "heavy lifting guy" in MVP.
 * Presenter keeps references of the View and the Model.
 * His role is to get the user's input from the View layer and initialize the model accordingly.
 * take decisions upon these data, do processing and represent the results in suitable for viewing 
 * in the View layer.
 * 
 * @author Bobi
 *
 */
public class Presenter implements MVP.PresenterOps {
	
	
	private EmployeeModel employeeModel;
	private PayRollView pvm;
	
	private static final String[] FAIL_CODES = {"Not valid number of entries", "Salary must be positive number.",
												"Salary must contain only numbers.", "Pension must be positive number.",
												"Pension must contain only numbers.", "Wrong Month format.", "Correct Employee's data format."};
	private static final String ERORR = " Something went wrong";
	
	public Presenter(PayRollView pvm){
		this.employeeModel = new EmployeeModel();
		this.pvm = pvm;
		
	}
	

	/**
	 * This is private method used to set the Model's data structure ( Employee object)
	 * @param data the user's input as String
	 * @return returns true if the data have been set successfuly ( upon passing validations in Model layer)
	 * 					or false if the validation failed.
	 */
	private boolean setModelData(String data) {
		// TODO Auto-generated method stub
		if(data == null){
			pvm.displayMessage("Please enter data for the Employee.");
			return false;
		}
		int result = employeeModel.setModel(data);
		pvm.displayMessage(FAIL_CODES[result]);
		if(result == 6)
			return true;
		return false;
		
	}

	@Override
	public Employee getModelData() {
		// TODO Auto-generated method stub
		return employeeModel.getModelData();
		
	}

	
	@Override
	public ModelOps getModel() {
		// TODO Auto-generated method stub
		return employeeModel;
	}
	
	

	@Override
	public void generatePaySlip(String str) {
		// TODO Auto-generated method stub
		if(setModelData(str) == true){
			boolean success = employeeModel.generatePaySlip();
			if(!success)
				pvm.displayMessage(ERORR);
			pvm.displayMessage(employeeModel.getPaySlip().toString());
			pvm.displayMessage("\nName: " + employeeModel.getPaySlip().getEmployee().getForName() + " " + employeeModel.getPaySlip().getEmployee().getSurName());
			pvm.displayMessage("Period: " + employeeModel.getPaySlip().getEmployee().getPeriod() + " month.");
			pvm.displayMessage("Gross income: " + employeeModel.getPaySlip().getGrossIncome());
			pvm.displayMessage("Income tax: " + employeeModel.getPaySlip().getIncomeTax());
			pvm.displayMessage("NetIncome: " + employeeModel.getPaySlip().getNetIncome());
			pvm.displayMessage("Pension: " + employeeModel.getPaySlip().getPension());
					
		}
		
	}
	
	

}

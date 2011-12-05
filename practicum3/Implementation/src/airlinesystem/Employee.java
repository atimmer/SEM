package airlinesystem;

public class Employee extends Person {

	private String jobDescription;
	
	public Employee(int identifier, String name, String jobDescription) {
		super(identifier, name);
		
		this.jobDescription = jobDescription;
	}
	
	public String getJobDescription() {
		return this.jobDescription;
	}

}
package airlinesystem;

public class Employee extends Person {

	/**
	 * jobDescription != null
	 */
	private String jobDescription;
	
	/**
	 * Initializes a employee object
	 * 
	 * @param identifier
	 * @param name
	 * @param jobDescription
	 * 
	 * @require name != null && jobDescription != null
	 */
	public Employee(int identifier, String name, String jobDescription) {
		super(identifier, name);
		
		this.jobDescription = jobDescription;
	}
	
	/**
	 * Gets the job description
	 * 
	 * @ensure result != null
	 * 
	 * @return The job description of this employee
	 */
	public String getJobDescription() {
		return this.jobDescription;
	}

	@Override
	public String toString() {
		return "{person: " + super.toString() + " with job " + jobDescription + "}";
	}
}
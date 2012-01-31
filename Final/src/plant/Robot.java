package plant;

import plant.physical.*;

/**
 * A robot that works on a product by adding a resource
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class Robot {

	private int identifier;
	private AssemblyLine line;
	private Class<? extends Resource> resourceType;
	
	/**
	 * Creates a new Robot for an assembly line
	 * @param resourceType The resource this robot uses for processing
	 * @param identifier The identifier for this robot
	 */
	public Robot(Class<? extends Resource> resourceType, int identifier) {
		this.identifier = identifier;
		this.resourceType = resourceType;
	}
	
	/**
	 * Assigns a new assembly line to this robot
	 * @param line The assembly line to assign
	 */
	public void setAssemblyLine(AssemblyLine line) {
		this.line = line;
	}
	
	/**
	 * The identifier for this robot
	 * @return Numeric identifier
	 */
	public int getIdentifier() {
		return identifier;
	}
	
	/**
	 * Adds a resource to a product
	 * @param product The product to work on
	 * @return true if the process is completed successfully, false otherwise
	 */
	public boolean process(Product product) {
		if(line == null) {
			return false;
		}
		
		Resource r = line.takeResource(resourceType);
		if(r == null) {
			return false;
		}else{
			product.addResource(r);
			return true;
		}
	}
	
}

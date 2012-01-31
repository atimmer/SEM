package plant.physical;

import java.util.ArrayList;

/**
 * Abstract class representing a product in the manufacturing plant
 * @author Koen van Urk and Anton Timmermans
 *
 */
public abstract class Product {

	protected double weight;
	protected ArrayList<Resource> resources;
	
	/**
	 * Returns whether or not this product is finished
	 * (i.e. it contains all  required resources)
	 * @return true if the product is finished, false otherwise
	 */
	public boolean isFinished() {
		return false;
	}
	
	/**
	 * Creates a new Product
	 */
	public Product() {
		this.resources = new ArrayList<Resource>();
	}
	
	/**
	 * Adds a resource to this product
	 * @param r The resource to add
	 * @require r != null
	 */
	public final void addResource(Resource r) {
		resources.add(r);
	}
	
	/**
	 * Returns the weight of this product at this state
	 * @return The current weight of this product
	 */
	public final double getWeight() {
		double result = 0;
		for(int i = 0; i < resources.size(); i++) {
			result += resources.get(i).getWeight();
		}
		
		return result;
	}
	
	/**
	 * A textual representation of the required resources
	 * @return String with required resources
	 */
	public abstract String requirements();
	
}

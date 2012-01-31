package plant.physical;

/**
 * Abstract class representing a resource in the manufacturing plant
 * @author Koen van Urk and Anton Timmermans
 *
 */
public abstract class Resource {
	
	protected double weight;
	
	/**
	 * Returns the weight of this resource
	 * @return The weight of the resource
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Creates a new resource with given weight and size
	 * @param weight The weight per piece of the resource
	 * @param size The size of the resource
	 */
	public Resource(double weight) {
		this.weight = weight;
	}
}

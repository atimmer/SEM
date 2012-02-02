package plant;

import plant.physical.*;
import java.util.ArrayList;

/**
 * A storage bin used to store resources
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class StorageBin {

	private int capacity;
	private Class<? extends Resource> resourceType;
	private ArrayList<Resource> resources;
	
	/**
	 * Creates a new storage bin for a specific resource with a capacity
	 * @param resourceType The type of resource for this storage bin
	 * @param capacity The capacity of this bin
	 */
	public StorageBin(Class<? extends Resource> resourceType, int capacity) {
		this.resourceType = resourceType;
		this.capacity = capacity;
		this.resources = new ArrayList<Resource>();
	}
	
	/**
	 * Returns the kind of resource this storage bin stores
	 * @return Resource class
	 */
	public Class<? extends Resource> getResourceType() {
		return resourceType;
	}
	
	/**
	 * The number of resources left in the storage bin
	 * @return The number of resources left
	 */
	public int getResourcesLeft() {
		return resources.size();
	}
	
	/**
	 * Tries to add a resource
	 * @param r A resource of the right type
	 * @return true if the resource has been added successfully, false otherwise
	 */
	public boolean addResource(Resource r) {
		if(r == null) {
			return false;
		}else if(capacity <= resources.size()) {
			return false;
		}else if(!r.getClass().equals(resourceType)){
			return false;
		}else{
			resources.add(r);
			return true;
		}
	}
	
	/**
	 * Returns a resource from the bin, or null if no resources are left
	 * @return A resource
	 */
	public Resource takeResource() {
		if(resources.size() > 0) {
			int index = resources.size()-1;
			Resource result = resources.get(index);
			resources.remove(index);
			return result;
		}else{
			return null;
		}
	}
	
	/**
	 * Returns the current status of this storage bin
	 * @return The current status
	 */
	public String getStatus() {
		return "Bin (" + resourceType.getSimpleName() + ") " + this.getResourcesLeft() + "/" + this.capacity + " resources left";
	}
	
	
}

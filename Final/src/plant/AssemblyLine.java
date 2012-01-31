package plant;

import java.util.ArrayList;

import plant.physical.Product;
import plant.physical.Resource;

/**
 * Assembly line containing bins and robots
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class AssemblyLine {

	/**
	 * A task for a given product and production goal for an assembly line
	 * @author Koen van Urk and Anton Timmermans
	 *
	 */
	public static class Task {
		private Class<? extends Product> productType;
		private int productionGoal;
		private int productsCreated;
		
		/**
		 * Constructor of a new task
		 * @param productType The type of product to create
		 * @param productionGoal The number of such products to create
		 */
		public Task(Class<? extends Product> productType, int productionGoal) {
			this.productionGoal = productionGoal;
			this.productType = productType;
		}
		
		/**
		 * Returns how much products are still left to be made this product run
		 * @return Number of products remaining to be produced
		 */
		public int getNumberOfProductsLeftToProduce() {
			return productionGoal - productsCreated;
		}
		
		/**
		 * Returns the product type for this product run
		 * @return Product type
		 */
		public Class<? extends Product> getProductType() {
			return productType;
		}
		
		/**
		 * Adds a created product and checks if it is finalized
		 * @param product The product that was produced
		 */
		public void addCreatedProduct(Product product) {
			if(product.isFinished()) {
				productsCreated++;
			}
		}
	}

	private boolean isRunning;
	private ArrayList<StorageBin> bins;
	private ArrayList<Robot> robots;
	private int identifier;
	
	private ArrayList<AssemblyLine.Task> tasks;
	
	/**
	 * Creates a new assembly line with identifier
	 * @param identifier The identifier for this assembly line
	 */
	public AssemblyLine(int identifier) {
		bins = new ArrayList<StorageBin>();
		robots = new ArrayList<Robot>();
		tasks = new ArrayList<AssemblyLine.Task>();
		this.identifier = identifier;
	}
	
	/**
	 * Schedules a new task
	 * @param task The task to schedule
	 */
	public void schedule(Task task) {
		tasks.add(task);
	}
	
	/**
	 * Completes one round of work
	 */
	public void work() {
		if(!isRunning) {
			return;
		}
		
		if(tasks.size() > 0) {
			Task task = tasks.get(0);
			Product product = null;
			try {
				product = task.getProductType().newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < robots.size(); i++) {
				robots.get(i).process(product);
			}
			
			task.addCreatedProduct(product);
			
			if(task.getNumberOfProductsLeftToProduce() <= 0) {
				tasks.remove(task);
			}
		}
	}
	
	/**
	 * Attempt to take a resource from a storage bin, if attempt fails it halts the assembly line
	 * @param resource The resource type
	 * @return The actual resource that was taken, or null if none
	 */
	public Resource takeResource(Class<? extends Resource> resource) {
		
		Resource result = null;
		for(int i = 0; i < bins.size() && result == null; i++) {
			if(bins.get(i).getResourceType().equals(resource)) {
				result = bins.get(i).takeResource();
			}
		}
		
		if(result == null) {
			halt();
		}
		
		return result;
	}
	
	/**
	 * Adds a storage bin
	 * @param bin The storage bin to add
	 */
	public void addStorageBin(StorageBin bin) {
		bins.add(bin);
	}
	
	/**
	 * Adds a robot to the assembly line
	 * @param robot The robot to add
	 */
	public void addRobot(Robot robot) {
		robots.add(robot);
		robot.setAssemblyLine(this);
	}
	
	/**
	 * Halts the assembly line
	 */
	public void halt() {
		isRunning = false;
	}
	
	/**
	 * Resumes the assembly line
	 */
	public void resume() {
		isRunning = true;
	}
	
	/**
	 * Returns the identifier of this assembly line
	 * @return The identifier
	 */
	public int getIdentifier() {
		return identifier;
	}
	
	/**
	 * Returns a description of the current status of the assembly line
	 * @return Description of the current status
	 */
	public String getStatus() {
		return "Line " + this.identifier + "\n-------\nRunning: " + this.isRunning + "\nTasks left: " + this.tasks.size() + "\n\n";
	}
}

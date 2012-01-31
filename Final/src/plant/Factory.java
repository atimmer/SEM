package plant;

import java.util.ArrayList;

import plant.physical.Product;
import plant.physical.resource.*;
import plant.physical.product.*;

/**
 * Class representing the actual factory
 * @author Koen van Urk and Anton Timmermans
 *
 */
public class Factory {

	private ArrayList<AssemblyLine> lines;
	private String name;
	
	/**
	 * Creates a new Manufacturing Plant
	 * @param name
	 */
	public Factory(String name) {
		lines = new ArrayList<AssemblyLine>();
		this.name = name;
	}
	
	/**
	 * Adds an assembly line to the factory
	 * @param line The assembly line
	 */
	public void addAssemblyLine(AssemblyLine line) {
		lines.add(line);
	}
	
	/**
	 * Adds a storage bin to a given assembly line in this factory
	 * @param bin The storage bin to add
	 * @param identifier The identifier of the assembly line
	 */
	public void addStorageBinToAssemblyLine(StorageBin bin, int identifier) {
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).getIdentifier() == identifier) {
				lines.get(i).addStorageBin(bin);
			}
		}
	}
	
	/**
	 * Returns the name of this particular factory
	 * @return The name of the factory
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the status of this factory
	 * @return The status of this factory
	 */
	public String getStatus() {
		String result = getName() + "\n-----------------------------\n\n";
		for(int i = 0; i < lines.size(); i++) {
			result = result + lines.get(i).getStatus() + "\n";
		}
		
		return result;
	}
	
	/**
	 * Tells all the assembly lines to work
	 */
	public void work() {
		for(int i = 0; i < lines.size(); i++) {
			lines.get(i).work();
		}
	}
	
	/**
	 * Resumes the assembly line with the given identifier
	 * @param identifier The identifier of the assembly line
	 */
	public void resumeAssemblyLine(int identifier) {
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).getIdentifier() == identifier) {
				lines.get(i).resume();
			}
		}
	}
	
	/**
	 * Halts the assembly line with the given identifier
	 * @param identifier The identifier of the assembly line
	 */
	public void haltAssemblyLine(int identifier) {
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).getIdentifier() == identifier) {
				lines.get(i).halt();
			}
		}
	}
	
	/**
	 * Schedules a given product for a run on an assembly line
	 * @param identifier The identifier of the assembly line
	 * @param productType The class of the product
	 * @param productionGoal The number of items to produce
	 */
	public void scheduleProductRunForAssemblyLine(int identifier, Class<? extends Product> productType, int productionGoal) {
		AssemblyLine.Task task = new AssemblyLine.Task(productType, productionGoal);
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).getIdentifier() == identifier) {
				lines.get(i).schedule(task);
			}
		}
	}
	
	public static void main(String[] args) {
		Factory factory = new Factory("Stuffed Animals LLC");
		
		StorageBin bin1 = new StorageBin(Eye.class, 10);
		bin1.addResource(new Eye());
		bin1.addResource(new Eye());
		bin1.addResource(new Eye());
		bin1.addResource(new Eye());
		bin1.addResource(new Eye());
		bin1.addResource(new Eye());
		
		StorageBin bin2 = new StorageBin(Skin.class, 8);
		bin2.addResource(new Skin());
		bin2.addResource(new Skin());
		
		Robot robot1 = new Robot(Eye.class, 1);
		Robot robot2 = new Robot(Eye.class, 2);
		Robot robot3 = new Robot(Skin.class, 3);
		
		AssemblyLine line1 = new AssemblyLine(1);
		line1.addRobot(robot1);
		line1.addRobot(robot2);
		line1.addRobot(robot3);
		line1.addStorageBin(bin1);
		line1.addStorageBin(bin2);
		
		factory.addAssemblyLine(line1);
		factory.scheduleProductRunForAssemblyLine(1, Bear.class, 3);
		
		System.out.println(factory.getStatus());
		factory.resumeAssemblyLine(1);
		System.out.println(factory.getStatus());
		factory.work();
		System.out.println(factory.getStatus());
		factory.work();
		System.out.println(factory.getStatus());
		factory.work();
		System.out.println(factory.getStatus());
	}
	
}

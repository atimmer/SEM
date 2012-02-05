package plant.tests;

import junit.framework.TestCase;
import plant.*;
import plant.physical.resource.*;

public class TestProductionLine extends TestCase {

	private Factory factory;
	private AssemblyLine line;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		factory = new Factory("Stuffed Animals LLC");
		line = new AssemblyLine(1);
	}
	
	public void testInitialize() {
		assertNotNull("factory shouldn't be null", factory);
		assertEquals("factory name", "Stuffed Animals LLC", factory.getName());
		
		assertNotNull("line shouldn't be null", line);
	}
	
	public void testAssemblyLineIdentifier() {
		assertEquals("assembly line identifier", 1, line.getIdentifier());
	}
	
	public void testAssemblyLineResumeAndHalt() {
		assertFalse("assembly line should be halted", line.isRunning());
		line.resume();
		assertTrue("assembly line should be running", line.isRunning());
		
		// After taking a resource (of which there are none currently)
		// the assembly line should be halted again
		assertNull("assembly line doesn't have resources", line.takeResource(Eye.class));
		assertFalse("assembly line should be halted", line.isRunning());
		
	}

}

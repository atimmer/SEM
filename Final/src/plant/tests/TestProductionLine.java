package plant.tests;

import junit.framework.TestCase;
import plant.*;

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

}

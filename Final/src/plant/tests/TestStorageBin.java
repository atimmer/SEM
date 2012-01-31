package plant.tests;

import plant.StorageBin;
import plant.physical.resource.*;
import junit.framework.TestCase;

public class TestStorageBin extends TestCase {

	private StorageBin bin;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		bin = new StorageBin(Filling.class, 10);
	}
	
	public void testInitialize() {
		assertNotNull("bin should not be null", bin);
		assertEquals("bin should be empty", 0, bin.getResourcesLeft());
	}
	
	public void testFillBin() {
		assertTrue("bin should accept resource", bin.addResource(new Filling()));
		assertEquals("bin should have 1 item", 1, bin.getResourcesLeft());
		assertFalse("bin should not accept null", bin.addResource(null));
		assertFalse("bin should not accept wool", bin.addResource(new Wool()));
		assertEquals("bin should still have 1 item", 1, bin.getResourcesLeft());
		bin.addResource(new Filling()); // 2
		bin.addResource(new Filling()); // 3
		bin.addResource(new Filling()); // 4
		bin.addResource(new Filling()); // 5
		bin.addResource(new Filling()); // 6
		bin.addResource(new Filling()); // 7
		bin.addResource(new Filling()); // 8
		bin.addResource(new Filling()); // 9
		bin.addResource(new Filling()); // 10
		
		assertEquals("bin should have 10 items", 10, bin.getResourcesLeft());
		assertFalse("bin should not accept any more fillings", bin.addResource(new Filling()));
		assertFalse("bin should not accept wool", bin.addResource(new Filling()));
	}
	
	public void testTakeFromBin() {
		assertNull("bin should not return a resource", bin.takeResource());
		
		bin.addResource(new Filling());
		assertEquals("bin should have 1 item", 1, bin.getResourcesLeft());
		assertNotNull("bin should return a resource", bin.takeResource());
		assertEquals("bin should have no items", 0, bin.getResourcesLeft());
	}

}

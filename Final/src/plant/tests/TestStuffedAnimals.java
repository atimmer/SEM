package plant.tests;

import junit.framework.TestCase;
import plant.physical.product.*;
import plant.physical.resource.*;

public class TestStuffedAnimals extends TestCase {

	private Bear bear;
	private Bunny bunny;
	private Squirrel squirrel;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		bear = new Bear();
		bunny = new Bunny();
		squirrel = new Squirrel();
	}
	
	public void testInitialize() {
		assertNotNull("bear should not be null", bear);
		assertNotNull("bunny should not be null", bunny);
		assertNotNull("squirrel should not be null", squirrel);
	}
	
	public void testFinishedBearProduct() {
		assertFalse("bear should not be finished yet (1)", bear.isFinished());
		bear.addResource(new Eye());
		assertFalse("bear should not be finished yet (2)", bear.isFinished());
		bear.addResource(new Eye());
		assertFalse("bear should not be finished yet (3)", bear.isFinished());
		bear.addResource(new Skin());
		assertTrue("bear should be finished", bear.isFinished());
	}
	
	public void testFinishedBunnyProduct() {
		assertFalse("bunny should not be finished yet (1)", bunny.isFinished());
		bunny.addResource(new Eye());
		assertFalse("bunny should not be finished yet (2)", bunny.isFinished());
		bunny.addResource(new Eye());
		assertFalse("bunny should not be finished yet (3)", bunny.isFinished());
		bunny.addResource(new Skin());
		assertFalse("bunny should not be finished yet (4)", bunny.isFinished());
		bunny.addResource(new Filling());
		assertTrue("bunny should be finished", bunny.isFinished());
	}
	
	public void testFinishedSquirrelProduct() {
		assertFalse("squirrel should not be finished yet (1)", squirrel.isFinished());
		squirrel.addResource(new Eye());
		assertFalse("squirrel should not be finished yet (2)", squirrel.isFinished());
		squirrel.addResource(new Eye());
		assertFalse("squirrel should not be finished yet (3)", squirrel.isFinished());
		squirrel.addResource(new Skin());
		assertFalse("squirrel should not be finished yet (4)", squirrel.isFinished());
		squirrel.addResource(new Filling());
		assertFalse("squirrel should not be finished yet (5)", squirrel.isFinished());
		squirrel.addResource(new Button());
		assertFalse("squirrel should not be finished yet (6)", squirrel.isFinished());
		squirrel.addResource(new Button());
		assertFalse("squirrel should not be finished yet (7)", squirrel.isFinished());
		squirrel.addResource(new Button());
		assertTrue("squirrel should be finished", squirrel.isFinished());
	}
	
	public void testBearWeight() {
		assertEquals("bear should not weigh anything", 0.0, bear.getWeight());
		Eye eye1 = new Eye();
		Eye eye2 = new Eye();
		Skin skin = new Skin();
		bear.addResource(eye1);
		bear.addResource(eye2);
		bear.addResource(skin);
		assertEquals("bear should weigh 2x eye + 1 skin", eye1.getWeight() + eye2.getWeight() + skin.getWeight(), bear.getWeight());
	}

}

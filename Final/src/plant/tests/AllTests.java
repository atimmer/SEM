package plant.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestStuffedAnimals.class);
		suite.addTestSuite(TestStorageBin.class);
		suite.addTestSuite(TestProductionLine.class);
		//$JUnit-END$
		return suite;
	}

}

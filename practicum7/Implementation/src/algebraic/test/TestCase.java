package algebraic.test;

import algebraic.*;

public class TestCase {

	public static void main(String[] args) {
		TestCase.getInstance().run();
	}
	
	
	// Dit is nou een Singleton.
	private static TestCase instance = null;
	
	private TestCase() { }
	
	public static TestCase getInstance() {
		if(TestCase.instance == null) {
			TestCase.instance = new TestCase();
		}
		
		return TestCase.instance;
	}
	// End of Singleton methoden.
	
	/**
	 * Runs all tests
	 */
	public void run() {
		System.out.println("ALGEBRAIC SYSTEM TESTS");
		System.out.println("--------------------");
		System.out.println("");
		
		testIntegerNumber();
		testAddition();
		testSubtraction();
		testMultiplication();
		testComplex();
	}
	
	/**
	 * Setup the test variables
	 */
	private void setup() {
		// No setup for this TestCase
	}
	
	/**
	 * Test: A single integer number
	 */
	public void testIntegerNumber() {
		setup();
		System.out.println("Test: Setting and getting the value of a number");
		
		int random = (int) (Math.random() * 100);
		Component number = new IntegerNumber(random);
		assertEquals(random, number.getValue());
		
		// Test with the number 2
		Component number2 = new IntegerNumber(2);
		assertEquals(2, number2.getValue());
	}
	
	/**
	 * Test: Addition of two numbers
	 */
	public void testAddition() {
		setup();
		System.out.println("Test: Adding two numbers");
		
		int random = (int) (Math.random() * 100);
		int random2 = (int) (Math.random() * 100);
		
		Component comp1 = new IntegerNumber(random);
		Component comp2 = new IntegerNumber(random2);
		
		Expression add = new AddExpression();
		add.addOperands(comp1, comp2);

		assertEquals(add.getValue(), random+random2);
	}
	
	/**
	 * Test: Subtraction of two numbers
	 */
	public void testSubtraction() {
		setup();
		System.out.println("Test: Subtracting two numbers");
		
		int random = (int) (Math.random() * 100);
		int random2 = (int) (Math.random() * 100);
		
		Component comp1 = new IntegerNumber(random);
		Component comp2 = new IntegerNumber(random2);
		
		Expression subtract = new SubtractExpression();
		subtract.addOperands(comp1, comp2);

		assertEquals(subtract.getValue(), random-random2);
	}
	
	/**
	 * Test: Multiplication of two numbers
	 */
	public void testMultiplication() {
		setup();
		System.out.println("Test: Multiplication of two numbers");
		
		int random = (int) (Math.random() * 100);
		int random2 = (int) (Math.random() * 100);
		
		Component comp1 = new IntegerNumber(random);
		Component comp2 = new IntegerNumber(random2);
		
		Expression multiply = new MultiplyExpression();
		multiply.addOperands(comp1, comp2);

		assertEquals(multiply.getValue(), random*random2);
	}
	
	/**
	 * Test: A complex sequence of operations
	 */
	public void testComplex() {
		setup();
		System.out.println("Test: Adding two numbers");
		
		int random1 = (int) (Math.random() * 100);
		int random2 = (int) (Math.random() * 100);
		int random3 = (int) (Math.random() * 100);
		int random4 = (int) (Math.random() * 100);
		
		Component comp1 = new IntegerNumber(random1);
		Component comp2 = new IntegerNumber(random2);
		Component comp3 = new IntegerNumber(random3);
		Component comp4 = new IntegerNumber(random4);

		SubtractExpression exp1 = new SubtractExpression();
		exp1.addOperands(comp1, comp2);
		
		MultiplyExpression exp2 = new MultiplyExpression();
		exp2.addOperands(exp1, comp3);
		
		AddExpression exp3 = new AddExpression();
		exp3.addOperands(exp2, comp4);
		
		assertEquals(exp3.getValue(), ((random1-random2)*random3)+random4);
	}
	
	
	/**
	 * Asserts that o1 equals (using the equals function) o2, displaying a message with the result
	 * @param o1 Object 1
	 * @param o2 Object 2
	 */
	private void assertEquals(Object o1, Object o2) {
		if(o1.equals(o2)) {
			System.out.println("+ OK");
		}else{
			System.out.println("- Error: " + o1 + " is not equal to " + o2);
		}
	}
	
}

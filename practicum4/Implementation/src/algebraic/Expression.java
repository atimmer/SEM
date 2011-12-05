package algebraic;

public abstract class Expression extends Component {
	
	/**
	 * componentA != null
	 */
	protected Component componentA;
	
	/**
	 * componentB != null
	 */
	protected Component componentB;
	
	/**
	 * Adds operants to this expression
	 * 
	 * @require operandA != null && operandB != null && !operandA.equals(this) && !operandB.equals(this)
	 * @ensure this.componentA = operandA && this.componentB = operandB
	 */
	public void addOperands(Component operandA, Component operandB) {
		this.componentA = operandA;
		this.componentB = operandB;
	}

	@Override
	public abstract int getValue();

}

package algebraic;

public class SubtractExpression extends Expression {

	@Override
	public int getValue() {
		return this.componentA.getValue() - this.componentB.getValue();
	}

}

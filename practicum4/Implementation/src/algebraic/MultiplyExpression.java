package algebraic;

public class MultiplyExpression extends Expression {

	@Override
	public int getValue() {
		return this.componentA.getValue() * this.componentB.getValue();
	}

}

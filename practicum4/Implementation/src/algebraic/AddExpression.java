package algebraic;

public class AddExpression extends Expression {

	@Override
	public int getValue() {
		return this.componentA.getValue() + this.componentB.getValue();
	}

}

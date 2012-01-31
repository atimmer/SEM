package algebraic;

public class IntegerNumber extends Component {
	
	private int value;
	
	/**
	 * Initializes a number
	 * 
	 * @ensure this.value = value
	 */
	public IntegerNumber(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
}

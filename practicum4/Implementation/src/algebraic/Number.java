package algebraic;

public class Number extends Component {
	
	private int value;
	
	/**
	 * Initializes a number
	 * 
	 * @ensure this.value = value
	 */
	public Number(int value) {
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return this.value;
	}
}

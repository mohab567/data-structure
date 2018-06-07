package eg.edu.alexu.csd.datastructure.calculator.cs80;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;
/**
 * @author DELL
 *
 */
public class MyCalculator implements ICalculator {

	@Override
	public int add(final int x, final int y) {
		return x + y;
	}

	@Override
	public float divide(final int x, final int y) {
		float z = (float) x / y;
		return z;
	}

}

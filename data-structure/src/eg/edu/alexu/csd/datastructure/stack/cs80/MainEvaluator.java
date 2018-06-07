package eg.edu.alexu.csd.datastructure.stack.cs80;

import java.util.Scanner;
/**
 * @author DELL
 *
 */
public class MainEvaluator {
	/**
	 * menu input.
	 */
		private static Scanner input;
		/**
		 * scan of  expression.
		 */
		private static Scanner input2;
		/**
		 * Calculator UI.
		 * @param args String
		 */
	public static void main(final String[] args) {
		MyEvaluator m1 = new MyEvaluator();
		while (true) {

	System.out.println("=========\n1:Enter exp. to evaluate\n2:End App");
			input = new Scanner(System.in);
			String scan = input.nextLine();
			if (scan.equals("1")) {
			System.out.println("Please Enter your expression(white "
+ "space is ignored and no unary or any other simpolic exp except +-*/)");
				input2 = new Scanner(System.in);
			try {
				System.out.println("The answer is "
			+ m1.evaluate(m1.infixToPostfix(input2.nextLine())));
				} catch (Exception e) {
				System.out.println("Wrong input");
				}
			} else if (scan.equals("2")) {
				break;
			} else {
				System.out.println("Wrong input");
			}
		}

	}

}

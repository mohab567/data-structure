package eg.edu.alexu.csd.datastructure.stack.cs80;

import java.util.Scanner;
/**
 * @author DELL
 *
 */
public class MainStack {
/**
 * menu input.
 */
	private static Scanner input;
/**
 * scan of pushed element.
 */
	private static Scanner input2;
/**
 * stack UI.
 * @param args String
 */
	public static void main(final String[] args) {
		MyStack e = new MyStack();
		while (true) {

			System.out.println(
				"===================\n1: Push \n2: Pop\n"
		+ "3: Peek\n4: Get size\n5: Check if empty\n6: End App");
			input = new Scanner(System.in);
			String scan = input.nextLine();
			if (scan.equals("1")) {
				input2 = new Scanner(System.in);
				e.push(input2.nextLine());
				System.out.println("pushed successfully");
			} else if (scan.equals("2")) {
				try {
			System.out.println("poped element is " + e.pop());
				} catch (Exception m) {
					System.out.println("No element to pop");
				}

			} else if (scan.equals("3")) {
				try {
				System.out.println("Top is " + e.peek());
				} catch (Exception m) {
				System.out.println("No element to peek");
				}

			} else if (scan.equals("4")) {
				System.out.println("Top is " + e.size());

			} else if (scan.equals("5")) {
				if (e.isEmpty()) {
					System.out.println("yes");
				} else {
					System.out.println("No");
				}
			} else if (scan.equals("6")) {

				break;

			} else {
				System.out.println("Wrong Input Try again");
			}

		}

	}
}

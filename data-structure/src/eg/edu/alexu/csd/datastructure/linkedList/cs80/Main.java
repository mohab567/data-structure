package eg.edu.alexu.csd.datastructure.linkedList.cs80;

import java.awt.Point;
import java.util.*;

public class Main {
	private static Scanner input;

	    static int[][] arrMaker(final String str1) {

		int i, j, n, arrSize = 0;
        final int size = 48;
		for (i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '(') {
				arrSize++;
			}
		}

		// array
		int[][] arr = new int[arrSize][2];

		for (j = 0, i = 0, n = 0; j < str1.length()
				&& i < arrSize; j++) {

			if ((int) str1.charAt(j) - size >= 0
					&& (int) str1.charAt(j) - size <= 9) {

				if (j + 1 < str1.length()
					&& (int) str1.charAt(j + 1) - size >= 0
					&& (int) str1.charAt(j + 1) - size <= 9) {

					if (j + 2 < str1.length() && (int) str1.charAt(j + 2) - size >= 0
							&& (int) str1.charAt(j + 2) - size <= 9) {

						if (j + 3 < str1.length() && (int) str1.charAt(j + 3) - size >= 0
								&& (int) str1.charAt(j + 3) - size <= 9) {

						arr[i][n] = ((int)
						str1.charAt(j) - size) * 1000;
						arr[i][n] += ((int)
						str1.charAt(j + 1) - size) * 100;
						arr[i][n] += ((int)
						str1.charAt(j + 2) - size) * 10;
						arr[i][n] += (int)
						str1.charAt(j + 3) - size;

						if (str1.charAt(j - 1) == '-') {
						arr[i][n] = -(arr[i][n]);
							}

							j += 3;

							if (n == 0) {
								n++;
							} else {
								n = 0;
								i++;
							}
						} else {

						arr[i][n] = ((int)
						str1.charAt(j) - size) * 100;
						arr[i][n] += ((int)
						str1.charAt(j + 1) - size) * 10;
						arr[i][n] += (int)
						str1.charAt(j + 2) - size;

						if (str1.charAt(j - 1) == '-') {
							arr[i][n] = -arr[i][n];
							}

							j += 2;

							if (n == 0) {
								n++;
							} else {
								n = 0;
								i++;
							}
						}

					} else {

						arr[i][n] = ((int)
						str1.charAt(j) - size) * 10;
						arr[i][n] += (int)
						str1.charAt(j + 1) - size;

						if (str1.charAt(j - 1) == '-') {
							arr[i][n] = -arr[i][n];
						}

						j++;

						if (n == 0) {
							n++;
						} else {
							n = 0;
							i++;
						}
					}

				} else {

					arr[i][n] = (int) str1.charAt(j) - size;

					if (str1.charAt(j - 1) == '-') {
						arr[i][n] = -arr[i][n];
					}

					if (n == 0) {
						n++;
					} else {
						n = 0;
						i++;
					}
				}
			}
		}

		return arr;
	}

	public static void main(final String[] args) {

		input = new Scanner(System.in);

		String character;
		String digit;
		String digit2;
		String points;
		Point p = new Point();
		int[][] arr;

		FPoly list = new FPoly();

		while (true) {
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("8- End the application");
			System.out.println("====================================================================");

			character = input.nextLine();

			if (character.charAt(0) == '1') {

				System.out.println("Insert the variable name : A, B or C");
				digit = input.nextLine();
				while (digit.charAt(0) != 'A' && digit.charAt(0) != 'B' && digit.charAt(0) != 'C') {
	System.out.println("Error Insert the variable name : A, B or C");
					digit = input.nextLine();
				}
	System.out.println("Insert the polynomial terms in the form :");
	System.out.println("(coeff1 , exponent1 ),(coeff2,exponent2),..");
				points = input.nextLine();
				arr = arrMaker(points);

				if (digit.charAt(0) == 'A') {
					list.setPolynomial('A', arr);
				System.out.println("Polynomial A is set");
				} else if (digit.charAt(0) == 'B') {
					list.setPolynomial('B', arr);
				System.out.println("Polynomial B is set");
				} else if (digit.charAt(0) == 'C') {
					list.setPolynomial('C', arr);
				System.out.println("Polynomial C is set");
				}

    System.out.println("=============================================");

			} else if (character.charAt(0) == '2') {
	System.out.println("Insert the variable name : A, B, C or R");
				digit = input.nextLine();
	while (digit.charAt(0) != 'A'
			&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C'
						&& digit.charAt(0) != 'R') {
	System.out.println("Error Insert the variable name : A, B or C");
					digit = input.nextLine();
				}
				if (digit.charAt(0) == 'A'
						|| digit.charAt(0) == 'B'
						|| digit.charAt(0) == 'C'
						|| digit.charAt(0) == 'R') {
					if (digit.charAt(0) == 'A') {
					System.out.println(list.print('A'));
					} else if (digit.charAt(0) == 'B') {
					System.out.println(list.print('B'));
					} else if (digit.charAt(0) == 'C') {
					System.out.println(list.print('C'));
					} else if (digit.charAt(0) == 'R') {
					System.out.println(list.print('R'));
					}

				}
			}

			else if (character.charAt(0) == '3') {
				System.out.println("Insert the first operand variable name : A, B, C or R");
				digit = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the first operand variable name : A, B, C or R");
					digit = input.nextLine();
				}
				System.out.println("Insert the second operand variable name : A, B, C or R");
				digit2 = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the second operand variable name : A, B, C or R");
					digit2 = input.nextLine();
				}
				arr = list.add(digit.charAt(0), digit2.charAt(0));

				System.out.print("Result set in R: ");
				if (arr.length == 0) {
					System.out.println("0");
				}

				for (int i = 0; i < arr.length; i++) {
					p = new Point();
					p.x = arr[i][0];
					p.y = arr[i][1];
					if (i + 1 != arr.length) {
						System.out.print("(" + p.x + "," + p.y + ")" + " , ");
					} else {
						System.out.println("(" + p.x + "," + p.y + ")");
					}
				}
			}

			else if (character.charAt(0) == '4') {
				System.out.println("Insert the first operand variable name : A, B, C or R");
				digit = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the first operand variable name : A, B, C or R");
					digit = input.nextLine();
				}
				System.out.println("Insert the second operand variable name : A, B, C or R");
				digit2 = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the second operand variable name : A, B, C or R");
					digit2 = input.nextLine();
				}
				arr = list.subtract(digit.charAt(0), digit2.charAt(0));

				System.out.print("Result set in R: ");
				if (arr.length == 0) {
					System.out.println("0");
				}

				for (int i = 0; i < arr.length; i++) {
					p = new Point();
					p.x = arr[i][0];
					p.y = arr[i][1];
					if (i + 1 != arr.length) {
						System.out.print("(" + p.x + "," + p.y + ")" + " , ");
					} else {
						System.out.println("(" + p.x + "," + p.y + ")");
					}
				}
			}

			else if (character.charAt(0) == '5') {
				System.out.println("Insert the first operand variable name : A, B, C or R");
				digit = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the first operand variable name : A, B, C or R");
					digit = input.nextLine();
				}
				System.out.println("Insert the second operand variable name : A, B, C or R");
				digit2 = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("Variable not set");
					System.out.println("Insert the second operand variable name : A, B, C or R");
					digit2 = input.nextLine();
				}
				arr = list.multiply(digit.charAt(0), digit2.charAt(0));

				System.out.print("Result set in R: ");
				if (arr.length == 0) {
					System.out.println("0");
				}

				for (int i = 0; i < arr.length; i++) {
					p = new Point();
					p.x = arr[i][0];
					p.y = arr[i][1];
					if (i + 1 != arr.length) {
						System.out.print("(" + p.x + "," + p.y + ")" + " , ");
					} else {
						System.out.println("(" + p.x + "," + p.y + ")");
					}
				}
			} else if (character.charAt(0) == '6') {
				System.out.println("Insert the variable name : A, B, C or R");
				digit = input.nextLine();

				System.out.println("Insert the point");
				float point, result = 0;
				point = input.nextFloat();
				character = input.nextLine();
				while ((digit.charAt(0) == 'A' && list.chooseList('A').isEmpty())
						|| (digit.charAt(0) == 'B' && list.chooseList('B').isEmpty())
						|| (digit.charAt(0) == 'C' && list.chooseList('C').isEmpty())
						|| (digit.charAt(0) == 'R' && list.chooseList('R').isEmpty()) || (digit.charAt(0) != 'A'
								&& digit.charAt(0) != 'B' && digit.charAt(0) != 'C' && digit.charAt(0) != 'R')) {
					System.out.println("You have 'A','B','C' and 'R' variable names only");
					character = input.nextLine();
				}
				if (digit.charAt(0) == 'A' || digit.charAt(0) == 'B' || digit.charAt(0) == 'C'
						|| digit.charAt(0) == 'R') {
					if (digit.charAt(0) == 'A') {
						result = list.evaluatePolynomial('A', point);
					} else if (digit.charAt(0) == 'B') {
						result = list.evaluatePolynomial('B', point);
					} else if (digit.charAt(0) == 'C') {
						result = list.evaluatePolynomial('C', point);
					} else if (digit.charAt(0) == 'R') {
						result = list.evaluatePolynomial('R', point);
					}

					System.out.println(result);
				}
			}

			else if (character.charAt(0) == '7') {
				System.out.println("Insert the variable name : A, B, C or R");
				digit = input.nextLine();

				if (digit.charAt(0) == 'A' || digit.charAt(0) == 'B' || digit.charAt(0) == 'C'
						|| digit.charAt(0) == 'R') {
					if (digit.charAt(0) == 'A') {
						list.clearPolynomial('A');
					} else if (digit.charAt(0) == 'B') {
						list.clearPolynomial('B');
					} else if (digit.charAt(0) == 'C') {
						list.clearPolynomial('C');
					} else if (digit.charAt(0) == 'R') {
						list.clearPolynomial('R');
					}

				} else {
					System.out.println("You have 'A','B','C' and 'R' variable names only");
					System.out.println("====================================================================");
				}
			}

			else if (character.charAt(0) == '8') {
				System.out.println("Bye Bye !!");
				break;
			}
		}

	}

}
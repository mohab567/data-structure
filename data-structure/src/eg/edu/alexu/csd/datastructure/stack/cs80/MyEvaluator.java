package eg.edu.alexu.csd.datastructure.stack.cs80;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 *
 * @author DELL
 *
 */
public class MyEvaluator implements IExpressionEvaluator {

	/**
	 *
	 * @param c current char
	 * @return "boolean"
	 */
	boolean isExpLow(final char c) {
		return c == '+' || c == '-';
	}



	/**
	 *
	 * @param c current char
	 * @return "boolean"
	 */
	boolean isExpHi(final char c) {
		return c == '*' || c == '/';
	}

	@Override
	public String infixToPostfix(final String expression) {
		int flag = 1;
		MyStack e = new MyStack();
		StringBuilder output = new StringBuilder();
		if (expression.length() != 0) {
			if (isExpHi(expression.charAt(0))
					|| isExpLow(expression.charAt(0))) {
				throw new RuntimeException();
			}
		}

		for (int i = 0; i < expression.length();) {

			if (expression.charAt(i) == ' ') {
				i++;
				continue;
			} else if (expression.charAt(i) == '(') {
				e.push('(');
				i++;
				continue;
			} else if (expression.charAt(i) == ')') {

				for (; (char) e.peek() != '(';) {
					output.append(e.pop());
				}
				output.append(' ');
				e.pop();
				i++;
				continue;

			} else if (Character.isDigit(expression.charAt(i))
					|| Character.isAlphabetic(
					expression.charAt(i))) {
				flag = 0;

				output.append(expression.charAt(i));
				i++;
				while (i != expression.length()
						&& Character.isDigit(
						expression.charAt(i))) {
					output.append(expression.charAt(i));
					i++;
				}
				output.append(' ');

				continue;
			} else if (isExpHi(expression.charAt(i))
					|| isExpLow(expression.charAt(i))) {
				if (flag == 1) {
					throw new RuntimeException();
				}

				if (isExpHi(expression.charAt(i))
						&& !e.isEmpty()
						&& isExpLow((char) e.peek())) {
					flag = 1;
					e.push(expression.charAt(i));
					i++;
					continue;
				} else if (!e.isEmpty()
						&& (char) e.peek() != '(') {

					output.append(e.pop());
					output.append(' ');
					continue;

				} else {
					flag = 1;
					e.push(expression.charAt(i));
					i++;
					continue;
				}

			} else {
				throw new RuntimeException();
			}

		}

		for (; !e.isEmpty();) {
			if ((char) e.peek() == '(') {
				throw new RuntimeException();
			}
			output.append(e.pop());
			output.append(' ');
		}
		if (flag == 1) {
			throw new RuntimeException();
		}

		return output.substring(0, output.length() - 1);
	}

	@Override
	public int evaluate(final String expression) {
		MyStack e = new MyStack();
		for (int i = 0; i < expression.length();) {
			if (expression.charAt(i) == ' ') {
				i++;
			} else if (Character.isDigit(expression.charAt(i))) {
				float temp = 0;
				int power = 1;
				final int x = 10;
				for (int z = i + 1; z != expression.length()
						&& Character.isDigit(
						expression.charAt(z)); z++) {
					power *= x;
				}

				for (; power > 0; i++) {
					temp += power
						* Character.getNumericValue(
						expression.charAt(i));
					power /= x;
				}
				e.push(temp);
			} else {
				if (i + 1 != expression.length()
						&& expression.charAt(i + 1)
						!= ' ') {
					throw new RuntimeException();
				}
				switch (expression.charAt(i)) {
				case '+':
					e.push((float) e.pop()
							+ (float) e.pop());
					break;
				case '-':
					e.push(-(float) e.pop()
							+ (float) e.pop());
					break;
				case '*':
					e.push((float) e.pop()
							* (float) e.pop());
					break;
				case '/':
					e.push(((float) 1
							/ (float) e.pop())
							* (float) e.pop());
					break;

				default:
					throw new RuntimeException();
				}
				i++;
			}

		}
		return (int) (float) e.peek();
	}
}

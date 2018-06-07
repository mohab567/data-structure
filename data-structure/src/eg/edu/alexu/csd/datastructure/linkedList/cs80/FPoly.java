package eg.edu.alexu.csd.datastructure.linkedList.cs80;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
/**
 * @author DELL
 *
 */
public class FPoly implements IPolynomialSolver {
/**
	 * A.
	 */
	DList a = new DList();
/**
	 * B.
	 */
	DList b = new DList();
/**
	 * C.
	 */
	DList c = new DList();
/**
	 * R.
	 */
	DList r = new DList();
/**
	 * -.
	 */
	DList temp = new DList();
/**

 * @param xx base
 * @param yy exp
 * @return result
 */
	public float power(final float xx, final int yy) {
		float result = 1;
		for (int i = 0; i < yy; i++) {
			result *= xx;
		}
		return result;
	}
/**

 * @param coef of term
 * @param exp of term
 * @return poly String
 */
	public String term(final int coef, final int exp) {
		String str = "";

		if (coef == 0) {
			return str;
		} else if (exp == 0) {
			str = "" + Math.abs(coef);
		} else if (Math.abs(coef) == 1) {
			if (exp == 1) {
				str = "x";
			} else {
				str = "x^" + exp;
			}
		} else if (exp == 1) {
			str = Math.abs(coef) + "x";
		} else {
			str = Math.abs(coef) + "x^" + exp;
		}

		return str;
	}
/**
 * @param name of poly
 * @return pointer on selected list
 */
	public DList chooseList(final char name) {
		if (name == 'A') {
			return a;
		} else if (name == 'B') {
			return b;
		} else if (name == 'C') {
			return c;
		} else if (name == '-') {
			return temp;
		} else if (name == 'R') {
			return r;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public void setPolynomial(final char poly, final int[][] terms) {

		DList list = chooseList(poly);

		list.clear();

	final int m = 2147483647;
	    int z = m;
		for (int i = 0; i < terms.length; i++) {
			Point p = new Point();
			p.x = terms[i][0];
			p.y = terms[i][1];
			if (p.y < 0) {
				throw new RuntimeException();
			}

			if (p.y >= z) {
				throw new RuntimeException();
			}

			if (p.x != 0) {
				list.add(p);
			}
			z = p.y;

		}

	}
	@Override
	public String print(final char poly) {
		if (chooseList(poly).isEmpty()) {
			return null;
		}

		DList list = new DList();
		list = chooseList(poly);

		Point p = new Point();
		int coef, exp;
		String equation = "";

		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				p = (Point) list.get(i);
				coef = p.x;
				exp = p.y;

				if (coef < 0) {
					equation = "-" + term(coef, exp);
				} else {
					equation = term(coef, exp);
				}

				p = new Point();
			} else {
				p = (Point) list.get(i);
				coef = p.x;
				exp = p.y;

				if (coef < 0) {
					equation += "-" + term(coef, exp);
				} else if (coef > 0) {
					equation += "+" + term(coef, exp);
				} else {
					equation += term(coef, exp);
				}

				p = new Point();
			}
		}

		return equation;
	}

	@Override
	public void clearPolynomial(final char poly) {
		if (chooseList(poly).isEmpty()) {
			throw new RuntimeException();
		}

		chooseList(poly).clear();
	}

	@Override
	public float evaluatePolynomial(final char poly, final float value) {

		if (chooseList(poly).isEmpty()) {
			throw new RuntimeException();
		}

		DList list = chooseList(poly);

		float sum = 0;

		for (int i = 0; i < list.size; i++) {
			Point p = (Point) list.get(i);

			sum += p.x * power(value, p.y);

		}
		return sum;
	}

	@Override
	public int[][] add(final char poly1, final char poly2) {
		if (chooseList(poly1).isEmpty()) {
			throw new RuntimeException();
		}
		if (chooseList(poly2).isEmpty()) {
			throw new RuntimeException();
		}

		DList list1 = chooseList(poly1);

		DList list2 = chooseList(poly2);

		int size1 = list1.size(),
				size2 = list2.size(), counter = 0, i = 0, j = 0;
		Point p1, p2;
		for (int m = 0; m < size1; m++) {
			for (int n = 0; n < size2; n++) {
				p1 = (Point) list1.get(m);
				p2 = (Point) list2.get(n);
				if (p1.y == p2.y) {
					counter++;
				}
				if (p1.x + p2.x == 0 && p1.y == p2.y) {
					counter++;
				}
			}
		}

		int[][] sum = new int[size1 + size2 - counter][2];
		counter = 0;

		while (true) {
			if (i == list1.size && j == list2.size) {
				break;
			}
			if (i < list1.size) {
				p1 = (Point) list1.get(i);
			} else {
				p1 = new Point(-1, -1);
			}
			if (j < list2.size) {
				p2 = (Point) list2.get(j);
			} else {
				p2 = new Point(-1, -1);
			}

			if (p1.y == p2.y) {
				if (p1.x + p2.x == 0) {
					j++;
					i++;
				} else {
					sum[counter][0] = p1.x + p2.x;
					sum[counter][1] = p2.y;
					counter++;
					j++;
					i++;
				}

			} else if (j == list2.size) {
				sum[counter][0] = p1.x;
				sum[counter][1] = p1.y;
				counter++;
				i++;
			} else if (i == list1.size) {
				sum[counter][0] = p2.x;
				sum[counter][1] = p2.y;
				counter++;
				j++;
			} else if (p1.y < p2.y) {
				sum[counter][0] = p2.x;
				sum[counter][1] = p2.y;
				counter++;
				j++;
			} else if (p1.y > p2.y) {
				sum[counter][0] = p1.x;
				sum[counter][1] = p1.y;
				counter++;
				i++;
			}

		}
		setPolynomial('R', sum);

		return sum;
	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		int[][] k = new int[1][2];
		k[0][0] = 0;
		k[0][1] = 0;

		temp.clear();

		for (int i = 0; i < chooseList(poly2).size; i++) {
			Point p = (Point) chooseList(poly2).get(i);

			Point n = new Point(-1 * (p.x), p.y);
			temp.add(n);
		}
		if (poly1 == poly2) {
			add(poly1, '-');
			return k;
		}
		return add(poly1, '-');
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		if ((chooseList(poly1).isEmpty())) {
			throw new RuntimeException();
		}
		if ((chooseList(poly2).isEmpty())) {
			throw new RuntimeException();
		}
		DList list1 = new DList();
		DList list2 = new DList();
		for (int s = 0; s < chooseList(poly1).size; s++) {
			list1.add(chooseList(poly1).get(s));
		}
		for (int s = 0; s < chooseList(poly2).size; s++) {
			list2.add(chooseList(poly2).get(s));
		}

		int size1 = list1.size(), size2 = list2.size();

		int[][] temp2 = new int[size2][2];

		for (int i = 0; i < size1; i++) {

			for (int j = 0; j < size2; j++) {
				Point p1 = (Point) list1.get(i);
				Point p2 = (Point) list2.get(j);

				temp2[j][0] = p1.x * p2.x;
				temp2[j][1] = p1.y + p2.y;
			}
			if (i == 0) {
				setPolynomial('R', temp2);

			} else {
				setPolynomial('-', temp2);
				add('-', 'R');
			}
		}
		int[][] multi = new int[chooseList('R').size][2];

		for (int i = 0; i < chooseList('R').size(); i++) {
			Point p1 = (Point) chooseList('R').get(i);

			multi[i][0] = p1.x;
			multi[i][1] = p1.y;
		}
		return multi;
	}
}

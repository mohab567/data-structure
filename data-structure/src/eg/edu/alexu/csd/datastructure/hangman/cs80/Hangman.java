package eg.edu.alexu.csd.datastructure.hangman.cs80;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
/**
 * @author DELL
 *
 */
public class Hangman implements IHangman {
	/**
	 * counters.
	 */
	int h = 0, n = 0, r = 0;
	/**
	 * max dic length.
	 */
	final int limit = 100;
	/**
	 * a copy.
	 */
	String[] str = new String[limit];
	/**
	 * a copy.
	 */
	String p = "";

	@Override
	public void setDictionary(final String[] words) {

		n = words.length;
		for (int i = 0; i < n; i++) {
			str[i] = words[i];
		}

		return;
	}

	@Override
	public String selectRandomSecretWord() {
		if (n == 0) {
			return null;
		}
		r = (int) (Math.random() * n);

		for (int f = 0; f < str[r].length(); f++) {
			p = p + "-";
		}

		return str[r];

	}
/**

 * @param answer selected word
 * @param s guessed char
 * @return isFound
 */
	 boolean hasLetter(final String answer, final Character s) {
		for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) == s) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String guess(final Character c) {
		if (c == null) {
			return p;
		}
		Character l = Character.toUpperCase(c);
		Character m = Character.toLowerCase(c);

		if (!hasLetter(str[r], l) && !hasLetter(str[r], m)) {

			if (h == 0) {
				return null;
			}
			h--;
			return p;
		} else {
			for (int z = 0; z < str[r].length(); z++) {
				if (str[r].charAt(z) == l
						|| str[r].charAt(z) == m) {
					p = p.substring(0, z)
							+ str[r].charAt(z)
							+ p.substring(z + 1);
				}

			}
			return p;
		}
	}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		if (max == null) {
			h = 0;
		} else {
			h = max - 1;
		}

	}

}

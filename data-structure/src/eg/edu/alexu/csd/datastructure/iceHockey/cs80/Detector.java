package eg.edu.alexu.csd.datastructure.iceHockey.cs80;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
//import java.util.arrays;
/**
 * @author DELL
 *
 */
public class Detector implements IPlayersFinder {
/**
	 * a copy.
	 */
	String[] photos;
/**
	 * a counter of teams.
	 */
	int count;
/**
	 * a point used to get midean.
	 */
	Point max;
/**
	 * a point used to get midean.
	 */
	Point min;
/**
	 * .
	 */
	int t;
/**
	 *midean array.
	 */
	Point[] mids;
	/**
	 * x axis length.
	 */
	int lenx;
	/**
	 * y axis length.
	 */
	int leny;
	/**

	 * @param photo image to process
	 * @param team number
	 * @return boolean
	 */
	public Point isFound(final String[] photo, final int team) {
		Point f = new Point(-1, 0);
		for (int c = 0; c < leny; c++) {
			for (int m = 0; m < lenx; m++) {
				if (photos[c].charAt(m) == team + '0') {
					f.x = m;
					f.y = c;

					return f;
				}
			}
		}
		return f;
	}
/**
 * @param org point to check
 */
	void rec(final Point org) {
		if (photos[org.y].charAt(org.x) == t + '0') {
			final int jump = 4;
			count += jump;
			photos[org.y] = photos[org.y].substring(0, org.x)
			+ '-' + photos[org.y].substring(org.x + 1);
			if (org.x < min.x) {
				min.x = org.x;
			}
			if (org.y < min.y) {
				min.y = org.y;
			}
			if (org.y > max.y) {
				max.y = org.y;
			}
			if (org.x > max.x) {
				max.x = org.x;
			}
			if (org.x != 0) {

				Point l = new Point(org);
				l.x--;
				rec(l);
			}
			if (org.x != photos[0].length() - 1) {
				Point r = new Point(org);
				r.x++;
				rec(r);

			}
			if (org.y != 0) {
				Point u = new Point(org);
				u.y--;

				rec(u);
			}
			if (org.y != photos.length - 1) {
				Point d = new Point(org);
				d.y++;
				rec(d);
			}
		}

	}
	/**
*@param gc index
	 */

	void sort(final int gc) {
		for (int i = 0; i < gc; i++) {
			for (int j = 0; j < gc - 1; j++) {
				if (mids[j].x > mids[j + 1].x
						|| (mids[j].x == mids[j + 1].x
						&& mids[j].y > mids[j + 1].y)) {
					Point temp = new Point(mids[j]);
					mids[j] = new Point(mids[j + 1]);
					mids[j + 1] = new Point(temp);
				}
			}
		}

	}
	@Override
	public Point[] findPlayers(final String[] photo,
			final int team, final int threshold) {
		if (photo.length == 0) {
			return new Point[0];
		}

		lenx = photo[0].length();
        final int e = 10000;
		mids = new Point[e];

		for (int i = 0; i < e; i++) {
			mids[i] = new Point();
		}

		leny = photo.length;

		photos = new String[photo.length];
		for (int i = 0; i < photo.length; i++) {
			photos[i] = photo[i];
		}
		t = team;

		int gc = 0;

		for (; isFound(photos, team).x != -1; gc++) {
			count = 0;

			max = new Point(isFound(photos, team));

			min = new Point(max);
			rec(min);

			if (count >= threshold) {
				mids[gc] = new Point(0, 0);
				mids[gc].x = min.x + max.x + 1;
				mids[gc].y = min.y + max.y + 1;

			} else {
				gc--;
			}
		}
		sort(gc);

		Point[] fff = new Point[gc];
		for (int k = 0; k < gc; k++) {
			fff[k] = new Point(mids[k]);
		}
		return fff;
	}
}

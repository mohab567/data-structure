package eg.edu.alexu.csd.datastructure.maze.cs80;
import eg.edu.alexu.csd.datastructure.stack.cs80.MyStack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs80.LinkedQueue;
/**
 * My maze solver using Deep first search(clock wise) and breath first search.
 * @author DELL
 *
 */
public class Maze implements IMazeSolver {
/**
 * array coordinate .
 * @author DELL
 *
 */
class Point {
	/**
	 * x from left.
	 */
	int x;
	/**
	 * y from upper.
	 */
	int y;
	/**
	 * mark.
	 */
	int m = 0;
	/**
	 * constractor.
	 * @param i its x coordinate.
	 * @param j its y coordinate.
	 */
	Point(final int i, final int j) {
		x = i;
		y = j;
	}
	/**
* constractor.
	 * @param i its x coordinate.
	 * @param j its y coordinate.
	 * @param z mark.
	 */
	Point(final int i, final int j, final int z) {
		x = i;
		y = j;
		m = z;
	}
}
/**
 * counter for array size of visited points.
 */
int count;
/**
 * visited points.
 */
int[][] points;
/**
 * maze copied in 2d array.
 */
char[][] mazeCopy;
/**
 * width length.
 */
int lenx;
/**
 * hight length.
 */
int leny;
/**
 * copies file to array.
 * @param maze file to be copied
 */
	void copyData(final File maze) {
		count = 0;
		Scanner scanner;
		try {
			scanner = new Scanner(maze);
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		     leny = scanner.nextInt();
		     lenx = scanner.nextInt();
		     points = new int[lenx * leny][2];
		 mazeCopy = new char[leny][lenx];
		 for (int i = 0; i < leny; i++) {
				 mazeCopy[i] = scanner.next().toCharArray();
				 if (mazeCopy[i].length > lenx) {
					 scanner.close();
					 throw new RuntimeException();
				 }
		 }
		 if (scanner.hasNext()) {
			 scanner.close();
			 throw new RuntimeException();
		 }
		 scanner.close();
		 if (!findE()) {
			 throw new RuntimeException();
		 }
	}
	/**
	 * mark as visited.
	 * @param y coordnate
	 * @param x coordnate
	 */
	void mark(final int y, final int x) {

		mazeCopy[y][x] = '#';
		points[count][0] = x;
		points[count][1] = y;
		count++;

	}
	/**
	 * find Start.
	 * @return Start place.
	 */
	int[]findS() {
		int[] x = new int[2];
		for (int i = 0; i < leny; i++) {
			for (int j = 0; j < lenx; j++) {
				if (mazeCopy[i][j] == 'S') {
					x[0] = j;
					x[1] = i;

					return x;
				}
			}
		}
		return null;

	}
	/**
	 * search for Exit.
	 * @return true if found.
	 */
	boolean findE() {
		for (int i = 0; i < leny; i++) {
			for (int j = 0; j < lenx; j++) {
				if (mazeCopy[i][j] == 'E') {

					return true;
				}
			}

	}
		return false;
	}
	@Override
	public int[][] solveDFS(final File maze) {
		int set = 0;

	      copyData(maze);
	int[] x = findS();
  int[][] visited;
      MyStack t = new MyStack();
   Point c = new Point(x[0], x[1]);
    t.push(c);
    while (!t.isEmpty()) {

    	c = (Point) t.pop();
    	switch (mazeCopy[c.y][c.x]) {
    	case '.':
    		mark(c.y, c.x);
    		t.push(new Point(c.x, c.y, 1));

    		if (c.x != 0 && mazeCopy[c.y][c.x - 1] != '#') {
    			t.push(new Point(c.x - 1, c.y));
    		}
    		if (c.y + 1 != leny && mazeCopy[c.y + 1][c.x] != '#') {
    			t.push(new Point(c.x, c.y + 1));
    		}
    		if (c.x + 1 != lenx && mazeCopy[c.y][c.x + 1] != '#') {
    			t.push(new Point(c.x + 1, c.y));
    		}
    		if (c.y != 0 && mazeCopy[c.y - 1][c.x] != '#') {
    			t.push(new Point(c.x, c.y - 1));
    		}

    		break;
    	case '#':
    		if (c.m == 1) {
    		count--;
    		}
    		break;
    	case 'S':
    		mark(c.y, c.x);
    		set++;
    		if (set > 1) {
    			throw new RuntimeException();

    		}

    		if (c.x != 0 && mazeCopy[c.y][c.x - 1] != '#') {
    			t.push(new Point(c.x - 1, c.y));
    		}
    		if (c.y + 1 != leny && mazeCopy[c.y + 1][c.x] != '#') {
    			t.push(new Point(c.x, c.y + 1));
    		}
    		if (c.x + 1 != lenx && mazeCopy[c.y][c.x + 1] != '#') {
    			t.push(new Point(c.x + 1, c.y));
    		}
    		if (c.y != 0 && mazeCopy[c.y - 1][c.x] != '#') {
    			t.push(new Point(c.x, c.y - 1));
    		}
    		break;
    	case 'E':
    		mark(c.y, c.x);

    		visited = new int[count][2];

    		for (int i = 0; i < count; i++) {
    			visited[i][0] = points[i][1];
    			visited[i][1] = points[i][0];
    		}
    		return visited;
    	default:
    		throw new RuntimeException();
    	}
    }
		return null;
	}

	@Override
	public int[][] solveBFS(final File maze) {
		int set = 0;

	      copyData(maze);
	int[] x = findS();
	Point[][] back = new Point[leny][lenx];
int[][] visited;
    LinkedQueue t = new LinkedQueue();
 Point c = new Point(x[0], x[1]);

  t.enqueue(c);
  while (!t.isEmpty()) {

  	c = (Point) t.dequeue();
  	switch (mazeCopy[c.y][c.x]) {
  	case '.':
  		mazeCopy[c.y][c.x] = '#';

  		if (c.y != 0 && mazeCopy[c.y - 1][c.x] != '#') {
  			back[c.y - 1][c.x] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x, c.y - 1));
  		}
  		if (c.x + 1 != lenx && mazeCopy[c.y][c.x + 1] != '#') {
  			back[c.y][c.x + 1] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x + 1, c.y));
  		}
  		if (c.y + 1 != leny && mazeCopy[c.y + 1][c.x] != '#') {
  			back[c.y + 1][c.x] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x, c.y + 1));
  		}

  		if (c.x != 0 && mazeCopy[c.y][c.x - 1] != '#') {
  	  		back[c.y][c.x - 1] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x - 1, c.y));
  		}

  		break;
  	case '#':

  		break;
  	case 'S':
  		mazeCopy[c.y][c.x] = '#';
  		back[c.y][c.x] = new Point(-1, -1);
  		set++;

  		if (set > 1) {
  			throw new RuntimeException();

  		}

  		if (c.y != 0 && mazeCopy[c.y - 1][c.x] != '#') {
  			back[c.y - 1][c.x] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x, c.y - 1));

  		}
  		if (c.x + 1 != lenx && mazeCopy[c.y][c.x + 1] != '#') {
  			back[c.y][c.x + 1] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x + 1, c.y));
  		}
  		if (c.y + 1 != leny && mazeCopy[c.y + 1][c.x] != '#') {
  			back[c.y + 1][c.x] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x, c.y + 1));
  		}

  		if (c.x != 0 && mazeCopy[c.y][c.x - 1] != '#') {
  	  		back[c.y][c.x - 1] = new Point(c.x, c.y);
  			t.enqueue(new Point(c.x - 1, c.y));
  		}

  		break;
  	case 'E':

  	while (c.x != -1) {


  		points[count][0] = c.x;
  		points[count][1] = c.y;
  		c = back[c.y][c.x];
  		count++;
  	}
  	visited = new int[count][2];
  	count--;
  	for (int i = 0; count >= 0; count--) {
  		visited[i][0] = points[count][1];
  		visited[i][1] = points[count][0];
  		i++;

  	}
  	return visited;
  	default:
  		throw new RuntimeException();
  	}
  }
		return null;
	}

}

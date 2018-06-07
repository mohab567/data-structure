package eg.edu.alexu.csd.datastructure.maze.cs80;
import java.io.File;
import java.io.FileNotFoundException;
public class Test {
	public static void main(String[] args) {
		Maze m = new Maze();
		File file = new File("C:/ll.txt");

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 2; j++) {
	System.out.print(m.solveDFS(file)[i][j]+" ");

	}System.out.println("");

		}}

}

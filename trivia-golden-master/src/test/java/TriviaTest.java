import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class TriviaTest {

	@Test
	public void xxx() throws IOException {
		PrintStream o = new PrintStream(new File("current.txt"));
		PrintStream console = System.out;
		System.setOut(o);
		GameRunner.main(null);

		File file1 = new File("original.txt");
		File file2 = new File("current.txt");
		boolean isTwoEqual = FileUtils.contentEquals(file1, file2);

		assertTrue(isTwoEqual);
	}

	@Test
	public void trying_to_generate_2_runs_equals_by_brute_force() throws IOException {
		PrintStream o = new PrintStream(new File("current.txt"));
		PrintStream console = System.out;
		System.setOut(o);
		int[] rolls = 	{5,1,2,1,3,5,2,1,2,2,3,5,4,5,2,2,2};
		int[] answers = {1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1};
		Game aGame = new Game();
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		for (int i =0; i< rolls.length;i++){

			aGame.roll(rolls[i]);

			if (answers[i] == 0) {
				aGame.wrongAnswer();
			} else {
				aGame.wasCorrectlyAnswered();
			}
		}

		File file1 = new File("original.txt");
		File file2 = new File("current.txt");
		boolean isTwoEqual = FileUtils.contentEquals(file1, file2);

		assertTrue(isTwoEqual);
	}


	@Test
	public void trying_to_generate_2_runs_equals() throws IOException {
		PrintStream o = new PrintStream(new File("current2.txt"));
		PrintStream console = System.out;
		System.setOut(o);

		String[] args = {"111"};
		GameRunner.main(args);

		File file1 = new File("original2.txt");
		File file2 = new File("current2.txt");
		boolean isTwoEqual = FileUtils.contentEquals(file1, file2);

		assertTrue(isTwoEqual);
	}
}

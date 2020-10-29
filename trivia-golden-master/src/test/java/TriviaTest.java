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
}

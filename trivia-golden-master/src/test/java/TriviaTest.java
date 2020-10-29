import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class TriviaTest {

	@Test
	public void xxx() throws IOException {

		String[] args = {};


		String workingDir = System.getProperty("user.dir");
		String referencePath = String.format("%s/src/test/java/sampleLogs.log", workingDir);
		String outputPath = String.format("%s/target/output.log", workingDir);

		PrintStream printer = new PrintStream(outputPath);
		System.setOut(printer);

		File referenceFile = new File(referencePath);
		File outputFile = new File(outputPath);

		GameRunner.main(args);

		byte[] f1 = Files.readAllBytes(referenceFile.toPath());
		byte[] f2 = Files.readAllBytes(outputFile.toPath());

		assertArrayEquals(f1, f2);
	}
}

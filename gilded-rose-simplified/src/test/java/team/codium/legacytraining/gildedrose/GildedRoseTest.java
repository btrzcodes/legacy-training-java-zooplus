package team.codium.legacytraining.gildedrose;

import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void the_behaviour_should_not_be_changed() throws IOException {
        changeSystemOutTo("src/test/resources/current.log");

        SampleExecution.main(new String[]{});

        assertFilesAreEqual(
                "src/test/resources/original.log",
                "src/test/resources/current.log"
        );
    }

    private void changeSystemOutTo(String filePath) throws FileNotFoundException {
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(filePath)), true));
    }

    private void assertFilesAreEqual(String expectedFile, String actualFile) throws IOException {
        assertEquals(readFile(expectedFile), readFile(actualFile));
    }

    private String readFile(String filePath) throws IOException {
        return new String(readAllBytes(Paths.get(filePath)));
    }

}

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintDateTest {
	@Test
	public void validate_is_printing() throws Exception {
		Printer spyPrinter = mock(Printer.class);
		PrintDate printDate = new PrintDate(new Calendar(), spyPrinter);

		printDate.printCurrentDate();

		// How can we test this function?
		verify(spyPrinter).printLine(any());
	}

	@Test
	public void validate_date() throws Exception {
		Printer spyPrinter = mock(Printer.class);
		PrintDate printDate = new PrintDate(new Calendar(), spyPrinter);

		printDate.printCurrentDate();

		// How can we test this function?
		verify(spyPrinter).printLine(any());
	}
}

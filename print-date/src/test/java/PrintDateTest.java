import org.junit.Test;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

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
		Calendar calendarValidator = mock(Calendar.class);
		Date date = new Date();
		PrintDate printDate = new PrintDate(calendarValidator, spyPrinter);
		when(calendarValidator.today()).thenReturn(date);

		printDate.printCurrentDate();
		verify(spyPrinter).printLine(date.toString());

		// How can we test this function?
	}
}

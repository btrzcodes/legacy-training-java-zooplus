import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class PrintDateTest {
	@Test
	public void printDate() throws Exception {
		Date myDate = new Date(1603970033);
		Calendar calendarValidator = mock(Calendar.class);
		when(calendarValidator.today()).thenReturn(myDate);
		Printer printerValidator = mock(Printer.class);
		PrintDate printDate = new PrintDate(calendarValidator, printerValidator);

		printDate.printCurrentDate();

		verify(printerValidator).printLine(myDate.toString());
	}

	@Test
	public void printDateWithoutMockito() throws Exception {
		Date expectedDate = new Date(1603970033);
		Calendar calendarStub = new CalendarStub();
		Printer printerSpy = new PrinterSpy();
		PrintDate printDate = new PrintDate(calendarStub, printerSpy);

		printDate.printCurrentDate();

		assertEquals(expectedDate.toString(), printerSpy.printLine(calendarStub.today().toString()));
	}
}

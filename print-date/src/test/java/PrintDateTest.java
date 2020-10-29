import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PrintDateTest {
    @Test
    public void checkPrintLineIsCalledWithMockito() throws Exception {
        Date expectedDate = new Date(1603968697);
        Calendar mockedCalendar = mock(Calendar.class);
        when(mockedCalendar.today()).thenReturn(expectedDate);
        Printer mockedPrinter = mock(Printer.class);
        PrintDate printDate = new PrintDate(mockedCalendar, mockedPrinter);

        printDate.printCurrentDate();

        verify(mockedPrinter).printLine(expectedDate.toString());
    }

    @Test
    public void checkPrintLineIsCalledWithoutMockito() throws Exception {
        Date expectedDate = new Date(1603968697);

        FakePrinter fakePrinter = new FakePrinter();
        Calendar fakeCalendar = new FakeCalendar(expectedDate);
        PrintDate printDate = new PrintDate(fakeCalendar, fakePrinter);

        printDate.printCurrentDate();

        assertEquals(fakePrinter.printedString, expectedDate.toString());
    }
}
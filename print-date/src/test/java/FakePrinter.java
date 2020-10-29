public class FakePrinter extends Printer {
    public String printedString;

    @Override
    void printLine(String line) {
        super.printLine(line);
        printedString = line;
    }
}

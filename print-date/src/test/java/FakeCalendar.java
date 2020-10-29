import java.util.Date;

public class FakeCalendar extends Calendar {

    Date today;

    public FakeCalendar(Date today) {
        this.today = today;
    }

    @Override
    Date today() {
        return this.today;
    }
}

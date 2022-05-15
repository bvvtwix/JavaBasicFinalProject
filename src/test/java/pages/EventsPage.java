package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class EventsPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'dod_new-event__calendar-icon')]/following::span[1]")
    List<WebElement> eventsDate;
    @FindBy(css = "div.dod_new-events-dropdown span")
    WebElement allEventDropDown;
    @FindBy(css = "div.dod_new-events-dropdown a[title='ДОД']")
    WebElement dod;
    @FindBy(css = "div.dod_new-type__text")
    List<WebElement> dodEventsList;

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public void validateEventDates() throws ParseException {

        Calendar currentDate = Calendar.getInstance();
        Calendar event = Calendar.getInstance();
        Locale locale = new Locale("ru");
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM", locale);

        for (WebElement eventDate : eventsDate) {
            event.setTime(formatter.parse(eventDate.getText().toUpperCase(Locale.ROOT)));
            event.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
//            System.out.println(String.format("cur: %s - event: %s", currentDate.getTime(), calendar.getTime()));
            Assert.assertTrue("current date > event date", currentDate.get(Calendar.DATE) <= event.get(Calendar.DATE)
                    && currentDate.get(Calendar.MONTH) <= event.get(Calendar.MONTH));
        }

    }

    public EventsPage sortByDod() {
        allEventDropDown.click();
        dod.click();
        return this;
    }

    public EventsPage checkDodEventsType() {

        for (WebElement dodEvent : dodEventsList) {
            Assert.assertEquals("Мероприятие не ДОД", "День открытых дверей", dodEvent.getText());
        }
        return this;
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='categories_id']//a[contains(@title, 'Тестирование')]")
    WebElement courses;
    @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(text(), 'События')]")
    WebElement events;
    @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[contains(text(), 'Календарь мероприятий')]")
    WebElement eventsCalendar;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public TestingCoursesPage openTestingCourses() {
        courses.click();
        return new TestingCoursesPage(driver);
    }

    public MainPage openOtusMainPage() {
        driver.get(cfg.urlOtus());
        return this;
    }

    public EventsPage openEvensPage() {
        events.click();
        eventsCalendar.click();
        return new EventsPage(driver);
    }

}

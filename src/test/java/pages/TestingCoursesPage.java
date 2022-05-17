package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TestingCoursesPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'lessons__new-item')]")
    List<WebElement> coursesCards;
    @FindBy(xpath = "//div[@class='lessons']/a[contains(@href, 'java-qa-pro')]")
    WebElement javaPro;

    public TestingCoursesPage(WebDriver driver) {
        super(driver);
    }

    public void checkCoursesCount() {
        Assert.assertEquals("Количество курсов по тестированию не соответствует ожидаемому",11, coursesCards.size());
    }

    public CourseCardPage openCourseCard() {
        javaPro.click();
        return new CourseCardPage(driver);
    }

    public void openAllCourseCards() {
        for (WebElement card : coursesCards) {
            card.click();
            new CourseCardPage(driver).checkCourseInfo();
            driver.navigate().back();
        }
    }
}

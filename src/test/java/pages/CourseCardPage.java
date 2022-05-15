package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseCardPage extends BasePage {

    @FindBy(xpath = "//div[@class='course-header2__title']")
    WebElement courseName;
    @FindBy(css = ".course-header2__subtitle")
    WebElement discription;
    @FindBy(css = "p.course-header2-bottom__item-text")
    List<WebElement> courseParams;

    public CourseCardPage(WebDriver driver) {
        super(driver);
    }

    public void checkCourseInfo() {
        Assert.assertTrue("Отсутствует название курса", courseName.getText().length() > 0);
        Assert.assertTrue("Отсутствует описание курса", discription.getText().length() > 0);

        for (WebElement param : courseParams) {
            Assert.assertTrue("Отсутствует параметр курса", param.getText().length() > 0);
        }
    }
}

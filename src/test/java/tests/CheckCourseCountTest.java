package tests;

import org.junit.Ignore;
import org.junit.Test;
import pages.MainPage;

import java.text.ParseException;

public class CheckCourseCountTest extends BaseTest {

        @Test
        public void сheckCourseCountInTestingTab() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage()
                    .openTestingCourses()
                    .checkCoursesCount();
        }

        @Test
        public void checkCourseCard() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage()
                    .openTestingCourses()
                    .openCourseCard()
                    .checkCourseInfo();
        }

        @Ignore
        public void checkAllCourseCards() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage()
                    .openTestingCourses()
                    .openAllCourseCards();
        }

        @Test
        public void eventsDateValidation() throws ParseException {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage()
                    .openEvensPage()
                    .validateEventDates();
        }

        @Test
        public void checkSortEventByDOD() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage()
                    .openEvensPage()
                    .sortByDod()
                    .checkDodEventsType();
        }

}


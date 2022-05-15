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
                    .openOtusMainPage(cfg.urlOtus())
                    .openTestingCourses()
                    .checkCoursesCount();
        }

        @Test
        public void checkCourseCard() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage(cfg.urlOtus())
                    .openTestingCourses()
                    .openCourseCard()
                    .checkCourseInfo();
        }

        @Ignore
        public void checkAllCourseCards() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage(cfg.urlOtus())
                    .openTestingCourses()
                    .openAllCourseCards();
        }

        @Test
        public void eventsDateValidation() throws ParseException {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage(cfg.urlOtus())
                    .openEvensPage()
                    .validateEventDates();
        }

        @Test
        public void checkSortEventByDOD() {
            initDriver();
            new MainPage(driver)
                    .openOtusMainPage(cfg.urlOtus())
                    .openEvensPage()
                    .sortByDod()
                    .checkDodEventsType();
        }

}


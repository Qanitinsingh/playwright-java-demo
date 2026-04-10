package pages.methods;

import pages.objects.HomePageObjects;
import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.steps.Hooks;

public class HomePageMethods {

    private static final Logger logger = LoggerFactory.getLogger(HomePageMethods.class);
    public static final Page page = Hooks.getPage();

    // =========================
    // Common Utility
    // =========================
    public static Locator getLocator(String selector) {
        return page.locator(selector);
    }

    public static Locator getFrameLocator(String frameSelector, String selector) {
        return page.frameLocator(frameSelector).locator(selector);
    }

    // =========================
    // Navigation
    // =========================
    public static void launchBrowser(String url) {
        try {
            page.navigate(url);
            logger.info("Navigated to URL: {}", url);
        } catch (Exception e) {
            logger.error("Failed to navigate to URL: {}", url, e);
            throw e;
        }
    }

    // =========================
    // Menu Actions
    // =========================
    public static void clickNoviceLink() {
        try {
            getLocator(HomePageObjects.NOVICE_LINK).click();
            logger.info("Clicked on Novice link");
        } catch (Exception e) {
            logger.error("Failed to click Novice link", e);
            throw e;
        }
    }

    public static void clickPracticeForm() {
        try {
            getLocator(HomePageObjects.PRACTICE_FORM_LINK).click();
            logger.info("Clicked on Practice Form link");
        } catch (Exception e) {
            logger.error("Failed to click Practice Form link", e);
            throw e;
        }
    }

    public static void clickBasicForm() {
        try {
            getLocator(HomePageObjects.BASIC_FORM_LINK).click();
            logger.info("Clicked on Basic Form link");
        } catch (Exception e) {
            logger.error("Failed to click Basic Form link", e);
            throw e;
        }
    }

    // =========================
    // Iframe Handling
    // =========================
    public static FrameLocator switchToIframe() {
        try {
            FrameLocator frame = page.frameLocator(HomePageObjects.CONTENT_IFRAME);
            logger.info("Switched to iframe: {}", HomePageObjects.CONTENT_IFRAME);
            return frame;
        } catch (Exception e) {
            logger.error("Failed to switch to iframe", e);
            throw e;
        }
    }

    // =========================
    // Form Actions
    // =========================
    public static void enterUsername(String username) {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.USERNAME_FIELD)
                    .fill(username);
            logger.info("Entered username: {}", username);
        } catch (Exception e) {
            logger.error("Failed to enter username", e);
            throw e;
        }
    }

    public static void enterPassword(String password) {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.PASSWORD_FIELD)
                    .fill(password);
            logger.info("Entered password");
        } catch (Exception e) {
            logger.error("Failed to enter password", e);
            throw e;
        }
    }

    public static void enterComments(String comments) {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.COMMENTS_FIELD)
                    .fill(comments);
            logger.info("Entered comments");
        } catch (Exception e) {
            logger.error("Failed to enter comments", e);
            throw e;
        }
    }

    public static void selectGender() {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.GENDER_MALE)
                    .click();
            logger.info("Selected gender: Male");
        } catch (Exception e) {
            logger.error("Failed to select gender", e);
            throw e;
        }
    }

    public static void selectSkills() {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.SKILLS)
                    .click();
            logger.info("Selected skills");
        } catch (Exception e) {
            logger.error("Failed to select skills", e);
            throw e;
        }
    }

    public static void selectExperience(String experience) {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.EXPERIENCE)
                    .selectOption(experience);
            logger.info("Selected experience: {}", experience);
        } catch (Exception e) {
            logger.error("Failed to select experience", e);
            throw e;
        }
    }

    public static void selectAutomationTools(String... tools) {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.AUTOMATION_TOOLS)
                    .selectOption(tools);
            logger.info("Selected automation tools");
        } catch (Exception e) {
            logger.error("Failed to select automation tools", e);
            throw e;
        }
    }

    public static void uploadResume(String filePath) {
        try {
         //   getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.CHOOSE_FILE)
          //          .setInputFiles(filePath);
            logger.info("Uploaded resume from: {}", filePath);
        } catch (Exception e) {
            logger.error("Failed to upload resume", e);
            throw e;
        }
    }

    public static void clickSubmit() {
        try {
            getFrameLocator(HomePageObjects.CONTENT_IFRAME, HomePageObjects.SUBMIT_BUTTON)
                    .click();
            logger.info("Clicked on Submit button");
        } catch (Exception e) {
            logger.error("Failed to click Submit button", e);
            throw e;
        }
    }
}
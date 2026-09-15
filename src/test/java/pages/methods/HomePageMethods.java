package pages.methods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HomePageMethods {

    final static Logger logger = LoggerFactory.getLogger(HomePageMethods.class);

    public static void launchBrowserAndNavigateToHomePage(Page page , String url) {
        try {
            page.navigate(url);
           logger.info("Launching browser and navigating to home page..." + url);
        }
        catch (Exception e) {
            logger.error("Error launching browser and navigating to home page: " + e.getMessage());
            throw e; // Rethrow the exception to ensure the test fails
        }
    }

    public static void verifyLeftSidebarMenuItemsOneByOne(Page page) {
        try {

            logger.info("Verifying left sidebar menu items one by one....");

            Locator menuItems = page.locator(".nav-sidebar li");

            int count = menuItems.count();

            logger.info("Total left sidebar menu items found: {}", count);

            for (int i = 0; i < count; i++) {

                Locator menuItem = menuItems.nth(i);

                String menuName = menuItem.innerText().trim();

                logger.info("Clicking menu item {}: {}", i + 1, menuName);

                menuItem.click();

                logger.info("Successfully clicked menu item: {}", menuName);
            }

        } catch (Exception e) {

            logger.error(
                    "Error verifying left sidebar menu items one by one: {}",
                    e.getMessage(),
                    e
            );

            throw e;
        }
    }

    public static void closeBrowser(Page page) {
        try {
            page.close();
            logger.info("Closing browser...");
        }
        catch (Exception e) {
            logger.error("Error closing browser: " + e.getMessage());
            throw e; // Rethrow the exception to ensure the test fails
        }
    }
}

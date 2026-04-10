package pages.steps;

import com.microsoft.playwright.*;
import io.cucumber.java.*;

public class Hooks {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    @Before
    public void setup() {

        playwright.set(Playwright.create());

        browser.set(
                playwright.get().chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                )
        );

        context.set(
                browser.get().newContext(
                        new Browser.NewContextOptions().setViewportSize(1920, 1080)
                )
        );

        page.set(context.get().newPage());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }

        if (context.get() != null) context.get().close();
        if (browser.get() != null) browser.get().close();
        if (playwright.get() != null) playwright.get().close();
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            String fileName = scenario.getName().replaceAll(" ", "_") + ".png";
            String filePath = System.getProperty("user.dir") + "/Screenshots/" + fileName;

            page.get().screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(java.nio.file.Paths.get(filePath))
                            .setFullPage(true)
            );

            // Optional: attach to report also
            byte[] screenshot = page.get().screenshot();
            scenario.attach(screenshot, "image/png", scenario.getName());

            System.out.println("Screenshot saved at: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
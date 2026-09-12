# Playwright Java Demo

This project demonstrates browser automation using Playwright with Java and Cucumber BDD. It is designed to test real web UIs such as the QA Automation Labs practice site and keeps the browser session reusable across a scenario.

## Tech stack
- Java 17
- Maven
- Playwright Java
- Cucumber JVM
- TestNG
- ChainTest reporting

## Project structure
- `src/test/java/pages/steps/Hooks.java` - browser and page lifecycle
- `src/test/java/pages/steps/...` - step definitions
- `src/test/java/pages/...` - page object classes
- `src/test/resources/Features/` - feature files
- `src/test/resources/chaintest.properties` - report configuration

## Setup
```bash
git clone https://github.com/Qanitinsingh/playwright-java-demo.git
cd playwright-java-demo
mvn clean install
```

## Run tests
```bash
mvn test
```

To run a specific feature or tag, update the Cucumber options in the runner class or pass a tag filter through Maven.

## Best-practice pattern used
The project follows a single-session approach:
- one browser session is launched in `Hooks`
- the same `Page` object is shared through `Hooks.getPage()`
- page classes accept `Page` via constructor
- actions are performed on the same page instance across the scenario

This avoids opening a new browser session for each menu click or step.

## Example feature flow
```gherkin
Feature: Left sidebar navigation

  Background:
   Given the user opens the "https://testing.qaautomationlabs.com/index.php" page
   And the left sidebar is visible

  Scenario: User clicks each left-side menu item in one browser session
   Then the user verifies all left-sidebar menu items in this order:
     | menu_name | page_path | title_contains |
     | Home      | index.php | UI Automation  |
     | Checkbox  | checkbox.php | Checkbox |
```

## Reporting
The project generates ChainTest HTML reports under the `ExtentReports` folder.

## Notes
- This repo currently uses the `master` branch naming convention for the remote repository.
- If you are working with a GitHub repo that uses `main`, rename the target branch accordingly before pushing.

## License
This project is for demonstration and learning purposes and follows the repository's existing licensing setup.
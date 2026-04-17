# Playwright Java Demo

## Overview
This repository provides a demonstration of using Playwright with Java for automated testing of web applications. It aims to showcase how Playwright can be leveraged to create robust and efficient test scripts that run on multiple browsers.

## Features
- Cross-browser testing (Chromium, Firefox, WebKit)
- Support for parallel test execution
- Easy setup and configuration
- Detailed reporting on test results

## Installation Instructions
1. **Clone the repository:**  
   ```bash
   git clone https://github.com/Qanitinsingh/playwright-java-demo.git
   ```
2. **Navigate to the project directory:**  
   ```bash
   cd playwright-java-demo
   ```
3. **Set up the project dependencies:**  
   This project uses Maven for dependency management. Run:  
   ```bash
   mvn install
   ```

## Running Tests
To run the tests, execute the following command in the project directory:
```bash
mvn test
```

## Example Test Code
Here's a simple example of a test written in Java using Playwright:
```java
import com.microsoft.playwright.*;
import static org.testng.Assert.*;

public class ExampleTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://example.com");
            assertEquals(page.title(), "Example Domain");
            browser.close();
        }
    }
}
```  

## Contributing Guidelines
Contributions are welcome! Please follow these steps to contribute:
1. Fork this repository.
2. Create a new feature branch:  
   ```bash
   git checkout -b my-feature-branch
   ```
3. Make your changes and commit them:  
   ```bash
   git commit -m "Add my feature"
   ```
4. Push to the branch:  
   ```bash
   git push origin my-feature-branch
   ```
5. Create a pull request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
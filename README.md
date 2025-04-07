# 🚀 Project: Automation Testing Suite

This project is a set of automated tests for the
[Automation Exercise](https://www.automationexercise.com) platform, designed to validate different functionalities
of the website using **Selenium + TestNG** and applying the **Page Object Model (POM)** pattern.

---

## 📌 Main Features

- ✅ **Page Object Model (POM)**: Modular and maintainable architecture.
- ✅ **Data-Driven Testing**: Uses **Excel** and **JSON** files for injecting test data.
- ✅ **Execution Parameters**: Supports different browsers and **headless** execution.
- ✅ **Detailed Logs**: Clear logging using `info` and `debug` levels.
- ✅ **Test Suites Execution**: Includes regression test suite.
- ⚠️ **Session Persistence via Cookies**: Cookie persistence was explored, but due to the `HttpOnly` flag, manipulation
  is not possible through code. The attempted implementation is commented in the code for future reference.

---

## 📂 Project Structure

```
📦 ProjectPageObjectModel
 ┣ 📂 .github
 ┃ ┗ 📂 workflows         # GitHub Actions workflow file 
 ┣ 📂 scripts
 ┃ ┣ run_suite.sh         # Executes tests via Maven and Generates Allure report
 ┃ ┗ run_allure.sh        # Generates Allure Report at Local Serve
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┗ 📂 resources       # General configuration files (e.g., config.properties) 
 ┃ ┣ 📂 test
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📂 automation
 ┃ ┃ ┃ ┃ ┣ 📂 cases       # Test cases grouped by feature
 ┃ ┃ ┃ ┣ 📂 pages         # Page Object classes
 ┃ ┃ ┃ ┣ 📂 data          # JSON and Excel data readers
 ┃ ┃ ┃ ┣ 📂 models        # Data classes (POJOs)
 ┃ ┃ ┃ ┗ 📂 utilities     # BasePage, driver setup, flows, logs
 ┃ ┃ ┣ 📂 resources       # Archivos como reportes, allure-results, etc.
 ┃ ┃ ┃ ┗ 📂 data          # JSON for login and Excel for test inputs
 ┣ 📜 pom.xml             # Maven project configuration and dependencies
```

---

## ⚙️ Installation & Setup

### 🔹 Prerequisites

- Java 17+
- Maven
- Selenium WebDriver
- TestNG
- Chrome, Edge, or any compatible browser

### 🔹 Installation

```bash
# Clone the repository
$ git clone https://github.com/JosKavi33/selenium-testng-pom.git
$ cd selenium-testng-pom

# Install dependencies
$ mvn clean install
```

---

## 🧪 Run the test suite

```bash
./scripts/run_suite.sh
```

🛠️ This script compiles the project, runs the tests, and generates the report in target/site/allure-maven-plugin.

## 📊 View the Allure report on-premises

```bash
./scripts/run_allure.sh
```

🌐 This will automatically open the report in your default browser

---

## 🚀 Running the Tests

### 🔹 Run all tests

```sh
mvn test
```

### 🔹 Run in a specific browser (e.g., Edge)

```sh
mvn test -Dbrowser=Edge
```

### 🔹 Run in headless mode

```sh
mvn test -Dheadless=true
```

### 🔹 Run group regression suite

```sh
mvn test -Dgroup=regression
```

---

## 🧪 Tested Functionalities

### 🔹🔐 Authentication

✅ User registration
✅ Login
⚠️ Cookies are not used due to HttpOnly — check commented code for reference

### 🔹🛒 Shopping Cart

✅ Add and remove products
✅ Validate prices and quantities
✅ Verify empty cart status

### 🔹🛍️ Products

✅ Validate product info
✅ Check product details
✅ Compare prices against Excel data

### 🔹📨 Contact & Reviews

✅ Submit contact forms
✅ Submit and validate product reviews

---

## ✨ Contributing

Contributions are welcome!
Fork the repo, create a new branch, and open a **pull request** 🚀

---

## 📄 License

MIT License — You are free to use, modify, and distribute this code. 🚀

---

🧠 Additional Notes

If using cookies or local storage in the future, make sure to review security restrictions such as HttpOnly, Secure, and
CORS policies.

This project was mainly tested on Chromium-based browsers (Chrome/Edge).

---

## 👤 Author

Developed and maintained by **Jose Cabrejo Villar**.



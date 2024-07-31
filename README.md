# The Retail Store Discounts

This project is a Java Spring Boot application that calculates the net payable amount on a bill, considering various
discount rules. The discount rules include percentage-based discounts for employees, affiliates, and customers have
membership duration over 2 years, as well as amount-based discounts.

## Features

- Calculates different types of discounts based on user type and bill amount.
- Applies percentage-based discounts for employees, affiliates, and loyal customers.
- Applies amount-based discounts (5$) for every $100 spent.
- Ensures percentage-based discounts do not apply to groceries.
- Allows only one percentage-based discount per bill.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ahmed-sayed/retail-website.git
    cd retail-website
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

### Unified Modeling Language (UML) class diagram
 you can find the 'UML' class diagram under path [**src/main/resources/UML/Retail Store UML.png**](src/main/resources/UML/Retail Store UML.png)
 

### Running the Application
To run the application, use the following command:

```bash
mvn spring-boot:run
```

### Running Tests

To run the tests, use the following command:
```bash
mvn test
```

### Generating Coverage Reports

This project uses the Jacoco plugin to generate test coverage reports. To generate the coverage report, run:```bash

```bash
mvn clean test
mvn jacoco:report
```

After running these commands, you can find the coverage report in the target/site/jacoco directory. Open index.html in a browser to view the coverage details, or after you run the command you can find generated reports under path [**index.html**](htmlReport/index.html)


## Running SonarQube Analysis

### Prerequisites

- [SonarQube Server](https://www.sonarqube.org/downloads/) installed and running.
- SonarQube Scanner for Maven configured in your `pom.xml`.

### Configure SonarQube
- Add Correct SonarQube properties to your pom.xml in the `properties` section




### Run SonarQube Analysis and Code quality summary Reports

Execute the following Maven command to perform the analysis and send the results to the SonarQube server:

```bash
mvn clean verify sonar:sonar
```
or 
```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=<your_project_key> \
  -Dsonar.projectName=<your_project_Name> \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=<your_project_token>
```

- clean: Cleans the project.
- verify: Runs the build lifecycle and tests.
- sonar:sonar: Runs SonarQube analysis.

### View SonarQube Reports
- Open your SonarQube dashboard at http://localhost:9000.
- Navigate to your project to view the quality summary, and look for your project. You’ll find detailed quality reports including: 
   - **Code Smells**: Issues related to code maintainability.
   - **Bugs**: Potential issues that could lead to incorrect behavior.
   - **Vulnerabilities**: Security risks in the code.
   - **Coverage**: Test coverage information.
   - **Technical Debt**: Estimated effort required to fix issues.
   

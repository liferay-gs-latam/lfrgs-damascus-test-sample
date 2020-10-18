**This project delivers to you a complete lean test architecture for your web functional/service/unit tests using the best frameworks and practices.**

## Languages and Frameworks

This project using the following languages and frameworks:

* [Damascus](https://github.com/yasuflatland-lf/damascus) Liferay Blade tool extension for generating scaffoldings of Service builder portlet with CRUD functionality
* [Java 11](https://openjdk.java.net/projects/jdk/11/) as the programming language
* [Seleium WebDriver](https://www.selenium.dev/) as the web browser automation framework using the Java binding
* [JavaFaker](https://github.com/DiUS/java-faker) as the faker data generation strategy
* [Liferay - frwSeleniumCommons](https://github.com/manoelcyreno/selenium-commons) as the Selenium binaries management
* [Lombok](https://projectlombok.org/) to minimize the boilerplate in the Java code

## Test Projects
* Functional Testing - [Link](https://github.com/liferay-gs-latam/lfrgs-damascus-test-sample/tree/dev/modules/test/functional-test-tdd)
* Service Testing - [(Link 1 - Test Class)](https://github.com/liferay-gs-latam/lfrgs-damascus-test-sample/tree/dev/modules/test/services-test) || [(Link 2 - Client Class)](https://github.com/liferay-gs-latam/lfrgs-damascus-test-sample/tree/dev/modules/todo/todo-service/src/test/java/com/liferay/damascus/service/test)
* Unit Testing - [Link](https://github.com/liferay-gs-latam/lfrgs-damascus-test-sample/tree/dev/modules/todo/todo-service/src/test/java/com/liferay/damascus/unit)

## How the project is structured:
* Functional Testing
> Unique module project was created;
>> Structered: Constants | Model | Pages | Suite | Tests | CommonMethods (base class)<br />
>> Patterns: Page Object | Data Factory

* Service Testing
> The strategy is to create a project where we need to divid in two parts
>> In test module: package to create the tests <br />
>> In microservice module: local where was create client module that contains (client | model | utils) <br />

* Unit Testing
> Its part of the microservice module. To unit testing, the best strategy is to use that into the each microservice module.

To be continue...

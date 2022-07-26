
## Keyword Driven Framework
A Keyword Driven Framework has all operations and instructions written in an external Excel file.

The basic working of the Keyword Driven Framework is to divide the Test Case into four or five different parts depending on your preference

1. Test Step: Small description of the Test Step

2. Locator name: Name of the locator like id, className etc

3. Locator value: Value of the identifier

4. Action: Name of the action such as click, getText, sendkeys etc.

5. Value: Data to be entered like Admin as username

### List of components

Below is the list of common components that you would required to achieve the task:

1. Excel Sheet: This keeps most of the data for Keyword Driven which is needed for the test like parts mentioned above

2. Base Java Class: Browser initialization goes here
3. Properties Class:  Properties file initialization goes here

4. Tests.java: To run tests using testng

5. Config.properties: browser name, url, username, password) in case excel file does not have them

6. Execution Engine: It contains all the code to drive the test from Excel sheet, Function Lib and Properties file.

Let just understand this concept with the help of the framework I have created for the demo of Open MRS application.

### Workflow

Consider that you have to automate a flow where you would need to do the following things:

1. Open a Browser

2. Navigate to URL

3. Enter Username

4. Enter Password

5. Click on LogIn button

6. Verify Login Successful

7. Select Location

8. Get Homepage header text

9. Close the Browser


Step1: To design a KDF, first identify all the actions to be performed. 
 
Step 2: Once all actions are identified, the next step is to map them in an excel sheet
![excelFile](https://user-images.githubusercontent.com/46183736/180224472-ffdbe3b5-2e8d-446e-84c0-268aa9841036.PNG)

Step 3: After that, create a project in IDE and all the dependencies in pom.xml file

![folder hierarchy](https://user-images.githubusercontent.com/46183736/180224566-360c83b3-5366-4fd3-8a38-caabb59d5148.PNG)

Step 4: Place created excel file under a new package

Step 5: Create config.properties, a base file(for browser and properties initialization),  KeywordEngine(containing the implementation of keywords and test cases) and a testNG class to for the execution of test cases. Place all of them in separate packages


### Built with
- Selenium
- TestNG
- Maven
- Java SE 11+
- Intellij IDEA
- Excel File

## Install Locally
- Clone this repository to your local computer using git clone 
- Install Java Development Kit - Set your JAVA_HOME environment variable to point to Java folder and add the JDK's bin folder to your path environment variable.
- Install Maven - add Maven's bin folder to your path environment variable.

## Verify the Installations 
Confirm installations and paths are setup in a terminal

# Maven
```sh
mvn -v
```

# Java
```sh
java -version
```

## How to run the project

1. Open folder in Intellij IDEA
2. Navigate to POM.xml file, right click and click reload
3. Navigate to Tests.java inside src/test/java/com/qa/mrs/keyword/tests/Tests.java
4. Run the file

There are many approaches to implement keyword driven framework but I have chosen this one.


Feel free to reach out on https://www.linkedin.com/in/javeria-nadeem-664375188/

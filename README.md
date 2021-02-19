# QA-Final-Project

Test Cases for Automation:

➔	Test Case 1: Sign up for Yahoo Finance - negative

1.	Go to https://finance.yahoo.com/
2.	Click on ‘Sign In’ button
3.	Click on ‘Create an account’ button
4.	Populate invalid data for all of the fields and press Continue (Prepare 2 sets of negative test data)
5.	Verify all errors messages for each field (as it is shown on the photo)

 


➔	Test Case 2: Check statistics for a company stock

1.	Go to https://finance.yahoo.com/
2.	In the search field, type a name of a company e.g. Apple (The names of the companies had to be provided by csv file)
3.	Select the typed company -> The Summary tab for the company is opened
4.	Verify the company Dividends rate - if the field “Forward Dividend & Yield” contains N/A then the company is not giving Dividends. For the test you have to use 2 companies (Apple and Amazon). The data for the dividend rate has to be provided in the csv file together with the name of the company. Example:
           Amazon, N/A (N/A)
           Apple, 0.82 (0.76%)

5.	Open “Statistics” tab
6.	Take the Current value for “Price/Book (mrq)” - you have to write xpath that is combining the name of the column “Current” and the name of the row “Price/Book” in it. Then compare the value with expected data also included in the csv file: 20.52 for Amazon and 25.61 for Apple

 


Requirements for the project:

1.	Page Object Model (POM) is used for designing the classes
2.	Your project has to support 2 browsers (Firefox and Chrome)
3.	The selected browser and the URL are provided by configuration file
4.	Driver is quit after the execution of each test
5.	Each Test case is implemented in separate classes
6.	Both tests are executed in parallel
7.	The test data is stored in a csv file and provided by Data Provider to the test.
8.	The tests should be executed in Jenkins. A Jenkins job is created for the execution.
9.	Should demonstrate at least one type of Wait principle in the project

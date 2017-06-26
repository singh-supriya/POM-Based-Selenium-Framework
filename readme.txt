---------------------------------
Command Line Arguments
---------------------------------
1. Navigate to the location where project is been placed
2. Write the command
ant run-tests-by-pattern -Dpattern=File Name to be executed
for ex: ant run-tests-by-pattern -Dpattern=ValidatePostAddFlow
and press enter

This command will execute the script

----------------------------------
Framework Structure
----------------------------------
src:

1. src.utils: Contains following files
a) DriverHelper: Contains the method of driver
b) DriverTestCase: Contains the afterclass, beforeclass methods. Also the methods being called in scripts directly
c) Log: Is used to add the logs in the script
d) PropertyReader: To perform the various operations in .properties file

2. src.pages: Contains Helper files
a) The helper pages extends the Driver helper
b) Webelements are being created using selenium's FindBy method
c) As the framework is using POM, each method is returning reference of a page

3. src.test: Contains the script file
a) In the script file, reading all the required test data from the properties file
b) The first method being called is loginSetUp() from driver test case that returns the object reference of the home page
c) The rest of the function is being called by passing the reference 

config:
Contains the .xml of the class file created

resources:
contains the .properties file
a) application.properties: Contains the URL of the application
b) testData.properties: Contains all the test data being used in the test


build.xml:
This file is to support Ant with the framework

log4j.xml:
It is used to support the log function in the test

logfile.log:
This contains the log statement being added in the script

Reports:
Reports -> html -> index.html
Contains the generated report that includes all the pass, fail and skip results

libs:
Contains the libraries being used in the framework

---------------------------------------------------
libraries to be included
---------------------------------------------------

selenium-server-standalone-2.53.0.jar
testng-5.14.1.jar
reportng-1.1.2.jar
log4j-1.2.17.jar
velocity-dep-1.4.jar
jcommander.jar


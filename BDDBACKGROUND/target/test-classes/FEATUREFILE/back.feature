Feature: 	Login Functionality

Background: Login 

Given I load the url "https://opensource-demo.orangehrmlive.com/"
Then I enter the username and password into the respective field
|username|password|
|Admin|admin123|
Then I click the login button

Scenario: Validating Dashboard text in the homepage
Then I Validate the text equals to "Dashboard" for the element "//h1"
Then I logout of the homepage

Scenario: Validating Admin text in  homepage
Then I Validate the text equals to "Admin" for the element "//b[contains(text(),'Admin')]"

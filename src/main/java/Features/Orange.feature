@FunctionalTest
Feature: Orange Login feature

@Smoke
Scenario: Orange Login Test
Given user is already on the login page
When tiltle of the login page is verified
Then User enters the username and passowrd
And User clicks on login button
And User is on the home page

@Regression
Scenario: Orange Login Test
Given user is already on the login page
When tiltle of the login page is verified
Then User enters the "Admin" and "admin123"
And User clicks on login button
And User is on the home page

@E2E
Scenario Outline: Orange Login Test
Given user is already on the login page
When tiltle of the login page is verified
Then User enters the "<username>" and "<password>"
And User clicks on login button
And User is on the home page

Examples:
				| username | password |
				| Admin    | admin123 |
				
				
				
				
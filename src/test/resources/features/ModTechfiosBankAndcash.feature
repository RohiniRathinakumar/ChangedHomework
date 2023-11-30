Feature: Techfios Other billing login page functionality validation

 Background: 
    Given User is on the techfios login page
@Regression1
Scenario Outline: User should be able to login with valid credentials 
	and open a new account	
	When User enters "<username>" in the "username" field
	When User enters "<password>" in the "password" field
	When User clicks on "login"
	Then User should land on Dashboard page. 
	And User clicks on "bankCash"
	And User clicks on "newAccount"
	And User enters "<accountTitle>" in the "accountTitle" field in accounts page 
	And User enters "<description>" in the "description" field in accounts page 
	And User enters "<initialBalance>" in the "initialBalance" field in accounts page  
	And User enters "<accountNumber>" in the "accountNumber" field in accounts page 
	And User enters "<contactPerson>" in the "contactPerson" field in accounts page 
	And User enters "<Phone>" in the "Phone" field in accounts page   
	And User enters "<internetBankingURL>" in the "internetBankingURL" field in accounts page  
	And User clicks on "submit"
	Then User should be able to validate Account Created Successfully.
	Examples: 
	|username|password||login|bankCash|newAccount|submit||accountTitle|description|initialBalance|accountNumber|contactPerson|Phone|internetBankingURL|
	|demo@techfios.com|abc123||login|bankCash|newAccount|submit||Rohini's Account|Savings Acc|$500000|67778432323|Rathinakumar|545332211|https://www.google.com/|
	
	
	
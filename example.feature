Feature: To Validate Product Management portal


Scenario Outline: Validate the Project are loaded when user selected "<project>"
    When user navigates to project tab under global administration
    And user search for the project "<project>"
    Then project details should be displayed
    
 Examples:
 |project|
 |Test|
 
 
 Scenario Outline: Validate the Project Mapping page loaded
    When user navigates to project mapping tab under global administration
    And user search for the project mapping with PnbOrg-"<pnbOrg>",SubPnbOrg-"<subPnbOrg>",ProductCategory-"<productCategory>" and Program as "<program>"
    Then project mapping details should be displayed
    
 Examples:
 |pnbOrg|subPnbOrg|productCategory|program|
 |Test|test|test|test|
 
 
 Scenario Outline: Validate the Data Utilities are loaded when user selected "<utilities>"
    When user navigates to data utilities tab under global administration
    And user search for the data utilities "<utilities>"
    Then data utilities details should be displayed
    
 Examples:
 |utilities|
 |Test|
 
 
 Scenario: Validate the Financials page loaded
    When user navigates to financials tab under global administration
    Then Financials page should be loaded
    
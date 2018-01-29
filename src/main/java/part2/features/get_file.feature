@dvlatest
Feature: Vehicle and Driver Data information  

Scenario: Get vehicle information from DVLA

Given Open the browser with the provided link 

When Vehicle registration data is read from spreadsheet and stored in a List

Then Vehicle information from DVLA is asserted against each item in the List



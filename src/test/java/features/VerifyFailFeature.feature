@Fail
Feature: Verify the Scenarios that will fail

  Scenario: Verify the Heading of the Home Page
    Given User navigates to website URL
    Then Verify heading of the Home Page should be "ArcGIS"

  Scenario: Verify Logo is displayed on the Home Page
    Given User navigates to website URL
    Then Verify Logo should be displayed on the Home Page
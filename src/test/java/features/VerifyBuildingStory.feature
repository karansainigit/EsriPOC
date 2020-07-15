@Story
Feature: Verify Building New Story

  Scenario: Verify Building Story with some text, image and map
    Given User navigates to website URL and clicks on Sign In
    And User Sign In using his credentials
    When User clicks on New Story
    And User Enters title of the story "Esri POC" and optional text "Text/Image/Map"
    And User add image for the story cover
    And User enters some text as Heading for the story "Demo Text: Heading to my story"
    And User choose any image for the story
    And User choose Living Atlas map "Watson Media" for the story
    Then Verify Story "Esri POC" is created successfully by going to My Stories
    And User Sign Out from account

  Scenario: Verify by Sign In again and deleting story
    Given User navigates to website URL and clicks on Sign In
    And User Sign In using his credentials
    Then Verify Story "Esri POC" is already present
    And Delete the Story and verify its successfully deleted
    And User Sign Out from account
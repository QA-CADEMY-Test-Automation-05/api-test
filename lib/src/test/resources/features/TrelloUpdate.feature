Feature: Update Board

  Background: Create Board
    Given I have the endpoint "/1/boards"
    And I have a body "{\"name\" : \"Create from Cucumber\" }"
    And I send a "POST"

  Scenario: Update Board
    When I have the endpoint "/1/boards/[id]"
    And I have a body "{\"name\" : \"Updated from Cucumber\" }"
    And I send a "put"
    Then I expect the status code 200

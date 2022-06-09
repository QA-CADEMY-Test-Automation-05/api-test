Feature: test Trello


  Scenario: set a get bords
    Given I have the endpoint "/1/members/me/boards"
    When I send a "get"
    Then I expect the status code 200

  @BoToBeDelete
  Scenario: create a board
    Given I have the endpoint "/1/boards"
    And I have a body "{\"name\" : \"Create from CucumberTBD\" }"
    When I send a "POST"
    Then I expect the status code 200

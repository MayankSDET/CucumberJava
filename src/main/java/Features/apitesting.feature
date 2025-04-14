
Feature: API Testing Feature 
  
  Background:
    Given The base URI is set to "https://api.restful-api.dev/objects"

  Scenario: Create, update, and verify an object
    When I create a new object with payload1
    Then The response status code should be 200
    And The "CPU model" in response should be "Intel Core i9"
    And The "Server" header should be "cloudflare"
    And I store the "id" and "data.price" from the response

    When I update the object using payload2
    Then The response status code should be 200
    And I store the updated "data.price" from the response

    When I retrieve the object by ID
    Then The response status code should be 200
    And The "data.price" in response should match the updated price

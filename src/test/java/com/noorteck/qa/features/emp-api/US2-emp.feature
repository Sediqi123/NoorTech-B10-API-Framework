Feature: Employee API

  Scenario: Get ALL Employee
    * def URL = 'https://hr-scrum.noortecktraining.com/employee/all'
    Given headers {Accept: 'application/json'}
    And url URL
    When method GET
    * print response

  Scenario Outline: Get employee by ID
    * def URL = 'https://hr-scrum.noortecktraining.com/employee/one'
    Given headers {Accept: 'application/json'}
    And params {id:<emp_id>}
    Given url URL
    When method GET
    * print response
    Then status <status>

    Examples: 
      | emp_id | status |
      |    115 |    200 |
      |    116 |    200 |
      |   5879 |    404 |

Feature: to test StudyMate Courses API hitting
  Scenario:
    Given the user is on the Course page
    When the user creates a new Course
    And provides all the information
    Then verify that new Course has been created
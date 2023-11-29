Feature: to test StudyMate Courses API hitting
  @CourseGet
  Scenario: get all the courses on the website
    Given the user is on the Course page
    When the user wants to get all the Courses
    Then verify that all the Courses are shown as a list
Feature: to test StudyMate Courses API hitting
  @CourseTest
  Scenario:
    Given the user is on the Course page
    When the user creates a new Course
    Then verify that new Course has been created
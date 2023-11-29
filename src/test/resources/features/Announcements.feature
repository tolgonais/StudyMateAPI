Feature: to test StudyMate Announcements API hitting
@AnnouncementCreate
  Scenario: Create new announcement
    Given the user is on the Announcement page
    When the user creates a new announcement
    When provides all the information
    Then verify that new announcement has been created.

  @AnnouncementGet
  Scenario: Get all Announcements
    Given the user is on the Announcement page
    When the user wants to retrieve an announcement
    When provides the announcement ID or relevant criteria
    Then verify that the announcement is successfully retrieved.

  @AnnouncementUpdate
  Scenario: Update Announcement
    Given the user is on the Announcement page
    When the user wants to update an existing announcement
    When provides the announcement ID and updated information
    Then verify that the announcement is successfully updated.

  @AnnouncementDelete
  Scenario: Delete Announcement
    Given the user is on the Announcement page
    When the user wants to delete an existing announcement
    And provides the announcement ID or relevant criteria
    Then verify that the announcement is successfully deleted.


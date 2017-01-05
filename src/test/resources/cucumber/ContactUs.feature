@Contact
Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    Then I should be able to contact QAWorks
    And enter "test", "testemail@mailinator.com" and "CONTACT ME" for contact

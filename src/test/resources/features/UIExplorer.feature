################################################################
## Author: Esakkivignesh ##
## Description: Cucumber Feature file for UI Explorer tests ##
################################################################

Feature: UI Explorer Feature

  Background:
    Given I open the site "http://the-internet.herokuapp.com"

    @checkbox
  Scenario: Check and Un-check functionality of checkboxes should be working fine
    Given I click on "Checkboxes" link
    And I got redirected to "checkboxes" page
    When I click checkbox "1"
    Then Checkbox "1" should be "enabled"
    When I click checkbox "2"
    Then Checkbox "2" should be "disabled"

    @textbox
  Scenario: Textbox should only allow numeric characters as input
    Given I click on "Inputs" link
    And I got redirected to "inputs" page
    When I enter text as "hello"
    Then Input textbox should contain ""
    When I enter text as "54321"
    Then Input textbox should contain "54321"



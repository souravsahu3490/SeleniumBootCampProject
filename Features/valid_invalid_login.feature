@Regression @ValidInvalidLogin
Feature: Valid and invalid login validation

  Background:
    Given User is on Amazon landing page
    When He hovers over Hello, Sign in
    And Clicks on Sign in button


  Scenario Outline: Valid login and logout validation
    And Provides the valid email '<email>' in the text box
    And Clicks on the Continue button
    And Provides the valid password '<password>' in the text box
    And Clicks on Login button
    Then He is successfully able to login
    And He hovers over Account and Lists
    And Clicks on Sign Out link
    And Login page appears

    Examples:
      | email                     | password |
      | sourav.sahu5510@gmail.com | XXXXX    |
      | sahu.sourav21@gmail.com   | XXXXX    |


  Scenario Outline: Invalid login validation with invalid email

    And Provides the invalid email '<email>' in the text box
    And Clicks on the Continue button
    Then He gets an error message in the same email page as 'We cannot find an account with that email address'

    Examples:
      | email               |
      | ghefsgwdb@gmail.com |
      | tedmqield@gmail.com |


  Scenario Outline: Invalid login validation with valid email but invalid password

    And Provides the valid email '<email>' in the text box
    And Clicks on the Continue button
    And Provides the invalid password '<password>' in the text box
    And Clicks on Login button
    Then He gets an error message in the same password page as 'Your password is incorrect' or 'To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below'

    Examples:
      | email                     | password       |
      | sourav.sahu5510@gmail.com | testing9875    |
      | sahu.sourav21@gmail.com   | testingpass278 |


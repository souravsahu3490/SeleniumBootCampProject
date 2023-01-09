Feature: Validate URL and page title

  @Regression @URLValidation
  Scenario: Enter the URL as http://amzn.in and check whether the URL is redirected to https://www.amazon.in/ and validate the page title

    Given Browser is opened
    When User enter the URL as 'http://amzn.in'
    Then URL is redirected to 'https://www.amazon.in/'
    And Page title is 'Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in'
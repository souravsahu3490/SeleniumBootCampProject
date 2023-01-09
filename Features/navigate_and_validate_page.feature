Feature: Navigate and validate pages

  @Regression @ValidatePage
  Scenario Outline: Naviagte to a page and verify whether the navigation was successful

    Given Browser is opened
    When User navigates to page '<page_name>' with url as '<url>'
    Then The page '<page_name>' must open without any issue

    Examples:
      | page_name                               | url                                                            |
      | Accounts and Lists - Create a Wish List | https://www.amazon.in/                                         |
      | Amazon Pay                              | https://www.amazonpay.in/                                      |
      | New Releases                            | https://www.amazon.in/gp/new-releases/?ref_=nav_cs_newreleases |
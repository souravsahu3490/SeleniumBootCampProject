Feature: Search for a mobile and add to cart

  @Regression @MobileSearch
  Scenario: Search for a mobile and check customer review, price, delivery and finally add to cart

    Given Browser is opened
    When User navigates to page 'https://www.amazon.in'
    And He searches for 'mi mobile'
    And Validates the results displayed
    And Selects Avg. Customer Review as '4 stars & Up'
    And Selects the first mobile that appears
    And Validates the change in the title, whether it is relevant to the selected mobile
    And Plays the mobile video
    And Validates the mobile price
    And Clicks on 'Select delivery location'
    And Waits for the pop up 'Choose your location' to appear
    And Enters the pincode '700027'
    And Clicks on the Apply button
    And Validates the change in the delivery location, It should display as 'Deliver to city pincode'
#    And Clicks on the sponsored link under Compare with similar items
#    And Verifies that a new window is opened with the mobile details
#    And Navigates to the new window and close it
#    And Navigates back to the previous window
    And Clicks on Add to Cart
    And Waits for the window to be displayed
    Then He validates the 'Added to Cart' message
    And Closes the 'Added to Cart' window
    And Scrolls the page downwards until 'Technical Details' are displayed
Feature: Add a dress with maximum price to cart

  @Test
  Scenario: Register a new customer account and add maximum price dress
    Given I am on the signIn or create account page
    And I create a new customer account
    And I add a dress of highest price to my cart
    And I sign out of my account
    And I am on the signIn or create account page
    And I log back into my account
    Then The dress is not available in my cart
#    Then The dress is available in my cart

  @Test
  Scenario: Sign In Using an existing account and add maximum price dress
      Given I am on the signIn or create account page
      And I login using email devadathpt@gmail.com and password Swaroopa@123
      And I add a dress of highest price to my cart
      And I sign out of my account
      And I am on the signIn or create account page
      And I login using email devadathpt@gmail.com and password Swaroopa@123
      Then The dress is not available in my cart
#      Then The dress is available in my cart





$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/Addcart.feature");
formatter.feature({
  "line": 1,
  "name": "Add a dress with maximum price to cart",
  "description": "",
  "id": "add-a-dress-with-maximum-price-to-cart",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Register a new customer account and add maximum price dress",
  "description": "",
  "id": "add-a-dress-with-maximum-price-to-cart;register-a-new-customer-account-and-add-maximum-price-dress",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on the signIn or create account page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I create a new customer account",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I add a dress of highest price to my cart",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I sign out of my account",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I am on the signIn or create account page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I log back into my account",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "The dress is not available in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "AddCartSteps.iAmOnTheSignInOrCreateAccountPage()"
});
formatter.result({
  "duration": 13098983659,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iCreateANewCustomerAccount()"
});
formatter.result({
  "duration": 7735263410,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iAddADressOfHighestPriceToMyCart()"
});
formatter.result({
  "duration": 29701850244,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iSignOutOfMyAccount()"
});
formatter.result({
  "duration": 4784758838,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iAmOnTheSignInOrCreateAccountPage()"
});
formatter.result({
  "duration": 9437972643,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iLogBackIntoMyAccount()"
});
formatter.result({
  "duration": 1832359453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "is not",
      "offset": 10
    }
  ],
  "location": "AddCartSteps.theDressIsAvailableInMyCart(String)"
});
formatter.result({
  "duration": 3183642616,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#    Then The dress is available in my cart"
    }
  ],
  "line": 15,
  "name": "Sign In Using an existing account and add maximum price dress",
  "description": "",
  "id": "add-a-dress-with-maximum-price-to-cart;sign-in-using-an-existing-account-and-add-maximum-price-dress",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "I am on the signIn or create account page",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I login using email devadathpt@gmail.com and password Swaroopa@123",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I add a dress of highest price to my cart",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I sign out of my account",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I am on the signIn or create account page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "I login using email devadathpt@gmail.com and password Swaroopa@123",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "The dress is not available in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "AddCartSteps.iAmOnTheSignInOrCreateAccountPage()"
});
formatter.result({
  "duration": 9741502515,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devadathpt@gmail.com",
      "offset": 20
    },
    {
      "val": "Swaroopa@123",
      "offset": 54
    }
  ],
  "location": "AddCartSteps.iLoginUsingEmail(String,String)"
});
formatter.result({
  "duration": 1930078018,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iAddADressOfHighestPriceToMyCart()"
});
formatter.result({
  "duration": 28750216804,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iSignOutOfMyAccount()"
});
formatter.result({
  "duration": 4363468360,
  "status": "passed"
});
formatter.match({
  "location": "AddCartSteps.iAmOnTheSignInOrCreateAccountPage()"
});
formatter.result({
  "duration": 8707366585,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "devadathpt@gmail.com",
      "offset": 20
    },
    {
      "val": "Swaroopa@123",
      "offset": 54
    }
  ],
  "location": "AddCartSteps.iLoginUsingEmail(String,String)"
});
formatter.result({
  "duration": 1909564589,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "is not",
      "offset": 10
    }
  ],
  "location": "AddCartSteps.theDressIsAvailableInMyCart(String)"
});
formatter.result({
  "duration": 2766626004,
  "status": "passed"
});
});
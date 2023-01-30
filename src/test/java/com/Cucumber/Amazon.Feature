Feature: it Is An Ecommerce Application To Purchase Products

Scenario: Home Page

Given user Launch The Browser and Application Url
When user Choose The Category From Dropdown
And user Search The Product In The Search Box and Choose The Relevant Product
Then user Click The SearchButton and navigate to Search Product Page

Scenario: Product Page

When user Get The Title and Offer Price Of The First Product
Then user Click On The First Product and Add The Product To The Cart and Click The Cart Icon

Scenario: Add To Cart

When user Verify The First Product Title and Offer Price In Cart Page
Then user Click On Proceed To Buy and Navigate to SignIn Page

Scenario: SignIn Page

When user Take The Screenshot Of The SingIn Page
Then user Close The Current Page and Quite The Browser



Feature: This feature is about booking a flight

  Scenario: Successful flight booking
    Given I am in Home page
      And I select My Account button in Navigation bar
      And I select Sign Up button in Navigation bar
      And I am in Sign Up page
      And I create a new account in Sign Up page
      And I am in My Account page
      And I have an existing account
      And I select User Account button in Navigation bar
      And I click on Logout button
      And I am in Login page
    When I login into existing account
      And I am in My Account page
      And I select Home button in Navigation bar
      And I select FLIGHTS menu in booking section
#      And I select ROUND TRIP flight option
#      And I set FIRST class tickets
#      And I set BARCELONA as arrival airport


#    Given I have an existing account
#    When I login this account
#      And I navigate to Home page
#      And I select FLIGHTS menu in booking section
#      And I select ROUND TRIP flight option
#      And I set FIRST class tickets
#      And I set RIGA as departure airport
#      And I set BARCELONA as arrival airport
#      And I set valid departure date
#      And I set valid return date
#      And I set 2 adults
#      And I set 2 children
#      And I set 1 infant
#      And I search for a flight
#      And I book the first flight offer available
#      And I confirm the booking
#      And I navigate to Home page
#      And I navigate to Accounts page
#      And I open invoice for the newest booking
#    Then new booking contains correct flight details

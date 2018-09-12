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
      And I select Round Trip flight option
      And I set BUSINESS class tickets
      And I set Riga as departure airport
      And I set Barcelona as arrival airport
      And I set 01.02.2019 as departure date
      And I set 03.02.2019 as return date
      And I select guests field
      And I set 2 adults
      And I set 2 children
      And I set 1 infant
      And I click on Done button in guests popup
      And I search for a flight
      And I am in Flight List page
      And I book the first flight offer available
      And I am in Confirmation page
      And I confirm the booking
      And I am in Invoice page
      And I select Home button in Navigation bar
      And I select User Account button in Navigation bar
      And I select Account button in Navigation bar
      And I select newest invoice in Account page
      And I am in Invoice page
    Then new booking contains correct flight details

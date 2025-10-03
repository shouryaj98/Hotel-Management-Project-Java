Feature: Hotel Management System

  Scenario: Display available features for each room type
    Given the hotel management system is running
    When the user requests room features for "Luxury Double Room"
    Then the system should display details for "Luxury Double Room"

  Scenario: Display room availability
    Given the hotel management system is running
    When the user requests room availability for "Deluxe Single Room"
    Then the system should display number of available "Deluxe Single Room"

  Scenario: Book a room
    Given the hotel management system is running
    When the user books a "Luxury Single Room" with name "Alice", contact "1111111", gender "F"
    Then the booking should be successful

  Scenario: Order food for a room
    Given a "Luxury Single Room" is booked with room number 31
    When the user orders "Sandwich" quantity "2" for room number 31
    Then the food order should be added to the room bill

  Scenario: Checkout from room
    Given a "Luxury Single Room" is booked and food has been ordered
    When the user checks out from room number 31
    Then the system should deallocate the room and display the total bill

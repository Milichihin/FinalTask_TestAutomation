Feature: Smoke
  As a user
  I check most of main elements on the site
  For sure that functionality of site is all right


  Scenario Outline: Check visibility of main site elements
    Given User opens '<homePage>' page
    And User checks `Main menu` visibility
    And User checks search bar visibility
    And User checks `Women menu` visibility
    And User checks `Men menu` visibility
    And User checks `Account menu` visibility
    And User checks `Save lists menu` visibility
    And User checks `Cart menu` visibility
    And User checks footer visibility

    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |


  Scenario Outline: Check add product to save list
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    When User clicks search button 
    And User clicks first `Save icon`
    When User clicks `Save lists menu`
    And User checks save list visibility 

    Examples:
      | homePage                    | keyword  |
      | https://www.asos.com/women/ | jeans    |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    When User clicks search button 
    And User clicks first product card 
    And User clicks `Add to Bag` button
    And User clicks `Cart Menu` button
    When User clicks `View Bag` button
    Then User checks list of selected products

    Examples:
      | homePage                    | keyword   |
      | https://www.asos.com/women/ | Jewellery |


  Scenario Outline: Check that you location is Ukraine
    Given User opens '<homePage>' page
    When User clicks `Location menu`
    Then User checks that location is '<location>'

    Examples:
      | homePage                    | location   |
      | https://www.asos.com/women/ | UA         |



  Scenario Outline: Check that all products in Sale Page have 'sale label'
    Given User opens '<salesPage>' page
    When User clicks `View all` card
    And User checks availability of `sale label` on each product card

    Examples:
      | salesPage                      |
      | https://www.asos.com/men/sale/ |


  Scenario Outline: Check that url contains search word
    Given User opens '<homePage>' page
    And User makes search by keyword '<keyword>'
    When User clicks search button 
    And User checks that url contains search '<keyword>' word

    Examples:
      | homePage                    | keyword   |
      | https://www.asos.com/women/ | adidas    |


  Scenario Outline: Check brand search result
    Given User opens '<homePage>' page
    And User makes search by keyword '<brand>'
    When User clicks search button
    Then User see only searched '<brand>'
    
    Examples:
      | homePage                    | brand   |
      | https://www.asos.com/women/ | adidas  |

  Scenario Outline: Check is `Load More` button works
    Given User opens '<homePage>' page
    And User makes search by keyword '<brand>'
    When User clicks search button
    Then User checks that amount of `Product Cards` is '<firstAmountOfCards>'
    And User clicks on `Load More` button
    Then User checks that newAmount of `Product Cards` is '<secondAmountOfCards>'

    Examples:
      | homePage                    | brand   | firstAmountOfCards | secondAmountOfCards
      | https://www.asos.com/women/ | adidas  | 72                 | 144


  Scenario Outline: Check 'Sign In' feature negative test
    Given User opens '<homePage>' page
    And User clicks `Account menu`
    When User clicks `My Account` link
    Then User checks `Sign In` form visibility
    And User fill '<email>' and '<password>' in `Email` field of form
    When User clicks `Sign In` button
    Then User see error message

    Examples:
      | homePage                    | email          |  password    |
      | https://www.asos.com/women/ | 1111@111.com   |  qwer        |


  Scenario Outline: Check 'Join' feature negative test
    Given User opens '<homePage>' page
    And User clicks `Account menu`
    And User clicks `Join` link
    When User fill '<emailToJoin>' in `Email` field of form to join
    And User fill '<firstName>' in `First Name` field of form 
    And User fill '<lastName>' in `Last Name` field of form 
    When User fill '<passwordToJoin>' in `Password` field of form to join
    Then User see `Email-error` message
    Then User see `Password-error` message 

    Examples:
      | homePage                    | emailToJoin     | firstName |   lastName | passwordToJoin |
      | https://www.asos.com/women/ | qwerty          | 1         |   1        | 1              |
      | https://www.asos.com/women/ | qwerty@         | 2         |   2        | 123            |
      | https://www.asos.com/women/ | qwerty@a.       | 3         |   3        | 123456          |

@FirstApplicationFeature
Feature: Create a new User
  Create an user and expect ok.

Scenario: an user
    Given A newUserRequest with name = "Lavinia Cavalcanti", email = "lavinia@gmail.com" and cpf = "80707309000"
    When create the object
    Then should create the user correctly

Scenario: an invalid user name
  Given A newUserRequest with name = " ", email = "lavinia@gmail.com" and cpf = "80707309000"
  Then should throw an exception

Scenario: an invalid email
  Given A newUserRequest with name = "Lavinia Cavalcanti", email = "" and cpf = "80707309000"
  Then should throw an exception

Scenario: an invalid cpf
  Given A newUserRequest with name = "Lavinia Cavalcanti", email = "lavinia@gmail.com" and cpf = ""
  Then should throw an exception
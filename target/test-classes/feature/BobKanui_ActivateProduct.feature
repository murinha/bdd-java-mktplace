Feature: BobKanui - Activate Product
@mktplace
Scenario:  Bob Kanui - Activate Product
	Given that i am at "http://rocket:rock4me@bob-shopsellercenter.kanui.net.br/" url
	And i wait for "Login" page to load
	When i fill field "username" with value "admin" in "Bob - Login"
	And i fill field "password" with value "rock4me" in "Bob - Login"
	And i click on button "login" in "Bob - Login"
	And i wait for "Home" page to load
	And i will see "Dashboard" page
	And i mouseover on "Catalog" menu, click on "PET" option in "Bob Kanui"
	And i wait for "PET" page to load
	And i search a product by "name" with value "Evelyn"
	And i select the product
	
	
	
	
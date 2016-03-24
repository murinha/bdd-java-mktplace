Feature: Bob Dafiti - Product Creation
@teste

Scenario: Product Creation
	Given that i am at "http://bob.aws.dafitierp.com.br/" url
	And i wait for "Page" page to load
	When i fill field "username" with value "admin" in "Bob - Login" page
	And i fill field "password" with value "rock4me" in "Bob - Login" page
	And i click on button "login" in "Bob - Login" page
	And i wait for "Page" page to load
	And i will see "Home" page
	And i mouseover on "Catalog" menu, click on "Product import" option in "Bob Dafiti" page
	And i wait for "Product import" page to load
	And i click on "Attribute Set" icon on "Product import" page
	And i select "Accessories" option in "Product import" page
	And i upload file "product_0203.csv" on "/home/documents/" path
	And i click on button "Upload file" in "Product import" page 
	And i wait for "Product import" page to load
	And i click on button "OK" in "Product import" page 
	
	
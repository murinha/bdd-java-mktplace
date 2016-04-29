Feature: Bob Dafiti - Coupon Creation

Scenario: Coupon Creation
	Given that i am at "http://bob.aws.dafitierp.com.br/" url
	And i wait for "Page" page to load
	When i fill field "username" with value "admin" in "Bob - Login" page
	And i fill field "password" with value "rock4me" in "Bob - Login" page
	And i click on button "login" in "Bob - Login" page
	And i wait for "Page" page to load
	And i will see "Home" in "Home" page
	And i mouseover on "Promotion" menu, click on "Vouchers" option in "Bob Dafiti" page
	And i wait for "Vouchers" page to load
	And i click on "Create new item" icon on "Vouchers" page
	And i wait for "Template Management" page to load
	And i click on "Type" icon on "Vouchers" page
	And i select "coupon" option in "Vouches" page
	And i wait for "Template Management" page to load
	And i fill field "Name" with value "test" in "Template Management" page
	And i fill field "Description" with value "test" in "Template Management" page
	
	
	
package foxman.patterns;

public class RegularExpressions {
	
	//? means optional 
	//matching a phone number
	//either digits
	//or a with 10 digits
	//also a number can not start with a 0 or a 1 
	
	// 1?\d{10} - this says an optional 1 with 10 digits after it
	// 1?[2-9]\d{9}- this says that there is an optional 1
	//the number after 1 can only be between 2 and 9, and then is followed by 9 digits
	
	//to test if the user enters paranthesis or - in between then make them optional in
	//case the user does not use that
	
	//1? -? \(? [2-9] \)? -? \d[2-9] -? \d[4]
	
	

}

function checkmn() {
	var a = document.getElementById("mn");
	// get your editext value here
	var pan="[A-Z]{1}[a-z]{1-5}";
	
	if(a.value.match(pan))   
	{   
		alert("Valid Name");
	}  
	else  
	{   
		alert("Enter Valid Name");
	}  
	
}
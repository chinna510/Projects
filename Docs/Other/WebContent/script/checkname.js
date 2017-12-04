function checkfn() {
	var a = document.getElementById("fn");
	var pan="[A-Z]{1}[a-z]{0-9}";
	if(a.value.match(pan))   
	{   
		alert("Valid Name");
	}  
	else  
	{   
		alert("Enter Valid Name");
	}  
	
}
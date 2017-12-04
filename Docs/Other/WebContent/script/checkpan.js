function checkpan() {
	var s = document.getElementById("pan"); // get your editext value here
	var resultDiv = document.getElementById("panwarn");
	var pan="[A-Z]{5}[0-9]{4}[A-Z]{1}";
	
	if(s.value.match(pan))   
	{   
		resultDiv.innerHTML = "Valid PAN";
		resultDiv.style.color = "green";  
	}  
	else  
	{   
		resultDiv.innerHTML = "Invalid PAN";
        resultDiv.style.color = "red";
	}  
	
}
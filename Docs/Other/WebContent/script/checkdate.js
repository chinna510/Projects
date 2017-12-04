function checkDate(){
    var idate = document.getElementById("dob"),
        resultDiv = document.getElementById("datewarn"),
        dateReg = /(0[1-9]|[12][0-9]|3[01])[\/](0[1-9]|1[012])[\/]201[4-9]|20[2-9][0-9]/;

    if(dateReg.test(idate.value)){
        if(isFutureDate(idate.value)){
            resultDiv.innerHTML = "Entered date is a future date";
            resultDiv.style.color = "red";
        } else {
            resultDiv.innerHTML = "It's a valid date";
            resultDiv.style.color = "green";
        }
    } else {
        resultDiv.innerHTML = "Invalid date!";
        resultDiv.style.color = "red";
    }
}
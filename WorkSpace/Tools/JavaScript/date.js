var date = new Date();
var days = [ "Sunday", "Monday", "Tueseday", "Wednesday", "Thursday", "Friday",
		"Saturday" ];
var months = [ "Jan", "Feb", "March", "April", "May", "June", "Julai", "Aug",
		"Sep", "Oct", "Nov", "Dec" ];
var currDate = date.getDate();
var currMonth = date.getUTCMonth();
var currYear = date.getFullYear();
var currTimeIM = date.getMinutes();
var currTIH = date.getHours();
var currTIS = date.getSeconds();
var day = date.getDay();
var currTime = ":" + currTimeIM + ":" + currTIS;
document.getElementById("date").innerHTML = "CURRENT DATE is : " + currDate
		+ " / " + months[currMonth] + " / " + currYear;
document.getElementById("date1").innerHTML = "CURRENT TIME is : " + timeIn24();
document.getElementById("date2").innerHTML = "CURRENT DAY  is : " + days[day];

function timeIn24() {
	if (currTIH > 12) {
		return (currTIH - 12) + "" + currTime + " PM";

	} else {
		return currTIH + "  " + currTime + "AM";
	}
}
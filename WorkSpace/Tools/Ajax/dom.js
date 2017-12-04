function getData() {
	var XMLHttpRequestObject = false;
	if (window.XMLHttpRequest) {
		XMLHttpRequestObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		XMLHttpRequestObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (XMLHttpRequestObject) {
		XMLHttpRequestObject.open("GET", "data1.txt");
		XMLHttpRequestObject.onreadystatechange = function() {
			if (XMLHttpRequestObject.readyState == 4
					&& XMLHttpRequestObject.status == 200) {
				var newPElement = document.createElement("p");
				var newText = document
						.createTextNode(XMLHttpRequestObject.responseText);
				newPElement.appendChild(newText);
				var divElement = document.getElementById("targetDiv");
				divElement.appendChild(newPElement);
			}
		}
		XMLHttpRequestObject.send(null);
	}
}
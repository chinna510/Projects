<%@ page session="false" %>
<%@ page import="java.util.*" %>
<%
// Look through cookies for language and country
String language = null;
String country = null;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
for (int i = 0; i < cookies.length; i++) {
Cookie cookie = cookies[i];
String name = cookie.getName();
if (name.equals("language"))
language = cookie.getValue();
if (name.equals("country"))
country = cookie.getValue();
}
}
// Get locale-specific resources
Locale locale = null;
if (language != null && country != null)
locale = new Locale(language, country);
if (locale == null)
locale = Locale.getDefault();
ResourceBundle RB = ResourceBundle.getBundle
("jspcr.sessions.welcome", locale);
// Store the resource bundle as an attribute of the request
request.setAttribute("RB", RB);
%>
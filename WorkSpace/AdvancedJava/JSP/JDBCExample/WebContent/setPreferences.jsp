<%@ page session="false" %>
<%
// Set cookies for language and country
final int ONE_YEAR = 60 * 60 * 24 * 365;
String[] parms = { "language", "country" };
for (int i = 0; i < parms.length; i++) {
String name = parms[i];
String value = request.getParameter(name);
if (value != null) {
Cookie cookie = new Cookie(name, value);
cookie.setMaxAge(ONE_YEAR);
response.addCookie(cookie);
}
}
// Redirect back to the calling JSP
String cameFrom = request.getParameter("cameFrom");
if (cameFrom == null)
cameFrom = request.getContextPath();
response.sendRedirect(cameFrom);
%>
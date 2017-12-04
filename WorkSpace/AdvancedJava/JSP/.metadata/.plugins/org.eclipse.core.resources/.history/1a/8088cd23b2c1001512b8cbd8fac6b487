<%@ page import="java.util.*" %>
<HTML>
<HEAD>
<TITLE>Echo</TITLE>
<STYLE>
<jsp:include page="style.css" flush="true"/>
</STYLE>
</HEAD>
<BODY>
<H3>HTTP Request Headers Received</H3>
<TABLE BORDER="1" CELLPADDING="4" CELLSPACING="0">
<%
Enumeration eNames = request.getHeaderNames();
while (eNames.hasMoreElements()) {
String name = (String) eNames.nextElement();
String value = normalize(request.getHeader(name));
%>
<TR> <TD><%= name %></TD> <TD><%= value %></TD> </TR>
<%
}
%>
</TABLE>
</BODY>
</HTML>
<%!
private String normalize(String value)
{StringBuffer sb = new StringBuffer();
for (int i = 0; i < value.length(); i++) {
char c = value.charAt(i);
sb.append(c);
if (c == ';')
sb.append("<BR>");
}
return sb.toString();
}
%>
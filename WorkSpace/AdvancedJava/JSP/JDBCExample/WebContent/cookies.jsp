<%@ page session="false"%>
<%@ page import="java.util.*"%>
<jsp:include page="getLocale.jsp" flush="true" />
<%
	ResourceBundle RB = (ResourceBundle) request.getAttribute("RB");
%>
<HTML>
<HEAD>
<TITLE>Using Cookies to Store Preferences</TITLE>
</HEAD>
<BODY>
	<P>
	<HR>
	<jsp:include page="languageBar.jsp" flush="true" />
	<H3><%=RB.getString("greeting")%></H3>
</BODY>
</HTML>
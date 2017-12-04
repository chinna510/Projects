<%@ page session="false" %>
<%@ page import="java.io.*,java.text.*,java.util.*" %>
<%-- Prints a conversion table of miles per gallon
to kilometers per liter --%>
<%!
private static final DecimalFormat FMT
= new DecimalFormat("#0.00");
%>
<HTML>
<HEAD>
<TITLE>Fuel Efficiency Conversion Chart</TITLE>
</HEAD>
<BODY>
<H3>Fuel Efficiency Conversion Chart</H3>
<TABLE BORDER=1 CELLPADDING=3 CELLSPACING=0>
<TR>
<TH>Kilometers per Liter</TH>
<TH>Miles per Gallon</TH>
</TR>
<%
for (double kpl = 5; kpl <= 20; kpl += 1.0) {
double mpg = kpl * 2.352146;
%>
<TR>
<TD><%= FMT.format(kpl)%></TD>
<TD><%= FMT.format(mpg)%></TD>
</TR>
<%
}
%>
</TABLE>
</BODY>
</HTML>
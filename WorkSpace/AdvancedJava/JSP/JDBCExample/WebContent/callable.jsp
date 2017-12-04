<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<%
// Prompt for beginning and ending years
String sLo = request.getParameter("lo");
if (sLo == null)
sLo = "";
String sHi = request.getParameter("hi");
if (sHi == null)
sHi = "";
%>
<H3>Select Composers by Year Born</H3>
<FORM>
<TABLE>
<TR>
<TD>Year range:
<INPUT TYPE="TEXT" NAME="lo" SIZE=4 VALUE="<%= sLo %>">
and
<INPUT TYPE="TEXT" NAME="hi" SIZE=4 VALUE="<%= sHi %>">
<INPUT TYPE="SUBMIT" VALUE="Search">
</TD>
</TR>
</TABLE>
</FORM>
<%
if (!sLo.equals("") && (!sHi.equals(""))) {
int lo = Integer.parseInt(sLo);
int hi = Integer.parseInt(sHi);
// Load the driver
Class.forName("com.mysql.jdbc.Driver");
Connection con = null;
try {
// Connect to the composers database
con = DriverManager.getConnection
("jdbc:mysql://localhost:3306/bizruntime","root","root");
// Set up callable procedure
String sql = "{call BornBetween(?, ?)}";
CallableStatement cstmt = con.prepareCall(sql);
cstmt.setInt(1, lo);
cstmt.setInt(2, hi);
ResultSet rs = cstmt.executeQuery();
%>
<P>
<TABLE>
<TR>
<TH>Name</TH>
<TH>Nationality</TH>
<TH>Lived</TH>
</TR>
<%
// Print the result set
while (rs.next()) {
String fname = rs.getString(1);
String lname = rs.getString(2);
String nationality = rs.getString(3);
int yearBorn = rs.getInt(4);
int yearDied = rs.getInt(5);
%>
<TR>
<TD><%= fname %> <%= lname %></TD>
<TD><%= nationality %></TD>
<TD><%= yearBorn %>-<%= yearDied %></TD>
</TR>
<%
}
%>
</TABLE>
<%
}
finally {
if (con != null) {
con.close();
con = null;
}
}
}
%>
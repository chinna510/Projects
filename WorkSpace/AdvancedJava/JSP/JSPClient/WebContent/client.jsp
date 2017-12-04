<%@page session="false" import="java.sql.*,java.text.*"
	contentType="text/xml"%>
<%
// Define constants for JDBC driver name and
// database URL
String DRIVER = "com.mysql.jdbc.Driver";
String DB_URL = "jdbc:idb:"
+ "jdbc:mysql://localhost/bizruntime";
// Get the product search argument and desired quantity
String product = request.getParameter("product");
if (product == null)
throw new ServletException("No product specified");
String qstring = request.getParameter("quantity");
if (qstring == null)
throw new ServletException("No quantity specified");
int quantity = 0;
try {
quantity = Integer.parseInt(qstring);
}
catch (NumberFormatException e) {
throw new ServletException("Quantity not numeric");
}

Class.forName(DRIVER);

Connection con = null;
try {
con = DriverManager.getConnection(DB_URL);

PreparedStatement pstmt = con.prepareStatement("select itemcode, price, description from products where prodtype = 'IN' and description like ? and onhand >= ?");
pstmt.setString(1, "%" + product + "%");
pstmt.setInt(2, quantity);

ResultSet rs = pstmt.executeQuery();

%><?xml version="1.0"?>
<price-quote> <supplier>LyricNote.com</supplier> <date><%=new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())
%> </date> <%
while (rs.next()) {
	String itemCode= rs.getString(1);
	double price= rs.getDouble(2) / 100;
	String description= rs.getString(3);

%> <item code="<%= itemCode %>"
	price="<%= new DecimalFormat("###.00").format(price) %>"
	description="<%= description %>"></item> <% 
}
%> </price-quote>
<%
}finally {
if (con != null)
con.close();
}

%>
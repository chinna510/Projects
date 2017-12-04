<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<HTML>
<HEAD>
<TITLE>Department Managers</TITLE>
</HEAD>
<BODY>
	<img src="images/lyric_note.png" border=1>
	<p>
	<hr color="#000000">
	<H2>Department Managers</H2>
	<%
		String DRIVER = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost/bizruntime";
		// Open a database connection
		Class.forName(DRIVER);
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, "root", "root");
			// Get department manager information
			String sql = "SELECT * from departments";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
	%>
	<%
			while (rs.next()) {
				String deptno = rs.getString(1);
				String deptname =rs.getString(2);
				String deptmgr = rs.getString(3);

{
	%>
	<%= deptno %>

	<%= deptname %>
	<%= deptmgr %>
	<%
		}
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
	%>


</BODY>
</HTML>

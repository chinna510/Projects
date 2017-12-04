<%@ page import="java.io.*,java.util.*"%>

<html>
<head>
<title>Parameter Values</title>
<base href="<lyric:baseURL/>">
<link rel="stylesheet" href="styles/diag.css">
</head>
<body>

	<table border="1">
		<tr>
			<td colspan="2" align="center" class="header">Parameter Values</td>
		</tr>
		<tr>
			<th>Name</th>
			<th>Value</th>
		</tr>
		<%
				int currentRow = 0;
				Enumeration eNames = request.getParameterNames();
				while (eNames.hasMoreElements()) {
					String name = (String) eNames.nextElement();
					String[] values = request.getParameterValues(name);
					for (int i = 0; i < values.length; i++) {
						String value = values[i];
						currentRow++;
						String rowClass = "row" + (currentRow % 2);
			%>
		<tr valign="top">
			<td align="right" class="<%=rowClass%>"><B><%=name%></B></td>
			<td align="left" class="<%=rowClass%>"><%=value%></td>
		</tr>
		<%
}
}
%>
	</table>

</body>
</html>
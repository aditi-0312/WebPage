<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>

<h1>Listing users</h1>
<table border="1">
			<thead>
			<th>User ID </th>
			<th>Username </th>
			<th>Email </th>
			</thead>
			<%
			List<User> listUsers = (List)request.getAttribute("listUsers");
			for(int i=0;i<listUsers.size(); i++){
				out.print("<tr>");
				out.print("<td>"+listUsers.get(i).getUsers_id()+"</td>");
				out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
				out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
				out.print("</tr>");
			}
			
			%>
			</table>

<%@include file="include/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession s = request.getSession();
	String name = s.getAttribute("name_session").toString();
	String email = s.getAttribute("email_session").toString();
	String password = s.getAttribute("password_session").toString();
	if ((name != null && !name.isEmpty()) && (email != null && !email.isEmpty())
			&& (password != null && !password.isEmpty())) {
		s.setAttribute("name_session", " ");
		s.setAttribute("email_session", " ");
		s.setAttribute("password_session", " ");
	%>
	<script type="text/javascript">
		alert("User logOut successfullyy....");
		window.location.href = "../index.html";
	</script>
	<%
	} else {
	%>
	<script type="text/javascript">
		window.location.href = "index.html";
	</script>
	<%
	}
	%>

</body>
</html>
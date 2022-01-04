<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Taker</title>
<%@ include file="resorces/liblarys.jsp"%>
<link href="css/style.css" rel="stylesheet">



<style type="text/css">
.heigth {
	width: 100%;
	height: 400px;
}

.img_height {
	height: 300px;
}
.img{
	 background-image: url("image/blogger")
}
</style>
</head>
<body class="bg-info img ">
	<div class="container">
	
		<div class="mt-2">
			<%@ include file="view/navbar.jsp"%>
		</div>

		<div>
			<h1 class="text-center mt-4">
			<% HttpSession session1 = request.getSession(); %>
				<i>Welcome to the Note Reminder <%= session1.getAttribute("name_session") %>...</i>
			</h1>
		</div>
		<div class="bg-light text-center card-body col-12 heigth">
			<div>
				<img class="img_height" alt="note_image" src="image/blogger.png">
			</div>
		</div>
		<div class="bg-dark text-center card-footer">
			<h4 class="text-white">
				<i>Vishal Patil</i>
			</h4>
			<h4 class="text-white">
				<i>vp2703681@gmail.com</i>
			</h4>

		</div>

	</div>
</body>
</html>
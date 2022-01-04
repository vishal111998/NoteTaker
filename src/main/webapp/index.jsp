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
</style>
</head>
<body class="bg-light">
	<div class="container">
	
		<!-- Login Modal -->
		<div class="modal fade " id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Note Taker</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="form-group" action="Login_User" method="get">
							<div class="login-form ">
								<div class="subtitle">Login or register</div>
								<a href="regi_user.jsp">Register</a><br>
								<label class="mt-1">Email</label>
								<input class="form-control " type="text" placeholder="Username" name="email" required="required"/>
								<label>Password</label>
								 <input class="form-control " type="password" placeholder="Password" name="password" required="required"/>
								 <div class="col-12 mt-2 float-left text-center">
								 	<button class="btn btn-primary" >Login</button>
								 	
								 </div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	<!-- end login modal -->
	
	
	
	

		<div class="mt-2">
			<%@ include file="view/index_navbar.jsp"%>
		</div>

		<div>
			<h1 class="text-center mt-4">
				<i>Welcome to the Note Reminder...</i>
			</h1>
		</div>
		<div class="bg-light text-center card-body col-12 heigth">
			<div>
				<img class="img_height" alt="note_image" src="image/bg_note.png">
			</div>
		</div>
		<div class="bg-dark text-center card-footer">
			<h4 class="text-white">
				<i>Created by Vishal Patil</i>
			</h4>
			<!-- <h4 class="text-white">
				<i>vp2703681@gmail.com</i>
			</h4>
 -->
		</div>

	</div>
</body>
</html>
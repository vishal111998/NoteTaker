<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
	<div class="container">
		<div calss="col-12">
			<h3 class="text-center">Registreation form</h3>
			<div class="col-2 float-left"></div>
			<div class="col-8 float-left">
				<form class="form-group" action="Regi_User" method="get">
					<div class="col-10">
						<label>Name</label> <input class="form-control" type="text"
							name="name" required="required" placeholder="enter name" />
					</div>
					<div class="col-10">
						<label>Email</label> <input class="form-control" type="email"
							name="email" required="required" placeholder="enter email" />
					</div>
					<div class="col-10">
						<label>Password</label> <input class="form-control"
							type="text" name="password" required="required"
							placeholder="enter password" />
					</div>
					<div class="col-10 text-center mt-3">
						<button class="btn btn-primary">Submit</button>
					</div>

				</form>
			</div>
			<div class="col-2 float-left"></div>
		</div>

	</div>

</body>
</html>
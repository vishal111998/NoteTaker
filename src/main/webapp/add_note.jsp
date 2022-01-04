<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Note Makers</title>
	<%@ include file="resorces/liblarys.jsp" %>
</head>
<body class="container bg-light">
	<div class="mt-2">
	    <%@ include file="view/navbar.jsp" %>
		<h1 class="text-center mt-4"><i>Add your notes...</i></h1>
	</div>
	

	<!-- Form tag -->
	
	<form class="form-group mt-3" method='post'  action='save_note' class="mt-5">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Note Title</label>
	    <input  type="text" name="title" class="form-control" id="title" required="required">  
	  </div>
	  
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Note Content</label>
	    <textarea 
	    		 name="content"
	    		 class="form-control" 
	    		 id="content"
	    		 style="height:170px"
	    		 required="required"
	    		 ></textarea>
	  </div>
	  <div class="container text-center">
		<button type="submit" class="btn btn-primary">Submit</button>   	
	  </div>  
	
	 	 
	</form>
</body>
</html>
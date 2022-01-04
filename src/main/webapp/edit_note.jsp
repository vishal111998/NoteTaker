<%@page import="com.project.entity.Note"%>
<%@page import="com.project.dao.NoteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note</title>
<%@ include file="resorces/liblarys.jsp" %>
</head>
<body class="bg-light">
	<%
		String str_id = request.getParameter("noteid");
		
		if(str_id!=null && !str_id.isEmpty()) {
			int noteId = Integer.parseInt(str_id);
			NoteDao ndao = new NoteDao();
			Note note = ndao.getNotesWithId(noteId);
			if(note!=null){
		
	%>
			<div class="container">
				<!-- bavbar -->
				<div class="mt-1">
					<%@ include file="view/navbar.jsp" %>
				</div>
			  
				<div class="col-12 row float-left">
					<h1 class="text-center mt-5"><i>Edit the note...</i></h1>
					<div class="col-2 float-left"></div>
					<div class="col-8 float-left">
					
						<form class="form-group mt-4" action="Edit_Note" method="get">
						  <div class="mb-3">
						  	<input type="hidden" name="id" value='<%=note.getId() %>'/>
						    <label for="exampleInputEmail1" class="form-label">Note Title</label>
						    <input
						    	type="text" 
						    	name="title" 
						    	class="form-control font-weight-bold" 
						    	value='<%=note.getTitle() %>' 
						    	id="title" 
						    	required="required"/>  
						  </div>
						  
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Note Content</label>
						    <input 
						  		     type="text"
						    		 value='<%=note.getContent() %>'
						    		 name="content"
						    		 class="form-control" 
						    		 id="content"
						    		 style="height:100px"
						    		 required="required"
						    		 />
						  </div>
						  <div class="container text-center">
							<button type="submit" class="btn btn-primary">Submit</button>   	
						  </div>  
				 
						</form>
				
					</div>
					<div class="col-2 float-left"></div>
						
				</div>
			</div>
				
			<%}else{%>
				<script type="text/javascript">
					alert("Sorry Id not found...");
					window.location.href("index.jsp");
				</script>
			<% } %>
		
		<%}else{ %>
			<script type="text/javascript">
				window.location.href("index.jsp");
			</script>
		<%} %>
	
</body>
</html>
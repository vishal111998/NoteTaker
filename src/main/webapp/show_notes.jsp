
<%@page import="com.project.entity.Note"%>
<%@page import="java.util.List"%>
<%@page import="com.project.dao.NoteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@ include file="resorces/liblarys.jsp" %>
<title>Show Note</title>
						
<style type="text/css">
	.class-header{
		width100%;
		height: 150px;
	}
.
</style>		
</head>
<body class="bg-light">
	

	<div class="container">
		<div class="mt-1">
			<%@ include file="view/navbar.jsp" %>
		</div>
		
		<div class="row">
			<h1 class="text-center mt-3"><i>This is the Show notes page...</i></h1>
			
			<% 
				List<Note> list = null;
				NoteDao notedao = new NoteDao();
				
			
				HttpSession s = request.getSession(); 
				String email = (String)s.getAttribute("email_session");
				System.out.println("show page session email :"+email);
				if(email!=null){
					list = notedao.getNotes(email);
				}
				
				
				if(list!=null && !list.isEmpty()){
					for(Note note : list){
					
			%>
				<div class="col-12 mt-3">
				    	
					<div class="card">
				    	<div class="card-header">
				    			<div class='col-8 float-left'><b style="font-size:25px;">ID:<%= note.getId()  %>&nbsp;&nbsp;</b>	
								<b style="font-size:20px"><%= note.getTitle() %></b></div>
								<div class='col-4 float-left'><p class="text-right" style="font-size:20px"><%= note.getDate() %></p></div>
								
							
						</div>
					  	<div class="card-body col-12 row">
					  		<div class="float-left col-10">
					  			<%= note.getContent() %>
					  		</div>
					  		<div class="float-left col-2">
					  		
					  			<a class="float-left" href="edit_note.jsp?noteid=<%=note.getId() %>">
					  				<img  style="height: 40px;" alt="edit" src="image/edit.png"></a>
					  				
					  				
					  			<a class="float-left ml-2" href="delete_note_id?noteid=<%=note.getId()%>">
					  				<img style="height: 40px;" alt="delete" src="image/delete.png">
					  			</a>		
					  		</div>
						</div>
					</div>
					
				</div>
				<%
				}
				}else{
					System.out.println("Note not found");
				}
				%>
		</div>
	
	</div>
	
	
	
</body>
</html>
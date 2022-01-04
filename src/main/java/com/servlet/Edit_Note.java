package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.NoteDao;

/**
 * Servlet implementation class Edit_Note
 */
@WebServlet("/Edit_Note")
public class Edit_Note extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw  = response.getWriter();
		response.setContentType("text/html");
		
		String str_id = request.getParameter("id");
		String str_title = request.getParameter("title");
		String str_content = request.getParameter("content");
		
		if(str_id!=null && str_title!=null && str_content!=null) {
			NoteDao ndao = new NoteDao();
			int noteid = Integer.parseInt(str_id);
			int status = ndao.updateNoteWithId(noteid,str_title,str_content);
			System.out.println("status : "+status);
			if(status>0) {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Note  is save successfully...');");
				pw.print("window.location.href='show_notes.jsp'");
				pw.print("</script>");
			}else {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Sorry... note does note save...');");
				pw.print("window.location.href='show_notes.jsp'");
				pw.print("</script>");
			}
			
		}
	}


}

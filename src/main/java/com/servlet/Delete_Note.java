package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.NoteDao;


@WebServlet("/delete_note_id")
public class Delete_Note extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		try {
			String noteId = request.getParameter("noteid");
			System.out.println("NoteIs" + noteId);
			NoteDao notedao = new NoteDao();
			int id = Integer.parseInt(noteId);
			int status = notedao.deleteNote(id);
			if (status>0) {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Note Id:- "+status+" delete successfully...');");
				pw.print("window.location.href='show_notes.jsp'");
				pw.print("</script>");
			}else {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Note Id:- "+status+" does not delete...');");
				pw.print("window.location.href='show_notes.jsp'");
				pw.print("</script>");
			}
			
		}catch(Exception e) {
			System.out.println("Exception in Delete_Note.doPost()");
			e.printStackTrace();
		}
	}

}

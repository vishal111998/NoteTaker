package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.NoteDao;
import com.project.entity.Note;

@WebServlet("/save_note")
public class Save_notes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			System.out.println(title);
			System.out.println(content);
			
			String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());  
			
			Note note = new Note();
			note.setTitle(title);
			note.setContent(content);
			note.setDate(date);
			System.out.println("Save naote session emali : "+session.getAttribute("email_session"));
			if(session.getAttribute("email_session").toString()!=null) {
				note.setEmail(session.getAttribute("email_session").toString());
			}else {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Plese registre first...!!!');");
				pw.print("window.location.href='index.jsp'");
				pw.print("</script>");
			}
			
			
			NoteDao notedao = new NoteDao();
			int status = notedao.saveNote(note);
			if(status>0) {
				System.out.println("Note successfully submited...!!!");
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Note Id:- "+status+" is save successfully...');");
				pw.print("window.location.href='add_note.jsp'");
				pw.print("</script>");
			}else{
				System.out.println("Note ...!!!");
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Sorry note not save...!!!');");
				pw.print("window.location.href='add_note.jsp'");
				pw.print("</script>");
			}
			
		} catch (Exception e) {
			System.out.println("Exception in save_notes.doPost()");
			e.printStackTrace();
		}
	}

}

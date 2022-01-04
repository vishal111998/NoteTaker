package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.NoteDao;
import com.project.entity.User;

@WebServlet("/Regi_User")
public class Regi_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoteDao ndao = new NoteDao();
		
		PrintWriter pw = response.getWriter();
		
		String str_name = request.getParameter("name");
		String str_email = request.getParameter("email");
		String str_password = request.getParameter("password");
		
		if(str_name!=null && str_email!=null && str_password!=null) {
			User user = new User();
			user.setName(str_name);
			user.setEmail(str_email);
			user.setPassword(str_password);
			
			User check_user = ndao.checkUser(str_email);
			if(check_user==null) {
				int status = ndao.saveUser(user);
				if(status>0) {	
					pw.print("<script type='text/javascript'>");
					pw.println("alert('User successfully registred...!!!');");
					pw.print("window.location.href='index.html'");
					pw.print("</script>");
				}else {
					pw.print("<script type='text/javascript'>");
					pw.println("alert('Sorry. user not registred...!!!');");
					pw.print("window.location.href='regi_user.jsp'");
					pw.print("</script>");
				}
			}else {
				pw.print("<script type='text/javascript'>");
				pw.println("alert('Sorry. user allready registred...!!!');");
				pw.print("window.location.href='regi_user.jsp'");
				pw.print("</script>");
			}
			
		}
	}

	
}

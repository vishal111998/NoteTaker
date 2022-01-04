package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.NoteDao;
import com.project.entity.User;

@WebServlet("/Login_User")
public class Login_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		NoteDao ndao = new NoteDao();

		PrintWriter pw = response.getWriter();

		String str_email = request.getParameter("email");
		String str_password = request.getParameter("password");
		try {
			if (str_email != null && str_password != null && !str_email.isEmpty() && !str_password.isEmpty()) {
				System.out.printf("email password "+str_email+" password"+str_password);
				try {
					User user = ndao.getUser(str_email);
					System.out.println("list :"+user);
					
					if (user != null) {
						
							try {
								String pass = user.getPassword();
								if(str_password.equals(pass)) {
									session.setAttribute("name_session", user.getName());
									session.setAttribute("email_session", user.getEmail());
									session.setAttribute("password_session", user.getPassword());
								}else{
									System.out.println("password not found exception in Login_user passwwerd if block");
									pw.print("<script type='text/javascript'>");
									pw.println("alert('Sorry. user not registred...!!!');");
									pw.print("window.location.href='index.jsp'");
									pw.print("</script>");
								}
								
							} catch (Exception e) {
								System.out.println("Exception in Login_User.session....!!!");
								e.printStackTrace();
							}
	
						
						pw.print("<script type='text/javascript'>");
						pw.println("alert('User successfully login...!!!');");
						pw.print("window.location.href='user_index.jsp'");
						pw.print("</script>");
					} else {
						pw.print("<script type='text/javascript'>");
						pw.println("alert('Sorry. user not login...!!!');");
						pw.print("window.location.href='regi_user.jsp'");
						pw.print("</script>");
					}
				} catch (Exception e) {
					System.out.println("Exception in Login_User.servlet....!!!");
					e.printStackTrace();
				}
				
			}
		
		}catch (Exception e) {
			System.out.println("Exception in Login_User.Outer password and email null....!!!");
			e.printStackTrace();
		}
	}

}

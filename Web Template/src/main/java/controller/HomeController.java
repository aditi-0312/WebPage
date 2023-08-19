package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import entity.User;
import model.UsersModel;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch (page) {
		case "home": {
			request.setAttribute("title", "Homepage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		case "listUser":{
			List<User> listUsers = new ArrayList<>();
			listUsers = new UsersModel().listusers(dataSource);
			request.setAttribute("listUsers", listUsers);
			request.setAttribute("title", "List of users");
			request.getRequestDispatcher("listUser.jsp").forward(request, response);
			break;
		}
			
		default:request.setAttribute("title", "Error page");
			request.getRequestDispatcher("error.jsp").forward(request, response);

		}
	}

}

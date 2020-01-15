package global.coda.hospitalmanagementsystem.api;

import global.coda.hospitalmanagementsystem.deligate.impl.UserService;
import global.coda.hospitalmanagementsystem.exception.InvalidInputTypeException;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;

import global.coda.hospitalmanagementsystem.model.User;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/update")
public class UserUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserUpdate() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    PrintWriter writer = response.getWriter();
    UserService userService = new UserService();
    User userData = new User();
    HttpSession session = request.getSession(false);
    int userId = (int) session.getAttribute("userId");
    // System.out.println("User Id ="+userId);
    userData.setUserId(userId);
    userData.setUserName(request.getParameter("username"));
    userData.setUserPassword(request.getParameter("password"));
    userData.setUserAge(Integer.parseInt(request.getParameter("age")));
    userData.setUserGender(request.getParameter("gender"));
    userData.setUserMobileNumber(request.getParameter("mobilenumber"));
    userData.setUserEmailId(request.getParameter("emailid"));
    userData.setUserEmailId(request.getParameter("addressLine1"));
    userData.setUserEmailId(request.getParameter("addressLine2"));
    userData.setUserEmailId(request.getParameter("addressLine3"));
    try {
      if (userService.modifyUser(userData)) {
        writer.print("Success!");
      } else {
        writer.print("Failure!");
      }
    } catch (SQLException | InvalidInputTypeException
        | UserNotFoundException e) {
      // TODO Auto-generated catch block

      e.printStackTrace();
    }
  }

}

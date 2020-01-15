package global.coda.hospitalmanagementsystem.api;

import global.coda.hospitalmanagementsystem.deligate.UserService;
import global.coda.hospitalmanagementsystem.exception.InvalidInputTypeException;

import global.coda.hospitalmanagementsystem.exception.PatientRecordNotFoundException;
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
 * Servlet implementation class UserLogin
 */
@WebServlet("/user")
public class UserLogin extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserLogin() {
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
    PrintWriter out = response.getWriter();
    out.println("Hai");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    UserService authenticationService = new UserService();
    // TODO Auto-generated method stub
    PrintWriter out = response.getWriter();
    String userId = request.getParameter("emailId");
    String password = request.getParameter("userPassword");
    User authenticatedUser = new User();
    try {
      authenticatedUser = authenticationService
          .getUserByEmailIdAndUserPassword(userId, password);
      if (authenticatedUser == null) {
        out.print("Wrong User name or Password!");
      } else {
        HttpSession session = request.getSession();
        session.setAttribute("userId", authenticatedUser.getUserId());
        out.print("<html><head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
            + "<title>Insert title here</title>\r\n" + "</head>\r\n"
            + "<body>\r\n"
            + "<form method=\"post\" action=\"/HospitalManagementApplication/update\">\r\n"
            + "User Name:<input type=\"text\" name=\"username\" value="
            + authenticatedUser.getUserName() + ">\r\n" + "<br>\r\n"
            + "Password:<input type=\"text\" name=\"password\" value="
            + authenticatedUser.getUserPassword() + ">\r\n" + "<br>\r\n"
            + "Age:<input type=\"text\" name=\"age\" value="
            + authenticatedUser.getUserAge() + ">\r\n" + "<br>\r\n"
            + "Gender:\r\n" + "<input type=\"text\"name=\"gender\" value="
            + authenticatedUser.getUserGender() + ">\r\n" + "<br>\r\n"
            + "Mobile Number:<input type=\"text\" name=\"mobilenumber\" value="
            + authenticatedUser.getUserMobileNumber() + ">\r\n" + "<br>\r\n"
            + "Email Id:<input type=\"text\" name=\"emailid\" value="
            + authenticatedUser.getUserEmailId() + ">\r\n" + "<br>\r\n"
            + "Address Line1:<input type=\"v\" name=\"address1\" value="
            + authenticatedUser.getUserAddressLine1() + ">\r\n" + "<br>\r\n"
            + "Address Line2:<input type=\"text\" name=\"address2\"value="
            + authenticatedUser.getUserAddressLine2() + ">\r\n" + "<br>\r\n"
            + "Address Line3:<input type=\"text\" name=\"address3\"value="
            + authenticatedUser.getUserAddressLine3() + ">\r\n" + "<br>\r\n" +

            "<input type=\"submit\" name=\"submit\" value=\"UPDATE PROFILE\"/>\r\n"
            + "\r\n" + "</form>\r\n" + "\r\n" + "</body>\r\n" + "</html>");

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (PatientRecordNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InvalidInputTypeException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}

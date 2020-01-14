package global.coda.hospitalmanagementsystem.api;

import global.coda.hospitalmanagementsystem.dao.database.PatientDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.deligate.AuthenticationService;

import global.coda.hospitalmanagementsystem.deligate.impl.PatientService;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQPI1;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserWebServices {
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  @POST
  @Path("/read")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response Read(@FormParam("emailId") String emailId,
      @FormParam("password") String password)
      throws BusinessExceptionMapper, UserNotFoundException{
    AuthenticationService service = new AuthenticationService();
    User user = service.getUserByEmailIdAndUserPassword(emailId, password);

    if (user.getUserId() != 0) {
      return Response.status(200).entity(user.toString()).build();
    } else {
      return Response.status(400).build();
    }
  }
  @POST
  @Path("/insert")
  public Response Insert(Patient patient) throws Exception {
    PatientService patientService = new PatientService();
    int patientId = patientService.addPatient(patient);
    if (patientId != 0) {
      // LOGGER.debug(MESSAGES_BUNDLE.getString());
      return Response.status(200).build();
    } else {
      return Response.status(400).build();
    }

  }
  @POST
  @Path("/update")
  public Response Update(Patient patient) throws Exception {

    UserDaoDb userDaoDb = new UserDaoDb();
    boolean status = userDaoDb.modifyUser(patient);
    if (status) {
      return Response.status(200).build();
    } else {
      return Response.status(400).build();
    }
  }

  public Response Delete() throws Exception {
    PatientDaoDb patientDaoDb = new PatientDaoDb();
    User user = new User();
    String deleteQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
    boolean status = patientDaoDb.deleteUser(user.getUserId(), deleteQuery);
    if (status) {
      return Response.status(200).build();
    } else {
      return Response.status(400).build();
    }

  }
}
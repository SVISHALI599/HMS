package global.coda.hospitalmanagementsystem.api;

import global.coda.hospitalmanagementsystem.dao.database.DoctorDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.deligate.AuthenticationService;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.Doctor;

import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQPI1;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/doctor")
public class DoctorWebServices {
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  @GET
  @Path("/read")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  public Response Read(@FormParam("emailId") String emailId,
      @FormParam("password") String password)
      throws BusinessExceptionMapper, SQLException, UserNotFoundException {
    AuthenticationService service = new AuthenticationService();
    User user = service.getUserByEmailIdAndUserPassword(emailId, password);

    if (user.getUserId() != 0) {
      return Response.status(200).entity(user.toString()).build();
    } else {
      return Response.status(400).build();
    }
  }

  @POST
  @Path("/update")
  public Response Update(Doctor doctor) throws Exception {

    UserDaoDb userDaoDb = new UserDaoDb();
    boolean status = userDaoDb.modifyUser(doctor);
    if (status) {
      return Response.status(200).build();
    } else {
      return Response.status(400).build();
    }
  }
  @POST
  @Path("/Insert")
  public int Insert(User user) throws Exception {
    DoctorDaoDb doctordaodb = new DoctorDaoDb();
    Doctor doctor = new Doctor();
    String insertQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
    int doctorId = doctordaodb.insertUser(doctor.getUserId(), doctor,
        insertQuery);
    return doctorId;
  }
  @GET
  @Path("/getAllpatients")
  public Response GetPatientList()throws Exception{
    DoctorDaoDb doctorDaoDb=new DoctorDaoDb();
    String getPatientQuery=DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
    doctorDaoDb.ListAllPatients(getPatientQuery);
    if (doctorId!=0) {
      return Response.status(200).build();
    } else {
      return Response.status(400).build();
    }
    
  }
}
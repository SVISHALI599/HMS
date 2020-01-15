package global.coda.hospitalmanagementsystem.service;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import global.coda.hospitalmanagementsystem.deligate.AuthenticationService;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

public class AuthenticationTest {
	@Test
	public void authenticateUserTest() throws SQLException, UserNotFoundException, BusinessExceptionMapper {
		User user=null;
		AuthenticationService authenticationService = new AuthenticationService();
		user = authenticationService.getUserByEmailIdAndUserPassword("kavitha@gmail.com", "kavi123*");
		assertEquals(user.getUserName(), "Kavitha");

	}
}

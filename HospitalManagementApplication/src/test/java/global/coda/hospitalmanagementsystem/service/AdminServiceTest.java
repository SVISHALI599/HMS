package global.coda.hospitalmanagementsystem.service;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import global.coda.hospitalmanagementsystem.deligate.impl.GlobalAdminService;

public class AdminServiceTest {
	GlobalAdminService globalAdminService = new GlobalAdminService();

	@Test
	public void testAdminService() {
		List<String> userData=new ArrayList<String>();
		userData.add("ram");
		userData.add("ram@123");
		userData.add("22");
		userData.add("M");
		userData.add("9808674532");
		userData.add(" ");
		userData.add("no.2");
		userData.add("kk nagar");
		userData.add("mambakkam,chennai");
		userData.add("cardio");
		userData.add("3");
		
		assertEquals(1, globalAdminService.addUser(3, userData));
	}
}

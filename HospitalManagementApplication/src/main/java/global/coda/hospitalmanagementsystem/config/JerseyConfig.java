package global.coda.hospitalmanagementsystem.config;

import global.coda.hospitalmanagementsystem.api.DoctorAPI;
import global.coda.hospitalmanagementsystem.api.PatientAPI;
import global.coda.hospitalmanagementsystem.api.UserAPI;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(UserAPI.class);
    register(PatientAPI.class);
    register(DoctorAPI.class);
  }
}
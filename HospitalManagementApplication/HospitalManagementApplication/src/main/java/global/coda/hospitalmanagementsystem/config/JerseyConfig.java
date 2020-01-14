package global.coda.hospitalmanagementsystem.config;

import global.coda.hospitalmanagementsystem.api.DoctorWebServices;
import global.coda.hospitalmanagementsystem.api.PatientWebServices;
import global.coda.hospitalmanagementsystem.api.UserWebServices;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
    register(UserWebServices.class);
    register(PatientWebServices.class);
    register(DoctorWebServices.class);
  }
}
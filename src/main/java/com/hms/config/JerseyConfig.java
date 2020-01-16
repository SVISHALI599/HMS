package com.hms.config;

import com.hms.api.DoctorApi;
import com.hms.api.PatientApi;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
  public JerseyConfig() {
   
    register(PatientApi.class);
    register(DoctorApi.class);
  }
}
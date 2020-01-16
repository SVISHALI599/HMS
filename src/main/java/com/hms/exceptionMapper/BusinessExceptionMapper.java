package com.hms.exceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BusinessExceptionMapper extends Exception implements ExceptionMapper<BusinessExceptionMapper>{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public BusinessExceptionMapper(String string, Exception e) {
    // TODO Auto-generated constructor stub
super(string);
  }

  @Override
  public Response toResponse(BusinessExceptionMapper exception) {
    // TODO Auto-generated method stub
    return null;
    

  }
 
  

}

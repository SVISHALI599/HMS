package global.coda.hospitalmanagementsytem.ExceptionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class SystemExceptionMapper extends Exception implements ExceptionMapper<SystemExceptionMapper>{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public SystemExceptionMapper(String string, Exception e) {
    // TODO Auto-generated constructor stub
  }

  public SystemExceptionMapper() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public Response toResponse(SystemExceptionMapper exception) {
    // TODO Auto-generated method stub
    return null;
  }

 

}

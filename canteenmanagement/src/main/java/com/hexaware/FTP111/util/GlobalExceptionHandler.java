package com.hexaware.FTP111.util;
import javax.ws.rs.ext.Provider;
//import java.io.IOException;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;
/**
* This class provides a REST interface for validation.
 */

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<IllegalArgumentException> {
/**
  *@param ex variable for Illegalexception.
  *@return the integer value.
 */
  public final Response toResponse(final IllegalArgumentException ex) {
    if (ex instanceof IllegalArgumentException) {
      return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
    }
    return Response.status(500).entity(ex.getMessage()).build();
  }
}

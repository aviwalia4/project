package com.hexaware.FTP111.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.PathParam;
import com.hexaware.FTP111.model.Menu;
import com.hexaware.FTP111.factory.MenuFactory;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuController {
/**
* Return menu details.
* @return the menu details.
 */
  // @GET
  // @Path("/{menItemId}")
  // @Produces(MediaType.APPLICATION_JSON)
  // public final List<MenuDetails> findByMenItemId(@PathParam ("menItemId") final int menItemId) {
  //   Validators.validateMenuItemId(menItemId);
  //   return MenuFactory.getMenuDetails(menItemId);
  // }
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Response listMenu() {
    final List<Menu> menuDetails = MenuFactory.showMenu();
    if (!menuDetails.isEmpty()) {
      return Response.ok().entity(menuDetails).build();
    } else {
      return Response.status(Response.Status.FORBIDDEN).entity("menu not found").build();
    }
  }
}

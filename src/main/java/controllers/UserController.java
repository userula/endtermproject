package controllers;

import domain.User;
import filters.customAnnotations.JWTTokenNeeded;
import filters.customAnnotations.OnlyAdmin;
import jakarta.ws.rs.container.ContainerRequestContext;
import services.UserService;
import services.interfaces.IUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.ResponseCache;

@Path("users")
public class UserController {
    private final IUserService userService = new UserService();

    @GET
    public String index(){
        return "Hello world!!!";
    }

    @JWTTokenNeeded
    @GET
    @Path("/{param}")
    public Response getUserByID(@PathParam("param") int id) {
        User user;
        try {
            user = userService.getUserByID(id);
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(user).build();
        }
    }

    @OnlyAdmin
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addUser(User user) {

        try {
            userService.addUser(user);
        } catch (ServerErrorException ex) {
            return Response
                    .serverError().entity(ex.getMessage()).build();
        } catch (BadRequestException ex) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex.getMessage()).build();
        }

        return Response.
                status(Response.Status.CREATED)
                .entity("User created successfully!")
                .build();
    }


}

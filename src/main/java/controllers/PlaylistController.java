package controllers;

import domain.Playlist;
import domain.User;
import filters.customAnnotations.JWTTokenNeeded;
import filters.customAnnotations.OnlyAdmin;
import services.PlaylistService;
import services.interfaces.IPlaylistService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.ResponseCache;
import java.util.ArrayList;

@Path("playlist")
public class PlaylistController {
    private final IPlaylistService playlistService = new PlaylistService();

    @GET
    public String index(){
        return "You are in Playlist block!";
    }

    @GET
    @Path("/{param}")
    public Response getPlaylistByUserID(@PathParam("param") int userId) {
        ArrayList<Playlist> p;
        try {
            p = playlistService.getPlaylistByUserID(userId);
        } catch (ServerErrorException ex) {
            return Response.serverError().build();
        } catch (BadRequestException ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(p).build();
        }
    }

    @OnlyAdmin
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public Response addPlaylist(Playlist p) {

        try {
            playlistService.addPlaylist(p);
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
                .entity("Playlist added successfully!")
                .build();
    }


}

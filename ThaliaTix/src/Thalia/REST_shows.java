package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/thalia/show")
public class REST_shows {
    private InterfaceShows is = new ShowManager();
    
    //CREATE SHOWS
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response controlLamp(String json) {
        Gson gson = new Gson();
        shows s = gson.fromJson(json, shows.class);
        
        shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime(), s.getSid(), s.getPrice());
        
     Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
     String st = gsonb.toJson(ns.getID());
     
     return Response.ok(st).build();
    }
    
    //UPDATE SHOWS
    @Path("{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeLamp(@PathParam("id") int showID, String json) {
    	
    		int id = showID;
    		Gson gson = new Gson();
        shows s = gson.fromJson(json, shows.class);
        shows sIn = is.getShowDetail(id);
        
        s.setWid(id);
        
        if (sIn.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + id).build();
        }
        else {
        		is.updateShow(id, s);
        		return Response.status(Response.Status.ACCEPTED).entity("Accepted").build();        }
    }
    
    
  //VIEW SHOWS
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificLamp(@PathParam("id") int lid) {
        // call the "Get Show Detail" use case
        shows s = is.getShowDetail(lid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + lid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s);
            return Response.ok(st).build();
        }
    }
    
    //VIEW ALL SHOWS
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        // calls the "Get All Shows" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(is.getAllShows());
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @PostConstruct
    public void postConstruct() {
        // This method gets executed exactly once, after the servlet container has been created
        // A good place to place code that needs to be executed once, at startup
    }
}


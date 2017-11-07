package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/thalia")
public class REST_shows {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();

	
	
	@PostConstruct
    public void postConstruct() {
        //Initialize theater seating
    		
		Section initSection;
		Seating initSeating;
		Seat initSeat;
		
		//Front Right
		initSection = iseat.createSections("Front Right", 123);
		for(int row = 1; row<=4; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 1; seat<=4; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		
		
		//Front Center
		initSection = iseat.createSections("Front Center", 124);
		for(int row = 1; row<=2; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 5; seat<=8; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		
		initSeating = iseat.createSeating(3);
		for(int seat = 5; seat<=9; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(4);
		for(int seat = 5; seat<=10; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		
		//Front Left
		initSection = iseat.createSections("Front Left", 125);
		for(int row = 1; row<=4; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 1; seat<=4; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}

		
		
		//Main Right
		initSection = iseat.createSections("Main Right", 126);
		for(int row = 5; row<=7; row++) {
			initSeating = iseat.createSeating(row);
					
			for(int seat = 1; seat<=5; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		
		//Main Center
		initSection = iseat.createSections("Main Center", 127);
		
		initSeating = iseat.createSeating(5);
		for(int seat = 6; seat<=11; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(6);
		for(int seat = 6; seat<=12; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(7);
		for(int seat = 6; seat<=13; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);

		
		
		//Main Left
		initSection = iseat.createSections("Main Center", 128);
		
		initSeating = iseat.createSeating(5);
		for(int seat = 12; seat<=16; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(6);
		for(int seat = 13; seat<=17; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(7);
		for(int seat = 14; seat<=18; seat++) {
			initSeat = iseat.createSeats(seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
	}
    
    
    //CREATE SHOWS
	@Path("/show")
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
    @Path("/show/{id}")
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
    @Path("/show/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificShow(@PathParam("id") int lid) {
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
    @Path("/show")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        // calls the "Get All Shows" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(is.getAllShows());
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    
    ///////////////////////////////SEATING///////////////////////////////
    
    //VIEW ALL SEATING
    @Path("/seating")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSeats() {
        // calls the "Get All Seats" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(iseat.getAllSeats());
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    //VIEW SPECIFIC SECTION
    @Path("/seating/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificSection(@PathParam("id") int lid) {
        // call the "Get Show Detail" use case
        Section s = iseat.getSectionDetail(lid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + lid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s);
            return Response.ok(st).build();
        }
    }
    
}


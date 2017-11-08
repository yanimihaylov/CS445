package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/thalia")
public class REST_shows {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	Section initSection;
	Seating initSeating;
	Seat initSeat;

	
	@PostConstruct
    public void postConstruct() {
        //Initialize theater seating
    		
		Section initSection;
		Seating initSeating;
		Seat initSeat;
		
		//Front Right
		initSection = iseat.createSections("Front Right", 123, 0);
		for(int row = 1; row<=4; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 1; seat<=4; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		
		
		//Front Center
		initSection = iseat.createSections("Front Center", 124, 0);
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
		initSection = iseat.createSections("Front Left", 125, 0);
		for(int row = 1; row<=4; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 1; seat<=4; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}

		
		
		//Main Right
		initSection = iseat.createSections("Main Right", 126, 0);
		for(int row = 5; row<=7; row++) {
			initSeating = iseat.createSeating(row);
					
			for(int seat = 1; seat<=5; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		
		//Main Center
		initSection = iseat.createSections("Main Center", 127, 0);
		
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
		initSection = iseat.createSections("Main Center", 128, 0);
		
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
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement showJSON = obj.get("show_info");
		
		JsonArray seatJSON = obj.getAsJsonArray("seating_info");
		
		//JsonObject seatObj = seatJSON.getAsJsonObject();
		
		String showString = showJSON.toString();
		String seatString = seatJSON.get(0).toString();
		
		
		
		System.out.println(showString);
		System.out.println(seatString);
		
        shows s = gson.fromJson(showString, shows.class); 
        shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime());
        
       // String sid = seatObj.get("sid").toString();
       //System.out.println(sid);

        
      //  Section sec;
      //  Section nsec = iseat.createSections("", 0, 0);
        
        for(int i = 0; i < seatJSON.size(); i++)
        {
        		JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
        		Section sec = gson.fromJson(seatJSONobj, Section.class);
        		Section nsec = iseat.createSections(sec.getSection_name(), sec.getSid(), sec.getPrice());
        		
        		for(int row = 1; row<=4; row++) {
        			initSeating = iseat.createSeating(row);
        			
        			for(int seat = 1; seat<=4; seat++) {
        				initSeat = iseat.createSeats(seat);
        				initSeating.seats.add(initSeat);
        			}
        			nsec.seating.add(initSeating);
        		}
        		
        		
        		ns.add(nsec);
        }
        
   /*     
		//Front Right
		initSection = iseat.createSections("Front Right", 123, 0);
		for(int row = 1; row<=4; row++) {
			initSeating = iseat.createSeating(row);
			
			for(int seat = 1; seat<=4; seat++) {
				initSeat = iseat.createSeats(seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		} */
		
		
  
     
	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	String st = gsonb.toJson("Done! :)");
	     
	return Response.ok(st).build();
	
	 /*     
    Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
    String st = gsonb.toJson(ns.getID());
    
    return Response.ok(st).build(); */
     
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


package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/thalia")
public class REST_shows {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	private requestShows rs = new requestShows();
	private initTheater it = new initTheater();
	Section initSection;
	Seating initSeating;
	Seat initSeat;

	
	@PostConstruct
    public void postConstruct() {
        //Initialize theater seating
    		
	}
	
	@GET
	@Path("/")
	public Response initTheater() {
		it.create();
        return Response.status(Response.Status.OK).entity("Theater Built!").build();
	}
    
    
    //CREATE SHOWS
	@Path("/show")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShows(String json) {
		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement showJSON = obj.get("show_info");
		
		JsonArray seatJSON = obj.getAsJsonArray("seating_info");
		
		//JsonObject seatObj = seatJSON.getAsJsonObject();
		
		String showString = showJSON.toString();
		String seatString = seatJSON.get(0).toString();
		
        shows s = gson.fromJson(showString, shows.class); 
        shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime());
        
        for(int i = 0; i < seatJSON.size(); i++)
        {
        		JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
        		Section sec = gson.fromJson(seatJSONobj, Section.class);
        		Section nsec = iseat.createSections(sec.getSection_name(), sec.getSid(), sec.getPrice());
        		int cid;
        		
        		if(sec.getSid()==123) {
        			nsec = it.initFrontRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid()==124) {
        			nsec = it.initFrontCenter();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid()==125) {
        			nsec = it.initFrontLeft();        
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid()==126) {
        			nsec = it.initMainRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid()==127) {
        			nsec = it.initMainCenter();        		
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid()==128) {
        			nsec = it.initMainLeft();}
        		
        		ns.add(nsec);

        }  
     
	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	String st = gsonb.toJson("Done! :)");
	     
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
        		return Response.status(Response.Status.ACCEPTED).entity("Show updated.").build();        }
    }
    
    
  //VIEW SHOWS
    @Path("/show/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificShow(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        shows s = is.getShowDetail(wid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
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
        List<shows> showsList = is.getAllShows();
        String s = gson.toJson(showsList);
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    
    
    //VIEW SHOW SECTIONS
    @Path("/show/{id}/sections")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowSections(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        shows s = is.getShowDetail(wid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s.getSections());
           
            return Response.ok(st).build();
        }
    }
    
    
  //VIEW SHOW SPECIFIC SECTION
    @Path("/show/{id}/sections/{sid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowSpecificSection(@PathParam("id") int wid, @PathParam("sid") int sid) {
        // call the "Get Show Detail" use case
        Section s = is.getSpecificSection(wid, sid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s);
            
            return Response.ok(st).build();
        }
    }
    
    
    
    
    
    
    ///////////////////////////////SEATING///////////////////////////////
  /*  
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
    */
    //VIEW SPECIFIC SECTION
    @Path("/seating/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificSection(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        Section s = iseat.getSectionDetail(wid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s);
            return Response.ok(st).build();
        }
    }
    
    
    //REQUEST SEATS AUTO
    @Path("/seating")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutoSeats(@QueryParam("show") int wid, @QueryParam("section") int sid, @QueryParam("count") int count, @QueryParam("cid") int cid) {
        // call the "Get Show Detail" use case
        requestResponse response = rs.autoShows(wid, sid, count);
        if (response.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(response);
            return Response.ok(st).build();
        }
    }
    
    
    
    
    
    ///////////////////////////////ORDERS///////////////////////////////

   /* //CREATE SHOWS
 	@Path("/orders")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     public Response createOrders(String json) {
 		
         Gson gson = new Gson();
         
         JsonObject obj = gson.fromJson(json, JsonObject.class);
 		JsonElement patronJSON = obj.get("patron_info");
 		
 		JsonArray seatJSON = obj.getAsJsonArray("seats");
 		
 		//JsonObject seatObj = seatJSON.getAsJsonObject();
 		
 		String patronString = patronJSON.toString();
 		String seatString = seatJSON.get(0).toString();
 		
         shows s = gson.fromJson(showString, shows.class); 
         shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime());
         
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
      
 	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
 	String st = gsonb.toJson("Done! :)");
 	     
 	return Response.ok(st).build();
     }
     */
}


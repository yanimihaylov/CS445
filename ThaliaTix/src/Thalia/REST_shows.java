package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/thalia")
public class REST_shows {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	private interfaceOrders iord = new orderManager();
	private InterfaceTicket itic = new ticketManager();
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
		
		
		String showString = showJSON.toString();
		
        shows s = gson.fromJson(showString, shows.class); 
        shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime());
        
        for(int i = 0; i < seatJSON.size(); i++)
        {
        		JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
        		Section sec = gson.fromJson(seatJSONobj, Section.class);
        		Section nsec = iseat.createSections(sec.getSection_name(), sec.getSid(), sec.getPrice());
        		
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
    
    
  //VIEW SHOW
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
    public Response getAutoSeats(@QueryParam("show") int wid, @QueryParam("section") int sid, @QueryParam("count") int count, @QueryParam("starting_seat_id") int cid) {
        // call the "Get Show Detail" use case
        requestResponse response = rs.autoShows(wid, sid, count, cid);
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

    //CRATE ORDERS
 	@Path("/orders")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     public Response createOrders(String json) {
 		
         Gson gson = new Gson();
         
        int price=0;
        int ticketCount=0;
         
        JsonObject obj = gson.fromJson(json, JsonObject.class);
 		JsonElement patronJSON = obj.get("patron_info");
 		JsonElement widJSON = obj.get("wid");
 		JsonElement sidJSON = obj.get("sid");
 		
 		JsonArray seatJSON = obj.getAsJsonArray("seats");
 		
 		//JsonObject seatObj = seatJSON.getAsJsonObject();
 		
 		String patronString = patronJSON.toString();
 		
 		int widInt = Integer.parseInt(widJSON.toString().substring(1,widJSON.toString().length()-1));		
 		int sidInt = Integer.parseInt(sidJSON.toString().substring(1,sidJSON.toString().length()-1));
 		
         patron pat = gson.fromJson(patronString, patron.class); 
         orders ord = iord.createOrder(widInt, sidInt, pat.getName(), pat.getPhone(), pat.getEmail(), pat.getBilling_address(), pat.getCc_number(), pat.getCc_exp_date());
  		 shows s = is.getShowDetail(widInt);         
  		
  		 ord.setShowI(s.getShowInfo());
  		 ord.setWid(widInt);
  		 ord.setSid(sidInt);
  		 
  		List<ticket> ticArray = new ArrayList<ticket>();
         for(int i = 0; i < seatJSON.size(); i++)
         {
        	 	JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
     		Seat st = gson.fromJson(seatJSONobj, Seat.class);
     		int cid = st.getCid();

     		
            Section sec = is.getSpecificSection(widInt, sidInt);
            price = sec.getPrice();
            String name = sec.getSection_name();

     		List<Seating> secArray = sec.getSeating();
     		
     		
     		for(int k=0; k<secArray.size(); k++) {
     			List<Seat> seats = secArray.get(k).getSeats();
     			
     			for(int j=0; j<seats.size(); j++) {
     				if(seats.get(j).getCid() == cid) {
     					seats.get(j).setStatus(false);
     					
     					//create ticket
     					ticket t = itic.createTicket(price, widInt, sidInt, name);
     					t.setPatronInfo(ord.getPat());
     					t.setShowInfo(ord.getShowI());
     					t.setCid(cid);
     					t.setRow(k+1);
     					ticketCount++;
     					ticArray.add(t);
     					
     				}
     			}
     		}
         }
         
         ord.setTickets(ticArray);
         price*=ticketCount;
         ord.setNumberOfTickets(ticketCount);
         ord.setOrderAmount(price);
 	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
 	String ret = gsonb.toJson(ord);
 	     
 	return Response.ok(ret).build();
     }
 	
 	
    //VIEW ALL ORDERS
    @Path("/orders")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        // calls the "Get All Shows" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<orders> showsList = iord.getAllOrders();
        String s = gson.toJson(showsList);
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    
    //VIEW ORDERS BY DATE
    @Path("/ordersD")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutoSeats(@QueryParam("start_date") String startD, @QueryParam("end_date") String endD) {
            // calls the "Get All Shows" use case
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            
            List<orders> ordersList = iord.getAllOrders();
            List<orders> dateList = new ArrayList<orders>();
            
            for(int i=0; i<ordersList.size(); i++) {
            		orders ord = ordersList.get(i);
            		Date dOrdered = ord.getDateOrdered();
            		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");
            		Date dStart = null;
            		Date dEnd = null;
            		
            		
            		try {
						dStart = formatter.parse(startD);
					} catch (ParseException e) {
						e.printStackTrace();
					}
            		
            		try {
						dEnd = formatter.parse(endD);
					} catch (ParseException e) {

						e.printStackTrace();
					}
            		
            		System.out.println("START " +dStart);
            		System.out.println("END " +dEnd);
            		System.out.println("ORDERED " +dOrdered);
            		System.out.println("-----");	
            		System.out.println(dOrdered.before(dEnd));
            		System.out.println(dOrdered.after(dStart));
            		System.out.println("-----NEW------");
            		System.out.println(dOrdered.before(dStart));
            		System.out.println(dOrdered.after(dEnd));
            		System.out.println("-----");
            		
            		
            			if((dOrdered.before(dEnd))&&(dOrdered.after(dStart))) {
            				System.out.println("adding");
            				dateList.add(ord);
            			}
            		
            }
            
            String s = gson.toJson(dateList);
            return Response.status(Response.Status.OK).entity(s).build();
        }
    
    //VIEW ORDER
    @Path("/orders/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("id") int oid) {
        // call the "Get Show Detail" use case
        orders ord = iord.getOrderDetail(oid);
        if (ord.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + oid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(ord);
            return Response.ok(st).build();
        }
    }
    
    
    
    
    ///////////////////////////////TICKETS///////////////////////////////
    
    	
    //VIEW TICKET
    @Path("/tickets/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificTicket(@PathParam("id") int tid) {
        // call the "Get Show Detail" use case
        ticket tic = itic.getTicketDetail(tid);
        if (tic.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + tid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(tic);
            return Response.ok(st).build();
        }
    }
    
    //SCAN TICKET
    @Path("/tickets/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response scanTicket(@PathParam("tid") int tid, String json) {
 		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement tidJSON = obj.get("tid");
		JsonElement statusJSON = obj.get("status");
		
 		int tidInt = Integer.parseInt(tidJSON.toString().substring(1,tidJSON.toString().length()-1));		
		String statusString = statusJSON.toString().substring(1,statusJSON.toString().length()-1);
		
		List<ticket> tixList = itic.getAllTickets();
		
		for(int i=0; i<tixList.size(); i++) {
			if(tixList.get(i).getTid()==tidInt)
				tixList.get(i).setStatus(statusString);
		}
		
		
		
		Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	 	String ret = gsonb.toJson(obj);
	 	     
	 	return Response.ok(ret).build();
    }
}


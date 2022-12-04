package Control;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.SSLEngineResult.Status;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import Entity.Flight;
import Entity.Seat;
import Entity.StatusEnum;



public class ReadJSN {
	public static ArrayList<Flight> jsonFlights ;
	public static Flight flight;
	public static Seat seatjson;
	public static ArrayList<Seat> arraySeats;
	public static int aircraftID;
	
	/**
	 * imports flights and seats from json to db.
	 * @param path json filepath.
	 */
    public static  void importFlightsFromJSON(String path) {
    	
    	jsonFlights = new ArrayList<Flight>(); 
    	arraySeats = new ArrayList<Seat>();
    	
    	
    	try (FileReader reader = new FileReader(new File(path))) {
    		JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
    		JsonArray flights = (JsonArray) doc.get("cancelled");
    		Iterator<Object> iterator = flights.iterator();

    		//need to update DB
    		while (iterator.hasNext()) {
    			JsonObject obj = (JsonObject) iterator.next();
    			
    			String a = (String) obj.get("FlightID");	
				int flightID = Integer.parseInt(a);

				String m =  (String)obj.get("DepartureDate");
				java.sql.Time departureTime = saveTheTime(m);
				java.sql.Date departureDate = saveTheDate(m);			 
				
				String n =  (String)obj.get("LandingDate");
				java.sql.Time landingTime = saveTheTime(n);
				java.sql.Date landingDate = saveTheDate(n);
				
				String c = (String) obj.get("AirportOrig");	
				int airportOrig = Integer.parseInt(c);
				
				String b = (String) obj.get("AirportDest");	
				int airportDest = Integer.parseInt(b);
				
				String y =  (String)obj.get("LastUpdated");
				java.sql.Date lastUpdated = saveTheDate(y);				
				
				String f = (String) obj.get("AircraftID");	
				 aircraftID = Integer.parseInt(f);
		    		JsonArray seats = (JsonArray) obj.get("Seats");
					seats.forEach(entry -> {
				        JsonObject seat = (JsonObject) entry;
				        String seat1 = (String) seat.get("idSeat");
				        int seat1I = Integer.parseInt(seat1);
				        String seat2 =(String) seat.get("rowNumber");
				        int seat2I = Integer.parseInt(seat2);
				        String seat3 =(String) seat.get("seatNumber");
				        
				        String seat4 =(String) seat.get("SeatStatus");
				        String seat5 =(String) seat.get("busy");
				        Boolean seat5B = Boolean.parseBoolean(seat5);
				        
				        seatjson = new Seat(seat1I, seat2I, seat3, seat4,seat5B,aircraftID	);
				        arraySeats.add(seatjson); 
					});
				
		        for (Seat s1 : arraySeats ) {
					FlightControl.getInstance().updateSeats(s1.getIdSeat(), s1.getRowNumber(), 
							s1.getSeatNumber(), s1.getDepartment(),s1.getAircraftID(), s1.isBusy());
				}
				flight = new Flight(flightID,  departureTime, departureDate,  landingTime, landingDate, (String) obj.get("Status"), airportOrig, 
				airportDest,  aircraftID, lastUpdated);
				jsonFlights.add(flight);
    			
				for (Flight f1 : jsonFlights ) {
					FlightControl.getInstance().updateFlight(f1.getId(), f1.getDepartureTime(), f1.getDepartureDate(), f1.getLandingTime(), f1.getLandingDate(),f1.getOrigID(), f1.getDestID(), f1.getStatus(), f1.getAircraftID(), f1.getLastUpdated());
				}
	
    		}
			System.out.println("good");
    	} catch (IOException | DeserializationException e) {
    		e.printStackTrace();
    	}
    }

    
	public static java.sql.Date saveTheDate(String date)
	{
		String year="";
		String month="";
		String day="";
		
		char[] myStr = date.toCharArray();

		
		for(int i=0; i<4; i++)
		{
			year += myStr[i];
		}
		
		for(int i=5; i<7; i++)
		{
			month += myStr[i];
		}
		
		for(int i=8; i<10; i++)
		{
			day += myStr[i];
		}
		
		int yearDate = Integer.parseInt(year);
		int monthDate = Integer.parseInt(month);
		int dayDate = Integer.parseInt(day);
	//	System.out.println(year);
		//System.out.println(month);
	//	System.out.println(day);
		LocalDate date2 = LocalDate.of(yearDate, monthDate, dayDate);
	//	System.out.println("date 222 " + date2);
		java.sql.Date myDate =java.sql.Date.valueOf(date2);
	//	System.out.println(myDate);
		return myDate;
		
	}
	
	public static java.sql.Time saveTheTime(String date)
	{
		String hour="";
		String minute="";
		
		
		char[] myStr = date.toCharArray();

		
		for(int i=11; i<13; i++)
		{
			hour += myStr[i];
		}
		
		for(int i=14; i<16; i++)
		{
			minute += myStr[i];
		}
		
		
		int hourTime = Integer.parseInt(hour);
		int minuteTime = Integer.parseInt(minute);
		java.sql.Time myDate=new java.sql.Time(hourTime, minuteTime, 0);
		return myDate;
		
	}
}

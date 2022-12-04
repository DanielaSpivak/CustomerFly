package Control;



import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.TimeZone;

import Entity.Aircraft;
import Entity.Airport;
import Entity.Customer;
import Entity.Flight;
import Entity.FlightAttendant;
import Entity.PilostInFlight;
import Entity.Pilot;
import Entity.Seat;

public class FlightSystem {
	
	
	private static FlightSystem flightSystem = null;
	private HashMap<Integer, Flight> flights;
	//private HashMap<Integer, Airport> airports;
	//private HashMap<Integer, Aircraft> aircrafts;
	//private HashMap<Integer, FlightAttendant> flightAttendants;
	//private HashMap<Integer, Pilot> pilots;
	//private HashMap<Flight, PilostInFlight> pilostInFlight;
	//private HashMap<Integer, Seat> seats;
	//private HashMap<HashMap<Integer, Flight>,ArrayList<Customer>> getCustomersfromUpdatedFlights;
	//private int flightID;
    public HashMap<String,String> cityAirportHm ;
    private HashMap<Integer, Seat> seats;
	
    
	public static FlightSystem getInstance()
	{
		if(flightSystem == null)
			flightSystem = new FlightSystem();
		return flightSystem;
	}
	
//	public FlightSystem(int flightID) {
//		this.flightID = flightID;
//	}
	public FlightSystem() {

		flights = new HashMap<Integer, Flight>();
		//getCustomersfromUpdatedFlights = new HashMap <HashMap<Integer, Flight>,ArrayList<Customer>> ();
		
		for(Flight flight: FlightControl.getInstance().getFlights()) {
			flights.put(flight.getId(), flight);
		}
		
		seats = new HashMap<Integer, Seat>();
		for(Seat seat: FlightControl.getInstance().getSeats()) {
			seats.put(seat.getIdSeat(), seat);
		}
		
		
	}

	public HashMap<Integer, Flight> getFlights() {
		return flights;
	}

	public HashMap<Integer, Seat> getSeats() {
		return seats;
	}
	
	public ArrayList <Seat> getSeatsByFlight (int flightID) {
		ArrayList<Seat> seatsInFlight = new ArrayList<>();
		if(flights.containsKey(flightID)) {
			flights.get(flightID);
			
				for(Seat s: seats.values()) {
					if(flights.get(flightID).getAircraftID() == s.getAircraftID() && !seatsInFlight.contains(s)) {
						seatsInFlight.add(s);
					}
				
			}
		}
		if(!seatsInFlight.isEmpty())
			return seatsInFlight;
		return null;
	}
	
		


	}
	

	


	
	
	


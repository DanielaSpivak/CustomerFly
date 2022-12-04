package Entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class Flight {
	//private static int idCounter = 1;
	private int id;
	private int destID;
	private int origID; 
	private Time departureTime;
	private Time landingTime;
	private Date lastUpdated;
	private Date landingDate;
	private Date departureDate;
	private String status;
	private int aircraftID;
	private static int idCounter = 1;
	private double flightLength;
	

	
	//Association class.
	private Set<PilostInFlight> pilotsInFligt;
	private Set<StewardessInFlight> stewardessInFlight;
	private Set<FlightInAirport> flightInAirport;
	

	public Flight(int id, Time departureTime, Date departureDate, Time landingTime, Date landingDate,  String status, int origID, int destID,int aircraftID, Date updateDate) {
		super();
		this.id = id;
		idCounter++;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.landingTime = landingTime;
		this.landingDate = landingDate;
		this.destID = destID;
		this.origID = origID;
		if(status.equals("ONTIME"))
			this.setStatus(StatusEnum.ONTIME);
		else if(status.equals("DELAYED"))
			this.setStatus(StatusEnum.DELAYED);
		else if(status.equals("CANCELLED"))
			this.setStatus(StatusEnum.CANCELLED);
		
		this.aircraftID = aircraftID;
		if (updateDate != null)
			this.lastUpdated = updateDate;
		else {this.lastUpdated=null;}
		
		
		this.pilotsInFligt = new HashSet <PilostInFlight> ();
		this.stewardessInFlight = new HashSet <StewardessInFlight> ();
		this.flightInAirport = new HashSet <FlightInAirport> ();
		//Airport airportOrg = new Airport(orgAirport);
		//Airport airportDest = new Airport(destAirportId);
	}
	
	/*public Flight(Time departureTime, Date departureDate, Time landingTime,
			Date landingDate, String status,int destID, int origID, int aircraftID) {
		super();
		this.id = idCounter++;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.landingTime = landingTime;
		this.landingDate = landingDate;
		this.destID = destID;
		this.origID = origID;

		if(status == "ontime")
			this.setStatus(StatusEnum.ONTIME);
		else if(status == "delayed")
			this.setStatus(StatusEnum.DELAYED);
		else if(status == "cancelled")
			this.setStatus(StatusEnum.CANCELLED);
		
		this.aircraftID = aircraftID;
		
		
		this.pilotsInFligt = new HashSet <PilostInFlight> ();
		this.stewardessInFlight = new HashSet <StewardessInFlight> ();
		this.flightInAirport = new HashSet <FlightInAirport> ();
		//Airport airportOrg = new Airport(orgAirportId);
		//Airport airportDest = new Airport(destAirportId);
	}
	*/
	
	//custFly DB
	public Flight(int id, int destID, int origID, Time departureTime, Time landingTime) {
		super();
		this.id = id;
		this.destID = destID;
		this.origID = origID;
		this.departureTime = departureTime;
		this.landingTime = landingTime;
	}

	public Flight(int id) {
		this.id = id;
	}

	//Get and Set methods
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Time getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(Time landingTime) {
		this.landingTime = landingTime;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	


	public String getStatus() {
		return status;
	}

	public void setStatus(StatusEnum statusEnum) {
		this.status = statusEnum.toString();
	}
	
	public Date getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}


	public Set<PilostInFlight> getPilotsInFligt() {
		return pilotsInFligt;
	}


	public Set<StewardessInFlight> getStewardessInFlight() {
		return stewardessInFlight;
	}


	public Set<FlightInAirport> getFlightInAirport() {
		return flightInAirport;
	}

	/**
	 * @return the aircraftID
	 */
	public int getAircraftID() {
		return aircraftID;
	}

	/**
	 * @param aircraftID the aircraftID to set
	 */
	public void setAircraftID(int aircraftID) {
		this.aircraftID = aircraftID;
	}

	public int getDestID() {
		return destID;
	}

	public void setDestID(int destID) {
		this.destID = destID;
	}

	public int getOrigID() {
		return origID;
	}

	public void setOrigID(int origID) {
		this.origID = origID;
	}

	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", destID=" + destID + ", origID=" + origID + ", departureTime=" + departureTime
				+ ", landingTime=" + landingTime + ", lastUpdated=" + lastUpdated + ", landingDate=" + landingDate
				+ ", departureDate=" + departureDate + ", status=" + status + ", aircraftID=" + aircraftID + "]";
	}


	
	
//	public Set<PilostInFlight> getPilotsInFligt() {
//		return  Collections.unmodifiableSet(pilotsInFligt);
//	}
//
//	public Set<StewardessInFlight> getStewardessInFlight() {
//		return Collections.unmodifiableSet(stewardessInFlight);
//	}
//
//	public Set<FlightInAirport> getFlightInAirport() {
//		return Collections.unmodifiableSet(flightInAirport);
//	}
//	
	
	
}

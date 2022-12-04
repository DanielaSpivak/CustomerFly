package Entity;
import java.sql.Time;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class Airport {
	//private static int idCounter = 1;
	private int id;
	private String country;
	private String city;
	private String tmz;
	
	private Set<FlightInAirport> flightInAirport;
	
	
	
	public Airport(int id, String country, String city, String tmz) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.tmz = tmz;

		this.flightInAirport = new HashSet <FlightInAirport> ();
	}
	
	public Airport(int id) {
		super();
		this.id = id;
		this.flightInAirport = new HashSet <FlightInAirport> ();
	}

	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the tmz
	 */
	public String getTmz() {
		return tmz;
	}

	/**
	 * @param tmz the tmz to set
	 */
	public void setTmz(String tmz) {
		this.tmz = tmz;
	}

	public Set<FlightInAirport> getFlightInAirport() {
		return flightInAirport;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", country=" + country + ", city=" + city + ", tmz=" + tmz + ", flightInAirport="
				+ flightInAirport + "]";
	}
	
//	public Set<FlightInAirport> getFlightInAirport() {
//		return Collections.unmodifiableSet(flightInAirport);
//	}
	
	
	
 
}

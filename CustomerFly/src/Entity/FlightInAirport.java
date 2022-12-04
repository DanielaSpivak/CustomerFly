package Entity;

public class FlightInAirport {
	
	private Flight flight;
	private Airport airport;
	private AirportType destOrOrigin;
	
	//Association class.
	public FlightInAirport(Flight flight, Airport airport, AirportType destOrOrigin) {
		super();
		this.flight = flight;
		this.airport = airport;
		this.destOrOrigin = destOrOrigin;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public AirportType getDestOrOrigin() {
		return destOrOrigin;
	}

	public void setDestOrOrigin(AirportType destOrOrigin) {
		this.destOrOrigin = destOrOrigin;
	}
	

	
	
	
	
	

}

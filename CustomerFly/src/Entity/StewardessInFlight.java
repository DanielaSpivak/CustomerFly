package Entity;

public class StewardessInFlight {
	//Association class.
	private Flight flight;
	private FlightAttendant flightAttendant;
	private int serialInFlight;
	private int idFlight;
	private int idFA;
	
	
	
	public StewardessInFlight(int idFlight,int idFA, int serialInFlight) {
		super();
		this.flight = new Flight(idFlight);
		this.flightAttendant = new FlightAttendant(idFA);
		this.serialInFlight = serialInFlight;
	}
	
	public int getIdFlight() {
		return idFlight;
	}

	public void setIdFlight(int idFlight) {
		this.idFlight = idFlight;
	}

	public int getIdFA() {
		return idFA;
	}

	public void setIdFA(int idFA) {
		this.idFA = idFA;
	}

	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public FlightAttendant getFlightAttendant() {
		return flightAttendant;
	}
	public void setFlightAttendant(FlightAttendant flightAttendant) {
		this.flightAttendant = flightAttendant;
	}
	public int getSerialInFlight() {
		return serialInFlight;
	}
	public void setSerialInFlight(int serialInFlight) {
		this.serialInFlight = serialInFlight;
	}
	
	

}

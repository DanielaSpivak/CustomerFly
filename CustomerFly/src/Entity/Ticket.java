package Entity;

public class Ticket {
	private int ticketID;
	private int flightID;
	
	public Ticket(int ticketID, int flightID) {
		super();
		this.ticketID = ticketID;
		this.flightID = flightID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flightID;
		result = prime * result + ticketID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (flightID != other.flightID)
			return false;
		if (ticketID != other.ticketID)
			return false;
		return true;
	}
	
	
	
	
	

}

package Entity;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FlightAttendant extends Employee {
	private static int idCounter = 1;
	//Association class.
	private Set<StewardessInFlight> stewardessInFlight;
	
	public FlightAttendant(int id, String firstName, String lastName, Date startDate, Date finishDate) {
		super(id, firstName, lastName, startDate, finishDate);
		this.stewardessInFlight = new HashSet <StewardessInFlight> ();
	}
	
	public FlightAttendant (int id) {
		super(id);
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		FlightAttendant.idCounter = idCounter;
	}

	public Set<StewardessInFlight> getStewardessInFlight() {
		return Collections.unmodifiableSet(stewardessInFlight);
	}
	
	
	
	
	
	

	
	
	

}

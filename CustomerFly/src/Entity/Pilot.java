package Entity;

import java.util.Collections;
import java.util.HashSet;
//import java.util.Date;
import java.util.Set;
import java.sql.Date;


public class Pilot extends Employee {
	
	private static int idCounter = 1;
	private int licenseNumber;
	private Date dateOfLiscense;
	//Association class.
	private Set<PilostInFlight> pilotsInFligt;
	
	
	public Pilot(int id, String firstName, String lastName, Date startDate, Date finishDate, 
			int licenseNumber, Date dateOfLiscense) {
		super(id, firstName, lastName, startDate, finishDate);
		this.licenseNumber = licenseNumber;
		this.dateOfLiscense = dateOfLiscense;
		this.pilotsInFligt = new HashSet<>();
	}
	
	public Pilot (int id) { 
		super(id);
	}
	//Get and Set methods
	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Pilot.idCounter = idCounter;
	}

	public int getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getDateOfLiscense() {
		return dateOfLiscense;
	}

	public void setDateOfLiscense(Date dateOfLiscense) {
		this.dateOfLiscense = dateOfLiscense;
	}

	public Set<PilostInFlight> getPilotsInFligt() {
		return Collections.unmodifiableSet(pilotsInFligt);
	}

	@Override
	public String toString() {
		return "Pilot [licenseNumber=" + licenseNumber + ", dateOfLiscense=" + dateOfLiscense + "]";
	}
	
	
	
	

}

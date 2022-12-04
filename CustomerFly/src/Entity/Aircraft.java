package Entity;

import Control.FlightControl;

public class Aircraft {
	private int empennageNumber;
	private int attendantsNumber;

	

	
	public Aircraft(int empennageNumber, int attendantsNumber) {
		super();
		this.empennageNumber = empennageNumber;
		this.attendantsNumber = attendantsNumber;
	}

	public Aircraft(int empennageNumber) {
		super();
		this.empennageNumber = empennageNumber;
	}

	public int getEmpennageNumber() {
		return empennageNumber;
	}

	public void setEmpennageNumber(int empennageNumber) {
		this.empennageNumber = empennageNumber;
	}

	public int getAttendantsNumber() {
		return attendantsNumber;
	}

	public void setAttendantsNumber(int attendantsNumber) {
		this.attendantsNumber = attendantsNumber;
	}
	public int getAircraftSize() {
		int aircraftID=0;
		for (Seat seat: FlightControl.getInstance().getSeats()) {
			if (seat.getAircraftID() == this.getEmpennageNumber())
				aircraftID++;
		}
		return aircraftID;
	}




	@Override
	public String toString() {
		return "Aircraft [empennageNumber=" + empennageNumber + ", attendantsNumber=" + attendantsNumber + ", seats="
				 + ",   ]";
	}
	
	
	
	
	
	
	
	

}

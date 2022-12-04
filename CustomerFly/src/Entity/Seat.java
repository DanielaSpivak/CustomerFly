package Entity;

public class Seat {
	private int idSeat;
	private int rowNumber;
	private String seatNumber;
	private String department;
	private static int idCounter = 1;
	private boolean busy;
	private int aircraftID;
	
	public Seat(int idSeat, int rowNumber, String seatNumber,
			String department,boolean busy, int aircraftID) {
		super();
		this.idSeat = idSeat;
		this.rowNumber = rowNumber;
		this.seatNumber = seatNumber;
		if(department.equals("BUSSINESCLASS") )
			this.setDepartment(HirarchSeat.BUSSINESCLASS);
		if(department.equals ("FIRSTCLASS")) 
			this.setDepartment(HirarchSeat.FIRSTCLASS);
		if(department.equals("TOURISTCLASS"))
			this.setDepartment(HirarchSeat.TOURISTCLASS);
		this.busy = busy;
		this.aircraftID = aircraftID;
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

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the busy
	 */
	public boolean isBusy() {
		return busy;
	}

	/**
	 * @param busy the busy to set
	 */
	public void setBusy(boolean busy) {
		this.busy = busy;
	}


	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(HirarchSeat department) {
		this.department = department.toString();
	}

	public int getIdSeat() {
		return idSeat;
	}

	@Override
	public String toString() {
		return "Seat [idSeat=" + idSeat + ", rowNumber=" + rowNumber + ", seatNumber=" + seatNumber + ", department="
				+ department + ", busy=" + busy + ", aircraftID=" + aircraftID + "]";
	}
	
	
	
	

}

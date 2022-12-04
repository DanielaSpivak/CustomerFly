package Entity;

public class PriceConts {
	private int ticketID;
	private int flightTimeConst;
	private int departmentConst;
	private int mealConst;
	private int permiumConst;
	
	public PriceConts(int ticketID, int flightTimeConst, int departmentConst, int mealConst, int permiumConst) {
		super();
		this.ticketID = ticketID;
		this.flightTimeConst = flightTimeConst;
		this.departmentConst = departmentConst;
		this.mealConst = mealConst;
		this.permiumConst = permiumConst;
	}
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getFlightTimeConst() {
		return flightTimeConst;
	}
	public void setFlightTimeConst(int flightTimeConst) {
		this.flightTimeConst = flightTimeConst;
	}
	public int getDepartmentConst() {
		return departmentConst;
	}
	public void setDepartmentConst(int departmentConst) {
		this.departmentConst = departmentConst;
	}
	public int getMealConst() {
		return mealConst;
	}
	public void setMealConst(int mealConst) {
		this.mealConst = mealConst;
	}
	public int getPermiumConst() {
		return permiumConst;
	}
	public void setPermiumConst(int permiumConst) {
		this.permiumConst = permiumConst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentConst;
		result = prime * result + flightTimeConst;
		result = prime * result + mealConst;
		result = prime * result + permiumConst;
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
		PriceConts other = (PriceConts) obj;
		if (departmentConst != other.departmentConst)
			return false;
		if (flightTimeConst != other.flightTimeConst)
			return false;
		if (mealConst != other.mealConst)
			return false;
		if (permiumConst != other.permiumConst)
			return false;
		if (ticketID != other.ticketID)
			return false;
		return true;
	}
	
	
	
	
	

}

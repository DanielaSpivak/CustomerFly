package Entity;

//include in erd
public class TicketInOrder {
	private int orderID;
	private int ticketID;
	private Meal mealType;
	private HirarchSeat deparment;
	
	public TicketInOrder(int orderID, int ticketID, Meal mealType, HirarchSeat deparment) {
		super();
		this.orderID = orderID;
		this.ticketID = ticketID;
		this.mealType = mealType;
		this.deparment = deparment;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public Meal getMealType() {
		return mealType;
	}

	public void setMealType(Meal mealType) {
		this.mealType = mealType;
	}

	public HirarchSeat getDeparment() {
		return deparment;
	}

	public void setDeparment(HirarchSeat deparment) {
		this.deparment = deparment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deparment == null) ? 0 : deparment.hashCode());
		result = prime * result + ((mealType == null) ? 0 : mealType.hashCode());
		result = prime * result + orderID;
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
		TicketInOrder other = (TicketInOrder) obj;
		if (deparment != other.deparment)
			return false;
		if (mealType != other.mealType)
			return false;
		if (orderID != other.orderID)
			return false;
		if (ticketID != other.ticketID)
			return false;
		return true;
	}
	
	
	
}

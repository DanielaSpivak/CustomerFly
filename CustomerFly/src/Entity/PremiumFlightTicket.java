package Entity;

public class PremiumFlightTicket extends Ticket{
	
	private int maxWeight;
	private int currentWeight;
	
	public PremiumFlightTicket(int ticketID, int flightID, int maxWeight, int currentWeight) {
		super(ticketID, flightID);
		this.maxWeight = maxWeight;
		this.currentWeight = currentWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + currentWeight;
		result = prime * result + maxWeight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiumFlightTicket other = (PremiumFlightTicket) obj;
		if (currentWeight != other.currentWeight)
			return false;
		if (maxWeight != other.maxWeight)
			return false;
		return true;
	}
	
	
	
	
	

}

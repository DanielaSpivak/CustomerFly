package Entity;

public class PilostInFlight {
	//Association class.
	private Pilot pilot;
	private Flight flight;
	private short rank;
	private Boolean busy;
	private int id;
	
	public PilostInFlight(int id, short rank, boolean busy) {
		super();
		this.pilot = new Pilot(id);
		this.rank = rank;
		this.busy = busy;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public short getRank() {
		return rank;
	}
	public void setRank(short rank) {
		this.rank = rank;
	}

	public Boolean getBusy() {
		return busy;
	}

	public void setBusy(Boolean busy) {
		this.busy = busy;
	}

	@Override
	public String toString() {
		return "PilostInFlight [pilot=" + pilot + ", flight=" + flight + ", rank=" + rank + "]";
	}
	
	
	
	
	
	

}

package Entity;

public class ProvidedBy {
	private int entertainmentID;
	private int supplierID;
	
	public ProvidedBy(int entertainmentID, int supplierID) {
		super();
		this.entertainmentID = entertainmentID;
		this.supplierID = supplierID;
	}

	public int getEntertainmentID() {
		return entertainmentID;
	}

	public void setEntertainmentID(int entertainmentID) {
		this.entertainmentID = entertainmentID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entertainmentID;
		result = prime * result + supplierID;
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
		ProvidedBy other = (ProvidedBy) obj;
		if (entertainmentID != other.entertainmentID)
			return false;
		if (supplierID != other.supplierID)
			return false;
		return true;
	}
	
	
	
}

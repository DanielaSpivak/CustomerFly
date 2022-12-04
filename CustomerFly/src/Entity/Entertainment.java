package Entity;

public class Entertainment {
	
	private int entertainmentID;
	private String entertainmentName;
	private String description;
	private Type type;
	
	
	public Entertainment(int entertainmentID, String entertainmentName, String description, Type type) {
		super();
		this.entertainmentID = entertainmentID;
		this.entertainmentName = entertainmentName;
		this.description = description;
		this.type = type;
	}


	public int getEntertainmentID() {
		return entertainmentID;
	}


	public void setEntertainmentID(int entertainmentID) {
		this.entertainmentID = entertainmentID;
	}


	public String getEntertainmentName() {
		return entertainmentName;
	}


	public void setEntertainmentName(String entertainmentName) {
		this.entertainmentName = entertainmentName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + entertainmentID;
		result = prime * result + ((entertainmentName == null) ? 0 : entertainmentName.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Entertainment other = (Entertainment) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (entertainmentID != other.entertainmentID)
			return false;
		if (entertainmentName == null) {
			if (other.entertainmentName != null)
				return false;
		} else if (!entertainmentName.equals(other.entertainmentName))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
	
	

}

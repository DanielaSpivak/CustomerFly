
package Entity;

import java.sql.Date;

public class Customer {
	private int passportNumber;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthDate;
	private String mainCitizenship;
	private String password;
	
	
	public Customer(int passportNumber, String firstName, String lastName, String email, Date birthDate,
			String mainCitizenship, String password) {
		super();
		this.passportNumber = passportNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.mainCitizenship = mainCitizenship;
		this.password = password;
	}
	
	public Customer(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMainCitizenship() {
		return mainCitizenship;
	}

	public void setMainCitizenship(String mainCitizenship) {
		this.mainCitizenship = mainCitizenship;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mainCitizenship == null) ? 0 : mainCitizenship.hashCode());
		result = prime * result + passportNumber;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Customer other = (Customer) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mainCitizenship == null) {
			if (other.mainCitizenship != null)
				return false;
		} else if (!mainCitizenship.equals(other.mainCitizenship))
			return false;
		if (passportNumber != other.passportNumber)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	
	
	

}

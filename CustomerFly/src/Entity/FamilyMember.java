package Entity;

import java.sql.Date;

public class FamilyMember extends Customer{
	private int familyMemberID;

	public FamilyMember(int passportNumber, String firstName, String lastName, String email, Date birthDate,
			String mainCitizenship, String password, int familyMemberID) {
		super(passportNumber, firstName, lastName, email, birthDate, mainCitizenship, password);
		this.familyMemberID = familyMemberID;
	}
	
	public FamilyMember(int passportNumber, int familyMemberID) {
		super(passportNumber);
		this.familyMemberID = familyMemberID;
	}
	

	public int getFamilyMemberID() {
		return familyMemberID;
	}

	public void setFamilyMemberID(int familyMemberID) {
		this.familyMemberID = familyMemberID;
	}
	
	
	

}

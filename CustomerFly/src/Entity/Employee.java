package Entity;

import java.util.Date;

public abstract class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private Date startDate;
	private Date finishDate;
	private boolean busy;
	
	public Employee(int id, String firstName, String lastName, Date startDate, Date finishDate, boolean busy) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.busy = busy;
	}
	//employee is busy
	public Employee(int id, String firstName, String lastName, Date startDate, Date finishDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.busy = true;
	}
	public Employee (int id) {
		this.id = id;
	}
	//Get and Set methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", startDate=" + startDate
				+ ", finishDate=" + finishDate + ", busy=" + busy + "]";
	}
	
	
	
	
	
	

}

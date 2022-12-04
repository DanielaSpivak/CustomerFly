package Entity;

import java.sql.Date;

public class Order {
	private int orderID;
	private Date dateOfOrder;
	private String paymentMethod;
	private int custID;
	
	public Order(int orderID, Date dateOfOrder, String paymentMethod, int custID) {
		super();
		this.orderID = orderID;
		this.dateOfOrder = dateOfOrder;
		this.paymentMethod = paymentMethod;
		
		if(paymentMethod == "cradit")
			this.setPaymentMethod(Payment.cradit);
		else if(paymentMethod == "paypal")
			this.setPaymentMethod(Payment.paypal);
		else if(paymentMethod == "bankTransfer")
			this.setPaymentMethod(Payment.bankTransfer);
		this.custID = custID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Payment paymentMethod) {
		this.paymentMethod = paymentMethod.toString();
	}

	public int getCust() {
		return custID;
	}

	public void setCust(int custID) {
		this.custID = custID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custID;
		result = prime * result + ((dateOfOrder == null) ? 0 : dateOfOrder.hashCode());
		result = prime * result + orderID;
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
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
		Order other = (Order) obj;
		if (custID != other.custID)
			return false;
		if (dateOfOrder == null) {
			if (other.dateOfOrder != null)
				return false;
		} else if (!dateOfOrder.equals(other.dateOfOrder))
			return false;
		if (orderID != other.orderID)
			return false;
		if (paymentMethod != other.paymentMethod)
			return false;
		return true;
	}

	
	
	
	

}

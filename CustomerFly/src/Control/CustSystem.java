package Control;


import java.util.HashMap;

import Entity.Customer;
import Entity.FamilyMember;
import Entity.Order;
import Entity.PremiumFlightTicket;
import Entity.Ticket;

public class CustSystem {
	private static CustSystem custSystem = null;
	private HashMap<Integer, Customer> customers;
	private HashMap<Integer, Ticket> tickets;
	private HashMap<Integer, Order> orders;
	private HashMap<Integer, FamilyMember> familyMembers;
	private HashMap<Integer, PremiumFlightTicket> premiumFlightTickets;
	
	
	
	public static CustSystem getInstance()
	{
		if(custSystem == null)
			custSystem = new CustSystem();
		return custSystem;
	}
	
	public CustSystem() {
		customers = new HashMap<>();
		tickets = new HashMap<>();
		orders = new HashMap<>();
		familyMembers = new HashMap<>();
		premiumFlightTickets = new HashMap<>();
	
		for(Customer cust: OrderAndCustControl.getInstance().getCustomers()) {
			customers.put(cust.getPassportNumber(), cust);
		}
		
		for(Ticket t: OrderAndCustControl.getInstance().getTickets()) {
			tickets.put(t.getTicketID(), t);
		}
		
		for(Order o: OrderAndCustControl.getInstance().getOrders()) {
			orders.put(o.getOrderID(), o);
		}
		
		for(FamilyMember fm: OrderAndCustControl.getInstance().getFamilyMembers()) {
			familyMembers.put(fm.getFamilyMemberID(), fm);
		}
		
		for(PremiumFlightTicket pt: OrderAndCustControl.getInstance().getPremiumFlightTickets()) {
			premiumFlightTickets.put(pt.getTicketID(), pt);
		}
	}

	public HashMap<Integer, Customer> getCustomers() {
		return customers;
	}

	public HashMap<Integer, Ticket> getTickets() {
		return tickets;
	}

	public HashMap<Integer, Order> getOrders() {
		return orders;
	}

	public HashMap<Integer, FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public HashMap<Integer, PremiumFlightTicket> getPremiumFlightTickets() {
		return premiumFlightTickets;
	}
	
	
}

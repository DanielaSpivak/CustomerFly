package Control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Entity.Consts;
import Entity.ConstsCustFly;
import Entity.Customer;
import Entity.FamilyMember;
import Entity.Flight;
import Entity.Order;
import Entity.PremiumFlightTicket;
import Entity.Ticket;

public class OrderAndCustControl {
	
		//custFLY
		private static OrderAndCustControl _instance;
		
		private OrderAndCustControl() {
			
		}
		
		public static OrderAndCustControl getInstance() {
			if (_instance == null)
				_instance = new OrderAndCustControl();
			return _instance;
		}
		
		/**
		 * fetches all customers from DB file.
		 * @return ArrayList of flights.
		 */
		public ArrayList<Customer> getCustomers() {
			ArrayList<Customer> results = new ArrayList<Customer>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_CUST);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Customer(rs.getInt(i++),rs.getString(i++), rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++),rs.getString(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		/**
		 * fetches all orders from DB file.
		 * @return ArrayList of flights.
		 */
		
		public ArrayList<Order> getOrders() {
			ArrayList<Order> results = new ArrayList<Order>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_ORDER);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Order(rs.getInt(i++),rs.getDate(i++), rs.getString(i++), rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		/**
		 * fetches all tickets from DB file.
		 * @return ArrayList of flights.
		 */
		
		public ArrayList<Ticket> getTickets() {
			ArrayList<Ticket> results = new ArrayList<Ticket>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_TICKET);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new Ticket(rs.getInt(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		/**
		 * fetches all premium flight tickets from DB file.
		 * @return ArrayList of flights.
		 */
		
		public ArrayList<PremiumFlightTicket> getPremiumFlightTickets() {
			ArrayList<PremiumFlightTicket> results = new ArrayList<PremiumFlightTicket>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_TICKET);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new PremiumFlightTicket(rs.getInt(i++),rs.getInt(i++), rs.getInt(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		
		/**
		 * fetches all FamilyMembers from DB file.
		 * @return ArrayList of flights.
		 */
		
		public ArrayList<FamilyMember> getFamilyMembers() {
			ArrayList<FamilyMember> results = new ArrayList<FamilyMember>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_TICKET);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.add(new FamilyMember(rs.getInt(i++),rs.getInt(i++)));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
		}
		
		public HashMap<Integer, Integer> getCustomersFromUpdatedFlights (int flightID) {
			HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
						PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_getCustomersfromUpdatedFlights);
						ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						int i = 1;
						results.put((rs.getInt(i++)), flightID);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return results;
			
		}

}

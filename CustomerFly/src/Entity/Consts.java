package Entity;

import java.net.URLDecoder;

public class Consts {
	


	private Consts() {
		throw new AssertionError();
	}
	
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	/*----------------------------------------- FLIGHTS QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_FLIGHT = "SELECT * FROM Flight";
	public static final String SQL_DELETE_FLIGHT = "{ call deleteFlight(?) }";
	public static final String SQL_ADD_NEW_FLIGHT = "{ call ADDFLIGHT(?,?,?,?,?,?,?,?,?) }";
	public static final String SQL_ADD_FLIGHT_TO_FLIGHTINAIRPORT = "{ call addFlightInAirport(?,?,?) }";
	public static final String SQL_UPDATE_FLIGHT = "{ call updateFlight(?,?,?,?,?,?,?,?,?,?) }";
	/*----------------------------------------- STAFF QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_FLIGHTATTENDED = "SELECT * FROM FlightAttendant";
	public static final String SQL_SELECTALL_PILOTS = "SELECT * FROM Pilot";
	public static final String SQL_AVAILABLE_FLIGHTATTENDED = "{ call availableFlightAttendeds() }";
	public static final String SQL_ADD_FLIGHTATTENDED_TO_FLIGHT = "{ call AddFAToFlight(?,?) }";
	public static final String SQL_AVAILABLE_PILOTS = "{ call availablePilots(????) }";
	public static final String SQL_ADD_PILOTS_TO_FLIGHT = "{ call addPilotsToFlight(?,?,?) }";
	/*----------------------------------------- AIRCRAFT QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_AIRCRAFT = "SELECT * FROM Aircraft";
	public static final String SQL_AIRCRAFT_SIZE = "{ call aircarftSize(????) }";
	/*----------------------------------------- AIRPORT QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_AIRPORT = "SELECT * FROM Airport";
	/*----------------------------------------- SEAT QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_SEAT = "SELECT * FROM Seat";
	public static final String SQL_UPDATE_Seat = "{ call updateSeat(?,?,?,?,?,?) }";
	
	/*----------------------------------------- ORDERS QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_ORDER = "SELECT * FROM Order";
	/*----------------------------------------- CUSTOMER QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_CUST = "SELECT * FROM Customer";
	public static final String SQL_SELECTALL_FamilyMembers = "SELECT * FROM FamilyMember";
	/*----------------------------------------- TICKETS QUERIES -----------------------------------------*/
	public static final String SQL_SELECTALL_TICKET = "SELECT * FROM Tickt";
	
	public static final String SQL_SELECTALL_AIRPORTS_DESTANDORIG = "SELECT * FROM FlightInAirport";
	public static final String SQL_SEL_LargeFlightsReport = "SELECT * FROM Test";
	public static final String SQL_SEL_getCustomersfromUpdatedFlights = "{ call getCustomersfromUpdatedFlights(?) }";

	//connecting db
	private static String getDBPath() {
		 try {
		String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/FlightsDB.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/Entity/FlightsDB.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
		}


}

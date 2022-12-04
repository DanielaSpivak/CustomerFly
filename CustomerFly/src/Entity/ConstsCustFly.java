package Entity;

import java.net.URLDecoder;

public class ConstsCustFly {
	
	private ConstsCustFly() {
		throw new AssertionError();
	}
	
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	
	


	
	//connecting db
	private static String getDBPath() {
		 try {
		String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		 decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/database/custFly.accdb";
		} else {
		 decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/Entity/custFly.accdb";
		}
		} catch (Exception e) {
		 e.printStackTrace();
		 return null;
		}
	}


}

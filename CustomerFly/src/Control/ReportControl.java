package Control;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import Entity.Consts;
import Entity.Flight;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JRException;




public class ReportControl {
	/**Singleton instance.*/
    private static ReportControl instance;
	  /**
     * Singleton getter.
     * @return instance of this.
     */
    public static ReportControl getInstance() {
        if (instance == null)
            instance = new ReportControl();
        return instance;
    }

	
	
	public JFrame produceReport( )
	{
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR))
			{

				
				String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
				try {
					path = URLDecoder.decode(path, "UTF-8");
					if (path.contains(".jar")) {
						path = "/Boundry/Blank_A4.jasper";
					} else {
						path = "../Boundry/Blank_A4.jasper";
					}
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				
				JasperPrint print = JasperFillManager.fillReport(
						getClass().getResourceAsStream(path),
						new HashMap<String, Object>(), conn);
				JFrame frame = new JFrame("Show Report");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				frame.setVisible(true);
				return frame;
			}
			catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	 


}

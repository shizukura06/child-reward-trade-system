package cloud.lucero.crts.control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.util.Base64;

public class connection {
    private static final String URL = Base64.decode("amRiYzpteXNxbDovLzE1MS4xMDYuMTE3LjUxOjMzMDYvdTgwOTIzMDcwOF9zaGl6X2xpdmU=", Base64.DEFAULT).toString();
    private static final String USERNAME = Base64.decode("dTgwOTIzMDcwOF9zaGl6X2xpdmU=", Base64.DEFAULT).toString();
    private static final String PASSWORD = Base64.decode("QEJjMTIzMTE=" , Base64.DEFAULT).toString();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
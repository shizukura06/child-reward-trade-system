package cloud.lucero.crts.control;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import android.util.Base64;

public class DbConn {

    private static byte[] data;
    private static String URL, URL2, USERNAME, PASSWORD;

    static {
        try {
            data = Base64.decode("amRiYzpteXNxbDovLzE1MS4xMDYuMTE3LjUxOjMzMDYvdTgwOTIzMDcwOF9zaGl6X2RiP3VzZXI9dTgwOTIzMDcwOF9zaGl6X2xpdmUmcGFzcz1AQmMxMjMxMSZ1c2VVbmljb2RlPXRydWUmY2hhcmFjdGVyRW5jb2Rpbmc9VVRGLTgmdXNlU1NMPXRydWUmY29ubmVjdFRpbWVvdXQ9NQ==", Base64.DEFAULT);
            URL = new String(data, "UTF-8");

//            data = Base64.decode("dTgwOTIzMDcwOF9zaGl6X2xpdmU=", Base64.DEFAULT);
//            USERNAME = new String(data, "UTF-8");
//
//            data = Base64.decode("QEJjMTIzMTE=", Base64.DEFAULT);
//            PASSWORD = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection("jdbc:mysql://151.106.117.51/u809230708_shiz_db?user=u809230708_shiz_live&password=@Bc12311&useUnicode=true&characterEncoding=UTF-8");
        return DriverManager.getConnection("jdbc:mysql://192.168.1.4:3306/crewardtrade?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=yes&characterEncoding=UTF-8&connectTimeout=5&user=steveng&password=abc12311");
//        return DriverManager.getConnection(URL);
    }
}
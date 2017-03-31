import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by banhidi on 3/31/17.
 */
public class Configurator {

    public static void saveProperty(Properties p, String fileName) throws IOException {
        FileOutputStream outs = new FileOutputStream(fileName);
        p.storeToXML(outs, null);
    }

    public static Properties getProperty(String fileName) throws IOException {
        Properties p = new Properties();
        p.loadFromXML(new FileInputStream(fileName));
        return p;
    }

}

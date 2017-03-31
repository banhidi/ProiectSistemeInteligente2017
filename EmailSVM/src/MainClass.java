import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by banhidi on 3/31/17.
 */
public class MainClass {
    public static final String CONFIG_FILE_NAME = "App.config";

    public static void main(String[] args) {
        try {
            Properties p = Configurator.getProperty(CONFIG_FILE_NAME);
            ImapEmailGetter emailGetter =
                    new ImapEmailGetter(
                            "imap.gmail.com",
                            p.getProperty("emailAdress"),
                            p.getProperty("password"));
            for (String s : emailGetter.getEmailSubjects("Advices")) {
                System.out.println(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;

/**
 * Created by banhidi on 3/31/17.
 */
public class ImapEmailGetter {
    private String emailAdress;
    private String password;
    private String host;

    public ImapEmailGetter(String host, String emailAdress, String password) {
        if (host == null || emailAdress == null || password == null)
            throw new NullPointerException();
        this.host = host;
        this.emailAdress = emailAdress;
        this.password = password;
    }

    public void setEmailAdress(String newEmailAdress) {
        emailAdress = newEmailAdress;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public List<String> getEmailSubjects(String folderName) {
        List<String> list = new LinkedList<>();
        try {
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");

            Session emailSession = Session.getDefaultInstance(properties, null);
            Store store = emailSession.getStore("imaps");
            store.connect(host, emailAdress, password);

            Folder emailFolder = store.getFolder(folderName);
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            for(Message m : messages)
                list.add(m.getSubject().toString());
        } catch(NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch(MessagingException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}

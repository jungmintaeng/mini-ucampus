package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication("jungmin7623@naver.com", "alrud4612");
	}
}

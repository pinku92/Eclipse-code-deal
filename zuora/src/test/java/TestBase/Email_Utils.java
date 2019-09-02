package TestBase;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ExcelUtility.ConstantUtility;

public class Email_Utils extends TestBase {

	public static Properties props = new Properties();

	public static void commerce_subscription(String filename,String subject,String body) {
		ExtentReport___ExcelSheet(subject,body,filename);
	}

	public static void commerce_comparison(String filename,String subject,String body) {
		ExtentReport(filename,subject,body);
	}

	public static void addAttachment(Multipart multipart, String filesource, String filename)

			throws MessagingException {
		DataSource source = new FileDataSource(filesource);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

	}

	public static void ExtentReport( String filename,String subject,String body) {
		Multipart multipart = new MimeMultipart();
		props.put("mail.smtp.ssl.trust", ConstantUtility.host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ConstantUtility.host);
		props.put("mail.smtp.port", "");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConstantUtility.username, ConstantUtility.password);
			}
		});
		try {
			String path_of_extent_report = Folder + "\\testoutputReport -" + timestamp + ".html";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ConstantUtility.from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ConstantUtility.to));
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			multipart.addBodyPart(messageBodyPart);
			addAttachment(multipart, path_of_extent_report, filename + ConstantUtility.html);
			message.setContent(multipart, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("Mail Sent Successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void ExtentReport___ExcelSheet(String subject, String body,String filename) {
		Multipart multipart = new MimeMultipart();
		props.put("mail.smtp.ssl.trust", ConstantUtility.host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", ConstantUtility.host);
		props.put("mail.smtp.port", "");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConstantUtility.username, ConstantUtility.password);
			}
		});
		try {
			String path_of_extent_report = Folder + "\\testoutputReport -" + timestamp + ".html";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ConstantUtility.from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ConstantUtility.to));
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			multipart.addBodyPart(messageBodyPart);
			addAttachment(multipart, ConstantUtility.path_of_excel, filename + ConstantUtility.filename_of_excel);
			addAttachment(multipart, path_of_extent_report, filename + ConstantUtility.html);
			message.setContent(multipart, "text/html; charset=utf-8");
 			Transport.send(message);

			System.out.println("Mail Sent Successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

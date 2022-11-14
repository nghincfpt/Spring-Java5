//package edu.poly.shop.service.Impl;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import edu.poly.shop.model.MailInfo;
//import edu.poly.shop.service.MailerService;
//
//@Service
//public class MailerServiceImp implements MailerService{
//List<MailInfo> list = new ArrayList<>();
//@Autowired
//JavaMailSender sender;
//
//@Override
//public void send(MailInfo mail) throws MessagingException{
//	MimeMessage message = sender.createMimeMessage();
//	// sữ dụng helper để thiết lập các thông tin cần thiết cho mesager
//	MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
//	helper.setFrom(mail.getFrom());
//	helper.setTo(mail.getTo());
//	helper.setSubject(mail.getSubject());
//	helper.setText(mail.getBody(),true);
//	helper.setReplyTo(mail.getFrom());
//	
//	
//	String[] cc = mail.getCc();
//	// kiểm tra mảng cc có tồn tại hay không
//	if(cc != null && cc.length > 0) {
//		helper.setCc(cc);
//	}
//	
//	String[] bcc = mail.getBcc();
//	// kiểm tra mảng bcc có tồn tại hay không
//	if(bcc != null && bcc.length > 0) {
//	helper.setBcc(bcc);
//	}
//	//  mảng files
//	List<File> files = mail.getFile();
//	if(files.size()>0) {
//		for(File file:files) {
//			helper.addAttachment(file.getName(), file);
//		}
//	}
//	
//	// gữi massage đến smtp server
//	sender.send(message);
//}
//	@Override
//	public void send(String to, String subject, String body) throws MessagingException {
//		this.send(new MailInfo(to,subject,body));
//	
//
//}
//}
//

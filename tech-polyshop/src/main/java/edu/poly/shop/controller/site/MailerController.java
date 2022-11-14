//package edu.poly.shop.controller.site;
//
//import javax.mail.MessagingException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import edu.poly.shop.model.MailInfo;
//import edu.poly.shop.service.MailerService;
//
//
//@Controller
//@RequestMapping("mailer")
//public class MailerController {
//
//	@Autowired
//	MailerService mailer;
//
//	@GetMapping("")
//	public String mailViewer() {
//		return "indexx";
//	}
//
//	@ResponseBody
//	@PostMapping("/send")
//	public String serd(Model model, @RequestParam String txtTo, @RequestParam String txtSubject,
//			@RequestParam String txtContent) {
//
//		try {
//			MailInfo mail = new MailInfo();
//			mail.setTo(txtTo);
//			mail.setSubject(txtSubject);
//			mail.setBody(txtContent);
//			mailer.send(mail);
//			return "<h1> Gữi email thành công</h1>";
//		} catch (MessagingException e) {
//			return "<h1> Gữi email thất bại</h1>" + e.getMessage();
//		}
//	}
//}

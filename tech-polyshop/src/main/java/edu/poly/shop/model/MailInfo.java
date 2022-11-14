package edu.poly.shop.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {

	String from ="CongNghi";
	String to;
	String[] cc;
	String[] bcc;
	String subject;
	String body;

 List<File> file = new ArrayList<>();
	public MailInfo(String to, String subject, String body) {
	
	this.to = to;
	this.subject = subject;
	this.body = body;
	}
}

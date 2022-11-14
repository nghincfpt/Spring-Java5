package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers1")
public class Customer1 implements Serializable {
	@Id
	
	private String name;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Column(length = 20)
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	@Column(nullable = false)
	private String status;
}

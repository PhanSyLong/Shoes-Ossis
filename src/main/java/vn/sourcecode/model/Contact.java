package vn.sourcecode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_contact")
public class Contact extends BaseModel {
	
	@Column(name = "firstname", length = 120, nullable = true)
	private String firstname;

	@Column(name = "lastname",length = 120, nullable = true)
	private String lastname;
	
	@Column(name = "mobile",length = 60, nullable = true)
	private String mobile;
	
	@Column(name = "email",length = 200, nullable = true)
	private String email;
	
	@Column(name = "address",length = 300, nullable = true)
	private String address;
	
	@Column(name = "request_type",length = 300, nullable = true)
	private String request_type;
	
	@Column(name = "message",length = 1200, nullable = true)
	private String message;
	
}

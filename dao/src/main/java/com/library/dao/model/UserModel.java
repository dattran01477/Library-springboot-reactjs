package com.library.dao.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.RoleEnum;

@Document("user")
public class UserModel extends AbstractModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("id_student")
	private String idStudent;
	
	@Field("password")
	private String password;
	
	@Field("Hire_Book")
	private List<HireDetailModel> hireDetails;

	@Field("username")
	private String username;

	@Field("hirebook_total")
	private String hireBookTotal;

	@Field("status")
	private String status;

	@Field("role")
	private RoleEnum role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHireBookTotal() {
		return hireBookTotal;
	}
	public void setHireBookTotal(String hireBookTotal) {
		this.hireBookTotal = hireBookTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	public List<HireDetailModel> getHireDetails() {
		return hireDetails;
	}
	public void setHireDetails(List<HireDetailModel> hireDetails) {
		this.hireDetails = hireDetails;
	}
}

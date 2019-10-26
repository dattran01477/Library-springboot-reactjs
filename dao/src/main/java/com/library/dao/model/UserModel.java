package com.library.dao.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.RoleEnum;
import com.library.dao.model.child.BorrowingCardModel;
import com.library.dao.model.child.PenalizeModel;

@Document("user")
public class UserModel extends AbstractModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Field(value = "user_name")
	private String username;
	
	private String password;
	
	private String name;
	
	private String status;
	
	private String gender;
	
	private String role;
	
	private String phoneNumber;
	
	private String email;
	
	private String registerCode;
	
	private String idEditor;
	
	private List<PenalizeModel> penalizeModels;//phiếu phạt
	
	private List<BorrowingCardModel> borrowingCardModels;//phiếu mượn

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public String getIdEditor() {
		return idEditor;
	}

	public void setIdEditor(String idEditor) {
		this.idEditor = idEditor;
	}

	public List<PenalizeModel> getPenalizeModels() {
		return penalizeModels;
	}

	public void setPenalizeModels(List<PenalizeModel> penalizeModels) {
		this.penalizeModels = penalizeModels;
	}

	public List<BorrowingCardModel> getBorrowingCardModels() {
		return borrowingCardModels;
	}

	public void setBorrowingCardModels(List<BorrowingCardModel> borrowingCardModels) {
		this.borrowingCardModels = borrowingCardModels;
	}
}

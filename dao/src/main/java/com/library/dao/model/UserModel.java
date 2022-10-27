package com.library.dao.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.GenderEnum;
import com.library.dao.enums.RoleEnum;
import com.library.dao.enums.StatusEnum;
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

	@Field(value = "password")
	private String password;

	@Field(value = "name")
	private String name;

	@Field(value = "status")
	private StatusEnum status;

	@Field(value = "gender")
	private GenderEnum gender;

	@Field(value = "role")
	private RoleEnum role;

	@Field(value = "phone")
	private String phoneNumber;

	@Field(value = "email")
	private String email;

	@Field(value = "register_code")
	private String registerCode;

	@Field(value = "editor_id")
	private String editorId;

	@Field(value = "penalize_card")
	private List<PenalizeModel> penalizeModels;// phiếu phạt

	@Field(value = "borrowing_card")
	private List<BorrowingCardModel> borrowingCardModels;// phiếu mượn

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

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
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

	public String getEditorId() {
		return editorId;
	}

	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}

	public void buildInfo(UserModel userForm) {
		this.username = userForm.getUsername();
		this.password = userForm.getPassword();
		this.name = userForm.getName();
		this.phoneNumber = userForm.getPhoneNumber();
		this.email = userForm.getEmail();
		this.registerCode = userForm.getRegisterCode();
		this.editorId = userForm.getEditorId();
		this.borrowingCardModels = userForm.getBorrowingCardModels();
		this.gender = userForm.getGender();
		this.penalizeModels = userForm.getPenalizeModels();
		this.role = userForm.getRole();
		this.status = userForm.getStatus();
	}
}

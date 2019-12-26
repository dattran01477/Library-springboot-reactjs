package com.library.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.GenderEnum;
import com.library.dao.enums.RoleEnum;
import com.library.dao.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Document("user")
@Getter
@Setter
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

	@Field(value = "firstName")
	private String firstName;

	@Field(value = "fbAccount")
	private String fbAccount;

	@Field(value = "instaAccount")
	private String instaAccount;

	@Field(value = "linkedAccount")
	private String linkedAccount;

	@Field(value = "lastName")
	private String lastName;

	@Field(value = "name")
	private String name;

	@Field(value = "avatarThumnail")
	private String avatarThumnail;

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

	@Field(value = "penalize_cards")
	private List<PenalizeModel> penalizes = new ArrayList<PenalizeModel>();// phiếu phạt

	@DBRef
	@Field(value = "borrowing_cards")
	private List<BorrowingCardModel> borrowings = new ArrayList<BorrowingCardModel>();// phiếu mượn

	public void buildInfo(UserModel userForm) {
		this.username = userForm.getUsername();
		this.password = userForm.getPassword();
		this.name = userForm.getName();
		this.phoneNumber = userForm.getPhoneNumber();
		this.email = userForm.getEmail();
		this.registerCode = userForm.getRegisterCode();
		this.editorId = userForm.getEditorId();
		this.gender = userForm.getGender();
		this.role = userForm.getRole();
		this.status = userForm.getStatus();
	}
}

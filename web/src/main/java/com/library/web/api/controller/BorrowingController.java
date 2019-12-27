package com.library.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.bussiness.service.impl.BorrowingCardServiceImpl;
import com.library.bussiness.service.impl.UserServiceImpl;
import com.library.dao.enums.BorrowingStatus;
import com.library.dao.model.BorrowingCardModel;
import com.library.dao.model.UserModel;
import com.library.dao.model.criteria.BorrowingCardCriteria;
import com.library.dao.model.dto.TabBorrowingTypeOfUserDTO;
import com.library.mail.service.MailService;
import com.library.web.utils.SecurityContextUtils;

@RestController
@RequestMapping("/borrowing-card")
public class BorrowingController extends AbstractController {
	@Autowired
	BorrowingCardServiceImpl borrwingCardServiceImpl;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	MailService mailService;

	@GetMapping
	public Page<BorrowingCardModel> findCategoryByCriteria(BorrowingCardCriteria criteria) {
		return borrwingCardServiceImpl.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BorrowingCardModel> findById(@PathVariable("id") String id) {
		try {
			BorrowingCardModel borrowingCardModel = borrwingCardServiceImpl.findById(id);
			return new ResponseEntity<BorrowingCardModel>(borrowingCardModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BorrowingCardModel>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/user/tabs")
	public ResponseEntity<TabBorrowingTypeOfUserDTO> tabs() {
		try {
			String username = SecurityContextUtils.getUserName();
			UserModel user = userServiceImpl.findByUsername(username);
			if (user != null) {
				List<BorrowingCardModel> lsBorrowing = borrwingCardServiceImpl.findByUserId(user.getId());
				TabBorrowingTypeOfUserDTO tabBorrowing = new TabBorrowingTypeOfUserDTO();
				tabBorrowing.setBorrowingCards(lsBorrowing);
				return new ResponseEntity<TabBorrowingTypeOfUserDTO>(tabBorrowing, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<TabBorrowingTypeOfUserDTO>(HttpStatus.FORBIDDEN);
	}

	@PostMapping
	public ResponseEntity<BorrowingCardModel> addNew(@RequestBody BorrowingCardModel borrowingCardForm) {
		try {
			UserModel userModel = userServiceImpl.findByUsername(SecurityContextUtils.getUserName());
			if (userModel != null) {
				borrowingCardForm.setUserId(userModel.getId());
				BorrowingCardModel borrowingCardModel = borrwingCardServiceImpl.create(borrowingCardForm);

				if (borrowingCardModel != null) {
					userModel.getBorrowings().add(borrowingCardModel);
					userServiceImpl.update(userModel);
					mailService.sendMail(userModel.getEmail(), borrowingCardModel);
					return new ResponseEntity<BorrowingCardModel>(borrowingCardModel, HttpStatus.OK);
				} 
			} else {
				throw new NullPointerException("Not found user");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BorrowingCardModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BorrowingCardModel> update(@PathVariable("id") String id,
			@RequestBody BorrowingCardModel borrowingCardForm) {
		try {
			BorrowingCardModel borrowingCardModel = borrwingCardServiceImpl.update(borrowingCardForm);
			return new ResponseEntity<BorrowingCardModel>(borrowingCardModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BorrowingCardModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			borrwingCardServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/{id}/register-return")
	public ResponseEntity<BorrowingCardModel> registerReturnBook(@PathVariable("id") String id) {
		try {
			BorrowingCardModel borrowCard = borrwingCardServiceImpl.findById(id.trim());
			if (borrowCard != null) {
				borrowCard.setStatus(BorrowingStatus.waitting_return.toString());
				borrowCard = borrwingCardServiceImpl.update(borrowCard);
				return new ResponseEntity<BorrowingCardModel>(borrowCard, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BorrowingCardModel>(HttpStatus.NOT_FOUND);
	}
}

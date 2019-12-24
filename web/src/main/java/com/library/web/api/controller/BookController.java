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

import com.library.bussiness.service.impl.BookServiceImpl;
import com.library.dao.model.BookModel;
import com.library.dao.model.child.ReviewModel;
import com.library.dao.model.criteria.BookCriteria;

@RestController
@RequestMapping("/books")
public class BookController extends AbstractController {
	@Autowired
	BookServiceImpl bookServiceImpl;

	@GetMapping
	public Page<BookModel> findCategoryByCriteria(BookCriteria criteria) {
		return bookServiceImpl.findBySearchCriteria(criteria);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookModel> findById(@PathVariable("id") String id) {
		try {
			BookModel book = bookServiceImpl.findById(id);
			return new ResponseEntity<BookModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<ReviewModel>> findReviews(@PathVariable("id") String id) {
		try {
			List<ReviewModel> reviews = bookServiceImpl.findAllReviewBook(id);
			return new ResponseEntity<List<ReviewModel>>(reviews, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<List<ReviewModel>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/{id}/reviews")
	public ResponseEntity<List<ReviewModel>> saveReview(@PathVariable("id") String id,
			@RequestBody ReviewModel reviewsModel) {
		try {
			reviewsModel.setBookId(id);
			ReviewModel review = bookServiceImpl.saveReview(reviewsModel);
			if (review != null) {
				List<ReviewModel> lsReview = bookServiceImpl.findAllReviewBook(id);
				return new ResponseEntity<List<ReviewModel>>(lsReview, HttpStatus.OK);
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<List<ReviewModel>>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<BookModel> addNew(@RequestBody BookModel bookFrom) {
		try {
			BookModel bookModel = bookServiceImpl.create(bookFrom);
			return new ResponseEntity<BookModel>(bookModel, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookModel> update(@PathVariable("id") String id, @RequestBody BookModel bookFrom) {
		try {
			BookModel book = bookServiceImpl.findById(id);
			book.buildInfo(bookFrom);
			bookServiceImpl.update(book);
			return new ResponseEntity<BookModel>(book, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<BookModel>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) {
		try {
			bookServiceImpl.delete(id);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}

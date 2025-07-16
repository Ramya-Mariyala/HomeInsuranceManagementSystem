package com.capgemini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.Quote;
import com.capgemini.exceptions.DuplicateQuoteFoundException;
import com.capgemini.exceptions.QuoteNotFoundException;
import com.capgemini.service.IQuoteService;

@RestController
@CrossOrigin
public class QuoteController {

	@Autowired
	IQuoteService quoteservice;

	
	/*
	 * Quote will be added
	 */
	@PostMapping("/quote")
	public ResponseEntity<String> addQuote(@RequestBody Quote quote) throws DuplicateQuoteFoundException {
		if (quoteservice.addQuote(quote)!=null) {
			return new ResponseEntity<>("Quote added successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Quote not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/*
	 *  Quote will be updated
	 */

	@PutMapping("quote/updatequote")
	public ResponseEntity<String> updateQuote(@RequestBody Quote quote)
			throws QuoteNotFoundException {

		if (quoteservice.updateQuote(quote))
			return new ResponseEntity<>("Quote updated successfully", HttpStatus.OK);
		return new ResponseEntity<>("Quote is not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	/*
	 *  Quote will be found by id 
	 */
	@GetMapping("quote/quotebyid/{quoteId}")
	public ResponseEntity<Quote> findQuoteByQuoteId(@PathVariable int quoteId) throws QuoteNotFoundException {
		Quote findQuote = quoteservice.findQuoteByQuoteId(quoteId);
		if (findQuote.equals(null))
			return new ResponseEntity("Quote is not found", HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Quote>(findQuote, HttpStatus.OK);
	}
	
	
	/* 
	 * Quote will be deleted
	 */

	@DeleteMapping("quote/deletequote/{quoteId}")
	public ResponseEntity<String> removeQuote(@PathVariable int quoteId) throws QuoteNotFoundException {
		if (quoteservice.removeQuote(quoteId))
			return new ResponseEntity<>("Quote deleted successfully", HttpStatus.OK);
		return new ResponseEntity<>("Quote not found", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	/* 
	 * List of quotes
	 */

	@GetMapping("quote/allquotes")
	public ResponseEntity<List<Quote>> showAllQuotes() throws QuoteNotFoundException {
		List<Quote> allQuotes = quoteservice.showAllQuotes();
		if (allQuotes.isEmpty())
			return new ResponseEntity("No Quotes found", HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<List<Quote>>(allQuotes, HttpStatus.OK);
	}
	
	/*
	 *  quote not found exception
	 */

	@ExceptionHandler(value = QuoteNotFoundException.class)
	public ResponseEntity<String> handleException(QuoteNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 *  duplicate quote exception
	 */

	@ExceptionHandler(value = DuplicateQuoteFoundException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException2(DuplicateQuoteFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


	}
}

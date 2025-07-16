package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entities.Quote;
import com.capgemini.exceptions.DuplicateQuoteFoundException;
import com.capgemini.exceptions.QuoteNotFoundException;
import com.capgemini.repository.IQuoteRepository;



@Service("quoteservice")
public class QuoteServiceImpl implements IQuoteService {

	@Autowired
	private IQuoteRepository quoteRepository;


	
	/*
	 * Quote will be added
	 */
	@Override
	public Quote addQuote(Quote quote) throws DuplicateQuoteFoundException {

		if (quoteRepository.existsById(quote.getQuoteId())) {
			throw new DuplicateQuoteFoundException("Duplicate Quote is Found");

		}

		quoteRepository.save(quote);
		return quote;

	}

	
	
	/*
	 *  Quote will be updated
	 */
	@Override
	public Boolean updateQuote(Quote quote) throws QuoteNotFoundException {

		if (quoteRepository.existsById(quote.getQuoteId())) {
			quoteRepository.save(quote);
			return true;
		} else {
			throw new QuoteNotFoundException("Quote not found");
		}

	}
	
	
	
	/*
	 *  Quote will be found by id 
	 */

	@Override
	public Quote findQuoteByQuoteId(int quoteId) throws QuoteNotFoundException {

		Optional<Quote> findquote = quoteRepository.findById(quoteId);
		if (findquote.isPresent()) {
			return findquote.get();
		} else {
			throw new QuoteNotFoundException("Quote not found");
		}

	}
	
	
	/* 
	 * Quote will be deleted
	 */

	@Override
	public Boolean removeQuote(int quoteId) throws QuoteNotFoundException {

		if (quoteRepository.existsById(quoteId)) {
			quoteRepository.deleteById(quoteId);
			return true;
		} else {
			throw new QuoteNotFoundException("Quote not found");
		}

	}
	
	
	
	/* 
	 * List of quotes
	 */

	@Override
	public List<Quote> showAllQuotes() throws QuoteNotFoundException {
		List<Quote> allQuotes = quoteRepository.findAll();
		if (allQuotes.isEmpty()) {
			throw new QuoteNotFoundException("No Quotes found");
		} else {
			return allQuotes;

		}
	}

}

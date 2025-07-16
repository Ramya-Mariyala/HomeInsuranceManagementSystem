package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.entities.Quote;
import com.capgemini.exceptions.DuplicateQuoteFoundException;
import com.capgemini.exceptions.QuoteNotFoundException;
import com.capgemini.repository.IQuoteRepository;

@SpringBootTest
public class QuoteServiceImplTestUsingMockito {
	@Autowired
	private QuoteServiceImpl quoteService;

	@MockBean
	private IQuoteRepository quoteRepository;

	/*
	 * 
	 * Test cases for adding quote
	 * 
	 */

	@Test
	public void theGivenQuoteIsAdded() throws DuplicateQuoteFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(3);
		quote.setPremiumType("Premium");
		quote.setPremium(10000);
		quote.setDwellingCoverage(1456);
		quote.setDetachedStructureCoverage(1000);
		quote.setDeductableAmount(1000);
		quote.setAdditionalLivingExpense(1000);
		quote.setMedicalExpense(1000);
		quote.setPersonalPropertyCoverage(1000);

		Quote res = quoteService.addQuote(quote);
		when(quoteRepository.save(quote)).thenReturn(quote);
		assertEquals(res.hashCode(), quote.hashCode());
	}

	/*
	 * 
	 * Test cases for finding quote by QuoteId
	 * 
	 */
	@Test
	public void theGivenQuoteIsFoundById() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(3);
		when(quoteRepository.findById(3)).thenReturn(Optional.of(quote));
		when(quoteRepository.existsById(3)).thenReturn(true);
		Quote result = quoteService.findQuoteByQuoteId(3);
		assertEquals(quote, result);

	}

	/*
	 * 
	 * Test cases for updating existing quote
	 * 
	 */

	@Test
	public void theGivenQuoteIsUpdated() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);
		quote.setPremiumType("Standard");
		quote.setPremium(10000);
		quote.setDwellingCoverage(1456);
		quote.setDetachedStructureCoverage(1000);
		quote.setDeductableAmount(1000);
		quote.setAdditionalLivingExpense(1000);
		quote.setMedicalExpense(1000);
		quote.setPersonalPropertyCoverage(1000);
		when(quoteRepository.existsById(quote.getQuoteId())).thenReturn(true);
		Boolean result = quoteService.updateQuote(quote);
		assertEquals(result, true);
	}

	/*
	 * 
	 * Test cases for Removing quote
	 * 
	 */

	@Test
	public void theGivenQuoteIsRemoved() throws QuoteNotFoundException {
		Quote quote = new Quote();
		// quote.setQuoteId(1);
		when(quoteRepository.findById(1)).thenReturn(Optional.of(quote));
		when(quoteRepository.existsById(1)).thenReturn(true);
		boolean result = quoteService.removeQuote(1);
		assertTrue(result);

	}
	/*
	 * 
	 * Test cases for viewing all quotes
	 * 
	 */

	@Test
	public void theListOfQuotes() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);

		List<Quote> quoteList = new ArrayList<>();
		quoteList.add(quote);
		when(quoteRepository.findAll()).thenReturn(quoteList);
		List<Quote> result = quoteService.showAllQuotes();
		assertEquals(result.size(), quoteList.size());
		assertNotNull(result);
	}

}
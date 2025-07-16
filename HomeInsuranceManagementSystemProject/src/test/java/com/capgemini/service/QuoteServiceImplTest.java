package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Quote;
import com.capgemini.exceptions.DuplicateQuoteFoundException;
import com.capgemini.exceptions.QuoteNotFoundException;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class QuoteServiceImplTest {

	@Autowired
	IQuoteService quoteServiceImp;
	
	
	/*
	 *  tests whether the quote is added or not
	 */
	@Test
	@Order(1)
	public void theGivenQuoteIsAdded() throws DuplicateQuoteFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);
		quote.setPremiumType("Premium");
		quote.setPremium(10000);
		quote.setDwellingCoverage(1456);
		quote.setDetachedStructureCoverage(1000);
		quote.setDeductableAmount(1000);
		quote.setAdditionalLivingExpense(1000);
		quote.setMedicalExpense(1000);
		quote.setPersonalPropertyCoverage(1000);

		Quote res = quoteServiceImp.addQuote(quote);
		assertEquals(res.hashCode(), quote.hashCode());
	}

	@Test
	@Order(2)
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

		Boolean result = quoteServiceImp.updateQuote(quote);
		assertTrue(result);
	}

	/*
	 *  tests whether the quote is found or not
	 */
	@Test
	@Order(3)
	public void theGivenQuoteIsFoundById() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);

		Quote result = quoteServiceImp.findQuoteByQuoteId(quote.getQuoteId());
		assertEquals(result.hashCode(), quote.hashCode());

	}

	
	/*
	 *  tests whether the quote is removed or not
	 */
	@Test
	@Order(6)
	public void theGivenQuoteIsRemoved() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);

		Boolean result = quoteServiceImp.removeQuote(1);
		assertTrue(result);

	}
	
	/*
	 *  tests the list of quotes are present in database or not
	 */

	@Test
	@Order(4)
	public void theListOfQuotes() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(1);

		List<Quote> quotes = quoteServiceImp.showAllQuotes();
		Boolean result = quotes.contains(quote);
		assertEquals(true, result);
	}
	/*
	 *  tests the quote not found exception
	 */

	@Test
	public void quoteNotFoundException() throws QuoteNotFoundException {
		Quote quote = new Quote();
		quote.setQuoteId(111);
		assertThrows(QuoteNotFoundException.class, () -> quoteServiceImp.updateQuote(quote), "Quote not Found");
		assertThrows(QuoteNotFoundException.class, () -> quoteServiceImp.findQuoteByQuoteId(111), "Quote not Found");
		assertThrows(QuoteNotFoundException.class, () -> quoteServiceImp.removeQuote(111), "Quote not Found");

	}
	
	/*
	 *  tests the duplicate quote exception
	 */
    @Test
    @Order(5)
    public void duplicateQuoteFoundException() throws DuplicateQuoteFoundException {
        Quote quote = new Quote();
        quote.setQuoteId(1);
        assertThrows(DuplicateQuoteFoundException.class, ()-> quoteServiceImp.addQuote(quote),"Quote already exists");
    }
}
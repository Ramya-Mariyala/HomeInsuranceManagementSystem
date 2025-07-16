package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Quote;
import com.capgemini.exceptions.DuplicateQuoteFoundException;
import com.capgemini.exceptions.QuoteNotFoundException;

public interface IQuoteService {
	public Quote addQuote(Quote quote) throws DuplicateQuoteFoundException;

	 

    public Boolean updateQuote(Quote quote) throws QuoteNotFoundException;

 

    public Quote findQuoteByQuoteId(int quoteId) throws QuoteNotFoundException;

 

    public Boolean removeQuote(int quoteId) throws QuoteNotFoundException;

 

    public List<Quote> showAllQuotes() throws QuoteNotFoundException;

}

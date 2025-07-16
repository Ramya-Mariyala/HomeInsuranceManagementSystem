import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Quote } from '../model/quote';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class QuoteService {

    constructor(private http: HttpClient) { }

    baseUrl: string = 'http://localhost:9091/quote';

    getQuotes() {
        return this.http.get<Quote[]>(this.baseUrl + '/allquotes');
    }
    // Get Quote By Id
    getQuoteById(quoteId: number) {
        return this.http.get<Quote>(this.baseUrl + '/quotebyid/' + quoteId);
    }
    // Create Quote
    createQuote(quote: Quote): Observable<string> {
        return this.http.post(this.baseUrl, quote, { responseType: 'text' });
    }
    // Modify Quote
    updateQuote(quote: Quote): Observable<string> {
        return this.http.put(this.baseUrl + '/updatequote', quote, { responseType: 'text' });
    }
    // Delete Quote
    deleteQuote(quoteId: number): Observable<string> {
        return this.http.delete(this.baseUrl + '/deletequote/' + quoteId, { responseType: 'text' });
    }
}
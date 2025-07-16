import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Quote } from 'src/app/model/quote';
import { QuoteService } from 'src/app/services/quote.service';

@Component({
  selector: 'app-list-quote',
  templateUrl: './list-quote.component.html',
  styleUrls: ['./list-quote.component.css']
})
export class ListQuoteComponent implements OnInit {
  quotes!: Quote[];
  constructor(private router: Router, private quoteService: QuoteService) { }

  ngOnInit(): void {
    this.quoteService.getQuotes().subscribe(data => {
      this.quotes = data;
    });
  }

  deleteQuote(quote: Quote): void {
    let result = confirm('Do you want to delete the user?')
    if (result) {
      this.quoteService.deleteQuote(quote.quoteId)
        .subscribe(data => {
          this.quotes = this.quotes.filter(u => u !== quote);
        });
    }
  };

  editQuote(quote: Quote): void {
    localStorage.removeItem("editQuoteId");
    localStorage.setItem("editQuoteId", quote.quoteId.toString());
    this.router.navigate(['edit-quote']);
  };

  addQuote(): void {
    this.router.navigate(['add-quote']);
  };
  logOutPolicyHolder(): void {
    this.router.navigate(['']);

  }
}
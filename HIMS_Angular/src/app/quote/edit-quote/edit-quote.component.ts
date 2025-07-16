import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Quote } from 'src/app/model/quote';
import { QuoteService } from 'src/app/services/quote.service';

@Component({
  selector: 'app-edit-quote',
  templateUrl: './edit-quote.component.html',
  styleUrls: ['./edit-quote.component.css']
})

export class EditQuoteComponent implements OnInit {

  quote!: Quote;
  editForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private quoteService: QuoteService) {
    this.editForm = this.formBuilder.group({
      //id: [],
      quoteId: ['', Validators.required],
      premiumType: ['', Validators.required],
      premium: ['', Validators.required],
      dwellingCoverage: ['', Validators.required],
      detachedStructureCoverage: ['', Validators.required],
      personalPropertyCoverage: ['', Validators.required],
      additionalLivingExpense: ['', Validators.required],
      medicalExpense: ['', Validators.required],
      deductableAmount: ['', Validators.required]
    });


  }

  ngOnInit() {
    let quoteId = localStorage.getItem("editQuoteId");
    if (!quoteId) {
      alert("Invalid action.")
      this.router.navigate(['list-quote']);
      return;
    }
    this.quoteService.getQuoteById(+quoteId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {

    this.quoteService.updateQuote(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-quote']);
        },
        error => {

          alert('error: ' + error.url);
        });
  }

}
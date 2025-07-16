import { Quote } from 'src/app/model/quote';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { QuoteService } from 'src/app/services/quote.service';

@Component({
  selector: 'app-quote',
  templateUrl: './quote.component.html',
  styleUrls: ['./quote.component.css']
})
export class QuoteComponent implements OnInit {

  quote!: Quote;
  quoteForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private quoteService: QuoteService) {
    this.quoteForm = this.formBuilder.group({
      //id: [],
      quoteId: [''],
      premiumType: [''],
      premium: [''],
      dwellingCoverage: [''],
      detachedStructureCoverage: [''],
      personalPropertyCoverage: [''],
      additionalLivingExpense: [''],
      medicalExpense: [''],
      deductableAmount: ['']
    });


  }
  ngOnInit(): void {
    let my_object = JSON.parse(localStorage.getItem('data') || '{}');

    console.log(my_object.userName);
    console.log(my_object.policyHolder);
    console.log(my_object.policyHolder.policyId);
    this.quoteService.getQuoteById(my_object.policyHolder.policyId.quote.quoteId).subscribe(data => {
      this.quoteForm.setValue(data);
      console.log(data);
    });


  }

}

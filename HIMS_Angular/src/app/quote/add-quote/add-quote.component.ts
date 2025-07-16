import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { QuoteService } from 'src/app/services/quote.service';


@Component({
  selector: 'app-add-quote',
  templateUrl: './add-quote.component.html',
  styleUrls: ['./add-quote.component.css']
})
export class AddQuoteComponent implements OnInit {

  addForm!: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private quoteservice: QuoteService) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: [''],
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

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }

    this.quoteservice.createQuote(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['add-property']);
      });

  }

}
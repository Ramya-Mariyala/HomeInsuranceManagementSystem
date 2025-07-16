import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PolicyHolder } from '../../model/policyholder';
import { PolicyholderService } from '../../services/policyholder.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-edit-policyholder',
  templateUrl: './edit-policyholder.component.html',
  styleUrls: ['./edit-policyholder.component.css']
})


export class EditPolicyholderComponent implements OnInit {

  policyHolder!: PolicyHolder;
  editForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private policyholderservice: PolicyholderService) {
    this.editForm = this.formBuilder.group({
      //id: [],
      policyHolderId: ['', Validators.required],
      policyHolderName: ['', Validators.required],
      policyName: ['', Validators.required],
      premiumType: ['', Validators.required],
      creditCard: ['', Validators.required],
      dob: ['', Validators.required],
      occupation: ['', Validators.required],
      annualIncome: ['', Validators.required],
      isRetired: ['', Validators.required],
      ssn: ['', Validators.required],
      emailId: ['', Validators.required],
      address: this.formBuilder.group({
        residenceType: ['', Validators.required],
        addressLine1: ['', Validators.required],
        addressLine2: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zip: ['', Validators.required],
        residenceUse: ['', Validators.required]
      }),
    });
  }
  ngOnInit() {

    let policyHolderId = localStorage.getItem("editPolicyHolderId");
    if (!policyHolderId) {
      alert("Invalid action.")
      this.router.navigate(['list-policyholder']);
      return;
    }


    this.policyholderservice.getPolicyHolderById(+policyHolderId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });


  }

  editPolicyHolderData() {

    this.policyholderservice.updatePolicyHolder(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-policyholder']);
        },
        error => {
          alert('error: ' + error.url);
        });
  }


}












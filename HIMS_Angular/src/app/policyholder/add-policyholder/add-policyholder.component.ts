import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PolicyholderService } from '../../services/policyholder.service';

@Component({
  selector: 'app-add-policyholder',
  templateUrl: './add-policyholder.component.html',
  styleUrls: ['./add-policyholder.component.css']
})
export class AddPolicyholderComponent implements OnInit {

  addForm!: FormGroup;
  submitted: boolean = false;


  constructor(private formBuilder: FormBuilder, private router: Router, private policyholderservice: PolicyholderService) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: [],
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
    policyId: this.formBuilder.group({
      policyId: ['', Validators.required]
    })
    });
  }

  addStudentData(){

    this.submitted = true;
    if(this.addForm.invalid){
      return;
    }
    this.policyholderservice.createPolicyHolder(this.addForm.value).subscribe(data => {
      this.router.navigate(['add-policy']);
    });
    this.router.navigate(['add-policy']);

  }
  listPolicyHolder(){
    this.router.navigate(['list-policyholder']);
  }
  addPolicy(){
    this.router.navigate(['add-policy']);
  }


   

}

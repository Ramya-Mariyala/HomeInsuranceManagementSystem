import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { PolicyHolder } from 'src/app/model/policyholder';
import { PolicyholderService } from 'src/app/services/policyholder.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  policyholder!: PolicyHolder;
  profileForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private router: Router, private policyholderservice: PolicyholderService) {
    this.profileForm = this.formBuilder.group({
      //id: [],
      policyHolderId: [''],
      policyHolderName: [''],
      policyName: [''],
      premiumType: [''],
      creditCard: [''],
      dob: [''],
      occupation: [''],
      annualIncome: [''],
      isRetired: [''],
      ssn: [''],
      emailId: [''],
      address: this.formBuilder.group({
        residenceType: [''],
        addressLine1: [''],
        addressLine2: [''],
        city: [''],
        state: [''],
        zip: [''],
        residenceUse: ['']
      }),
    });
  }


  ngOnInit(): void {
    let my_object = JSON.parse(localStorage.getItem('data') || '{}');

    console.log(my_object.userName);
    console.log(my_object.policyHolder.policyHolderId);
    this.policyholderservice.getPolicyHolderById(my_object.policyHolder.policyHolderId).subscribe(data => {
      this.profileForm.setValue(data);
      console.log(data);

    });



  }
  editPolicyHolderData() {

    this.policyholderservice.updatePolicyHolder(this.profileForm.value)
      .pipe(first())
      .subscribe(
        data => {
          alert("Profile got updated");
          this.router.navigate(['profile']);
        },
        error => {
          alert('error: ' + error.url);
        });
  }

}

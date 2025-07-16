import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Policy } from 'src/app/model/policy';
import { PolicyService } from 'src/app/services/policy.service';

@Component({
  selector: 'app-policy',
  templateUrl: './policy.component.html',
  styleUrls: ['./policy.component.css']
})
export class PolicyComponent implements OnInit {

  policy!: Policy;
  policyForm!: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private policyService: PolicyService) {
    this.policyForm = this.formBuilder.group({
      policyId: [''],
      policyEffectiveDate: [''],
      policyEndDate: [''],
      policyTerm: [''],
      policyStatus: ['']
    });
  }

  ngOnInit(): void {
    let my_object = JSON.parse(localStorage.getItem('data') || '{}');

    console.log(my_object.userName);
    console.log(my_object.policyHolder);
    console.log(my_object.policyHolder.policyId);
    this.policyService.getPolicyById(my_object.policyHolder.policyId.policyId).subscribe(data => {
      this.policyForm.setValue(data);
      console.log(data);


  });

  }
}

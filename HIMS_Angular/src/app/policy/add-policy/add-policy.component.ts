import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PolicyService } from 'src/app/services/policy.service';

@Component({
  selector: 'app-add-policy',
  templateUrl: './add-policy.component.html',
  styleUrls: ['./add-policy.component.css']
})
export class AddPolicyComponent implements OnInit {
  addForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private policyService: PolicyService) {

  }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      policyId: ['', Validators.required],
      policyEffectiveDate: ['', Validators.required],
      policyEndDate: ['', Validators.required],
      policyTerm: ['', Validators.required],
      policyStatus: ['', Validators.required]
    });
  }
  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.policyService.createPolicy(this.addForm.value).subscribe(data => {
      this.router.navigate(['add-quote']);
    });
    this.router.navigate(['add-quote']);
  }

}
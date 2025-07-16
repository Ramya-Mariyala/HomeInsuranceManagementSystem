import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Policy } from 'src/app/model/policy';
import { PolicyService } from 'src/app/services/policy.service';

@Component({
  selector: 'app-edit-policy',
  templateUrl: './edit-policy.component.html',
  styleUrls: ['./edit-policy.component.css']
})
export class EditPolicyComponent implements OnInit {
  policy!: Policy;
  editForm!: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private policyService: PolicyService) {
    this.editForm = this.formBuilder.group({
      policyId: ['', Validators.required],
      policyEffectiveDate: ['', Validators.required],
      policyEndDate: ['', Validators.required],
      policyTerm: ['', Validators.required],
      policyStatus: ['', Validators.required]
    });
  }

  ngOnInit() {

    let policyId = localStorage.getItem("editpolicyId");
    if (!policyId) {
      alert("Invalid Action.")
      this.router.navigate(['list-policy']);
      return;
    }

    this.policyService.getPolicyById(+policyId).subscribe(data => {
      this.editForm.setValue(data);
    });


  }
  onSubmit() {
    this.submitted = true;
    if (this.editForm.invalid) {
      alert('invalid editform');
      return;
    }
    alert(JSON.stringify(this.editForm.value));
    this.policyService.updatePolicy(this.editForm.value).pipe(first())
      .subscribe(data => {
        this.router.navigate(['list-policy']);
      },
        error => {
          alert('error: ' + error.url);
        });
  }

}

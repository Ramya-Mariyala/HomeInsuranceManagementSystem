import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Policy } from 'src/app/model/policy';
import { PolicyService } from 'src/app/services/policy.service';

@Component({
  selector: 'app-list-policy',
  templateUrl: './list-policy.component.html',
  styleUrls: ['./list-policy.component.css']
})
export class ListPolicyComponent implements OnInit {
  policies!: Policy[];
  constructor(private router: Router, private policyService: PolicyService) { }

  ngOnInit(): void {

    {
      this.policyService.getPolicies().subscribe(data => {
        this.policies = data;
      });

    }
  }

  deletePolicy(policy: Policy): void {
    let result = confirm('Do you want to delete the policy?')
    if (result) {
      this.policyService.deletePolicy(policy.policyId)
        .subscribe(data => {
          this.policies = this.policies.filter(u => u !== policy);
        });
    }
  };
  editPolicy(policy: Policy): void {
    localStorage.removeItem("editpolicyId");
    localStorage.setItem("editpolicyId", policy.policyId.toString());
    this.router.navigate(['edit-policy']);
  };
  addPolicy(): void {
    this.router.navigate(['add-policy']);
  };
  
  logOutPolicyHolder(): void{
    this.router.navigate(['']);
  
}

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyHolder } from '../../model/policyholder';
import { PolicyholderService } from '../../services/policyholder.service';

@Component({
  selector: 'app-list-policyholder',
  templateUrl: './list-policyholder.component.html',
  styleUrls: ['./list-policyholder.component.css']
})
export class ListPolicyholderComponent implements OnInit {

  policyholders!: PolicyHolder[];

  constructor(private router: Router, private policyholderservice: PolicyholderService) { }

  ngOnInit(): void {​​​​​
      this.policyholderservice.getPolicyHolders().subscribe(data => {
        this.policyholders = data;
      });

  }​​​​​
  addPolicyHolder(): void {
    this.router.navigate(['add-policyholder']);
  }
  editPolicyHolder(policyholder: PolicyHolder): void {
    localStorage.removeItem("editPolicyHolderId");
    localStorage.setItem("editPolicyHolderId", policyholder.policyHolderId.toString());
    this.router.navigate(['edit-policyholder']);

  }

  // logOff user
  logOutPolicyHolder(): void{
      this.router.navigate(['']);
    
}

// Delete PolicyHolder
deletePolicyHolder(policyholder: PolicyHolder): void {
    let result = confirm('Do you want to delete the user?')
    if(result)
    {
      this.policyholderservice.deletePolicyHolder(policyholder.policyHolderId)
        .subscribe( data => {
          this.policyholders = this.policyholders.filter(p => p !== policyholder);
        });
      }
}




}

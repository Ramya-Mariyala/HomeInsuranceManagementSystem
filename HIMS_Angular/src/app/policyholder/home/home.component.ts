import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PolicyHolder } from '../../model/policyholder';
import { PolicyholderService } from '../../services/policyholder.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  policyholder!: PolicyHolder;
  
  obj: any;

  constructor(private router: Router, private policyholderservice: PolicyholderService) { }

  ngOnInit(): void {
  }
  home() {
    this.router.navigate(['']);

  }
  policy() {
    this.router.navigate(['policy']);


  }
  profile() {

    this.router.navigate(['profile']);

    


  }

}

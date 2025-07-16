import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  users!: User[];

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {


  }

  // logOff user
  logOutUser(): void {

    this.router.navigate(['']);

  }

  viewAgent(): void {
    this.router.navigate(['home-agent']);
  }

  viewPolicyHolder(): void {
    this.router.navigate(['policyholder']);
  }
}
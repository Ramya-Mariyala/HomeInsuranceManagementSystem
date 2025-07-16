import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean = false;
  inform!: any;
  inValidLogin: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private service: UserService) {
    this.loginForm = new FormGroup({
      userName: new FormControl(),
      password: new FormControl(),
      role: new FormControl()
    });
  }
  onSubmit() {
    let userName: string = this.loginForm.controls.userName.value;
    let password: string = this.loginForm.controls.password.value;
    let role: string = this.loginForm.controls.role.value;
    console.log(this.loginForm.value, userName, password, role);
    this.submitted = true;
    if (this.loginForm.controls.userName.value == "admin" && this.loginForm.controls.password.value == "admin" && this.loginForm.controls.role.value == "admin") {
      alert("Continue");
      this.router.navigate(['admin']);
    }
    else {
      this.inform = this.service.login(userName, password, role).subscribe(
        data => {
          this.inform = data;
          localStorage.setItem("data", JSON.stringify(data));
          if (this.loginForm.controls.role.value == "Agent") {

            this.router.navigate(['home-agent']);
          }
          else if (this.loginForm.controls.role.value == "Policyholder") {

            this.router.navigate(['policyholder']);
          }

        },
        error => {
          alert("Invalid UserName/Password/Role");
        }
      );
    }
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      userName: new FormControl(),
      password: new FormControl(),
      role: new FormControl()
    });
  }
  addUser(): void {
    this.router.navigate(['/add-user']);
  }
}
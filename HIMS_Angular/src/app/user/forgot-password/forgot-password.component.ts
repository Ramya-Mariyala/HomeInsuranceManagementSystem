import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotForm: FormGroup;
  submitted: boolean = false;
  inform!: any;
  constructor(private formBuilder: FormBuilder, private router: Router, private service: UserService) {
    this.forgotForm = new FormGroup({
      userName: new FormControl()
    });
  }



  ngOnInit(): void {
    this.forgotForm = new FormGroup({
      userName: new FormControl(),
    });
  }
  onSubmit() {
    let userName = this.forgotForm.controls.userName.value;
    console.log(this.forgotForm.controls.userName.value);
    this.submitted = true;
    this.inform = this.service.forgotPassword(userName).subscribe(data => {
     alert("your password is"+data);
      this.inform = data;
    });
  }

  cancel(): void {
    this.router.navigate(['policyholder']);
  }

}

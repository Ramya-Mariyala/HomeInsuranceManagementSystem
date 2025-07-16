import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  addForm!: FormGroup;
  submitted: boolean = false;
  user!: User;


  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      role: ['', Validators.required],
    });

  }

  onSubmit() {
    let userName: string = this.addForm.controls.userName.value;
    let password: string = this.addForm.controls.password.value;
    let role: string = this.addForm.controls.role.value;
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.userService.createUser(this.addForm.value)
      .subscribe(data => {
        if(this.addForm.controls.role.value == "Policyholder"){
          this.router.navigate(['add-policyholder']);
        }
        else{
          this.router.navigate(['add-agent']);
        }
        //this.router.navigate(['']);
      });
  }

  cancel(): void {
    this.router.navigate(['']);
  }
}
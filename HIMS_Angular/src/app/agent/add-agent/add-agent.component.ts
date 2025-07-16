import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AgentService } from 'src/app/services/agent.service';

@Component({
  selector: 'app-add-agent',
  templateUrl: './add-agent.component.html',
  styleUrls: ['./add-agent.component.css']
})
export class AddAgentComponent implements OnInit {

  addForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private agentService: AgentService) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      agentId: ['', Validators.required],
      agentName: ['', Validators.required],
      designation: ['', Validators.required],
      salary: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required],
      mobileNo: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.addForm.invalid) {
      return;
    }
    this.agentService.createAgent(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['list-agent']);
      });
  }

}​​​​​​​​
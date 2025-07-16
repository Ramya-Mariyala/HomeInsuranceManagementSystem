import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Agent } from 'src/app/model/agent';
import { AgentService } from 'src/app/services/agent.service';



@Component({
  selector: 'app-edit-agent',
  templateUrl: './edit-agent.component.html',
  styleUrls: ['./edit-agent.component.css']
})
export class EditAgentComponent implements OnInit {

  agent!: Agent;
  editForm!: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private agentService: AgentService) {
    this.editForm = this.formBuilder.group({

      agentId: ['', Validators.required],
      agentName: ['', Validators.required],
      designation: ['', Validators.required],
      salary: ['', Validators.required],
      address: ['', Validators.required],
      email: ['', Validators.required],
      mobileNo: ['', Validators.required]
    });
  }
  ngOnInit() {

    let agentId = localStorage.getItem("editAgentId");
    if (!agentId) {
      alert("Invalid action.")
      this.router.navigate(['list-agent']);
      return;
    }


    this.agentService.getAgentById(+agentId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });


  }

  onSubmit() {

    this.agentService.updateAgent(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-agent']);
        },
        error => {
          //alert('error: ' + error.url);
          this.router.navigate(['list-agent']);
        });
  }


}
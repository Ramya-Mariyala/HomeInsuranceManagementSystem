import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agent } from 'src/app/model/agent';
import { AgentService } from 'src/app/services/agent.service';

@Component({
  selector: 'app-list-agent',
  templateUrl: './list-agent.component.html',
  styleUrls: ['./list-agent.component.css']
})
export class ListAgentComponent implements OnInit {
  agents!: Agent[];

  constructor(private router: Router, private agentService: AgentService) { }

  // Initialize with default list of agents
  ngOnInit() {


    this.agentService.getAgents().subscribe(data => {
      this.agents = data;
    });


  }

  // Delete Agent
  deleteAgent(agent: Agent): void {
    let result = confirm('Do you want to delete the user?')
    if (result) {
      this.agentService.deleteAgent(agent.agentId)
        .subscribe(data => {
          this.agents = this.agents.filter(u => u !== agent);
        });
    }
  };

  // Modify Agent
  editAgent(agent: Agent): void {
    localStorage.removeItem("editAgentId");
    localStorage.setItem("editAgentId", agent.agentId.toString());
    this.router.navigate(['edit-agent']);
  };

  // Add New Agent
  addAgent(): void {
    this.router.navigate(['add-agent']);
  }
  cancel(){
    this.router.navigate(['admin']);
  }

}​​​​​​​​
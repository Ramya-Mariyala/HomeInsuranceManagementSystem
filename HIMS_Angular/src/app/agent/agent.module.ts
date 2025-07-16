import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddAgentComponent } from './add-agent/add-agent.component';
import { EditAgentComponent } from './edit-agent/edit-agent.component';
import { HomeAgentComponent } from './home-agent/home-agent.component';
import { ListAgentComponent } from './list-agent/list-agent.component';
import { AgentService } from '../services/agent.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';



@NgModule({
  declarations: [AddAgentComponent, EditAgentComponent, HomeAgentComponent, ListAgentComponent],
  imports: [
    CommonModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule
  ],
  providers: [AgentService]
})
export class AgentModule { }

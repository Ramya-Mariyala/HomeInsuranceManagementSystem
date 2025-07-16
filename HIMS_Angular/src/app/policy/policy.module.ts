import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddPolicyComponent } from './add-policy/add-policy.component';
import { EditPolicyComponent } from './edit-policy/edit-policy.component';
import { ListPolicyComponent } from './list-policy/list-policy.component';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { PolicyService } from '../services/policy.service';



@NgModule({
  declarations: [AddPolicyComponent, EditPolicyComponent, ListPolicyComponent],
  imports: [
    CommonModule, AppRoutingModule, HttpClientModule, ReactiveFormsModule
  ],
  providers: [PolicyService]
})
export class PolicyModule { }

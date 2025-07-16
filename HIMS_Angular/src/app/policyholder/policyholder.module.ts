import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddPolicyholderComponent } from './add-policyholder/add-policyholder.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { PolicyholderService } from '../services/policyholder.service';
import { EditPolicyholderComponent } from './edit-policyholder/edit-policyholder.component';
import { ListPolicyholderComponent } from './list-policyholder/list-policyholder.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { PolicyComponent } from './policy/policy.component';
import { QuoteComponent } from './quote/quote.component';
import { PropertyComponent } from './property/property.component';



@NgModule({
  declarations: [AddPolicyholderComponent, EditPolicyholderComponent, ListPolicyholderComponent, HomeComponent, ProfileComponent, PolicyComponent, QuoteComponent, PropertyComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [PolicyholderService]

})
export class PolicyholderModule { }

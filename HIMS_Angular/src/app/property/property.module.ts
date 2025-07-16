import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddPropertyComponent } from './add-property/add-property.component';
import { ListPropertyComponent } from './list-property/list-property.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from '../app-routing.module';
import { PropertyService } from '../services/property.service';



@NgModule({
  declarations: [AddPropertyComponent, ListPropertyComponent],
  imports: [
    CommonModule, ReactiveFormsModule, HttpClientModule, AppRoutingModule
  ],
  providers: [PropertyService]

})
export class PropertyModule { }

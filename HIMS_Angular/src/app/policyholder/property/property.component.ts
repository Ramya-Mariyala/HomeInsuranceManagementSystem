import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Property } from 'src/app/model/property';
import { PropertyService } from 'src/app/services/property.service';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['./property.component.css']
})
export class PropertyComponent implements OnInit {

  property!: Property;
  propertyForm!: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private propertyservice: PropertyService) {
    this.propertyForm = this.formBuilder.group({
      //id: [],
      propertyId: [''],
      marketValue: [''],
      yearBuilt: [''],
      squareFootage: [''],
      dwellingStyle: [''],
      roofMaterial: [''],
      garageType: [''],
      fullBathCount: [''],
      halfBathCount: [''],
      hasSwimmingPool: [''],
    });


  }
  ngOnInit(): void {
    let my_object = JSON.parse(localStorage.getItem('data') || '{}');

    console.log(my_object.userName);
    console.log(my_object.policyHolder);
    console.log(my_object.policyHolder.policyId);
    this.propertyservice.getPropertyById(my_object.policyHolder.policyId.quote.property.propertyId).subscribe(data => {
      this.propertyForm.setValue(data);
      console.log(data);
    });


  }


}

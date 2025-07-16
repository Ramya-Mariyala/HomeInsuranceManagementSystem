import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PropertyService } from 'src/app/services/property.service';

@Component({
  selector: 'app-add-property',
  templateUrl: './add-property.component.html',
  styleUrls: ['./add-property.component.css']
})
export class AddPropertyComponent implements OnInit {
  addForm!: FormGroup;
  submitted: boolean = false;


  constructor(private formBuilder: FormBuilder, private router: Router, private propertyService: PropertyService) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: [],
      propertyId: ['', Validators.required],
      marketValue: ['', Validators.required],
      yearBuilt: ['', Validators.required],
      squareFootage: ['', Validators.required],
      dwellingStyle: ['', Validators.required],
      roofMaterial: ['', Validators.required],
      garageType: ['', Validators.required],
      fullBathCount: ['', Validators.required],
      halfBathCount: ['', Validators.required],
      hasSwimmingPool: ['', Validators.required]
    });

  }
  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.propertyService.createProperty(this.addForm.value)
      .subscribe(data => {
        alert("Data Added successfully");
        this.router.navigate(['policyholder']);
      });
  }
}
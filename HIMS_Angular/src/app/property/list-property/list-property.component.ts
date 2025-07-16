import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Property } from 'src/app/model/property';
import { PropertyService } from 'src/app/services/property.service';


@Component({
  selector: 'app-list-property',
  templateUrl: './list-property.component.html',
  styleUrls: ['./list-property.component.css']
})
export class ListPropertyComponent implements OnInit {

  properties!: Property[];
  constructor(private router: Router, private propertyService: PropertyService) { }

  ngOnInit(): void {

    this.propertyService.getProperties().subscribe(data => {

      this.properties = data;
    });
  }
  // Add New Property
  addProperty(): void {
    this.router.navigate(['add-property']);
  };
  logOutPolicyHolder(): void{
    this.router.navigate(['']);
  
}

}
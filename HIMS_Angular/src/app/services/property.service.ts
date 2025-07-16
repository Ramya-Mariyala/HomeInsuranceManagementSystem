import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Property } from '../model/property';
@Injectable({
    providedIn: 'root'
})
export class PropertyService {



    // for Json - Server uncomment following url
    baseUrl: string = 'http://localhost:9091/property';

    constructor(private http: HttpClient) { }

    //get all properties
    getProperties() {
        return this.http.get<Property[]>(this.baseUrl + '/allproperties');
    }

    getPropertyById(propertyId: number){
        return this.http.get<Property>(this.baseUrl + '/propertyById/' + propertyId);
      }

    // Create Property
    createProperty(property: Property): Observable<string> {
        return this.http.post(this.baseUrl, property, { responseType: 'text' });
    }
}
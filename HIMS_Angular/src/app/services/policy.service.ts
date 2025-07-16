import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Policy } from '../model/policy';
@Injectable({
    providedIn: 'root'
})
export class PolicyService {

    constructor(private http: HttpClient) { }
 
    baseUrl: string = "http://localhost:9091";

    getPolicies() {
        return this.http.get<Policy[]>(this.baseUrl + '/allpolicies');
    }
    createPolicy(policy: Policy): Observable<string> {
        return this.http.post(this.baseUrl + '/policy', policy, { responseType: 'text' });
    }
    getPolicyById(policyId: number) {
        return this.http.get<Policy>(this.baseUrl + '/policybyid/' + policyId);
    }
    updatePolicy(policy: Policy): Observable<string> {
        return this.http.put(this.baseUrl + '/updatepolicy/' + policy.policyId, policy, { responseType: 'text' });
    }
    deletePolicy(policyId: number): Observable<string> {
        return this.http.delete(this.baseUrl + '/deletepolicy/' + policyId, { responseType: 'text' });
    }
}
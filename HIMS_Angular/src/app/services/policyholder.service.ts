import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PolicyHolder } from '../model/policyholder';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PolicyholderService {

  baseUrl: string = "http://localhost:9091/policyHolder";


  constructor(private http: HttpClient) { }


  createPolicyHolder(policyholder: PolicyHolder): Observable<string> {
    return this.http.post(this.baseUrl, policyholder, { responseType: 'text' });
  }

  updatePolicyHolder(policyholder: PolicyHolder): Observable<string>{
    return this.http.put(this.baseUrl + '/policyHolderUpdate' , policyholder, { responseType: 'text' });
  }

  getPolicyHolderById(policyHolderId: number){
    return this.http.get<PolicyHolder>(this.baseUrl + '/policyHolderById/' + policyHolderId);
  }
  getPolicyHolders(){
    return this.http.get<PolicyHolder[]>(this.baseUrl + '/policyHolderList');
  }

  deletePolicyHolder(policyHolderId: number): Observable<any> {
    return this.http.delete(this.baseUrl + '/policyHolderDeleteById/' + policyHolderId, { responseType: 'text' });
  }
}

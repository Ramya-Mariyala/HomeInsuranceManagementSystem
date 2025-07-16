import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    constructor(private http: HttpClient) { }


    // for Json - Server uncomment following url
    baseUrl: string = 'http://localhost:9091';

    login(userName: string, password: string, role: string) {
        return this.http.get(this.baseUrl + "/user/signin/" + userName + "/" + password + "/" + role);
    }

    // Create User
    createUser(user: User): Observable<String> {
        return this.http.post(this.baseUrl + '/users', user, { responseType: 'text' });
    }

    // Modify User
    updateUser(user: User) {
        return this.http.put<string>(this.baseUrl + '/' + user.userName, user);
    }

    forgotPassword(userName: string): Observable<string> {
        alert(userName);
        return this.http.get(this.baseUrl + "/forgotPassword" + "/" + userName, { responseType: "text" });
    }
}
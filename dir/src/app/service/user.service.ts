import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {


    baseUrl = 'http://localhost:8080/user';
  
    constructor(private http: HttpClient) { }
    
    getuserbyemail(email:string): Observable<any> {
      return this.http.get(`${this.baseUrl}/get/${email}`);
    }
  }

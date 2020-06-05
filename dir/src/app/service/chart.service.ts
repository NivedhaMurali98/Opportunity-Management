import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

 


  baseUrl = 'http://localhost:8080/chart';

  constructor(private http: HttpClient) { }

 
  getchartsk(): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists`);
  }
  getchartloc(): Observable<any> {
    return this.http.get(`${this.baseUrl}/listsloc`);
  }
  getcharthm(): Observable<any> {
    return this.http.get(`${this.baseUrl}/listshm`);
  }
  
}
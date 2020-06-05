import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  baseUrl = 'http://localhost:8080/location';

  constructor(private http: HttpClient) { }

 
  getlocations(): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists`);
  }
  getlocbyid(id: number):Observable<any> {
    return this.http.get(`${this.baseUrl}/list/${id}`);
  }
}
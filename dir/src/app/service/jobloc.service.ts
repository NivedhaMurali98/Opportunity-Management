import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JoblocService {

  baseUrl = 'http://localhost:8080/joblocs';

  constructor(private http: HttpClient) { }

 
  createJobloc(job: Object) {
    return this.http.post(`${this.baseUrl}/add`, job);
  }
  updateJobloc(job: Object) {
    return this.http.post(`${this.baseUrl}/update`, job);
  }
  deleteJobloc(id: number) {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }
  getJoblocs(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists/${id}`);
  }
}
  
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

 

  baseUrl = 'http://localhost:8080/skill';

  constructor(private http: HttpClient) { }

 
  getskills(): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists`);
  }
  getskillbyid(id: number):Observable<any> {
    return this.http.get(`${this.baseUrl}/list/${id}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobskillService {

  baseUrl = 'http://localhost:8080/jobsk';

  constructor(private http: HttpClient) { }

 
  createJobsk(job: Object) {
    return this.http.post(`${this.baseUrl}/add`, job);
  }
  updateJobsk(job: Object) {
    return this.http.post(`${this.baseUrl}/update`, job);
  }
  deleteJobsk(id: number) {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }
  getJobsks(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists/${id}`);
  }
}
  
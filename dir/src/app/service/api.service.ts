import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Jobb } from './jobb';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  
  baseUrl = 'http://localhost:8080/job';

  constructor(private http: HttpClient) { }

 //api to create a job entity
  createJob(job: Object) {
    return this.http.post(`${this.baseUrl}/add`, job);
  }

  //api to update a job
  updateJob(job: Object) {
    return this.http.put(`${this.baseUrl}/updates`, job);
  }

  //api to delete a job entity
  deleteJob(id: number) {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

  //api to get all jobs
  getJobs(): Observable<any> {
    return this.http.get(`${this.baseUrl}/lists`);
  }

  //api to get job  by id
  getJob(id: number):Observable<any> {
    return this.http.get(`${this.baseUrl}/print/${id}`);
  }
  
  
}
  
  


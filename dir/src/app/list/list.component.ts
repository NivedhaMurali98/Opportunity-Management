import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Jobb } from '../service/jobb';
import { ApiService } from '../service/api.service';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { JoblocService } from '../service/jobloc.service';
import { JobskillService } from '../service/jobskill.service';
import { jobloc } from '../service/jobloc';
import { jobsk } from '../service/jobsk';
import { AuthenticationService } from '../service/authentication.service';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit, AfterViewInit {
  public displayedColumns = ['createrid', 'jobid', 'openings', 'description','emptype','details','update','delete'];
  public dataSource = new MatTableDataSource<Jobb>();
  @ViewChild(MatSort) sort: MatSort;
  constructor(private employeeService: ApiService,private router: Router,
    private joobloc :JoblocService,private jobskl:JobskillService,
    public loginService: AuthenticationService) { }
    

  s:number;
  n:boolean;
  
  
 public jobloc:string="Location:";
 public jobsk:string="Skillsets:";
  public i:number;

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
  @ViewChild(MatPaginator) paginator: MatPaginator;

  

  delete(sel_job:number)
  {
      console.log(sel_job)

      this.joobloc.deleteJobloc(sel_job).subscribe(data => console.log(data), error => console.log(error));
      this.jobskl.deleteJobsk(sel_job).subscribe(data => console.log(data), error => console.log(error));
      this.employeeService.deleteJob(sel_job).subscribe(data => console.log(data), error => console.log(error));
      this.router.navigate(['/create']);
  }
  update(sel_job:number)
  {
    
   

      this.s=sel_job;
     
      this.router.navigate(['/edit'], { queryParams: { id: this.s} });
      
    
    }

    desc(sel_job:number)
    {
      if(this.n==true) 
      {
      this.n=false;
     
      } 
    else{
          this.n=true;
          this.jobloc="Location:";
          this.jobsk="Skillsets:";
          this.joobloc.getJoblocs(sel_job).subscribe((users:jobloc[]) => {
          for(this.i=0;this.i<users.length;this.i++)
          {
           this.jobloc=this.jobloc.concat(users[this.i].loc,",");
          }
        });
          this.jobskl.getJobsks(sel_job).subscribe((users:jobsk[]) =>{

         
          for(this.i=0;this.i<users.length;this.i++)
          {
           this.jobsk=this.jobsk.concat(users[this.i].skill,",");
          }
        }); 
       
       
  
   
    
  }
    }


  

  ngOnInit(): void {
    this.getjobs();
    this.n=true;
    
    

  }
 
  
  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  public getjobs = () => {
    this.employeeService.getJobs()
    .subscribe(res => {
      this.dataSource.data = res as Jobb[];
      console.log(this.dataSource.data)
    })
  }

}

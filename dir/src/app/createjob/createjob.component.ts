import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../service/api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Jobb } from '../service/jobb';
import { Observable } from 'rxjs';
import { LocationService } from '../service/location.service';
import { locations } from '../service/Location';
import { Skill } from '../service/skill';
import { SkillService } from '../service/skill.service';
import { JoblocService } from '../service/jobloc.service';
import { jobloc } from '../service/jobloc';
import { jobsk } from '../service/jobsk';
import { JobskillService } from '../service/jobskill.service';


@Component
({
  selector: 'app-createjob',
  templateUrl: './createjob.component.html',
  styleUrls: ['./createjob.component.scss']
})
export class CreatejobComponent implements OnInit
{
  constructor
  (
    private employeeService: ApiService,
    private locservice :LocationService,
    private skillservice:SkillService,
    private joobloc :JoblocService,
    private jobskl:JobskillService,
    private router: Router,
  ){}

  job: Jobb = new Jobb();
  submitted = false; 
  loc: Observable<locations[]>;
  skill:Observable<Skill[]>;
  jl: jobloc= new jobloc();
  js: jobsk= new jobsk();
  addform :FormGroup
  sub: any
  id: number;
  i:number;

  ngOnInit(): void 
  {
      //form group initialisation and validations
      this.addform=new FormGroup
      ({  
      user_id : new FormControl('' , [Validators.required,Validators .minLength(4)] ),  
      job_id : new FormControl('' , [Validators.required,Validators.minLength(3)] ), 
      openings : new FormControl('' , [Validators.required ] ), 
      desc : new FormControl('' , [Validators.required ] ), 
      skillset : new FormControl('' , [Validators.required ,] ), 
      emp_type : new FormControl('' , [Validators.required ] ), 
      locations : new FormControl('' , [Validators.required ] ), 
      date : new FormControl('' , [Validators.required ] ), 
      }); 
     
      //api for getting the locations and skills for multiselect fields
      this.loc=this.locservice.getlocations();
      this.skill=this.skillservice.getskills();
      this.submitted=false;  
  }
 
  //form submit button to create job
  Submit() 
  {

    if(this.addform.valid)
    {
      this.job.jobid =this.addform.get('job_id').value;
      this.job.updatorid =this.addform.get('user_id').value;
      this.job.createrid =this.addform.get('user_id').value;
      this.job.emptype =this.addform.get('emp_type').value;
      this.job.description =this.addform.get('desc').value;
      this.job.openings =this.addform.get('openings').value;

      //loop to enter all thelocations for given job id
      for(this.i=1;this.i<=this.addform.get('locations').value.length;this.i++)
      { 
        this.jl.jobid=this.addform.get('job_id').value;
        this.jl.loc=this.addform.get('locations').value[this.i-1];
        this.joobloc.createJobloc(this.jl).subscribe(data => console.log(data), error => console.log(error));
      }
      //loop for adding all skills for the given id
      for(this.i=1;this.i<=this.addform.get('skillset').value.length;this.i++)
      {
        this.js.jobid=this.addform.get('job_id').value;
        this.js.skill=this.addform.get('skillset').value[this.i-1];
        this.jobskl.createJobsk(this.js).subscribe(data => console.log(data), error => console.log(error));
      }
      this.job.isactive="true";
      this.job.datemod= this.addform.get('date').value;
      this.employeeService.createJob(this.job).subscribe(data => console.log(data), error => console.log(error));
      alert("JOB ADDED SUCCESSFULLY")
      this.router.navigate(['/list']);
    }
    else
    {
      alert(" INVALID FIELD VALUES CHECK AGAIN");
    }
  }
}


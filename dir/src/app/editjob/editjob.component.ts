import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../service/api.service';
import { Jobb } from '../service/jobb';
import { LocationService } from '../service/location.service';
import { SkillService } from '../service/skill.service';
import { JoblocService } from '../service/jobloc.service';
import { JobskillService } from '../service/jobskill.service';
import { Observable } from 'rxjs';
import { locations } from '../service/Location';
import { jobloc } from '../service/jobloc';
import { jobsk } from '../service/jobsk';
import { Skill } from '../service/skill';

@Component({
  selector: 'app-editjob',
  templateUrl: './editjob.component.html',
  styleUrls: ['./editjob.component.scss']
})
export class EditjobComponent implements OnInit {

  constructor(private activateRouter:ActivatedRoute, private employeeService: ApiService,
    private locservice :LocationService,
    private skillservice:SkillService,private joobloc :JoblocService,private jobskl:JobskillService,
    private router: Router,) { }
    loc: Observable<locations[]>;
   skill:Observable<Skill[]>;
   jl: jobloc= new jobloc();
   js: jobsk= new jobsk();
  addform :FormGroup
  sub: any
  id: number;
  job: Jobb = new Jobb();
  i:number;
  ngOnInit(): void {
  
      this.addform=new FormGroup({  
        user_id : new FormControl('' , [Validators.required ,Validators .minLength(4)] ),  
       
        openings : new FormControl('' , [Validators.required ] ), 
        desc : new FormControl('' , [Validators.required ] ), 
        skillset : new FormControl('' , [Validators.required ,] ), 
        emp_type : new FormControl('' , [Validators.required ] ), 
        locations : new FormControl('' , [Validators.required ] ), 
        date : new FormControl('' , [Validators.required ] ), 
        
      }); 
      this.sub = this.activateRouter.queryParams
        .subscribe(params => {
          // Defaults to 0 if no query param provided.
          this.id = +params['id'] || 0;
        }); 
        this.loc=this.locservice.getlocations();
        this.skill=this.skillservice.getskills();
        
  }

  update()
  {
    if(this.addform.valid)
    {
    this.job.jobid =this.id;
    this.job.updatorid =this.addform.get('user_id').value;
    this.job.createrid =this.addform.get('user_id').value;
    this.job.emptype =this.addform.get('emp_type').value;
    this.job.description =this.addform.get('desc').value;
   
    this.job.openings =this.addform.get('openings').value;
    
    this.job.isactive="true";
    this.job.datemod= this.addform.get('date').value;
    this.joobloc.deleteJobloc(this.id).subscribe(data => console.log(data), error => console.log(error));
    this.jobskl.deleteJobsk(this.id).subscribe(data => console.log(data), error => console.log(error));
  
    for(this.i=1;this.i<=this.addform.get('locations').value.length;this.i++)
    {
      this.jl.jobid=this.id;
      this.jl.loc=this.addform.get('locations').value[this.i-1];
      this.joobloc.createJobloc(this.jl).subscribe(data => console.log(data), error => console.log(error));
       
    }
    for(this.i=1;this.i<=this.addform.get('skillset').value.length;this.i++)
    {
      this.js.jobid=this.id;
      this.js.skill=this.addform.get('skillset').value[this.i-1];
      this.jobskl.createJobsk(this.js).subscribe(data => console.log(data), error => console.log(error));
       
    }
    
   
    this.employeeService.updateJob(this.job).subscribe(data => console.log(data), error => console.log(error));
    this.router.navigate(['/list']);
  }
  else
  {
    alert("Invalid Field values check again");

  }

  
  }


}

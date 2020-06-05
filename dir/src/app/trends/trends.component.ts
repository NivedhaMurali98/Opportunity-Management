import { Component, OnInit } from '@angular/core';
import { ChartService } from '../service/chart.service';
import { chart } from '../service/chart';



@Component
({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.scss']
})

export class TrendsComponent implements OnInit 
{

  constructor(private cs : ChartService) { }
  public users: chart[];
  public t:string[]=[''];
  public data:number[]=[];
  public thm:string[]=[''];
  public datahm:number[]=[];
  public tbar:string[]=[''];
  public databar:number[]=[];
  public i:number;
  public chartType: string = 'pie';
  public chartType1: string = 'bar';

  public chartDatasets: Array<any> = [{ data: this.datahm, label: 'HIRING MANAGER TREND' }];
  public chartDatasets1: Array<any> = [{ data:this.data, label: 'SKILLSET TREND ' }];
  public chartDatasets2: Array<any> = [{ data:this.databar, label: 'LOCATION TREND' }];
  public chartColors: Array<any> = 
  [{
      backgroundColor: ['#F7464A', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360','#ec407a ','#5c6bc0','#9ccc65','#ff7043'],
      hoverBackgroundColor: ['#FF5A5E', '#5AD3D1', '#FFC870', '#A8B3C5', '#616774','#ec407a ','#5c6bc0','#9ccc65','#ff7043'],
      borderWidth: 2,
  }];
  public chartOptions: any ={responsive: true};

  
  //oninit function we fetch all the data from database for the charts
  ngOnInit(): void 
  {
    this.i=0;
    //to fetch skills trends data
    this.cs.getchartsk().subscribe((users:chart[]) => 
    {
      this.users=users
      for(this.i=0;this.users.length;this.i++)
      {
      this.t[this.i]=this.users[this.i].title;
      this.data[this.i]=this.users[this.i].count;
      }
    });
    //to fetch the location trends data
    this.cs.getchartloc().subscribe((users:chart[]) => 
    {
      this.users=users
      for(this.i=0;this.users.length;this.i++)
      {
      this.tbar[this.i]=this.users[this.i].title;
      this.databar[this.i]=this.users[this.i].count;
      }
    });
    //to fetch hiring manager trend from databse
    this.cs.getcharthm().subscribe((users:chart[]) => 
    {
      this.users=users
      for(this.i=0;this.users.length;this.i++)
      {
      this.thm[this.i]=this.users[this.i].title;
      this.datahm[this.i]=this.users[this.i].count;
      }
      console.log(this.thm);
    });
}
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }
}

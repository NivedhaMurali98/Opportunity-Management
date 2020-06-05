import { LoginformComponent } from './loginform/loginform.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGradService } from './service/auth-grad.service';
import { CreatejobComponent } from './createjob/createjob.component';
import { EditjobComponent } from './editjob/editjob.component';
import { ListComponent } from './list/list.component';
import { TrendsComponent } from './trends/trends.component';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';

//all the routes of the application
const routes: Routes = 
[
  {path: '', pathMatch:'full', redirectTo :'login'},
  {path: 'home',  component: HomeComponent,canActivate:[AuthGradService]},
  {path: 'create',  component: CreatejobComponent,canActivate:[AuthGradService]},
  {path: 'edit',  component: EditjobComponent,canActivate:[AuthGradService]},
  {path: 'login',  component:LoginformComponent },
  {path: 'list',  component: ListComponent,canActivate:[AuthGradService]},
  {path: 'trend',  component: TrendsComponent,canActivate:[AuthGradService]},
  {path: '404', component: ErrorComponent},
  {path: '**', redirectTo: '/404'},
 
];

@NgModule
({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

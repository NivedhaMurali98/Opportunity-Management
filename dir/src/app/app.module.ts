import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginformComponent } from './loginform/loginform.component';
import { HeaderComponent } from './header/header.component';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CreatejobComponent } from './createjob/createjob.component';

import {SocialLoginModule,GoogleLoginProvider,AuthServiceConfig} from 'angularx-social-login'
import { HttpClientModule } from '@angular/common/http';
import { EditjobComponent } from './editjob/editjob.component';
import { ListComponent } from './list/list.component';
import {MatTableModule} from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { TrendsComponent } from './trends/trends.component';
import { ErrorComponent } from './error/error.component';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatPaginatorModule } from '@angular/material/paginator';
import { HomeComponent } from './home/home.component';




const config = new AuthServiceConfig([
  {
    id:GoogleLoginProvider.PROVIDER_ID,
    provider:new GoogleLoginProvider('1080805177882-7hres4k33p4581p8t6aiol9rvkqsdmg2.apps.googleusercontent.com')
  }

]);

export function provideConfig()
{
  return config;
}


@NgModule({
  declarations: [
    AppComponent,
   
    LoginformComponent,
    HeaderComponent,
  
    CreatejobComponent,
  
    EditjobComponent,
    ListComponent,
    TrendsComponent,
    ErrorComponent,
    HomeComponent,
    
    
   
  ],
  imports: [
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    MatTableModule,
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
BrowserAnimationsModule,
ReactiveFormsModule ,
FormsModule,
SocialLoginModule,
HttpClientModule
  ],
  providers: [
    {
      provide : AuthServiceConfig ,useFactory : provideConfig
    }
  ],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }

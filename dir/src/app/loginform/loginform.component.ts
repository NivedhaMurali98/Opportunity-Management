import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {SocialUser,AuthService,GoogleLoginProvider} from 'angularx-social-login'
import { UserService } from '../service/user.service';
import { user } from '../service/user';
import { Observable } from 'rxjs';

@Component
({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.scss']
})

export class LoginformComponent implements  OnInit 
{ 

  invalidLogin = true;
  loginform: FormGroup;
  public user: any = SocialUser;
  user1:Observable<user[]>;
  admin_stat:String;

  constructor(private router: Router,public loginService: AuthenticationService,
  private fb:FormBuilder,private socialAuthService: AuthService ,
  private userservice:UserService) 
  { }
  ngOnInit(): void { }

  //method for google sign in and store the session variable
  googlelogin()
  {
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then((userData) =>
    {
      this.user =userData;
       this.userservice.getuserbyemail(this.user.email).subscribe(data => 
        
        
        {if(data.role=="admin"){sessionStorage.setItem("admin","yes") }
        }, error => console.log(error));
    
      
      sessionStorage.setItem("tokenid",this.user.idToken);
      this.invalidLogin = false;
      this.router.navigate(['/home'])
    });
  }

  //method to log out of the system and session is ended
  logout() 
  {
    this.socialAuthService.signOut().then()
    {
      sessionStorage.removeItem("tokenid");
      sessionStorage.removeItem("admin");
      this.invalidLogin = true;
      this.router.navigate(['/login'])
    }
  }
  
}
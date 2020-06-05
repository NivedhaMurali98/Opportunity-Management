import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
constructor() { }

 

  isUserLoggedIn() {
    let user = sessionStorage.getItem('tokenid')
    console.log(!(user === null))
    return !(user === null)
  }
  
  isUserAdmin() {
    let admin_stat = sessionStorage.getItem('admin')
    console.log(admin_stat);
    return (admin_stat == "yes")
  }


  
}

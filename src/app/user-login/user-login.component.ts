import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user:User=new User();
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
  }

  checkLogin()
  {
    this.userService.loginUser(this.user.name, this.user.password)
    .subscribe((data: User) => {
      console.log(data)
      if (data != null) {
        this.router.navigate(["/userhome"])
        this.setCurrentUser(data)
      }
    }
      , error => console.log(error));
  this.user = new User();
  }


  login() {
    this.checkLogin();
  }

  setCurrentUser(data : User)
  {
    localStorage.setItem('data',JSON.stringify(data));
  }

}

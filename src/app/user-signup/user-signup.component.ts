import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {

  user:User=new User();

  constructor(private userService: UserService,private router:Router) { }

  save()
  {
    this.userService.createUser(this.user)
      .subscribe(data => {
        console.log(data)
        this.router.navigate(["/userlogin"])
      }
        , error => console.log(error));
    this.user = new User();
  }

  ngOnInit() {
  }

  onSubmit() {
    this.save();
  }

}

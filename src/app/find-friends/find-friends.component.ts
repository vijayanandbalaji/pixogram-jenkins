import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../service/user.service';
import { Follow } from '../service/follow.model';
import { FollowService } from '../service/follow.service';

@Component({
  selector: 'app-find-friends',
  templateUrl: './find-friends.component.html',
  styleUrls: ['./find-friends.component.css']
})
export class FindFriendsComponent implements OnInit {

  user: User = new User();
  friends: Observable<User[]>
  user1: Follow = new Follow();
  following: User = new User();


  constructor(private userService: UserService, private followService: FollowService, private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('data'));
    this.friends = this.userService.displayfriends();

  }

  follows() {

    this.user1.userId = JSON.parse(localStorage.getItem('data'));
    this.user1.followId = this.following;
    this.followService.follow(this.user1)
      .subscribe((data: Follow) => {
        console.log(data)
        if (data != null) {
          this.router.navigate(["/findfriends"])
        }
      }

        , error => console.log(error));
    this.user1 = new Follow();


  }

  follow(find:User) {
    this.following = find;
    this.follows();
  }

}
import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { Follow } from '../service/follow.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { FollowService } from '../service/follow.service';
import { PostService } from '../service/post.service';
import { Post } from '../service/post.model';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  user:User=new User();
  followers: Observable<Follow[]>;
  follow1:Follow=new Follow();
  Follower:Follow=new Follow();
  follow:Observable<Follow[]>;
  unfollow:Follow=new Follow();
  UnFollow:Follow=new Follow();
  post:Observable<Post[]>
  

  constructor(private router:Router,private followService:FollowService,private postService:PostService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('data'));
  }


  findfollowers()
  {
    //let userId = localStorage.getItem('data');
    this.followers=this.followService.displayfollower(this.user.id.toString());

  }
  follower()
  {
    this.findfollowers();
  }



  followerdisplay()
  {
    this.Follower.userId = JSON.parse(localStorage.getItem('data'));
    this.Follower.followId = this.follow1.userId;
    this.followService.follow(this.Follower)
      .subscribe((data: Follow) => {
        console.log(data)
        if (data != null) {
          this.router.navigate(["/profile"])
        }
      }

        , error => console.log(error));
    this.Follower = new Follow();

  }

  following(f:Follow)
  {
    this.follow1=f;
    this.followerdisplay();
  }


 

displayfollow()
{
  this.follow=this.followService.displayfollow(this.user.id.toString());
}


  followings()
  {
    this.displayfollow();
  }


unfollows()
{


  //this.unFollow.userId = JSON.parse(localStorage.getItem('data'));
  this.followService.unFollow(this.unfollow.id)
     .subscribe((data: Follow) => {
       console.log(data)
       if (data != null) {
         this.router.navigate(["/profile"])
      }
     }

       , error => console.log(error));
   this.Follower = new Follow();  
}


  unFollow(f1:Follow)
  {
    this.unfollow=f1;
    this.unfollows();
  }












  // media display
  mymedia()
  {
    this.displaymedia();
  }

  displaymedia()
  {
    this.post=this.postService.getPostsById(this.user.id.toString());
  }
}

import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { Post } from '../service/post.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  
  user:User=new User();

  post:Observable<Post[]>
 
  constructor(private router:Router,private userService:UserService,private postService:PostService) { }

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('data'));
    this.post = this.postService.getPosts()
  }

}

import { Component, OnInit } from '@angular/core';
import { User } from '../service/user.model';
import { PostService } from '../service/post.service';
import { Router } from '@angular/router';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-upload-media',
  templateUrl: './upload-media.component.html',
  styleUrls: ['./upload-media.component.css']
})
export class UploadMediaComponent implements OnInit {
  fileData: File = null;
  progress: { percentage: number } = { percentage: 0 };
  user:User = new User();
 
  constructor(private postService:PostService,private router:Router) {} 
  

  ngOnInit() {
    this.user=JSON.parse(localStorage.getItem('data'));
  }

  selectFile(event) {
    this.fileData = <File>event.target.files[0];
  }


  onSubmit(form:NgForm) {
    this.progress.percentage = 0;
    this.postService.uploadPost(this.user.id, this.fileData, form.value.title, form.value.description).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.router.navigate(['/profile'])
      }
    });

    this.fileData = undefined;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Post } from './post.model';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = "http://localhost:9531/post";

  constructor(private http: HttpClient) { }


  uploadPost(user, file: File, title: String, desc: String): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();

    formdata.append('user', user);
    formdata.append('file', file);
    formdata.append('title', <string>title);
    formdata.append('desc', <string>desc);


    const req = new HttpRequest('POST', "http://localhost:9531/post/upload", formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  getPostsById(userId :String): Observable<Post[]> {
    console.log(userId)
    return this.http.get<Post[]>(`${this.baseUrl}/${userId}`)
  }


  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.baseUrl}/all`)
  }

}

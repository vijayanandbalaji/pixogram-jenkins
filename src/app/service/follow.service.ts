import { Injectable } from '@angular/core';

import { Follow } from './follow.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class FollowService {
  private baseUrl = 'http://localhost:9531/follow';

  constructor(private http: HttpClient) { }
 
  follow(user1: Follow): Observable<any> {
    return this.http.post(`${this.baseUrl}/following/user`, user1);
  }

  displayfollower(id : String):Observable<Follow[]>{
    return this.http.get<Follow[]>(`${this.baseUrl}/display/followers/${id}`);
  }

  displayfollow(id : String):Observable<Follow[]>{
    return this.http.get<Follow[]>(`${this.baseUrl}/display/following/${id}`);
  }


  unFollow(unfollowUser:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/delete/${unfollowUser}`)
  }

}
